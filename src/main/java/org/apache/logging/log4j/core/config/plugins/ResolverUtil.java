package org.apache.logging.log4j.core.config.plugins;

import org.apache.logging.log4j.*;
import java.lang.annotation.*;
import org.apache.logging.log4j.core.helpers.*;
import java.net.*;
import org.osgi.framework.wiring.*;
import org.osgi.framework.*;
import java.util.*;
import java.io.*;
import java.util.jar.*;
import org.apache.logging.log4j.status.*;

public class ResolverUtil
{
    private static final Logger LOGGER;
    private static final String VFSZIP = "vfszip";
    private static final String BUNDLE_RESOURCE = "bundleresource";
    private final Set<Class<?>> classMatches;
    private final Set<URI> resourceMatches;
    private ClassLoader classloader;
    
    public ResolverUtil() {
        this.classMatches = new HashSet<Class<?>>();
        this.resourceMatches = new HashSet<URI>();
    }
    
    public Set<Class<?>> getClasses() {
        return this.classMatches;
    }
    
    public Set<URI> getResources() {
        return this.resourceMatches;
    }
    
    public ClassLoader getClassLoader() {
        return (this.classloader != null) ? this.classloader : (this.classloader = Loader.getClassLoader(ResolverUtil.class, null));
    }
    
    public void setClassLoader(final ClassLoader classloader) {
        this.classloader = classloader;
    }
    
    public void findImplementations(final Class<?> clazz, final String... array) {
        if (array == null) {
            return;
        }
        final IsA isA = new IsA(clazz);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.findInPackage(isA, array[i]);
        }
    }
    
    public void findSuffix(final String s, final String... array) {
        if (array == null) {
            return;
        }
        final NameEndsWith nameEndsWith = new NameEndsWith(s);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.findInPackage(nameEndsWith, array[i]);
        }
    }
    
    public void findAnnotated(final Class<? extends Annotation> clazz, final String... array) {
        if (array == null) {
            return;
        }
        final AnnotatedWith annotatedWith = new AnnotatedWith(clazz);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.findInPackage(annotatedWith, array[i]);
        }
    }
    
    public void findNamedResource(final String s, final String... array) {
        if (array == null) {
            return;
        }
        final NameIs nameIs = new NameIs(s);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.findInPackage(nameIs, array[i]);
        }
    }
    
    public void find(final Test test, final String... array) {
        if (array == null) {
            return;
        }
        for (int length = array.length, i = 0; i < length; ++i) {
            this.findInPackage(test, array[i]);
        }
    }
    
    public void findInPackage(final Test obj, String replace) {
        replace = replace.replace('.', '/');
        final ClassLoader classLoader = this.getClassLoader();
        Enumeration<URL> resources;
        try {
            resources = classLoader.getResources(replace);
        }
        catch (final IOException ex) {
            ResolverUtil.LOGGER.warn("Could not read package: " + replace, ex);
            return;
        }
        while (resources.hasMoreElements()) {
            try {
                final URL url = resources.nextElement();
                String s = URLDecoder.decode(url.getFile(), Charsets.UTF_8.name());
                if (s.startsWith("file:")) {
                    s = s.substring(5);
                }
                if (s.indexOf(33) > 0) {
                    s = s.substring(0, s.indexOf(33));
                }
                ResolverUtil.LOGGER.info("Scanning for classes in [" + s + "] matching criteria: " + obj);
                if ("vfszip".equals(url.getProtocol())) {
                    final String substring = s.substring(0, s.length() - replace.length() - 2);
                    final URL url2 = new URL(url.getProtocol(), url.getHost(), substring);
                    final JarInputStream jarInputStream = new JarInputStream(url2.openStream());
                    try {
                        this.loadImplementationsInJar(obj, replace, substring, jarInputStream);
                    }
                    finally {
                        this.close(jarInputStream, url2);
                    }
                }
                else if ("bundleresource".equals(url.getProtocol())) {
                    this.loadImplementationsInBundle(obj, replace);
                }
                else {
                    final File file = new File(s);
                    if (file.isDirectory()) {
                        this.loadImplementationsInDirectory(obj, replace, file);
                    }
                    else {
                        this.loadImplementationsInJar(obj, replace, file);
                    }
                }
            }
            catch (final IOException ex2) {
                ResolverUtil.LOGGER.warn("could not read entries", ex2);
            }
        }
    }
    
    private void loadImplementationsInBundle(final Test test, final String s) {
        final Iterator iterator = ((BundleWiring)FrameworkUtil.getBundle((Class)ResolverUtil.class).adapt((Class)BundleWiring.class)).listResources(s, "*.class", 1).iterator();
        while (iterator.hasNext()) {
            this.addIfMatching(test, (String)iterator.next());
        }
    }
    
    private void loadImplementationsInDirectory(final Test test, final String str, final File file) {
        final File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (final File file2 : listFiles) {
            final StringBuilder sb = new StringBuilder();
            sb.append(str).append("/").append(file2.getName());
            final String s = (str == null) ? file2.getName() : sb.toString();
            if (file2.isDirectory()) {
                this.loadImplementationsInDirectory(test, s, file2);
            }
            else if (this.isTestApplicable(test, file2.getName())) {
                this.addIfMatching(test, s);
            }
        }
    }
    
    private boolean isTestApplicable(final Test test, final String s) {
        int n = 414904984;
        while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case -1272184175: {
                    if (test.doesMatchClass()) {
                        n = 1032896489;
                        continue;
                    }
                    n = -158210352;
                    continue;
                }
                case 1032896489: {
                    return true;
                }
                case 414904984: {
                    if (!test.doesMatchResource()) {
                        n = -2141198265;
                        continue;
                    }
                    n = 1032896489;
                    continue;
                }
                case -158210352: {
                    return false;
                }
                case -2141198265: {
                    if (s.endsWith(".class")) {
                        n = -1272184175;
                        continue;
                    }
                    n = -158210352;
                    continue;
                }
            }
        }
    }
    
    private void loadImplementationsInJar(final Test test, final String s, final File obj) {
        JarInputStream jarInputStream = null;
        try {
            jarInputStream = new JarInputStream(new FileInputStream(obj));
            this.loadImplementationsInJar(test, s, obj.getPath(), jarInputStream);
        }
        catch (final FileNotFoundException ex) {
            ResolverUtil.LOGGER.error("Could not search jar file '" + obj + "' for classes matching criteria: " + test + " file not found");
        }
        catch (final IOException ex2) {
            ResolverUtil.LOGGER.error("Could not search jar file '" + obj + "' for classes matching criteria: " + test + " due to an IOException", ex2);
        }
        finally {
            this.close(jarInputStream, obj);
        }
    }
    
    private void close(final JarInputStream jarInputStream, final Object o) {
        if (jarInputStream != null) {
            try {
                jarInputStream.close();
            }
            catch (final IOException ex) {
                ResolverUtil.LOGGER.error("Error closing JAR file stream for {}", o, ex);
            }
        }
    }
    
    private void loadImplementationsInJar(final Test obj, final String prefix, final String str, final JarInputStream jarInputStream) {
        try {
            JarEntry nextJarEntry;
            while ((nextJarEntry = jarInputStream.getNextJarEntry()) != null) {
                final String name = nextJarEntry.getName();
                if (!nextJarEntry.isDirectory() && name.startsWith(prefix) && this.isTestApplicable(obj, name)) {
                    this.addIfMatching(obj, name);
                }
            }
        }
        catch (final IOException ex) {
            ResolverUtil.LOGGER.error("Could not search jar file '" + str + "' for classes matching criteria: " + obj + " due to an IOException", ex);
        }
    }
    
    protected void addIfMatching(final Test obj, final String s) {
        try {
            final ClassLoader classLoader = this.getClassLoader();
            if (obj.doesMatchClass()) {
                final String replace = s.substring(0, s.indexOf(46)).replace('/', '.');
                if (ResolverUtil.LOGGER.isDebugEnabled()) {
                    ResolverUtil.LOGGER.debug("Checking to see if class " + replace + " matches criteria [" + obj + "]");
                }
                final Class<?> loadClass = classLoader.loadClass(replace);
                if (obj.matches(loadClass)) {
                    this.classMatches.add(loadClass);
                }
            }
            if (obj.doesMatchResource()) {
                URL url = classLoader.getResource(s);
                if (url == null) {
                    url = classLoader.getResource(s.substring(1));
                }
                if (url != null && obj.matches(url.toURI())) {
                    this.resourceMatches.add(url.toURI());
                }
            }
        }
        catch (final Throwable t) {
            ResolverUtil.LOGGER.warn("Could not examine class '" + s + "' due to a " + t.getClass().getName() + " with message: " + t.getMessage());
        }
    }
    
    static {
        LOGGER = StatusLogger.getLogger();
    }
    
    public static class NameIs extends ResourceTest
    {
        private final String name;
        
        public NameIs(final String str) {
            this.name = "/" + str;
        }
        
        @Override
        public boolean matches(final URI uri) {
            return uri.getPath().endsWith(this.name);
        }
        
        @Override
        public String toString() {
            return "named " + this.name;
        }
    }
    
    public abstract static class ResourceTest implements Test
    {
        @Override
        public boolean matches(final Class<?> clazz) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean doesMatchClass() {
            return false;
        }
        
        @Override
        public boolean doesMatchResource() {
            return true;
        }
    }
    
    public interface Test
    {
        boolean matches(final Class<?> p0);
        
        boolean matches(final URI p0);
        
        boolean doesMatchClass();
        
        boolean doesMatchResource();
    }
    
    public static class AnnotatedWith extends ClassTest
    {
        private final Class<? extends Annotation> annotation;
        
        public AnnotatedWith(final Class<? extends Annotation> annotation) {
            this.annotation = annotation;
        }
        
        @Override
        public boolean matches(final Class<?> clazz) {
            return clazz != null && clazz.isAnnotationPresent(this.annotation);
        }
        
        @Override
        public String toString() {
            return "annotated with @" + this.annotation.getSimpleName();
        }
    }
    
    public abstract static class ClassTest implements Test
    {
        @Override
        public boolean matches(final URI uri) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean doesMatchClass() {
            return true;
        }
        
        @Override
        public boolean doesMatchResource() {
            return false;
        }
    }
    
    public static class NameEndsWith extends ClassTest
    {
        private final String suffix;
        
        public NameEndsWith(final String suffix) {
            this.suffix = suffix;
        }
        
        @Override
        public boolean matches(final Class<?> clazz) {
            return clazz != null && clazz.getName().endsWith(this.suffix);
        }
        
        @Override
        public String toString() {
            return "ends with the suffix " + this.suffix;
        }
    }
    
    public static class IsA extends ClassTest
    {
        private final Class<?> parent;
        
        public IsA(final Class<?> parent) {
            this.parent = parent;
        }
        
        @Override
        public boolean matches(final Class<?> clazz) {
            return clazz != null && this.parent.isAssignableFrom(clazz);
        }
        
        @Override
        public String toString() {
            return "is assignable to " + this.parent.getSimpleName();
        }
    }
}
