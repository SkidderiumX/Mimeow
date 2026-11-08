/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class JSONConfiguration
extends BaseConfiguration
implements Reconfigurable {
    private static final String[] VERBOSE_CLASSES = new String[]{ResolverUtil.class.getName()};
    private static final int BUF_SIZE = 16384;
    private final List<Status> status = new ArrayList<Status>();
    private JsonNode root;
    private final List<String> messages = new ArrayList<String>();
    private final File configFile;

    public JSONConfiguration(ConfigurationFactory.ConfigurationSource configurationSource) {
        this.configFile = configurationSource.getFile();
        try {
            Object object;
            InputStream inputStream2 = configurationSource.getInputStream();
            byte[] byArray = this.toByteArray(inputStream2);
            inputStream2.close();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            ObjectMapper objectMapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_COMMENTS, true);
            this.root = objectMapper.readTree((InputStream)byteArrayInputStream);
            if (this.root.size() == 1) {
                object = this.root.elements();
                this.root = (JsonNode)object.next();
            }
            this.processAttributes(this.rootNode, this.root);
            object = this.getDefaultStatus();
            boolean bl = false;
            PrintStream printStream = System.out;
            for (Map.Entry<String, String> entry : this.rootNode.getAttributes().entrySet()) {
                if ("status".equalsIgnoreCase(entry.getKey())) {
                    object = Level.toLevel(this.getStrSubstitutor().replace(entry.getValue()), null);
                    if (object != null) continue;
                    object = Level.ERROR;
                    this.messages.add("Invalid status specified: " + entry.getValue() + ". Defaulting to ERROR");
                    continue;
                }
                if ("dest".equalsIgnoreCase(entry.getKey())) {
                    String string = entry.getValue();
                    if (string == null) continue;
                    if (string.equalsIgnoreCase("err")) {
                        printStream = System.err;
                        continue;
                    }
                    try {
                        String[] stringArray = FileUtils.fileFromURI(new URI(string));
                        String string2 = Charset.defaultCharset().name();
                        printStream = new PrintStream((OutputStream)new FileOutputStream((File)stringArray), true, string2);
                    }
                    catch (URISyntaxException uRISyntaxException) {
                        System.err.println("Unable to write to " + string + ". Writing to stdout");
                    }
                    continue;
                }
                if ("shutdownHook".equalsIgnoreCase(entry.getKey())) {
                    String string = this.getStrSubstitutor().replace(entry.getValue());
                    this.isShutdownHookEnabled = !string.equalsIgnoreCase("disable");
                    continue;
                }
                if ("verbose".equalsIgnoreCase(entry.getKey())) {
                    bl = Boolean.parseBoolean(this.getStrSubstitutor().replace(entry.getValue()));
                    continue;
                }
                if ("packages".equalsIgnoreCase(entry.getKey())) {
                    String[] stringArray;
                    for (String string : stringArray = this.getStrSubstitutor().replace(entry.getValue()).split(",")) {
                        PluginManager.addPackage(string);
                    }
                    continue;
                }
                if ("name".equalsIgnoreCase(entry.getKey())) {
                    this.setName(this.getStrSubstitutor().replace(entry.getValue()));
                    continue;
                }
                if ("monitorInterval".equalsIgnoreCase(entry.getKey())) {
                    int n = Integer.parseInt(this.getStrSubstitutor().replace(entry.getValue()));
                    if (n <= 0 || this.configFile == null) continue;
                    this.monitor = new FileConfigurationMonitor(this, this.configFile, this.listeners, n);
                    continue;
                }
                if (!"advertiser".equalsIgnoreCase(entry.getKey())) continue;
                this.createAdvertiser(this.getStrSubstitutor().replace(entry.getValue()), configurationSource, byArray, "application/json");
            }
            Iterator<Object> iterator2 = ((StatusLogger)LOGGER).getListeners();
            boolean bl2 = false;
            while (iterator2.hasNext()) {
                StatusListener statusListener = (StatusListener)iterator2.next();
                if (!(statusListener instanceof StatusConsoleListener)) continue;
                bl2 = true;
                ((StatusConsoleListener)statusListener).setLevel((Level)((Object)object));
                if (bl) continue;
                ((StatusConsoleListener)statusListener).setFilters(VERBOSE_CLASSES);
            }
            if (!bl2 && object != Level.OFF) {
                StatusConsoleListener statusConsoleListener = new StatusConsoleListener((Level)((Object)object), printStream);
                if (!bl) {
                    statusConsoleListener.setFilters(VERBOSE_CLASSES);
                }
                ((StatusLogger)LOGGER).registerListener(statusConsoleListener);
                for (String string2 : this.messages) {
                    LOGGER.error(string2);
                }
            }
            if (this.getName() == null) {
                this.setName(configurationSource.getLocation());
            }
        }
        catch (Exception exception) {
            LOGGER.error("Error parsing " + configurationSource.getLocation(), (Throwable)exception);
            exception.printStackTrace();
        }
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void setup() {
        Iterator iterator2 = this.root.fields();
        List<Node> list = this.rootNode.getChildren();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            JsonNode object = (JsonNode)entry.getValue();
            if (object.isObject()) {
                LOGGER.debug("Processing node for object " + (String)entry.getKey());
                list.add(this.constructNode((String)entry.getKey(), this.rootNode, object));
                continue;
            }
            if (!object.isArray()) continue;
            LOGGER.error("Arrays are not supported at the root configuration.");
        }
        LOGGER.debug("Completed parsing configuration");
        if (this.status.size() > 0) {
            for (Status status : this.status) {
                LOGGER.error("Error processing element " + status.name + ": " + (Object)((Object)status.errorType));
            }
            return;
        }
    }

    @Override
    public Configuration reconfigure() {
        if (this.configFile != null) {
            try {
                ConfigurationFactory.ConfigurationSource configurationSource = new ConfigurationFactory.ConfigurationSource((InputStream)new FileInputStream(this.configFile), this.configFile);
                return new JSONConfiguration(configurationSource);
            }
            catch (FileNotFoundException fileNotFoundException) {
                LOGGER.error("Cannot locate file " + this.configFile, (Throwable)fileNotFoundException);
            }
        }
        return null;
    }

    private Node constructNode(String string, Node node, JsonNode jsonNode) {
        Object object;
        Object object2;
        PluginType<?> pluginType = this.pluginManager.getPluginType(string);
        Node node2 = new Node(node, string, pluginType);
        this.processAttributes(node2, jsonNode);
        Iterator iterator2 = jsonNode.fields();
        List<Node> list = node2.getChildren();
        while (iterator2.hasNext()) {
            object2 = (Map.Entry)iterator2.next();
            object = (JsonNode)object2.getValue();
            if (!object.isArray() && !object.isObject()) continue;
            if (pluginType == null) {
                this.status.add(new Status(string, (JsonNode)object, ErrorType.CLASS_NOT_FOUND));
            }
            if (object.isArray()) {
                LOGGER.debug("Processing node for array " + (String)object2.getKey());
                for (int i = 0; i < object.size(); ++i) {
                    String string2 = this.getType(object.get(i), (String)object2.getKey());
                    PluginType<?> pluginType2 = this.pluginManager.getPluginType(string2);
                    Node node3 = new Node(node2, (String)object2.getKey(), pluginType2);
                    this.processAttributes(node3, object.get(i));
                    if (string2.equals(object2.getKey())) {
                        LOGGER.debug("Processing " + (String)object2.getKey() + "[" + i + "]");
                    } else {
                        LOGGER.debug("Processing " + string2 + " " + (String)object2.getKey() + "[" + i + "]");
                    }
                    Iterator iterator3 = object.get(i).fields();
                    List<Node> list2 = node3.getChildren();
                    while (iterator3.hasNext()) {
                        Map.Entry entry = (Map.Entry)iterator3.next();
                        if (!((JsonNode)entry.getValue()).isObject()) continue;
                        LOGGER.debug("Processing node for object " + (String)entry.getKey());
                        list2.add(this.constructNode((String)entry.getKey(), node3, (JsonNode)entry.getValue()));
                    }
                    list.add(node3);
                }
                continue;
            }
            LOGGER.debug("Processing node for object " + (String)object2.getKey());
            list.add(this.constructNode((String)object2.getKey(), node2, (JsonNode)object));
        }
        object2 = pluginType == null ? "null" : pluginType.getElementName() + ":" + pluginType.getPluginClass();
        object = node2.getParent() == null ? "null" : (node2.getParent().getName() == null ? "root" : node2.getParent().getName());
        LOGGER.debug("Returning " + node2.getName() + " with parent " + (String)object + " of type " + (String)object2);
        return node2;
    }

    private String getType(JsonNode jsonNode, String string) {
        Iterator iterator2 = jsonNode.fields();
        while (iterator2.hasNext()) {
            JsonNode jsonNode2;
            Map.Entry entry = (Map.Entry)iterator2.next();
            if (!((String)entry.getKey()).equalsIgnoreCase("type") || !(jsonNode2 = (JsonNode)entry.getValue()).isValueNode()) continue;
            return jsonNode2.asText();
        }
        return string;
    }

    private void processAttributes(Node node, JsonNode jsonNode) {
        Map<String, String> map = node.getAttributes();
        Iterator iterator2 = jsonNode.fields();
        while (iterator2.hasNext()) {
            JsonNode jsonNode2;
            Map.Entry entry = (Map.Entry)iterator2.next();
            if (((String)entry.getKey()).equalsIgnoreCase("type") || !(jsonNode2 = (JsonNode)entry.getValue()).isValueNode()) continue;
            map.put((String)entry.getKey(), jsonNode2.asText());
        }
    }

    protected byte[] toByteArray(InputStream inputStream2) throws IOException {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[16384];
        while ((n = inputStream2.read(byArray, 0, byArray.length)) != -1) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private class Status {
        private final JsonNode node;
        private final String name;
        private final ErrorType errorType;

        public Status(String string, JsonNode jsonNode, ErrorType errorType) {
            this.name = string;
            this.node = jsonNode;
            this.errorType = errorType;
        }
    }

    private static enum ErrorType {
        CLASS_NOT_FOUND;

    }
}

