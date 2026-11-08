/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Packet;
import com.jcraft.jogg.Page;
import com.jcraft.jogg.StreamState;
import com.jcraft.jogg.SyncState;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Comment;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.Info;
import com.jcraft.jorbis.JOrbisException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class VorbisFile {
    static final int CHUNKSIZE = 8500;
    static final int SEEK_SET = 0;
    static final int SEEK_CUR = 1;
    static final int SEEK_END = 2;
    static final int OV_FALSE = -1;
    static final int OV_EOF = -2;
    static final int OV_HOLE = -3;
    static final int OV_EREAD = -128;
    static final int OV_EFAULT = -129;
    static final int OV_EIMPL = -130;
    static final int OV_EINVAL = -131;
    static final int OV_ENOTVORBIS = -132;
    static final int OV_EBADHEADER = -133;
    static final int OV_EVERSION = -134;
    static final int OV_ENOTAUDIO = -135;
    static final int OV_EBADPACKET = -136;
    static final int OV_EBADLINK = -137;
    static final int OV_ENOSEEK = -138;
    InputStream datasource;
    boolean seekable = false;
    long offset;
    long end;
    SyncState oy = new SyncState();
    int links;
    long[] offsets;
    long[] dataoffsets;
    int[] serialnos;
    long[] pcmlengths;
    Info[] vi;
    Comment[] vc;
    long pcm_offset;
    boolean decode_ready = false;
    int current_serialno;
    int current_link;
    float bittrack;
    float samptrack;
    StreamState os = new StreamState();
    DspState vd = new DspState();
    Block vb = new Block(this.vd);

    public VorbisFile(String string) throws JOrbisException {
        SeekableInputStream seekableInputStream = null;
        try {
            seekableInputStream = new SeekableInputStream(string);
            int n = this.open(seekableInputStream, null, 0);
            if (n == -1) {
                throw new JOrbisException("VorbisFile: open return -1");
            }
        }
        catch (Exception exception) {
            throw new JOrbisException("VorbisFile: " + exception.toString());
        }
        finally {
            if (seekableInputStream != null) {
                try {
                    ((InputStream)seekableInputStream).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
    }

    public VorbisFile(InputStream inputStream2, byte[] byArray, int n) throws JOrbisException {
        int n2 = this.open(inputStream2, byArray, n);
        if (n2 == -1) {
            // empty if block
        }
    }

    private int get_data() {
        int n = this.oy.buffer(8500);
        byte[] byArray = this.oy.data;
        int n2 = 0;
        try {
            n2 = this.datasource.read(byArray, n, 8500);
        }
        catch (Exception exception) {
            return -128;
        }
        this.oy.wrote(n2);
        if (n2 == -1) {
            n2 = 0;
        }
        return n2;
    }

    private void seek_helper(long l) {
        VorbisFile.fseek(this.datasource, l, 0);
        this.offset = l;
        this.oy.reset();
    }

    private int get_next_page(Page page, long l) {
        int n;
        int n2;
        block6: {
            if (l > 0L) {
                l += this.offset;
            }
            while (true) {
                if (l > 0L && this.offset >= l) {
                    return -1;
                }
                n2 = this.oy.pageseek(page);
                if (n2 < 0) {
                    this.offset -= (long)n2;
                    continue;
                }
                if (n2 != 0) break block6;
                if (l == 0L) {
                    return -1;
                }
                n = this.get_data();
                if (n == 0) {
                    return -2;
                }
                if (n < 0) break;
            }
            return -128;
        }
        n = (int)this.offset;
        this.offset += (long)n2;
        return n;
    }

    private int get_prev_page(Page page) throws JOrbisException {
        int n;
        long l = this.offset;
        int n2 = -1;
        block0: while (n2 == -1) {
            if ((l -= 8500L) < 0L) {
                l = 0L;
            }
            this.seek_helper(l);
            while (this.offset < l + 8500L) {
                n = this.get_next_page(page, l + 8500L - this.offset);
                if (n == -128) {
                    return -128;
                }
                if (n < 0) {
                    if (n2 != -1) continue block0;
                    throw new JOrbisException();
                }
                n2 = n;
            }
        }
        this.seek_helper(n2);
        n = this.get_next_page(page, 8500L);
        if (n < 0) {
            return -129;
        }
        return n2;
    }

    int bisect_forward_serialno(long l, long l2, long l3, int n, int n2) {
        int n3;
        long l4 = l3;
        long l5 = l3;
        Page page = new Page();
        while (l2 < l4) {
            long l6 = l4 - l2 < 8500L ? l2 : (l2 + l4) / 2L;
            this.seek_helper(l6);
            n3 = this.get_next_page(page, -1L);
            if (n3 == -128) {
                return -128;
            }
            if (n3 < 0 || page.serialno() != n) {
                l4 = l6;
                if (n3 < 0) continue;
                l5 = n3;
                continue;
            }
            l2 = n3 + page.header_len + page.body_len;
        }
        this.seek_helper(l5);
        n3 = this.get_next_page(page, -1L);
        if (n3 == -128) {
            return -128;
        }
        if (l2 >= l3 || n3 == -1) {
            this.links = n2 + 1;
            this.offsets = new long[n2 + 2];
            this.offsets[n2 + 1] = l2;
        } else {
            n3 = this.bisect_forward_serialno(l5, this.offset, l3, page.serialno(), n2 + 1);
            if (n3 == -128) {
                return -128;
            }
        }
        this.offsets[n2] = l;
        return 0;
    }

    int fetch_headers(Info info, Comment comment, int[] nArray, Page page) {
        Page page2 = new Page();
        Packet packet = new Packet();
        if (page == null) {
            int n = this.get_next_page(page2, 8500L);
            if (n == -128) {
                return -128;
            }
            if (n < 0) {
                return -132;
            }
            page = page2;
        }
        if (nArray != null) {
            nArray[0] = page.serialno();
        }
        this.os.init(page.serialno());
        info.init();
        comment.init();
        int n = 0;
        while (n < 3) {
            int n2;
            this.os.pagein(page);
            while (n < 3 && (n2 = this.os.packetout(packet)) != 0) {
                if (n2 == -1) {
                    info.clear();
                    comment.clear();
                    this.os.clear();
                    return -1;
                }
                if (info.synthesis_headerin(comment, packet) != 0) {
                    info.clear();
                    comment.clear();
                    this.os.clear();
                    return -1;
                }
                ++n;
            }
            if (n >= 3 || this.get_next_page(page, 1L) >= 0) continue;
            info.clear();
            comment.clear();
            this.os.clear();
            return -1;
        }
        return 0;
    }

    void prefetch_all_headers(Info info, Comment comment, int n) throws JOrbisException {
        Page page = new Page();
        this.vi = new Info[this.links];
        this.vc = new Comment[this.links];
        this.dataoffsets = new long[this.links];
        this.pcmlengths = new long[this.links];
        this.serialnos = new int[this.links];
        block0: for (int i = 0; i < this.links; ++i) {
            if (info != null && comment != null && i == 0) {
                this.vi[i] = info;
                this.vc[i] = comment;
                this.dataoffsets[i] = n;
            } else {
                this.seek_helper(this.offsets[i]);
                this.vi[i] = new Info();
                this.vc[i] = new Comment();
                if (this.fetch_headers(this.vi[i], this.vc[i], null, null) == -1) {
                    this.dataoffsets[i] = -1L;
                } else {
                    this.dataoffsets[i] = this.offset;
                    this.os.clear();
                }
            }
            long l = this.offsets[i + 1];
            this.seek_helper(l);
            do {
                int n2;
                if ((n2 = this.get_prev_page(page)) != -1) continue;
                this.vi[i].clear();
                this.vc[i].clear();
                continue block0;
            } while (page.granulepos() == -1L);
            this.serialnos[i] = page.serialno();
            this.pcmlengths[i] = page.granulepos();
        }
    }

    private int make_decode_ready() {
        if (this.decode_ready) {
            System.exit(1);
        }
        this.vd.synthesis_init(this.vi[0]);
        this.vb.init(this.vd);
        this.decode_ready = true;
        return 0;
    }

    int open_seekable() throws JOrbisException {
        Info info = new Info();
        Comment comment = new Comment();
        Page page = new Page();
        int[] nArray = new int[1];
        int n = this.fetch_headers(info, comment, nArray, null);
        int n2 = nArray[0];
        int n3 = (int)this.offset;
        this.os.clear();
        if (n == -1) {
            return -1;
        }
        if (n < 0) {
            return n;
        }
        this.seekable = true;
        VorbisFile.fseek(this.datasource, 0L, 2);
        long l = this.offset = VorbisFile.ftell(this.datasource);
        l = this.get_prev_page(page);
        if (page.serialno() != n2) {
            if (this.bisect_forward_serialno(0L, 0L, l + 1L, n2, 0) < 0) {
                this.clear();
                return -128;
            }
        } else if (this.bisect_forward_serialno(0L, l, l + 1L, n2, 0) < 0) {
            this.clear();
            return -128;
        }
        this.prefetch_all_headers(info, comment, n3);
        return 0;
    }

    int open_nonseekable() {
        this.links = 1;
        this.vi = new Info[this.links];
        this.vi[0] = new Info();
        this.vc = new Comment[this.links];
        this.vc[0] = new Comment();
        int[] nArray = new int[1];
        if (this.fetch_headers(this.vi[0], this.vc[0], nArray, null) == -1) {
            return -1;
        }
        this.current_serialno = nArray[0];
        this.make_decode_ready();
        return 0;
    }

    void decode_clear() {
        this.os.clear();
        this.vd.clear();
        this.vb.clear();
        this.decode_ready = false;
        this.bittrack = 0.0f;
        this.samptrack = 0.0f;
    }

    int process_packet(int n) {
        Page page = new Page();
        while (true) {
            Packet packet;
            int n2;
            if (this.decode_ready && (n2 = this.os.packetout(packet = new Packet())) > 0) {
                long l = packet.granulepos;
                if (this.vb.synthesis(packet) == 0) {
                    int n3 = this.vd.synthesis_pcmout(null, null);
                    this.vd.synthesis_blockin(this.vb);
                    this.samptrack += (float)(this.vd.synthesis_pcmout(null, null) - n3);
                    this.bittrack += (float)(packet.bytes * 8);
                    if (l != -1L && packet.e_o_s == 0) {
                        n3 = this.seekable ? this.current_link : 0;
                        int n4 = this.vd.synthesis_pcmout(null, null);
                        l -= (long)n4;
                        for (int i = 0; i < n3; ++i) {
                            l += this.pcmlengths[i];
                        }
                        this.pcm_offset = l;
                    }
                    return 1;
                }
            }
            if (n == 0) {
                return 0;
            }
            if (this.get_next_page(page, -1L) < 0) {
                return 0;
            }
            this.bittrack += (float)(page.header_len * 8);
            if (this.decode_ready && this.current_serialno != page.serialno()) {
                this.decode_clear();
            }
            if (!this.decode_ready) {
                int n5;
                if (this.seekable) {
                    this.current_serialno = page.serialno();
                    for (n5 = 0; n5 < this.links && this.serialnos[n5] != this.current_serialno; ++n5) {
                    }
                    if (n5 == this.links) {
                        return -1;
                    }
                    this.current_link = n5;
                    this.os.init(this.current_serialno);
                    this.os.reset();
                } else {
                    int[] nArray = new int[1];
                    int n6 = this.fetch_headers(this.vi[0], this.vc[0], nArray, page);
                    this.current_serialno = nArray[0];
                    if (n6 != 0) {
                        return n6;
                    }
                    ++this.current_link;
                    n5 = 0;
                }
                this.make_decode_ready();
            }
            this.os.pagein(page);
        }
    }

    int clear() {
        this.vb.clear();
        this.vd.clear();
        this.os.clear();
        if (this.vi != null && this.links != 0) {
            for (int i = 0; i < this.links; ++i) {
                this.vi[i].clear();
                this.vc[i].clear();
            }
            this.vi = null;
            this.vc = null;
        }
        if (this.dataoffsets != null) {
            this.dataoffsets = null;
        }
        if (this.pcmlengths != null) {
            this.pcmlengths = null;
        }
        if (this.serialnos != null) {
            this.serialnos = null;
        }
        if (this.offsets != null) {
            this.offsets = null;
        }
        this.oy.clear();
        return 0;
    }

    static int fseek(InputStream inputStream2, long l, int n) {
        if (inputStream2 instanceof SeekableInputStream) {
            SeekableInputStream seekableInputStream = (SeekableInputStream)inputStream2;
            try {
                if (n == 0) {
                    seekableInputStream.seek(l);
                } else if (n == 2) {
                    seekableInputStream.seek(seekableInputStream.getLength() - l);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            return 0;
        }
        try {
            if (n == 0) {
                inputStream2.reset();
            }
            inputStream2.skip(l);
        }
        catch (Exception exception) {
            return -1;
        }
        return 0;
    }

    static long ftell(InputStream inputStream2) {
        try {
            if (inputStream2 instanceof SeekableInputStream) {
                SeekableInputStream seekableInputStream = (SeekableInputStream)inputStream2;
                return seekableInputStream.tell();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return 0L;
    }

    int open(InputStream inputStream2, byte[] byArray, int n) throws JOrbisException {
        return this.open_callbacks(inputStream2, byArray, n);
    }

    int open_callbacks(InputStream inputStream2, byte[] byArray, int n) throws JOrbisException {
        int n2;
        this.datasource = inputStream2;
        this.oy.init();
        if (byArray != null) {
            int n3 = this.oy.buffer(n);
            System.arraycopy(byArray, 0, this.oy.data, n3, n);
            this.oy.wrote(n);
        }
        if ((n2 = inputStream2 instanceof SeekableInputStream ? this.open_seekable() : this.open_nonseekable()) != 0) {
            this.datasource = null;
            this.clear();
        }
        return n2;
    }

    public int streams() {
        return this.links;
    }

    public boolean seekable() {
        return this.seekable;
    }

    public int bitrate(int n) {
        if (n >= this.links) {
            return -1;
        }
        if (!this.seekable && n != 0) {
            return this.bitrate(0);
        }
        if (n < 0) {
            long l = 0L;
            for (int i = 0; i < this.links; ++i) {
                l += (this.offsets[i + 1] - this.dataoffsets[i]) * 8L;
            }
            return (int)Math.rint((float)l / this.time_total(-1));
        }
        if (this.seekable) {
            return (int)Math.rint((float)((this.offsets[n + 1] - this.dataoffsets[n]) * 8L) / this.time_total(n));
        }
        if (this.vi[n].bitrate_nominal > 0) {
            return this.vi[n].bitrate_nominal;
        }
        if (this.vi[n].bitrate_upper > 0) {
            if (this.vi[n].bitrate_lower > 0) {
                return (this.vi[n].bitrate_upper + this.vi[n].bitrate_lower) / 2;
            }
            return this.vi[n].bitrate_upper;
        }
        return -1;
    }

    public int bitrate_instant() {
        int n;
        int n2 = n = this.seekable ? this.current_link : 0;
        if (this.samptrack == 0.0f) {
            return -1;
        }
        int n3 = (int)((double)(this.bittrack / this.samptrack * (float)this.vi[n].rate) + 0.5);
        this.bittrack = 0.0f;
        this.samptrack = 0.0f;
        return n3;
    }

    public int serialnumber(int n) {
        if (n >= this.links) {
            return -1;
        }
        if (!this.seekable && n >= 0) {
            return this.serialnumber(-1);
        }
        if (n < 0) {
            return this.current_serialno;
        }
        return this.serialnos[n];
    }

    public long raw_total(int n) {
        if (!this.seekable || n >= this.links) {
            return -1L;
        }
        if (n < 0) {
            long l = 0L;
            for (int i = 0; i < this.links; ++i) {
                l += this.raw_total(i);
            }
            return l;
        }
        return this.offsets[n + 1] - this.offsets[n];
    }

    public long pcm_total(int n) {
        if (!this.seekable || n >= this.links) {
            return -1L;
        }
        if (n < 0) {
            long l = 0L;
            for (int i = 0; i < this.links; ++i) {
                l += this.pcm_total(i);
            }
            return l;
        }
        return this.pcmlengths[n];
    }

    public float time_total(int n) {
        if (!this.seekable || n >= this.links) {
            return -1.0f;
        }
        if (n < 0) {
            float f = 0.0f;
            for (int i = 0; i < this.links; ++i) {
                f += this.time_total(i);
            }
            return f;
        }
        return (float)this.pcmlengths[n] / (float)this.vi[n].rate;
    }

    public int raw_seek(int n) {
        if (!this.seekable) {
            return -1;
        }
        if (n < 0 || (long)n > this.offsets[this.links]) {
            this.pcm_offset = -1L;
            this.decode_clear();
            return -1;
        }
        this.pcm_offset = -1L;
        this.decode_clear();
        this.seek_helper(n);
        switch (this.process_packet(1)) {
            case 0: {
                this.pcm_offset = this.pcm_total(-1);
                return 0;
            }
            case -1: {
                this.pcm_offset = -1L;
                this.decode_clear();
                return -1;
            }
        }
        while (true) {
            switch (this.process_packet(0)) {
                case 0: {
                    return 0;
                }
                case -1: {
                    this.pcm_offset = -1L;
                    this.decode_clear();
                    return -1;
                }
            }
        }
    }

    public int pcm_seek(long l) {
        int n = -1;
        long l2 = this.pcm_total(-1);
        if (!this.seekable) {
            return -1;
        }
        if (l < 0L || l > l2) {
            this.pcm_offset = -1L;
            this.decode_clear();
            return -1;
        }
        for (n = this.links - 1; n >= 0 && l < (l2 -= this.pcmlengths[n]); --n) {
        }
        long l3 = l - l2;
        long l4 = this.offsets[n + 1];
        long l5 = this.offsets[n];
        int n2 = (int)l5;
        Page page = new Page();
        while (l5 < l4) {
            long l6 = l4 - l5 < 8500L ? l5 : (l4 + l5) / 2L;
            this.seek_helper(l6);
            int n3 = this.get_next_page(page, l4 - l6);
            if (n3 == -1) {
                l4 = l6;
                continue;
            }
            long l7 = page.granulepos();
            if (l7 < l3) {
                n2 = n3;
                l5 = this.offset;
                continue;
            }
            l4 = l6;
        }
        if (this.raw_seek(n2) != 0) {
            this.pcm_offset = -1L;
            this.decode_clear();
            return -1;
        }
        if (this.pcm_offset >= l) {
            this.pcm_offset = -1L;
            this.decode_clear();
            return -1;
        }
        if (l > this.pcm_total(-1)) {
            this.pcm_offset = -1L;
            this.decode_clear();
            return -1;
        }
        while (this.pcm_offset < l) {
            int n4 = (int)(l - this.pcm_offset);
            float[][][] fArrayArray = new float[1][][];
            int[] nArray = new int[this.getInfo((int)-1).channels];
            int n5 = this.vd.synthesis_pcmout(fArrayArray, nArray);
            if (n5 > n4) {
                n5 = n4;
            }
            this.vd.synthesis_read(n5);
            this.pcm_offset += (long)n5;
            if (n5 >= n4 || this.process_packet(1) != 0) continue;
            this.pcm_offset = this.pcm_total(-1);
        }
        return 0;
    }

    int time_seek(float f) {
        int n = -1;
        long l = this.pcm_total(-1);
        float f2 = this.time_total(-1);
        if (!this.seekable) {
            return -1;
        }
        if (f < 0.0f || f > f2) {
            this.pcm_offset = -1L;
            this.decode_clear();
            return -1;
        }
        for (n = this.links - 1; n >= 0; --n) {
            l -= this.pcmlengths[n];
            if (f >= (f2 -= this.time_total(n))) break;
        }
        long l2 = (long)((float)l + (f - f2) * (float)this.vi[n].rate);
        return this.pcm_seek(l2);
    }

    public long raw_tell() {
        return this.offset;
    }

    public long pcm_tell() {
        return this.pcm_offset;
    }

    public float time_tell() {
        int n = -1;
        long l = 0L;
        float f = 0.0f;
        if (this.seekable) {
            l = this.pcm_total(-1);
            f = this.time_total(-1);
            for (n = this.links - 1; n >= 0; --n) {
                f -= this.time_total(n);
                if (this.pcm_offset >= (l -= this.pcmlengths[n])) break;
            }
        }
        return f + (float)(this.pcm_offset - l) / (float)this.vi[n].rate;
    }

    public Info getInfo(int n) {
        if (this.seekable) {
            if (n < 0) {
                if (this.decode_ready) {
                    return this.vi[this.current_link];
                }
                return null;
            }
            if (n >= this.links) {
                return null;
            }
            return this.vi[n];
        }
        if (this.decode_ready) {
            return this.vi[0];
        }
        return null;
    }

    public Comment getComment(int n) {
        if (this.seekable) {
            if (n < 0) {
                if (this.decode_ready) {
                    return this.vc[this.current_link];
                }
                return null;
            }
            if (n >= this.links) {
                return null;
            }
            return this.vc[n];
        }
        if (this.decode_ready) {
            return this.vc[0];
        }
        return null;
    }

    int host_is_big_endian() {
        return 1;
    }

    int read(byte[] byArray, int n, int n2, int n3, int n4, int[] nArray) {
        int n5 = this.host_is_big_endian();
        int n6 = 0;
        while (true) {
            if (this.decode_ready) {
                float[][][] fArrayArray = new float[1][][];
                int[] nArray2 = new int[this.getInfo((int)-1).channels];
                int n7 = this.vd.synthesis_pcmout(fArrayArray, nArray2);
                float[][] fArray = fArrayArray[0];
                if (n7 != 0) {
                    int n8 = this.getInfo((int)-1).channels;
                    int n9 = n3 * n8;
                    if (n7 > n / n9) {
                        n7 = n / n9;
                    }
                    if (n3 == 1) {
                        int n10 = n4 != 0 ? 0 : 128;
                        for (int i = 0; i < n7; ++i) {
                            for (int j = 0; j < n8; ++j) {
                                int n11 = (int)((double)fArray[j][nArray2[j] + i] * 128.0 + 0.5);
                                if (n11 > 127) {
                                    n11 = 127;
                                } else if (n11 < -128) {
                                    n11 = -128;
                                }
                                byArray[n6++] = (byte)(n11 + n10);
                            }
                        }
                    } else {
                        int n12;
                        int n13 = n12 = n4 != 0 ? 0 : 32768;
                        if (n5 == n2) {
                            if (n4 != 0) {
                                for (int i = 0; i < n8; ++i) {
                                    int n14 = nArray2[i];
                                    int n15 = i;
                                    for (int j = 0; j < n7; ++j) {
                                        int n16 = (int)((double)fArray[i][n14 + j] * 32768.0 + 0.5);
                                        if (n16 > Short.MAX_VALUE) {
                                            n16 = Short.MAX_VALUE;
                                        } else if (n16 < Short.MIN_VALUE) {
                                            n16 = Short.MIN_VALUE;
                                        }
                                        byArray[n15] = (byte)(n16 >>> 8);
                                        byArray[n15 + 1] = (byte)n16;
                                        n15 += n8 * 2;
                                    }
                                }
                            } else {
                                for (int i = 0; i < n8; ++i) {
                                    float[] fArray2 = fArray[i];
                                    int n17 = i;
                                    for (int j = 0; j < n7; ++j) {
                                        int n18 = (int)((double)fArray2[j] * 32768.0 + 0.5);
                                        if (n18 > Short.MAX_VALUE) {
                                            n18 = Short.MAX_VALUE;
                                        } else if (n18 < Short.MIN_VALUE) {
                                            n18 = Short.MIN_VALUE;
                                        }
                                        byArray[n17] = (byte)(n18 + n12 >>> 8);
                                        byArray[n17 + 1] = (byte)(n18 + n12);
                                        n17 += n8 * 2;
                                    }
                                }
                            }
                        } else if (n2 != 0) {
                            for (int i = 0; i < n7; ++i) {
                                for (int j = 0; j < n8; ++j) {
                                    int n19 = (int)((double)fArray[j][i] * 32768.0 + 0.5);
                                    if (n19 > Short.MAX_VALUE) {
                                        n19 = Short.MAX_VALUE;
                                    } else if (n19 < Short.MIN_VALUE) {
                                        n19 = Short.MIN_VALUE;
                                    }
                                    byArray[n6++] = (byte)((n19 += n12) >>> 8);
                                    byArray[n6++] = (byte)n19;
                                }
                            }
                        } else {
                            for (int i = 0; i < n7; ++i) {
                                for (int j = 0; j < n8; ++j) {
                                    int n20 = (int)((double)fArray[j][i] * 32768.0 + 0.5);
                                    if (n20 > Short.MAX_VALUE) {
                                        n20 = Short.MAX_VALUE;
                                    } else if (n20 < Short.MIN_VALUE) {
                                        n20 = Short.MIN_VALUE;
                                    }
                                    byArray[n6++] = (byte)(n20 += n12);
                                    byArray[n6++] = (byte)(n20 >>> 8);
                                }
                            }
                        }
                    }
                    this.vd.synthesis_read(n7);
                    this.pcm_offset += (long)n7;
                    if (nArray != null) {
                        nArray[0] = this.current_link;
                    }
                    return n7 * n9;
                }
            }
            switch (this.process_packet(1)) {
                case 0: {
                    return 0;
                }
                case -1: {
                    return -1;
                }
            }
        }
    }

    public Info[] getInfo() {
        return this.vi;
    }

    public Comment[] getComment() {
        return this.vc;
    }

    public void close() throws IOException {
        this.datasource.close();
    }

    public class SeekableInputStream
    extends InputStream {
        RandomAccessFile raf = null;
        final String mode = "r";

        SeekableInputStream(String string) throws IOException {
            this.raf = new RandomAccessFile(string, "r");
        }

        public int read() throws IOException {
            return this.raf.read();
        }

        public int read(byte[] byArray) throws IOException {
            return this.raf.read(byArray);
        }

        public int read(byte[] byArray, int n, int n2) throws IOException {
            return this.raf.read(byArray, n, n2);
        }

        public long skip(long l) throws IOException {
            return this.raf.skipBytes((int)l);
        }

        public long getLength() throws IOException {
            return this.raf.length();
        }

        public long tell() throws IOException {
            return this.raf.getFilePointer();
        }

        public int available() throws IOException {
            return this.raf.length() == this.raf.getFilePointer() ? 0 : 1;
        }

        public void close() throws IOException {
            this.raf.close();
        }

        public synchronized void mark(int n) {
        }

        public synchronized void reset() throws IOException {
        }

        public boolean markSupported() {
            return false;
        }

        public void seek(long l) throws IOException {
            this.raf.seek(l);
        }
    }
}

