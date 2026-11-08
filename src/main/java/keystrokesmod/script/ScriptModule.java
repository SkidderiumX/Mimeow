/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import keystrokesmod.script.Script;
import x.oc2cf3d80e17;
import x.oc321b4679dd;
import x.oc69da1aa7f5;

public class ScriptModule
extends oc69da1aa7f5 {
    private final oc321b4679dd customName;

    public ScriptModule(Script script) {
        super(script);
        this.customName = new oc321b4679dd("Custom name", "", script.name, 0xF23718D ^ 0xF2371AD, this::renameDisplayName);
        this.z$1k81rl22ylo65(this.customName, "setting.customName");
    }

    @Override
    public String getDisplayName() {
        String string = this.customName.\u00ca().trim();
        return string.isEmpty() ? this.z$3i8m9vxwuvqj0() : string;
    }

    public String getCustomName() {
        return this.customName.\u00ca();
    }

    public void setCustomName(String string) {
        this.customName.z$1bnplyl2p7uqx(string == null ? "" : string.trim());
        oc69da1aa7f5.\u02e4 = true;
    }

    private void renameDisplayName() {
        this.setCustomName(this.customName.\u00ca());
        oc2cf3d80e17.\u04eb();
    }

    @Override
    public boolean canBeEnabled() {
        return super.canBeEnabled() && (this.\u01f4 == null || !this.\u01f4.error);
    }

    @Override
    public void onEnable() {
        if (this.\u01f4 != null && oc2cf3d80e17.\u013e != null) {
            oc2cf3d80e17.\u013e.onEnable(this.\u01f4);
        }
    }

    @Override
    public void onDisable() {
        if (this.\u01f4 != null && oc2cf3d80e17.\u013e != null) {
            oc2cf3d80e17.\u013e.onDisable(this.\u01f4);
        }
    }

    @Override
    public String getInfo() {
        if (this.\u01f4 != null) {
            String string = this.\u01f4.getString("getSuffix", new Object[0]);
            return string == null ? "" : string;
        }
        return super.getInfo();
    }
}

