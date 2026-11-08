/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.AchievementHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy.EventSerializer;
import java.util.function.Predicate;

public class HoverEventSerializer<T extends HoverEvent>
extends EventSerializer<HoverEvent, T, HoverEventAction, TextComponent> {
    public static final HoverEventSerializer<TextHoverEvent> TEXT = HoverEventSerializer.createBasic(TextHoverEvent.class::isInstance, TextHoverEvent::getText, HoverEventAction.SHOW_TEXT, TextHoverEvent::new);
    public static final HoverEventSerializer<AchievementHoverEvent> ACHIEVEMENT = HoverEventSerializer.createBasic(AchievementHoverEvent.class::isInstance, achievementHoverEvent -> new StringComponent(achievementHoverEvent.getStatistic()), HoverEventAction.SHOW_ACHIEVEMENT, textComponent -> new AchievementHoverEvent(textComponent.asUnformattedString()));
    public static final HoverEventSerializer<ItemHoverEvent> LEGACY_ITEM = HoverEventSerializer.createBasic(hoverEvent -> hoverEvent instanceof ItemHoverEvent && ((ItemHoverEvent)hoverEvent).isLegacy(), itemHoverEvent -> {
        ItemHoverEvent.LegacyHolder legacyHolder = (ItemHoverEvent.LegacyHolder)itemHoverEvent.getData();
        return new StringComponent(legacyHolder.getData());
    }, HoverEventAction.SHOW_ITEM, textComponent -> new ItemHoverEvent(textComponent.asUnformattedString()));
    public static final HoverEventSerializer<EntityHoverEvent> LEGACY_ENTITY = HoverEventSerializer.createBasic(hoverEvent -> hoverEvent instanceof EntityHoverEvent && ((EntityHoverEvent)hoverEvent).getData() instanceof EntityHoverEvent.LegacyHolder, entityHoverEvent -> ((EntityHoverEvent.LegacyHolder)entityHoverEvent.getData()).getData(), HoverEventAction.SHOW_ENTITY, EntityHoverEvent::new);

    private static <T extends HoverEvent> HoverEventSerializer<T> createBasic(Predicate<HoverEvent> predicate, EventSerializer.BasicIOFunction<T, TextComponent> basicIOFunction, HoverEventAction hoverEventAction, EventSerializer.BasicIOFunction<TextComponent, T> basicIOFunction2) {
        return new HoverEventSerializer<T>(predicate, basicIOFunction, hoverEventAction, basicIOFunction2);
    }

    private static <T extends HoverEvent> HoverEventSerializer<T> createSNbt(Predicate<HoverEvent> predicate, EventSerializer.IOFunction<T, TextComponent> iOFunction, HoverEventAction hoverEventAction, EventSerializer.IOFunction<TextComponent, T> iOFunction2) {
        return new HoverEventSerializer<T>(predicate, iOFunction, hoverEventAction, iOFunction2);
    }

    protected HoverEventSerializer(Predicate<HoverEvent> predicate, EventSerializer.IOFunction<T, TextComponent> iOFunction, HoverEventAction hoverEventAction, EventSerializer.IOFunction<TextComponent, T> iOFunction2) {
        super(predicate, iOFunction, hoverEventAction, iOFunction2);
    }
}

