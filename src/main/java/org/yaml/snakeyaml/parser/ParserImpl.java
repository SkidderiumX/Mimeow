/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.parser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.parser.Production;
import org.yaml.snakeyaml.parser.VersionTagsTuple;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;

public class ParserImpl
implements Parser {
    private static final Map<String, String> DEFAULT_TAGS = new HashMap<String, String>();
    protected final Scanner scanner;
    private Event currentEvent;
    private final ArrayStack<Production> states;
    private final ArrayStack<Mark> marks;
    private Production state;
    private VersionTagsTuple directives;

    public ParserImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        this(new ScannerImpl(streamReader, loaderOptions));
    }

    public ParserImpl(Scanner scanner) {
        this.scanner = scanner;
        this.currentEvent = null;
        this.directives = new VersionTagsTuple(null, new HashMap<String, String>(DEFAULT_TAGS));
        this.states = new ArrayStack(100);
        this.marks = new ArrayStack(10);
        this.state = new ParseStreamStart();
    }

    @Override
    public boolean checkEvent(Event.ID iD) {
        this.peekEvent();
        return this.currentEvent != null && this.currentEvent.is(iD);
    }

    @Override
    public Event peekEvent() {
        if (this.currentEvent == null && this.state != null) {
            this.currentEvent = this.state.produce();
        }
        return this.currentEvent;
    }

    @Override
    public Event getEvent() {
        this.peekEvent();
        Event event = this.currentEvent;
        this.currentEvent = null;
        return event;
    }

    private CommentEvent produceCommentEvent(CommentToken commentToken) {
        Mark mark = commentToken.getStartMark();
        Mark mark2 = commentToken.getEndMark();
        String string = commentToken.getValue();
        CommentType commentType = commentToken.getCommentType();
        return new CommentEvent(commentType, string, mark, mark2);
    }

    private VersionTagsTuple processDirectives() {
        Object object;
        HashMap<String, String> hashMap = new HashMap<String, String>(this.directives.getTags());
        for (String list : DEFAULT_TAGS.keySet()) {
            hashMap.remove(list);
        }
        this.directives = new VersionTagsTuple(null, hashMap);
        while (this.scanner.checkToken(Token.ID.Directive)) {
            Object object2;
            object = (DirectiveToken)this.scanner.getToken();
            if (((DirectiveToken)object).getName().equals("YAML")) {
                if (this.directives.getVersion() != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", ((Token)object).getStartMark());
                }
                List list = ((DirectiveToken)object).getValue();
                Integer n = (Integer)list.get(0);
                if (n != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", ((Token)object).getStartMark());
                }
                object2 = (Integer)list.get(1);
                if ((Integer)object2 == 0) {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_0, hashMap);
                    continue;
                }
                this.directives = new VersionTagsTuple(DumperOptions.Version.V1_1, hashMap);
                continue;
            }
            if (!((DirectiveToken)object).getName().equals("TAG")) continue;
            List list = ((DirectiveToken)object).getValue();
            String string = (String)list.get(0);
            object2 = (String)list.get(1);
            if (hashMap.containsKey(string)) {
                throw new ParserException(null, null, "duplicate tag handle " + string, ((Token)object).getStartMark());
            }
            hashMap.put(string, (String)object2);
        }
        object = new HashMap();
        if (!hashMap.isEmpty()) {
            object = new HashMap<String, String>(hashMap);
        }
        for (String string : DEFAULT_TAGS.keySet()) {
            if (hashMap.containsKey(string)) continue;
            hashMap.put(string, DEFAULT_TAGS.get(string));
        }
        return new VersionTagsTuple(this.directives.getVersion(), (Map<String, String>)object);
    }

    private Event parseFlowNode() {
        return this.parseNode(false, false);
    }

    private Event parseBlockNodeOrIndentlessSequence() {
        return this.parseNode(true, true);
    }

    private Event parseNode(boolean bl, boolean bl2) {
        NodeEvent nodeEvent;
        Mark mark = null;
        Mark mark2 = null;
        Mark mark3 = null;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            AliasToken aliasToken = (AliasToken)this.scanner.getToken();
            nodeEvent = new AliasEvent(aliasToken.getValue(), aliasToken.getStartMark(), aliasToken.getEndMark());
            this.state = this.states.pop();
        } else {
            boolean bl3;
            Object object;
            Object object2;
            Object object3;
            String string = null;
            TagTuple tagTuple = null;
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                object3 = (AnchorToken)this.scanner.getToken();
                mark = ((Token)object3).getStartMark();
                mark2 = ((Token)object3).getEndMark();
                string = ((AnchorToken)object3).getValue();
                if (this.scanner.checkToken(Token.ID.Tag)) {
                    object2 = (TagToken)this.scanner.getToken();
                    mark3 = ((Token)object2).getStartMark();
                    mark2 = ((Token)object2).getEndMark();
                    tagTuple = ((TagToken)object2).getValue();
                }
            } else if (this.scanner.checkToken(Token.ID.Tag)) {
                object3 = (TagToken)this.scanner.getToken();
                mark3 = mark = ((Token)object3).getStartMark();
                mark2 = ((Token)object3).getEndMark();
                tagTuple = ((TagToken)object3).getValue();
                if (this.scanner.checkToken(Token.ID.Anchor)) {
                    object2 = (AnchorToken)this.scanner.getToken();
                    mark2 = ((Token)object2).getEndMark();
                    string = ((AnchorToken)object2).getValue();
                }
            }
            object3 = null;
            if (tagTuple != null) {
                object2 = tagTuple.getHandle();
                object = tagTuple.getSuffix();
                if (object2 != null) {
                    if (!this.directives.getTags().containsKey(object2)) {
                        throw new ParserException("while parsing a node", mark, "found undefined tag handle " + (String)object2, mark3);
                    }
                    object3 = this.directives.getTags().get(object2) + (String)object;
                } else {
                    object3 = object;
                }
            }
            if (mark == null) {
                mark2 = mark = this.scanner.peekToken().getStartMark();
            }
            nodeEvent = null;
            boolean bl4 = bl3 = object3 == null || ((String)object3).equals("!");
            if (bl2 && this.scanner.checkToken(Token.ID.BlockEntry)) {
                mark2 = this.scanner.peekToken().getEndMark();
                nodeEvent = new SequenceStartEvent(string, (String)object3, bl3, mark, mark2, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseIndentlessSequenceEntryKey();
            } else if (this.scanner.checkToken(Token.ID.Scalar)) {
                object = (ScalarToken)this.scanner.getToken();
                mark2 = ((Token)object).getEndMark();
                ImplicitTuple implicitTuple = ((ScalarToken)object).getPlain() && object3 == null || "!".equals(object3) ? new ImplicitTuple(true, false) : (object3 == null ? new ImplicitTuple(false, true) : new ImplicitTuple(false, false));
                nodeEvent = new ScalarEvent(string, (String)object3, implicitTuple, ((ScalarToken)object).getValue(), mark, mark2, ((ScalarToken)object).getStyle());
                this.state = this.states.pop();
            } else if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
                mark2 = this.scanner.peekToken().getEndMark();
                nodeEvent = new SequenceStartEvent(string, (String)object3, bl3, mark, mark2, DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowSequenceFirstEntry();
            } else if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
                mark2 = this.scanner.peekToken().getEndMark();
                nodeEvent = new MappingStartEvent(string, (String)object3, bl3, mark, mark2, DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowMappingFirstKey();
            } else if (bl && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
                mark2 = this.scanner.peekToken().getStartMark();
                nodeEvent = new SequenceStartEvent(string, (String)object3, bl3, mark, mark2, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockSequenceFirstEntry();
            } else if (bl && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
                mark2 = this.scanner.peekToken().getStartMark();
                nodeEvent = new MappingStartEvent(string, (String)object3, bl3, mark, mark2, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockMappingFirstKey();
            } else if (string != null || object3 != null) {
                nodeEvent = new ScalarEvent(string, (String)object3, new ImplicitTuple(bl3, false), "", mark, mark2, DumperOptions.ScalarStyle.PLAIN);
                this.state = this.states.pop();
            } else {
                object = this.scanner.peekToken();
                throw new ParserException("while parsing a " + (bl ? "block" : "flow") + " node", mark, "expected the node content, but found '" + (Object)((Object)((Token)object).getTokenId()) + "'", ((Token)object).getStartMark());
            }
        }
        return nodeEvent;
    }

    private Event processEmptyScalar(Mark mark) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), "", mark, mark, DumperOptions.ScalarStyle.PLAIN);
    }

    static {
        DEFAULT_TAGS.put("!", "!");
        DEFAULT_TAGS.put("!!", "tag:yaml.org,2002:");
    }

    private class ParseFlowMappingEmptyValue
    implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        @Override
        public Event produce() {
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseFlowMappingValue
    implements Production {
        private ParseFlowMappingValue() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingKey(false));
                    return ParserImpl.this.parseFlowNode();
                }
                ParserImpl.this.state = new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            Token token = ParserImpl.this.scanner.peekToken();
            return ParserImpl.this.processEmptyScalar(token.getStartMark());
        }
    }

    private class ParseFlowMappingKey
    implements Production {
        private final boolean first;

        public ParseFlowMappingKey(boolean bl) {
            this.first = bl;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowMappingKey(this.first);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl.this.state = new ParseFlowMappingKey(true);
                            return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
                        }
                    } else {
                        Token token = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", (Mark)ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + (Object)((Object)token.getTokenId()), token.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token = ParserImpl.this.scanner.getToken();
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.states.push(new ParseFlowMappingValue());
                        return ParserImpl.this.parseFlowNode();
                    }
                    ParserImpl.this.state = new ParseFlowMappingValue();
                    return ParserImpl.this.processEmptyScalar(token.getEndMark());
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.this.marks.pop();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            } else {
                ParserImpl.this.state = new ParseFlowEndComment();
            }
            return mappingEndEvent;
        }
    }

    private class ParseFlowMappingFirstKey
    implements Production {
        private ParseFlowMappingFirstKey() {
        }

        @Override
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token.getStartMark());
            return new ParseFlowMappingKey(true).produce();
        }
    }

    private class ParseFlowSequenceEntryMappingEnd
    implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        @Override
        public Event produce() {
            ParserImpl.this.state = new ParseFlowSequenceEntry(false);
            Token token = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(token.getStartMark(), token.getEndMark());
        }
    }

    private class ParseFlowSequenceEntryMappingValue
    implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
                    return ParserImpl.this.parseFlowNode();
                }
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
            Token token = ParserImpl.this.scanner.peekToken();
            return ParserImpl.this.processEmptyScalar(token.getStartMark());
        }
    }

    private class ParseFlowSequenceEntryMappingKey
    implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        @Override
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    private class ParseFlowEndComment
    implements Production {
        private ParseFlowEndComment() {
        }

        @Override
        public Event produce() {
            CommentEvent commentEvent = ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            }
            return commentEvent;
        }
    }

    private class ParseFlowSequenceEntry
    implements Production {
        private final boolean first;

        public ParseFlowSequenceEntry(boolean bl) {
            this.first = bl;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowSequenceEntry(this.first);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl.this.state = new ParseFlowSequenceEntry(true);
                            return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
                        }
                    } else {
                        Token token = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", (Mark)ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + (Object)((Object)token.getTokenId()), token.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token = ParserImpl.this.scanner.peekToken();
                    MappingStartEvent mappingStartEvent = new MappingStartEvent(null, null, true, token.getStartMark(), token.getEndMark(), DumperOptions.FlowStyle.FLOW);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return mappingStartEvent;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            } else {
                ParserImpl.this.state = new ParseFlowEndComment();
            }
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseFlowSequenceFirstEntry
    implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        @Override
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token.getStartMark());
            return new ParseFlowSequenceEntry(true).produce();
        }
    }

    private class ParseBlockMappingValueCommentList
    implements Production {
        List<CommentToken> tokens;

        public ParseBlockMappingValueCommentList(List<CommentToken> list) {
            this.tokens = list;
        }

        @Override
        public Event produce() {
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseBlockMappingValueComment
    implements Production {
        List<CommentToken> tokens = new LinkedList<CommentToken>();

        private ParseBlockMappingValueComment() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                this.tokens.add((CommentToken)ParserImpl.this.scanner.getToken());
                return this.produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                if (!this.tokens.isEmpty()) {
                    return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
                }
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingValueCommentList(this.tokens);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseBlockMappingValue
    implements Production {
        private ParseBlockMappingValue() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.state = new ParseBlockMappingValueComment();
                    return ParserImpl.this.state.produce();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingKey());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Scalar)) {
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingKey();
            Token token = ParserImpl.this.scanner.peekToken();
            return ParserImpl.this.processEmptyScalar(token.getStartMark());
        }
    }

    private class ParseBlockMappingKey
    implements Production {
        private ParseBlockMappingKey() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingValue());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingValue();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token token = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block mapping", (Mark)ParserImpl.this.marks.pop(), "expected <block end>, but found '" + (Object)((Object)token.getTokenId()) + "'", token.getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return mappingEndEvent;
        }
    }

    private class ParseBlockMappingFirstKey
    implements Production {
        private ParseBlockMappingFirstKey() {
        }

        @Override
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token.getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseIndentlessSequenceEntryValue
    implements Production {
        BlockEntryToken token;

        public ParseIndentlessSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseIndentlessSequenceEntryValue(this.token);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseIndentlessSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    private class ParseIndentlessSequenceEntryKey
    implements Production {
        private ParseIndentlessSequenceEntryKey() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                BlockEntryToken blockEntryToken = (BlockEntryToken)ParserImpl.this.scanner.getToken();
                return new ParseIndentlessSequenceEntryValue(blockEntryToken).produce();
            }
            Token token = ParserImpl.this.scanner.peekToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseBlockSequenceEntryValue
    implements Production {
        BlockEntryToken token;

        public ParseBlockSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockSequenceEntryValue(this.token);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseBlockSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    private class ParseBlockSequenceEntryKey
    implements Production {
        private ParseBlockSequenceEntryKey() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockSequenceEntryKey();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                BlockEntryToken blockEntryToken = (BlockEntryToken)ParserImpl.this.scanner.getToken();
                return new ParseBlockSequenceEntryValue(blockEntryToken).produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token token = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block collection", (Mark)ParserImpl.this.marks.pop(), "expected <block end>, but found '" + (Object)((Object)token.getTokenId()) + "'", token.getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseBlockSequenceFirstEntry
    implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        @Override
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token.getStartMark());
            return new ParseBlockSequenceEntryKey().produce();
        }
    }

    private class ParseBlockNode
    implements Production {
        private ParseBlockNode() {
        }

        @Override
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }

    private class ParseDocumentContent
    implements Production {
        private ParseDocumentContent() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseDocumentContent();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                Event event = ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
                return event;
            }
            return new ParseBlockNode().produce();
        }
    }

    private class ParseDocumentEnd
    implements Production {
        private ParseDocumentEnd() {
        }

        @Override
        public Event produce() {
            Mark mark;
            Token token = ParserImpl.this.scanner.peekToken();
            Mark mark2 = mark = token.getStartMark();
            boolean bl = false;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                token = ParserImpl.this.scanner.getToken();
                mark2 = token.getEndMark();
                bl = true;
            }
            DocumentEndEvent documentEndEvent = new DocumentEndEvent(mark, mark2, bl);
            ParserImpl.this.state = new ParseDocumentStart();
            return documentEndEvent;
        }
    }

    private class ParseDocumentStart
    implements Production {
        private ParseDocumentStart() {
        }

        @Override
        public Event produce() {
            Token token;
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                ParserImpl.this.scanner.resetDocumentIndex();
                token = ParserImpl.this.scanner.peekToken();
                Mark mark = token.getStartMark();
                VersionTagsTuple versionTagsTuple = ParserImpl.this.processDirectives();
                while (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.scanner.getToken();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                        throw new ParserException(null, null, "expected '<document start>', but found '" + (Object)((Object)ParserImpl.this.scanner.peekToken().getTokenId()) + "'", ParserImpl.this.scanner.peekToken().getStartMark());
                    }
                    token = ParserImpl.this.scanner.getToken();
                    Mark mark2 = token.getEndMark();
                    DocumentStartEvent documentStartEvent = new DocumentStartEvent(mark, mark2, true, versionTagsTuple.getVersion(), versionTagsTuple.getTags());
                    ParserImpl.this.states.push(new ParseDocumentEnd());
                    ParserImpl.this.state = new ParseDocumentContent();
                    return documentStartEvent;
                }
            }
            token = (StreamEndToken)ParserImpl.this.scanner.getToken();
            StreamEndEvent streamEndEvent = new StreamEndEvent(token.getStartMark(), token.getEndMark());
            if (!ParserImpl.this.states.isEmpty()) {
                throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
            }
            if (!ParserImpl.this.marks.isEmpty()) {
                throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
            }
            ParserImpl.this.state = null;
            return streamEndEvent;
        }
    }

    private class ParseImplicitDocumentStart
    implements Production {
        private ParseImplicitDocumentStart() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseImplicitDocumentStart();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                Mark mark;
                Token token = ParserImpl.this.scanner.peekToken();
                Mark mark2 = mark = token.getStartMark();
                DocumentStartEvent documentStartEvent = new DocumentStartEvent(mark, mark2, false, null, null);
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseBlockNode();
                return documentStartEvent;
            }
            return new ParseDocumentStart().produce();
        }
    }

    private class ParseStreamStart
    implements Production {
        private ParseStreamStart() {
        }

        @Override
        public Event produce() {
            StreamStartToken streamStartToken = (StreamStartToken)ParserImpl.this.scanner.getToken();
            StreamStartEvent streamStartEvent = new StreamStartEvent(streamStartToken.getStartMark(), streamStartToken.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return streamStartEvent;
        }
    }
}

