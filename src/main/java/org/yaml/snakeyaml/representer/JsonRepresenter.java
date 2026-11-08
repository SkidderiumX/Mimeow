/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.representer;

import java.util.Base64;
import java.util.Date;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Represent;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.representer.SafeRepresenter;

public class JsonRepresenter
extends Representer {
    public JsonRepresenter(DumperOptions dumperOptions) {
        super(dumperOptions);
        this.representers.put(byte[].class, new RepresentByteArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        if (dumperOptions.getDefaultScalarStyle() != DumperOptions.ScalarStyle.JSON_SCALAR_STYLE) {
            throw new IllegalStateException("JSON requires ScalarStyle.JSON_SCALAR_STYLE");
        }
        if (dumperOptions.getNonPrintableStyle() != DumperOptions.NonPrintableStyle.ESCAPE) {
            throw new IllegalStateException("JSON requires NonPrintableStyle.ESCAPE");
        }
    }

    protected class RepresentByteArray
    implements Represent {
        protected RepresentByteArray() {
        }

        @Override
        public Node representData(Object object) {
            String string = Base64.getEncoder().encodeToString((byte[])object);
            return JsonRepresenter.this.representScalar(Tag.STR, string);
        }
    }

    protected class RepresentDate
    extends SafeRepresenter.RepresentDate {
        protected RepresentDate() {
        }

        @Override
        public Tag getDefaultTag() {
            return Tag.STR;
        }
    }
}

