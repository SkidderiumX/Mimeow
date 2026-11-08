/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.reflect.Reflection;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public class ClassPath {
    private static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = new Predicate<ClassInfo>(){

        @Override
        public boolean apply(ClassInfo classInfo) {
            return classInfo.className.indexOf(36) == -1;
        }
    };
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private final ImmutableSet<ResourceInfo> resources;

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.resources = immutableSet;
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        Scanner scanner = new Scanner();
        for (Map.Entry entry : ClassPath.getClassPathEntries(classLoader).entrySet()) {
            scanner.scan((URI)entry.getKey(), (ClassLoader)entry.getValue());
        }
        return new ClassPath(scanner.getResources());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String string) {
        Preconditions.checkNotNull(string);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (ClassInfo classInfo : this.getTopLevelClasses()) {
            if (!classInfo.getPackageName().equals(string)) continue;
            builder.add(classInfo);
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String string) {
        Preconditions.checkNotNull(string);
        String string2 = string + '.';
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (ClassInfo classInfo : this.getTopLevelClasses()) {
            if (!classInfo.getName().startsWith(string2)) continue;
            builder.add(classInfo);
        }
        return builder.build();
    }

    @VisibleForTesting
    static ImmutableMap<URI, ClassLoader> getClassPathEntries(ClassLoader classLoader) {
        LinkedHashMap<URI, ClassLoader> linkedHashMap = Maps.newLinkedHashMap();
        ClassLoader classLoader2 = classLoader.getParent();
        if (classLoader2 != null) {
            linkedHashMap.putAll(ClassPath.getClassPathEntries(classLoader2));
        }
        if (classLoader instanceof URLClassLoader) {
            URLClassLoader uRLClassLoader = (URLClassLoader)classLoader;
            for (URL uRL : uRLClassLoader.getURLs()) {
                URI uRI;
                try {
                    uRI = uRL.toURI();
                }
                catch (URISyntaxException uRISyntaxException) {
                    throw new IllegalArgumentException(uRISyntaxException);
                }
                if (linkedHashMap.containsKey(uRI)) continue;
                linkedHashMap.put(uRI, classLoader);
            }
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }

    @VisibleForTesting
    static String getClassName(String string) {
        int n = string.length() - CLASS_FILE_NAME_EXTENSION.length();
        return string.substring(0, n).replace('/', '.');
    }

    @VisibleForTesting
    public static final class Scanner {
        private final ImmutableSortedSet.Builder<ResourceInfo> resources = new ImmutableSortedSet.Builder<Object>(Ordering.usingToString());
        private final Set<URI> scannedUris = Sets.newHashSet();

        Scanner() {
        }

        ImmutableSortedSet<ResourceInfo> getResources() {
            return this.resources.build();
        }

        void scan(URI uRI, ClassLoader classLoader) throws IOException {
            if (uRI.getScheme().equals("file") && this.scannedUris.add(uRI)) {
                this.scanFrom(new File(uRI), classLoader);
            }
        }

        @VisibleForTesting
        void scanFrom(File file, ClassLoader classLoader) throws IOException {
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                this.scanDirectory(file, classLoader);
            } else {
                this.scanJar(file, classLoader);
            }
        }

        private void scanDirectory(File file, ClassLoader classLoader) throws IOException {
            this.scanDirectory(file, classLoader, "", ImmutableSet.<File>of());
        }

        private void scanDirectory(File file, ClassLoader classLoader, String string, ImmutableSet<File> immutableSet) throws IOException {
            File file2 = file.getCanonicalFile();
            if (immutableSet.contains(file2)) {
                return;
            }
            File[] fileArray = file.listFiles();
            if (fileArray == null) {
                logger.warning("Cannot read directory " + file);
                return;
            }
            ImmutableCollection immutableCollection = ((ImmutableSet.Builder)((ImmutableSet.Builder)ImmutableSet.builder().addAll(immutableSet)).add(file2)).build();
            for (File file3 : fileArray) {
                String string2 = file3.getName();
                if (file3.isDirectory()) {
                    this.scanDirectory(file3, classLoader, string + string2 + "/", (ImmutableSet<File>)immutableCollection);
                    continue;
                }
                String string3 = string + string2;
                if (string3.equals("META-INF/MANIFEST.MF")) continue;
                this.resources.add((Object)ResourceInfo.of(string3, classLoader));
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void scanJar(File file, ClassLoader classLoader) throws IOException {
            JarFile jarFile;
            try {
                jarFile = new JarFile(file);
            }
            catch (IOException iOException) {
                return;
            }
            try {
                for (URI object : Scanner.getClassPathFromManifest(file, jarFile.getManifest())) {
                    this.scan(object, classLoader);
                }
                Enumeration<JarEntry> enumeration = jarFile.entries();
                while (enumeration.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry)enumeration.nextElement();
                    if (jarEntry.isDirectory() || jarEntry.getName().equals("META-INF/MANIFEST.MF")) continue;
                    this.resources.add((Object)ResourceInfo.of(jarEntry.getName(), classLoader));
                }
            }
            finally {
                try {
                    jarFile.close();
                }
                catch (IOException iOException) {}
            }
        }

        @VisibleForTesting
        static ImmutableSet<URI> getClassPathFromManifest(File file, @Nullable Manifest manifest) {
            if (manifest == null) {
                return ImmutableSet.of();
            }
            ImmutableSet.Builder builder = ImmutableSet.builder();
            String string = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (string != null) {
                for (String string2 : CLASS_PATH_ATTRIBUTE_SEPARATOR.split(string)) {
                    URI uRI;
                    try {
                        uRI = Scanner.getClassPathEntry(file, string2);
                    }
                    catch (URISyntaxException uRISyntaxException) {
                        logger.warning("Invalid Class-Path entry: " + string2);
                        continue;
                    }
                    builder.add(uRI);
                }
            }
            return builder.build();
        }

        @VisibleForTesting
        static URI getClassPathEntry(File file, String string) throws URISyntaxException {
            URI uRI = new URI(string);
            if (uRI.isAbsolute()) {
                return uRI;
            }
            return new File(file.getParentFile(), string.replace('/', File.separatorChar)).toURI();
        }
    }

    @Beta
    public static final class ClassInfo
    extends ResourceInfo {
        private final String className;

        ClassInfo(String string, ClassLoader classLoader) {
            super(string, classLoader);
            this.className = ClassPath.getClassName(string);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int n = this.className.lastIndexOf(36);
            if (n != -1) {
                String string = this.className.substring(n + 1);
                return CharMatcher.DIGIT.trimLeadingFrom(string);
            }
            String string = this.getPackageName();
            if (string.isEmpty()) {
                return this.className;
            }
            return this.className.substring(string.length() + 1);
        }

        public String getName() {
            return this.className;
        }

        public Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new IllegalStateException(classNotFoundException);
            }
        }

        @Override
        public String toString() {
            return this.className;
        }
    }

    @Beta
    public static class ResourceInfo {
        private final String resourceName;
        final ClassLoader loader;

        static ResourceInfo of(String string, ClassLoader classLoader) {
            if (string.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION)) {
                return new ClassInfo(string, classLoader);
            }
            return new ResourceInfo(string, classLoader);
        }

        ResourceInfo(String string, ClassLoader classLoader) {
            this.resourceName = Preconditions.checkNotNull(string);
            this.loader = Preconditions.checkNotNull(classLoader);
        }

        public final URL url() {
            return Preconditions.checkNotNull(this.loader.getResource(this.resourceName), "Failed to load resource: %s", this.resourceName);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object object) {
            if (object instanceof ResourceInfo) {
                ResourceInfo resourceInfo = (ResourceInfo)object;
                return this.resourceName.equals(resourceInfo.resourceName) && this.loader == resourceInfo.loader;
            }
            return false;
        }

        public String toString() {
            return this.resourceName;
        }
    }
}

