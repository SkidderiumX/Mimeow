/*
 * Decompiled with CFR 0.152.
 */
package x;

public class occd6cefb795 {
    public final byte[] \u0161;
    public final int \u010b;
    public final int \u00c8;
    public int \u0241;

    public occd6cefb795(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public occd6cefb795(byte[] byArray, int n, int n2) {
        this.\u0161 = byArray;
        this.\u010b = n;
        this.\u00c8 = n2;
    }

    public occd6cefb795 \u00df() {
        occd6cefb795 occd6cefb7952 = new occd6cefb795(this.\u0161, this.\u010b, this.\u00c8);
        occd6cefb7952.\u0241 = this.\u0241;
        return occd6cefb7952;
    }

    public int \u00fa() {
        return this.\u0241 >= this.\u00c8 ? 0 : this.\u0161[this.\u010b + this.\u0241++] & (0xF00670AD ^ 0xF0067052);
    }

    public int \u00f3(int n) {
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            n2 = n2 << (0x6EE768D5 ^ 0x6EE768DD) | this.\u00fa();
        }
        return n2;
    }

    public void \u02e0(int n) {
        this.\u0241 = n >= 0 && n <= this.\u00c8 ? n : this.\u00c8;
    }

    public void \u0576(int n) {
        this.\u02e0(this.\u0241 + n);
    }

    public occd6cefb795 \u0511(int n, int n2) {
        return n >= 0 && n2 >= 0 && n <= this.\u00c8 && n2 <= this.\u00c8 - n ? new occd6cefb795(this.\u0161, this.\u010b + n, n2) : new occd6cefb795(new byte[0]);
    }
}

