/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.BaseConfiguration;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.FileConfigurationMonitor;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.Reconfigurable;
import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.apache.logging.log4j.core.config.plugins.PluginType;
import org.apache.logging.log4j.core.config.plugins.ResolverUtil;
import org.apache.logging.log4j.core.helpers.FileUtils;
import org.apache.logging.log4j.status.StatusConsoleListener;
import org.apache.logging.log4j.status.StatusListener;
import org.apache.logging.log4j.status.StatusLogger;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLConfiguration
extends BaseConfiguration
implements Reconfigurable {
    private static final String XINCLUDE_FIXUP_LANGUAGE = "http://apache.org/xml/features/xinclude/fixup-language";
    private static final String XINCLUDE_FIXUP_BASE_URIS = "http://apache.org/xml/features/xinclude/fixup-base-uris";
    private static final String[] VERBOSE_CLASSES = new String[]{ResolverUtil.class.getName()};
    private static final String LOG4J_XSD = "Log4j-config.xsd";
    private static final int BUF_SIZE = 16384;
    private final List<Status> status = new ArrayList<Status>();
    private Element rootElement;
    private boolean strict;
    private String schema;
    private final File configFile;

    static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        XMLConfiguration.enableXInclude(documentBuilderFactory);
        return documentBuilderFactory.newDocumentBuilder();
    }

    private static void enableXInclude(DocumentBuilderFactory documentBuilderFactory) {
        try {
            documentBuilderFactory.setXIncludeAware(true);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            LOGGER.warn("The DocumentBuilderFactory does not support XInclude: " + documentBuilderFactory, (Throwable)unsupportedOperationException);
        }
        catch (AbstractMethodError abstractMethodError) {
            LOGGER.warn("The DocumentBuilderFactory is out of date and does not support XInclude: " + documentBuilderFactory);
        }
        try {
            documentBuilderFactory.setFeature(XINCLUDE_FIXUP_BASE_URIS, true);
        }
        catch (ParserConfigurationException parserConfigurationException) {
            LOGGER.warn("The DocumentBuilderFactory [" + documentBuilderFactory + "] does not support the feature [" + XINCLUDE_FIXUP_BASE_URIS + "]", (Throwable)parserConfigurationException);
        }
        catch (AbstractMethodError abstractMethodError) {
            LOGGER.warn("The DocumentBuilderFactory is out of date and does not support setFeature: " + documentBuilderFactory);
        }
        try {
            documentBuilderFactory.setFeature(XINCLUDE_FIXUP_LANGUAGE, true);
        }
        catch (ParserConfigurationException parserConfigurationException) {
            LOGGER.warn("The DocumentBuilderFactory [" + documentBuilderFactory + "] does not support the feature [" + XINCLUDE_FIXUP_LANGUAGE + "]", (Throwable)parserConfigurationException);
        }
        catch (AbstractMethodError abstractMethodError) {
            LOGGER.warn("The DocumentBuilderFactory is out of date and does not support setFeature: " + documentBuilderFactory);
        }
    }

    public XMLConfiguration(ConfigurationFactory.ConfigurationSource configurationSource) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        this.configFile = configurationSource.getFile();
        byte[] byArray = null;
        try {
            String string;
            String[] stringArray;
            object5 = new ArrayList();
            object4 = configurationSource.getInputStream();
            byArray = this.toByteArray((InputStream)object4);
            ((InputStream)object4).close();
            object3 = new InputSource(new ByteArrayInputStream(byArray));
            object2 = XMLConfiguration.newDocumentBuilder().parse((InputSource)object3);
            this.rootElement = object2.getDocumentElement();
            object = this.processAttributes(this.rootNode, this.rootElement);
            Level level = this.getDefaultStatus();
            boolean bl = false;
            PrintStream printStream = System.out;
            for (Map.Entry<String, String> entry : object.entrySet()) {
                if ("status".equalsIgnoreCase(entry.getKey())) {
                    Level level2 = Level.toLevel(this.getStrSubstitutor().replace(entry.getValue()), null);
                    if (level2 != null) {
                        level = level2;
                        continue;
                    }
                    object5.add("Invalid status specified: " + entry.getValue() + ". Defaulting to " + (Object)((Object)level));
                    continue;
                }
                if ("dest".equalsIgnoreCase(entry.getKey())) {
                    String string2 = this.getStrSubstitutor().replace(entry.getValue());
                    if (string2 == null) continue;
                    if (string2.equalsIgnoreCase("err")) {
                        printStream = System.err;
                        continue;
                    }
                    try {
                        stringArray = FileUtils.fileFromURI(new URI(string2));
                        string = Charset.defaultCharset().name();
                        printStream = new PrintStream((OutputStream)new FileOutputStream((File)stringArray), true, string);
                    }
                    catch (URISyntaxException uRISyntaxException) {
                        System.err.println("Unable to write to " + string2 + ". Writing to stdout");
                    }
                    continue;
                }
                if ("shutdownHook".equalsIgnoreCase(entry.getKey())) {
                    String string3 = this.getStrSubstitutor().replace(entry.getValue());
                    this.isShutdownHookEnabled = !string3.equalsIgnoreCase("disable");
                    continue;
                }
                if ("verbose".equalsIgnoreCase(entry.getKey())) {
                    bl = Boolean.parseBoolean(this.getStrSubstitutor().replace(entry.getValue()));
                    continue;
                }
                if ("packages".equalsIgnoreCase(this.getStrSubstitutor().replace(entry.getKey()))) {
                    String[] stringArray2;
                    for (String string4 : stringArray2 = entry.getValue().split(",")) {
                        PluginManager.addPackage(string4);
                    }
                    continue;
                }
                if ("name".equalsIgnoreCase(entry.getKey())) {
                    this.setName(this.getStrSubstitutor().replace(entry.getValue()));
                    continue;
                }
                if ("strict".equalsIgnoreCase(entry.getKey())) {
                    this.strict = Boolean.parseBoolean(this.getStrSubstitutor().replace(entry.getValue()));
                    continue;
                }
                if ("schema".equalsIgnoreCase(entry.getKey())) {
                    this.schema = this.getStrSubstitutor().replace(entry.getValue());
                    continue;
                }
                if ("monitorInterval".equalsIgnoreCase(entry.getKey())) {
                    int n = Integer.parseInt(this.getStrSubstitutor().replace(entry.getValue()));
                    if (n <= 0 || this.configFile == null) continue;
                    this.monitor = new FileConfigurationMonitor(this, this.configFile, this.listeners, n);
                    continue;
                }
                if (!"advertiser".equalsIgnoreCase(entry.getKey())) continue;
                this.createAdvertiser(this.getStrSubstitutor().replace(entry.getValue()), configurationSource, byArray, "text/xml");
            }
            Iterator<Object> iterator2 = ((StatusLogger)LOGGER).getListeners();
            boolean bl2 = false;
            while (iterator2.hasNext()) {
                StatusListener statusListener = (StatusListener)iterator2.next();
                if (!(statusListener instanceof StatusConsoleListener)) continue;
                bl2 = true;
                ((StatusConsoleListener)statusListener).setLevel(level);
                if (bl) continue;
                ((StatusConsoleListener)statusListener).setFilters(VERBOSE_CLASSES);
            }
            if (!bl2 && level != Level.OFF) {
                StatusConsoleListener statusConsoleListener = new StatusConsoleListener(level, printStream);
                if (!bl) {
                    statusConsoleListener.setFilters(VERBOSE_CLASSES);
                }
                ((StatusLogger)LOGGER).registerListener(statusConsoleListener);
                stringArray = object5.iterator();
                while (stringArray.hasNext()) {
                    string = (String)stringArray.next();
                    LOGGER.error(string);
                }
            }
        }
        catch (SAXException sAXException) {
            LOGGER.error("Error parsing " + configurationSource.getLocation(), (Throwable)sAXException);
        }
        catch (IOException iOException) {
            LOGGER.error("Error parsing " + configurationSource.getLocation(), (Throwable)iOException);
        }
        catch (ParserConfigurationException parserConfigurationException) {
            LOGGER.error("Error parsing " + configurationSource.getLocation(), (Throwable)parserConfigurationException);
        }
        if (this.strict && this.schema != null && byArray != null) {
            object5 = null;
            try {
                object5 = this.getClass().getClassLoader().getResourceAsStream(this.schema);
            }
            catch (Exception exception) {
                LOGGER.error("Unable to access schema " + this.schema);
            }
            if (object5 != null) {
                object4 = new StreamSource((InputStream)object5, LOG4J_XSD);
                object3 = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
                object2 = null;
                try {
                    object2 = ((SchemaFactory)object3).newSchema((Source)object4);
                }
                catch (SAXException sAXException) {
                    LOGGER.error("Error parsing Log4j schema", (Throwable)sAXException);
                }
                if (object2 != null) {
                    object = ((Schema)object2).newValidator();
                    try {
                        ((Validator)object).validate(new StreamSource(new ByteArrayInputStream(byArray)));
                    }
                    catch (IOException iOException) {
                        LOGGER.error("Error reading configuration for validation", (Throwable)iOException);
                    }
                    catch (SAXException sAXException) {
                        LOGGER.error("Error validating configuration", (Throwable)sAXException);
                    }
                }
            }
        }
        if (this.getName() == null) {
            this.setName(configurationSource.getLocation());
        }
    }

    @Override
    public void setup() {
        if (this.rootElement == null) {
            LOGGER.error("No logging configuration");
            return;
        }
        this.constructHierarchy(this.rootNode, this.rootElement);
        if (this.status.size() > 0) {
            for (Status status : this.status) {
                LOGGER.error("Error processing element " + status.name + ": " + (Object)((Object)status.errorType));
            }
            return;
        }
        this.rootElement = null;
    }

    @Override
    public Configuration reconfigure() {
        if (this.configFile != null) {
            try {
                ConfigurationFactory.ConfigurationSource configurationSource = new ConfigurationFactory.ConfigurationSource((InputStream)new FileInputStream(this.configFile), this.configFile);
                return new XMLConfiguration(configurationSource);
            }
            catch (FileNotFoundException fileNotFoundException) {
                LOGGER.error("Cannot locate file " + this.configFile, (Throwable)fileNotFoundException);
            }
        }
        return null;
    }

    private void constructHierarchy(Node node, Element element) {
        this.processAttributes(node, element);
        StringBuilder stringBuilder = new StringBuilder();
        NodeList nodeList = element.getChildNodes();
        List<Node> list = node.getChildren();
        for (int i = 0; i < nodeList.getLength(); ++i) {
            org.w3c.dom.Node node2;
            org.w3c.dom.Node node3 = nodeList.item(i);
            if (node3 instanceof Element) {
                node2 = (Element)node3;
                String string = this.getType((Element)node2);
                PluginType<?> pluginType = this.pluginManager.getPluginType(string);
                Node node4 = new Node(node, string, pluginType);
                this.constructHierarchy(node4, (Element)node2);
                if (pluginType == null) {
                    String string2 = node4.getValue();
                    if (!node4.hasChildren() && string2 != null) {
                        node.getAttributes().put(string, string2);
                        continue;
                    }
                    this.status.add(new Status(string, element, ErrorType.CLASS_NOT_FOUND));
                    continue;
                }
                list.add(node4);
                continue;
            }
            if (!(node3 instanceof Text)) continue;
            node2 = (Text)node3;
            stringBuilder.append(node2.getData());
        }
        String string = stringBuilder.toString().trim();
        if (string.length() > 0 || !node.hasChildren() && !node.isRoot()) {
            node.setValue(string);
        }
    }

    private String getType(Element element) {
        if (this.strict) {
            NamedNodeMap namedNodeMap = element.getAttributes();
            for (int i = 0; i < namedNodeMap.getLength(); ++i) {
                Attr attr;
                org.w3c.dom.Node node = namedNodeMap.item(i);
                if (!(node instanceof Attr) || !(attr = (Attr)node).getName().equalsIgnoreCase("type")) continue;
                String string = attr.getValue();
                namedNodeMap.removeNamedItem(attr.getName());
                return string;
            }
        }
        return element.getTagName();
    }

    private byte[] toByteArray(InputStream inputStream2) throws IOException {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[16384];
        while ((n = inputStream2.read(byArray, 0, byArray.length)) != -1) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private Map<String, String> processAttributes(Node node, Element element) {
        NamedNodeMap namedNodeMap = element.getAttributes();
        Map<String, String> map = node.getAttributes();
        for (int i = 0; i < namedNodeMap.getLength(); ++i) {
            Attr attr;
            org.w3c.dom.Node node2 = namedNodeMap.item(i);
            if (!(node2 instanceof Attr) || (attr = (Attr)node2).getName().equals("xml:base")) continue;
            map.put(attr.getName(), attr.getValue());
        }
        return map;
    }

    private class Status {
        private final Element element;
        private final String name;
        private final ErrorType errorType;

        public Status(String string, Element element, ErrorType errorType) {
            this.name = string;
            this.element = element;
            this.errorType = errorType;
        }
    }

    private static enum ErrorType {
        CLASS_NOT_FOUND;

    }
}

