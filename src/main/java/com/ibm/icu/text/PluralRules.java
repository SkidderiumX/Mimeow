package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PluralRulesLoader;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.ULocale;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class PluralRules implements Serializable {
   private static final long serialVersionUID = 1L;
   private final PluralRules.RuleList rules;
   private final Set<String> keywords;
   private int repeatLimit;
   private transient int hashCode;
   private transient Map<String, List<Double>> _keySamplesMap;
   private transient Map<String, Boolean> _keyLimitedMap;
   public static final String KEYWORD_ZERO = "zero";
   public static final String KEYWORD_ONE = "one";
   public static final String KEYWORD_TWO = "two";
   public static final String KEYWORD_FEW = "few";
   public static final String KEYWORD_MANY = "many";
   public static final String KEYWORD_OTHER = "other";
   public static final double NO_UNIQUE_VALUE = -0.00123456777;
   private static final PluralRules.Constraint NO_CONSTRAINT = new PluralRules.Constraint() {
      private static final long serialVersionUID = 9163464945387899416L;

      @Override
      public boolean isFulfilled(double var1) {
         return true;
      }

      @Override
      public boolean isLimited() {
         return false;
      }

      @Override
      public String toString() {
         return "n is any";
      }

      @Override
      public int updateRepeatLimit(int var1) {
         return var1;
      }
   };
   private static final PluralRules.Rule DEFAULT_RULE = new PluralRules.Rule() {
      private static final long serialVersionUID = -5677499073940822149L;

      @Override
      public String getKeyword() {
         return "other";
      }

      @Override
      public boolean appliesTo(double var1) {
         return true;
      }

      @Override
      public boolean isLimited() {
         return false;
      }

      @Override
      public String toString() {
         return "(other)";
      }

      @Override
      public int updateRepeatLimit(int var1) {
         return var1;
      }
   };
   public static final PluralRules DEFAULT = new PluralRules(new PluralRules.RuleChain(DEFAULT_RULE));

   public static PluralRules parseDescription(String var0) throws ParseException {
      var0 = var0.trim();
      return var0.length() == 0 ? DEFAULT : new PluralRules(parseRuleChain(var0));
   }

   public static PluralRules createRules(String var0) {
      try {
         return parseDescription(var0);
      } catch (ParseException var2) {
         return null;
      }
   }

   private static PluralRules.Constraint parseConstraint(String var0) throws ParseException {
      var0 = var0.trim().toLowerCase(Locale.ENGLISH);
      Object var1 = null;
      String[] var2 = Utility.splitString(var0, "or");

      for (int var3 = 0; var3 < var2.length; var3++) {
         Object var4 = null;
         String[] var5 = Utility.splitString(var2[var3], "and");

         for (int var6 = 0; var6 < var5.length; var6++) {
            Object var7 = NO_CONSTRAINT;
            String var8 = var5[var6].trim();
            String[] var9 = Utility.splitWhitespace(var8);
            int var10 = 0;
            boolean var11 = true;
            boolean var12 = true;
            long var13 = Long.MAX_VALUE;
            long var15 = Long.MIN_VALUE;
            long[] var17 = null;
            boolean var18 = false;
            int var19 = 0;
            String var20 = var9[var19++];
            if (!"n".equals(var20)) {
               throw unexpected(var20, var8);
            }

            if (var19 < var9.length) {
               var20 = var9[var19++];
               if ("mod".equals(var20)) {
                  var10 = Integer.parseInt(var9[var19++]);
                  var20 = nextToken(var9, var19++, var8);
               }

               if ("is".equals(var20)) {
                  var20 = nextToken(var9, var19++, var8);
                  if ("not".equals(var20)) {
                     var11 = false;
                     var20 = nextToken(var9, var19++, var8);
                  }
               } else {
                  var18 = true;
                  if ("not".equals(var20)) {
                     var11 = false;
                     var20 = nextToken(var9, var19++, var8);
                  }

                  if ("in".equals(var20)) {
                     var20 = nextToken(var9, var19++, var8);
                  } else {
                     if (!"within".equals(var20)) {
                        throw unexpected(var20, var8);
                     }

                     var12 = false;
                     var20 = nextToken(var9, var19++, var8);
                  }
               }

               if (var18) {
                  String[] var21 = Utility.splitString(var20, ",");
                  var17 = new long[var21.length * 2];
                  int var22 = 0;

                  for (byte var23 = 0; var22 < var21.length; var23 += 2) {
                     String var24 = var21[var22];
                     String[] var25 = Utility.splitString(var24, "..");
                     long var26;
                     long var28;
                     if (var25.length == 2) {
                        var26 = Long.parseLong(var25[0]);
                        var28 = Long.parseLong(var25[1]);
                        if (var26 > var28) {
                           throw unexpected(var24, var8);
                        }
                     } else {
                        if (var25.length != 1) {
                           throw unexpected(var24, var8);
                        }

                        var26 = var28 = Long.parseLong(var25[0]);
                     }

                     var17[var23] = var26;
                     var17[var23 + 1] = var28;
                     var13 = Math.min(var13, var26);
                     var15 = Math.max(var15, var28);
                     var22++;
                  }

                  if (var17.length == 2) {
                     var17 = null;
                  }
               } else {
                  var13 = var15 = Long.parseLong(var20);
               }

               if (var19 != var9.length) {
                  throw unexpected(var9[var19], var8);
               }

               var7 = new PluralRules.RangeConstraint(var10, var11, var12, var13, var15, var17);
            }

            if (var4 == null) {
               var4 = var7;
            } else {
               var4 = new PluralRules.AndConstraint((PluralRules.Constraint)var4, (PluralRules.Constraint)var7);
            }
         }

         if (var1 == null) {
            var1 = var4;
         } else {
            var1 = new PluralRules.OrConstraint((PluralRules.Constraint)var1, (PluralRules.Constraint)var4);
         }
      }

      return (PluralRules.Constraint)var1;
   }

   private static ParseException unexpected(String var0, String var1) {
      return new ParseException("unexpected token '" + var0 + "' in '" + var1 + "'", -1);
   }

   private static String nextToken(String[] var0, int var1, String var2) throws ParseException {
      if (var1 < var0.length) {
         return var0[var1];
      } else {
         throw new ParseException("missing token at end of '" + var2 + "'", -1);
      }
   }

   private static PluralRules.Rule parseRule(String var0) throws ParseException {
      int var1 = var0.indexOf(58);
      if (var1 == -1) {
         throw new ParseException("missing ':' in rule description '" + var0 + "'", 0);
      } else {
         String var2 = var0.substring(0, var1).trim();
         if (!isValidKeyword(var2)) {
            throw new ParseException("keyword '" + var2 + " is not valid", 0);
         } else {
            var0 = var0.substring(var1 + 1).trim();
            if (var0.length() == 0) {
               throw new ParseException("missing constraint in '" + var0 + "'", var1 + 1);
            } else {
               PluralRules.Constraint var3 = parseConstraint(var0);
               return new PluralRules.ConstrainedRule(var2, var3);
            }
         }
      }
   }

   private static PluralRules.RuleChain parseRuleChain(String var0) throws ParseException {
      PluralRules.RuleChain var1 = null;
      String[] var2 = Utility.split(var0, ';');

      for (int var3 = 0; var3 < var2.length; var3++) {
         PluralRules.Rule var4 = parseRule(var2[var3].trim());
         if (var1 == null) {
            var1 = new PluralRules.RuleChain(var4);
         } else {
            var1 = var1.addRule(var4);
         }
      }

      return var1;
   }

   public static PluralRules forLocale(ULocale var0) {
      return PluralRulesLoader.loader.forLocale(var0, PluralRules.PluralType.CARDINAL);
   }

   public static PluralRules forLocale(ULocale var0, PluralRules.PluralType var1) {
      return PluralRulesLoader.loader.forLocale(var0, var1);
   }

   private static boolean isValidKeyword(String var0) {
      return PatternProps.isIdentifier(var0);
   }

   private PluralRules(PluralRules.RuleList var1) {
      this.rules = var1;
      this.keywords = Collections.unmodifiableSet(var1.getKeywords());
   }

   public String select(double var1) {
      return this.rules.select(var1);
   }

   public Set<String> getKeywords() {
      return this.keywords;
   }

   public double getUniqueKeywordValue(String var1) {
      Collection var2 = this.getAllKeywordValues(var1);
      return var2 != null && var2.size() == 1 ? (Double)var2.iterator().next() : -0.00123456777;
   }

   public Collection<Double> getAllKeywordValues(String var1) {
      if (!this.keywords.contains(var1)) {
         return Collections.emptyList();
      } else {
         Collection var2 = this.getKeySamplesMap().get(var1);
         return var2.size() > 2 && !this.getKeyLimitedMap().get(var1) ? null : var2;
      }
   }

   public Collection<Double> getSamples(String var1) {
      return !this.keywords.contains(var1) ? null : this.getKeySamplesMap().get(var1);
   }

   private Map<String, Boolean> getKeyLimitedMap() {
      this.initKeyMaps();
      return this._keyLimitedMap;
   }

   private Map<String, List<Double>> getKeySamplesMap() {
      this.initKeyMaps();
      return this._keySamplesMap;
   }

   private synchronized void initKeyMaps() {
      if (this._keySamplesMap == null) {
         byte var1 = 3;
         HashMap var2 = new HashMap();

         for (String var4 : this.keywords) {
            var2.put(var4, this.rules.isLimited(var4));
         }

         this._keyLimitedMap = var2;
         HashMap var12 = new HashMap();
         int var13 = this.keywords.size();
         int var5 = Math.max(5, this.getRepeatLimit() * 3) * 2;

         for (int var6 = 0; var13 > 0 && var6 < var5; var6++) {
            double var7 = var6 / 2.0;
            String var9 = this.select(var7);
            boolean var10 = this._keyLimitedMap.get(var9);
            Object var11 = (List)var12.get(var9);
            if (var11 == null) {
               var11 = new ArrayList(3);
               var12.put(var9, var11);
            } else if (!var10 && var11.size() == 3) {
               continue;
            }

            var11.add(var7);
            if (!var10 && var11.size() == 3) {
               var13--;
            }
         }

         if (var13 > 0) {
            for (String var16 : this.keywords) {
               if (!var12.containsKey(var16)) {
                  var12.put(var16, Collections.emptyList());
                  if (--var13 == 0) {
                     break;
                  }
               }
            }
         }

         for (Entry var17 : var12.entrySet()) {
            var12.put(var17.getKey(), Collections.unmodifiableList((List)var17.getValue()));
         }

         this._keySamplesMap = var12;
      }
   }

   public static ULocale[] getAvailableULocales() {
      return PluralRulesLoader.loader.getAvailableULocales();
   }

   public static ULocale getFunctionalEquivalent(ULocale var0, boolean[] var1) {
      return PluralRulesLoader.loader.getFunctionalEquivalent(var0, var1);
   }

   @Override
   public String toString() {
      return "keywords: " + this.keywords + " limit: " + this.getRepeatLimit() + " rules: " + this.rules.toString();
   }

   @Override
   public int hashCode() {
      if (this.hashCode == 0) {
         int var1 = this.keywords.hashCode();

         for (int var2 = 0; var2 < 12; var2++) {
            var1 = var1 * 31 + this.select(var2).hashCode();
         }

         if (var1 == 0) {
            var1 = 1;
         }

         this.hashCode = var1;
      }

      return this.hashCode;
   }

   @Override
   public boolean equals(Object var1) {
      return var1 instanceof PluralRules && this.equals((PluralRules)var1);
   }

   public boolean equals(PluralRules var1) {
      if (var1 == null) {
         return false;
      } else if (var1 == this) {
         return true;
      } else if (this.hashCode() != var1.hashCode()) {
         return false;
      } else if (!var1.getKeywords().equals(this.keywords)) {
         return false;
      } else {
         int var2 = Math.max(this.getRepeatLimit(), var1.getRepeatLimit());

         for (int var3 = 0; var3 < var2 * 2; var3++) {
            if (!this.select(var3).equals(var1.select(var3))) {
               return false;
            }
         }

         return true;
      }
   }

   private int getRepeatLimit() {
      if (this.repeatLimit == 0) {
         this.repeatLimit = this.rules.getRepeatLimit() + 1;
      }

      return this.repeatLimit;
   }

   public PluralRules.KeywordStatus getKeywordStatus(String var1, int var2, Set<Double> var3, Output<Double> var4) {
      if (var4 != null) {
         var4.value = null;
      }

      if (!this.rules.getKeywords().contains(var1)) {
         return PluralRules.KeywordStatus.INVALID;
      } else {
         Collection var5 = this.getAllKeywordValues(var1);
         if (var5 == null) {
            return PluralRules.KeywordStatus.UNBOUNDED;
         } else {
            int var6 = var5.size();
            if (var3 == null) {
               var3 = Collections.emptySet();
            }

            if (var6 > var3.size()) {
               if (var6 == 1) {
                  if (var4 != null) {
                     var4.value = var5.iterator().next();
                  }

                  return PluralRules.KeywordStatus.UNIQUE;
               } else {
                  return PluralRules.KeywordStatus.BOUNDED;
               }
            } else {
               HashSet var7 = new HashSet(var5);

               for (Double var9 : var3) {
                  var7.remove(var9 - var2);
               }

               if (var7.size() == 0) {
                  return PluralRules.KeywordStatus.SUPPRESSED;
               } else {
                  if (var4 != null && var7.size() == 1) {
                     var4.value = var7.iterator().next();
                  }

                  return var6 == 1 ? PluralRules.KeywordStatus.UNIQUE : PluralRules.KeywordStatus.BOUNDED;
               }
            }
         }
      }
   }

   private static class AndConstraint extends PluralRules.BinaryConstraint {
      private static final long serialVersionUID = 7766999779862263523L;

      AndConstraint(PluralRules.Constraint var1, PluralRules.Constraint var2) {
         super(var1, var2, " && ");
      }

      @Override
      public boolean isFulfilled(double var1) {
         return this.a.isFulfilled(var1) && this.b.isFulfilled(var1);
      }

      @Override
      public boolean isLimited() {
         return this.a.isLimited() || this.b.isLimited();
      }
   }

   private abstract static class BinaryConstraint implements PluralRules.Constraint, Serializable {
      private static final long serialVersionUID = 1L;
      protected final PluralRules.Constraint a;
      protected final PluralRules.Constraint b;
      private final String conjunction;

      protected BinaryConstraint(PluralRules.Constraint var1, PluralRules.Constraint var2, String var3) {
         this.a = var1;
         this.b = var2;
         this.conjunction = var3;
      }

      @Override
      public int updateRepeatLimit(int var1) {
         return this.a.updateRepeatLimit(this.b.updateRepeatLimit(var1));
      }

      @Override
      public String toString() {
         return this.a.toString() + this.conjunction + this.b.toString();
      }
   }

   private static class ConstrainedRule implements PluralRules.Rule, Serializable {
      private static final long serialVersionUID = 1L;
      private final String keyword;
      private final PluralRules.Constraint constraint;

      public ConstrainedRule(String var1, PluralRules.Constraint var2) {
         this.keyword = var1;
         this.constraint = var2;
      }

      public PluralRules.Rule and(PluralRules.Constraint var1) {
         return new PluralRules.ConstrainedRule(this.keyword, new PluralRules.AndConstraint(this.constraint, var1));
      }

      public PluralRules.Rule or(PluralRules.Constraint var1) {
         return new PluralRules.ConstrainedRule(this.keyword, new PluralRules.OrConstraint(this.constraint, var1));
      }

      @Override
      public String getKeyword() {
         return this.keyword;
      }

      @Override
      public boolean appliesTo(double var1) {
         return this.constraint.isFulfilled(var1);
      }

      @Override
      public int updateRepeatLimit(int var1) {
         return this.constraint.updateRepeatLimit(var1);
      }

      @Override
      public boolean isLimited() {
         return this.constraint.isLimited();
      }

      @Override
      public String toString() {
         return this.keyword + ": " + this.constraint;
      }
   }

   private interface Constraint extends Serializable {
      boolean isFulfilled(double var1);

      boolean isLimited();

      int updateRepeatLimit(int var1);
   }

   public static enum KeywordStatus {
      INVALID,
      SUPPRESSED,
      UNIQUE,
      BOUNDED,
      UNBOUNDED;
   }

   private static class OrConstraint extends PluralRules.BinaryConstraint {
      private static final long serialVersionUID = 1405488568664762222L;

      OrConstraint(PluralRules.Constraint var1, PluralRules.Constraint var2) {
         super(var1, var2, " || ");
      }

      @Override
      public boolean isFulfilled(double var1) {
         return this.a.isFulfilled(var1) || this.b.isFulfilled(var1);
      }

      @Override
      public boolean isLimited() {
         return this.a.isLimited() && this.b.isLimited();
      }
   }

   public static enum PluralType {
      CARDINAL,
      ORDINAL;
   }

   private static class RangeConstraint implements PluralRules.Constraint, Serializable {
      private static final long serialVersionUID = 1L;
      private int mod;
      private boolean inRange;
      private boolean integersOnly;
      private long lowerBound;
      private long upperBound;
      private long[] range_list;

      RangeConstraint(int var1, boolean var2, boolean var3, long var4, long var6, long[] var8) {
         this.mod = var1;
         this.inRange = var2;
         this.integersOnly = var3;
         this.lowerBound = var4;
         this.upperBound = var6;
         this.range_list = var8;
      }

      @Override
      public boolean isFulfilled(double var1) {
         if (this.integersOnly && var1 - (long)var1 != 0.0) {
            return !this.inRange;
         } else {
            if (this.mod != 0) {
               var1 %= this.mod;
            }

            boolean var3 = var1 >= this.lowerBound && var1 <= this.upperBound;
            if (var3 && this.range_list != null) {
               var3 = false;

               for (byte var4 = 0; !var3 && var4 < this.range_list.length; var4 += 2) {
                  var3 = var1 >= this.range_list[var4] && var1 <= this.range_list[var4 + 1];
               }
            }

            return this.inRange == var3;
         }
      }

      @Override
      public boolean isLimited() {
         return this.integersOnly && this.inRange && this.mod == 0;
      }

      @Override
      public int updateRepeatLimit(int var1) {
         int var2 = this.mod == 0 ? (int)this.upperBound : this.mod;
         return Math.max(var2, var1);
      }

      @Override
      public String toString() {
         class ListBuilder {
            StringBuilder sb = new StringBuilder("[");

            ListBuilder add(String var1) {
               return this.add(var1, null);
            }

            ListBuilder add(String var1, Object var2) {
               if (this.sb.length() > 1) {
                  this.sb.append(", ");
               }

               this.sb.append(var1);
               if (var2 != null) {
                  this.sb.append(": ").append(var2.toString());
               }

               return this;
            }

            @Override
            public String toString() {
               String var1 = this.sb.append(']').toString();
               this.sb = null;
               return var1;
            }
         }

         ListBuilder var1 = new ListBuilder();
         if (this.mod > 1) {
            var1.add("mod", this.mod);
         }

         if (this.inRange) {
            var1.add("in");
         } else {
            var1.add("except");
         }

         if (this.integersOnly) {
            var1.add("ints");
         }

         if (this.lowerBound == this.upperBound) {
            var1.add(String.valueOf(this.lowerBound));
         } else {
            var1.add(this.lowerBound + "-" + this.upperBound);
         }

         if (this.range_list != null) {
            var1.add(Arrays.toString(this.range_list));
         }

         return var1.toString();
      }
   }

   private interface Rule extends Serializable {
      String getKeyword();

      boolean appliesTo(double var1);

      boolean isLimited();

      int updateRepeatLimit(int var1);
   }

   private static class RuleChain implements PluralRules.RuleList, Serializable {
      private static final long serialVersionUID = 1L;
      private final PluralRules.Rule rule;
      private final PluralRules.RuleChain next;

      public RuleChain(PluralRules.Rule var1) {
         this(var1, null);
      }

      private RuleChain(PluralRules.Rule var1, PluralRules.RuleChain var2) {
         this.rule = var1;
         this.next = var2;
      }

      public PluralRules.RuleChain addRule(PluralRules.Rule var1) {
         return new PluralRules.RuleChain(var1, this);
      }

      private PluralRules.Rule selectRule(double var1) {
         PluralRules.Rule var3 = null;
         if (this.next != null) {
            var3 = this.next.selectRule(var1);
         }

         if (var3 == null && this.rule.appliesTo(var1)) {
            var3 = this.rule;
         }

         return var3;
      }

      @Override
      public String select(double var1) {
         PluralRules.Rule var3 = this.selectRule(var1);
         return var3 == null ? "other" : var3.getKeyword();
      }

      @Override
      public Set<String> getKeywords() {
         HashSet var1 = new HashSet();
         var1.add("other");

         for (PluralRules.RuleChain var2 = this; var2 != null; var2 = var2.next) {
            var1.add(var2.rule.getKeyword());
         }

         return var1;
      }

      @Override
      public boolean isLimited(String var1) {
         PluralRules.RuleChain var2 = this;

         boolean var3;
         for (var3 = false; var2 != null; var2 = var2.next) {
            if (var1.equals(var2.rule.getKeyword())) {
               if (!var2.rule.isLimited()) {
                  return false;
               }

               var3 = true;
            }
         }

         return var3;
      }

      @Override
      public int getRepeatLimit() {
         int var1 = 0;

         for (PluralRules.RuleChain var2 = this; var2 != null; var2 = var2.next) {
            var1 = var2.rule.updateRepeatLimit(var1);
         }

         return var1;
      }

      @Override
      public String toString() {
         String var1 = this.rule.toString();
         if (this.next != null) {
            var1 = this.next.toString() + "; " + var1;
         }

         return var1;
      }
   }

   private interface RuleList extends Serializable {
      String select(double var1);

      Set<String> getKeywords();

      int getRepeatLimit();

      boolean isLimited(String var1);
   }
}
