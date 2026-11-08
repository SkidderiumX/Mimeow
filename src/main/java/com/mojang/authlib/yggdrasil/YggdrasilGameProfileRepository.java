/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.HttpAuthenticationService;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.ProfileNotFoundException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.response.ProfileSearchResultsResponse;
import java.util.HashSet;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YggdrasilGameProfileRepository
implements GameProfileRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String BASE_URL = "https://api.mojang.com/";
    private static final String SEARCH_PAGE_URL = "https://api.mojang.com/profiles/";
    private static final int ENTRIES_PER_PAGE = 2;
    private static final int MAX_FAIL_COUNT = 3;
    private static final int DELAY_BETWEEN_PAGES = 100;
    private static final int DELAY_BETWEEN_FAILURES = 750;
    private final YggdrasilAuthenticationService authenticationService;

    public YggdrasilGameProfileRepository(YggdrasilAuthenticationService yggdrasilAuthenticationService) {
        this.authenticationService = yggdrasilAuthenticationService;
    }

    @Override
    public void findProfilesByNames(String[] stringArray, Agent agent, ProfileLookupCallback profileLookupCallback) {
        HashSet<String> hashSet = Sets.newHashSet();
        for (String string : stringArray) {
            if (Strings.isNullOrEmpty(string)) continue;
            hashSet.add(string.toLowerCase());
        }
        int n = 0;
        for (List list : Iterables.partition(hashSet, 2)) {
            boolean bl;
            int n2 = 0;
            do {
                bl = false;
                try {
                    ProfileSearchResultsResponse profileSearchResultsResponse = this.authenticationService.makeRequest(HttpAuthenticationService.constantURL(SEARCH_PAGE_URL + agent.getName().toLowerCase()), list, ProfileSearchResultsResponse.class);
                    n2 = 0;
                    LOGGER.debug("Page {} returned {} results, parsing", n, profileSearchResultsResponse.getProfiles().length);
                    HashSet hashSet2 = Sets.newHashSet(list);
                    for (GameProfile gameProfile : profileSearchResultsResponse.getProfiles()) {
                        LOGGER.debug("Successfully looked up profile {}", gameProfile);
                        hashSet2.remove(gameProfile.getName().toLowerCase());
                        profileLookupCallback.onProfileLookupSucceeded(gameProfile);
                    }
                    Object object = hashSet2.iterator();
                    while (object.hasNext()) {
                        String string = (String)object.next();
                        LOGGER.debug("Couldn't find profile {}", string);
                        profileLookupCallback.onProfileLookupFailed(new GameProfile(null, string), new ProfileNotFoundException("Server did not find the requested profile"));
                    }
                    try {
                        Thread.sleep(100L);
                    }
                    catch (InterruptedException interruptedException) {}
                }
                catch (AuthenticationException authenticationException) {
                    if (++n2 == 3) {
                        for (Object object : list) {
                            LOGGER.debug("Couldn't find profile {} because of a server error", object);
                            profileLookupCallback.onProfileLookupFailed(new GameProfile(null, (String)object), authenticationException);
                        }
                        continue;
                    }
                    try {
                        Thread.sleep(750L);
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    bl = true;
                }
            } while (bl);
        }
    }
}

