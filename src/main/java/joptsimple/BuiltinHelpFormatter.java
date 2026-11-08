/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import joptsimple.HelpFormatter;
import joptsimple.OptionDescriptor;
import joptsimple.ParserRules;
import joptsimple.internal.Classes;
import joptsimple.internal.Rows;
import joptsimple.internal.Strings;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BuiltinHelpFormatter
implements HelpFormatter {
    private final Rows nonOptionRows;
    private final Rows optionRows;

    BuiltinHelpFormatter() {
        this(80, 2);
    }

    public BuiltinHelpFormatter(int n, int n2) {
        this.nonOptionRows = new Rows(n * 2, 0);
        this.optionRows = new Rows(n, n2);
    }

    @Override
    public String format(Map<String, ? extends OptionDescriptor> map) {
        Comparator<OptionDescriptor> comparator = new Comparator<OptionDescriptor>(){

            @Override
            public int compare(OptionDescriptor optionDescriptor, OptionDescriptor optionDescriptor2) {
                return optionDescriptor.options().iterator().next().compareTo(optionDescriptor2.options().iterator().next());
            }
        };
        TreeSet<OptionDescriptor> treeSet = new TreeSet<OptionDescriptor>(comparator);
        treeSet.addAll(map.values());
        this.addRows(treeSet);
        return this.formattedHelpOutput();
    }

    private String formattedHelpOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.nonOptionRows.render();
        if (!Strings.isNullOrEmpty(string)) {
            stringBuilder.append(string).append(Strings.LINE_SEPARATOR);
        }
        stringBuilder.append(this.optionRows.render());
        return stringBuilder.toString();
    }

    private void addRows(Collection<? extends OptionDescriptor> collection) {
        this.addNonOptionsDescription(collection);
        if (collection.isEmpty()) {
            this.optionRows.add("No options specified", "");
        } else {
            this.addHeaders(collection);
            this.addOptions(collection);
        }
        this.fitRowsToWidth();
    }

    private void addNonOptionsDescription(Collection<? extends OptionDescriptor> collection) {
        OptionDescriptor optionDescriptor = this.findAndRemoveNonOptionsSpec(collection);
        if (this.shouldShowNonOptionArgumentDisplay(optionDescriptor)) {
            this.nonOptionRows.add("Non-option arguments:", "");
            this.nonOptionRows.add(this.createNonOptionArgumentsDisplay(optionDescriptor), "");
        }
    }

    private boolean shouldShowNonOptionArgumentDisplay(OptionDescriptor optionDescriptor) {
        return !Strings.isNullOrEmpty(optionDescriptor.description()) || !Strings.isNullOrEmpty(optionDescriptor.argumentTypeIndicator()) || !Strings.isNullOrEmpty(optionDescriptor.argumentDescription());
    }

    private String createNonOptionArgumentsDisplay(OptionDescriptor optionDescriptor) {
        StringBuilder stringBuilder = new StringBuilder();
        this.maybeAppendOptionInfo(stringBuilder, optionDescriptor);
        this.maybeAppendNonOptionsDescription(stringBuilder, optionDescriptor);
        return stringBuilder.toString();
    }

    private void maybeAppendNonOptionsDescription(StringBuilder stringBuilder, OptionDescriptor optionDescriptor) {
        stringBuilder.append(stringBuilder.length() > 0 && !Strings.isNullOrEmpty(optionDescriptor.description()) ? " -- " : "").append(optionDescriptor.description());
    }

    private OptionDescriptor findAndRemoveNonOptionsSpec(Collection<? extends OptionDescriptor> collection) {
        Iterator<? extends OptionDescriptor> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            OptionDescriptor optionDescriptor = iterator2.next();
            if (!optionDescriptor.representsNonOptions()) continue;
            iterator2.remove();
            return optionDescriptor;
        }
        throw new AssertionError((Object)"no non-options argument spec");
    }

    private void addHeaders(Collection<? extends OptionDescriptor> collection) {
        if (this.hasRequiredOption(collection)) {
            this.optionRows.add("Option (* = required)", "Description");
            this.optionRows.add("---------------------", "-----------");
        } else {
            this.optionRows.add("Option", "Description");
            this.optionRows.add("------", "-----------");
        }
    }

    private boolean hasRequiredOption(Collection<? extends OptionDescriptor> collection) {
        for (OptionDescriptor optionDescriptor : collection) {
            if (!optionDescriptor.isRequired()) continue;
            return true;
        }
        return false;
    }

    private void addOptions(Collection<? extends OptionDescriptor> collection) {
        for (OptionDescriptor optionDescriptor : collection) {
            if (optionDescriptor.representsNonOptions()) continue;
            this.optionRows.add(this.createOptionDisplay(optionDescriptor), this.createDescriptionDisplay(optionDescriptor));
        }
    }

    private String createOptionDisplay(OptionDescriptor optionDescriptor) {
        StringBuilder stringBuilder = new StringBuilder(optionDescriptor.isRequired() ? "* " : "");
        Iterator<String> iterator2 = optionDescriptor.options().iterator();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            stringBuilder.append(string.length() > 1 ? "--" : ParserRules.HYPHEN);
            stringBuilder.append(string);
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(", ");
        }
        this.maybeAppendOptionInfo(stringBuilder, optionDescriptor);
        return stringBuilder.toString();
    }

    private void maybeAppendOptionInfo(StringBuilder stringBuilder, OptionDescriptor optionDescriptor) {
        String string = this.extractTypeIndicator(optionDescriptor);
        String string2 = optionDescriptor.argumentDescription();
        if (string != null || !Strings.isNullOrEmpty(string2)) {
            this.appendOptionHelp(stringBuilder, string, string2, optionDescriptor.requiresArgument());
        }
    }

    private String extractTypeIndicator(OptionDescriptor optionDescriptor) {
        String string = optionDescriptor.argumentTypeIndicator();
        if (!Strings.isNullOrEmpty(string) && !String.class.getName().equals(string)) {
            return Classes.shortNameOf(string);
        }
        return null;
    }

    private void appendOptionHelp(StringBuilder stringBuilder, String string, String string2, boolean bl) {
        if (bl) {
            this.appendTypeIndicator(stringBuilder, string, string2, '<', '>');
        } else {
            this.appendTypeIndicator(stringBuilder, string, string2, '[', ']');
        }
    }

    private void appendTypeIndicator(StringBuilder stringBuilder, String string, String string2, char c, char c2) {
        stringBuilder.append(' ').append(c);
        if (string != null) {
            stringBuilder.append(string);
        }
        if (!Strings.isNullOrEmpty(string2)) {
            if (string != null) {
                stringBuilder.append(": ");
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append(c2);
    }

    private String createDescriptionDisplay(OptionDescriptor optionDescriptor) {
        List<?> list = optionDescriptor.defaultValues();
        if (list.isEmpty()) {
            return optionDescriptor.description();
        }
        String string = this.createDefaultValuesDisplay(list);
        return (optionDescriptor.description() + ' ' + Strings.surround("default: " + string, '(', ')')).trim();
    }

    private String createDefaultValuesDisplay(List<?> list) {
        return list.size() == 1 ? list.get(0).toString() : list.toString();
    }

    private void fitRowsToWidth() {
        this.nonOptionRows.fitToWidth();
        this.optionRows.fitToWidth();
    }
}

