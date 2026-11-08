/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.comments;

import com.viaversion.viaversion.libs.snakeyaml.comments.CommentType;
import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.events.CommentEvent;

public class CommentLine {
    private final Mark startMark;
    private final Mark endMark;
    private final String value;
    private final CommentType commentType;

    public CommentLine(CommentEvent commentEvent) {
        this(commentEvent.getStartMark(), commentEvent.getEndMark(), commentEvent.getValue(), commentEvent.getCommentType());
    }

    public CommentLine(Mark mark, Mark mark2, String string, CommentType commentType) {
        this.startMark = mark;
        this.endMark = mark2;
        this.value = string;
        this.commentType = commentType;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public CommentType getCommentType() {
        return this.commentType;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "<" + this.getClass().getName() + " (type=" + (Object)((Object)this.getCommentType()) + ", value=" + this.getValue() + ")>";
    }
}

