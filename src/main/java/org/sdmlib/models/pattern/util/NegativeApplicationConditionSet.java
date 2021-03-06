/*
   Copyright (c) 2013 zuendorf 
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package org.sdmlib.models.pattern.util;

import java.util.Collection;

import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.booleanList;
import org.sdmlib.models.modelsets.booleanSet;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.pattern.NegativeApplicationCondition;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.PatternElement;
import org.sdmlib.models.pattern.ReachabilityGraph;
import org.sdmlib.models.pattern.util.PatternElementSet;
import org.sdmlib.models.pattern.util.PatternSet;
import org.sdmlib.models.pattern.util.ReachabilityGraphSet;

public class NegativeApplicationConditionSet extends SDMSet<NegativeApplicationCondition>
{
   public booleanSet getHasMatch()
   {
      booleanSet result = new booleanSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getHasMatch());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withHasMatch(boolean value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withHasMatch(value);
      }
      
      return this;
   }

   public NegativeApplicationConditionSet withCurrentNAC(NegativeApplicationCondition value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withCurrentSubPattern(value);
      }
      
      return this;
   }

   public StringList getModifier()
   {
      StringList result = new StringList();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getModifier());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withModifier(String value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withModifier(value);
      }
      
      return this;
   }

   public booleanList getDoAllMatches()
   {
      booleanList result = new booleanList();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getDoAllMatches());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withDoAllMatches(boolean value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withDoAllMatches(value);
      }
      
      return this;
   }

   public StringList getPatternObjectName()
   {
      StringList result = new StringList();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getPatternObjectName());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withPatternObjectName(String value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withPatternObjectName(value);
      }
      
      return this;
   }

   public PatternSet getCurrentSubPattern()
   {
      PatternSet result = new PatternSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getCurrentSubPattern());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withCurrentSubPattern(Pattern value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withCurrentSubPattern(value);
      }
      
      return this;
   }



   public String toString()
   {
      StringList stringList = new StringList();
      
      for (NegativeApplicationCondition elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   public String getEntryType()
   {
      return "org.sdmlib.models.pattern.NegativeApplicationCondition";
   }


   public intList getDebugMode()
   {
      intList result = new intList();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getDebugMode());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withDebugMode(int value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.setDebugMode(value);
      }
      
      return this;
   }

   public PatternElementSet getElements()
   {
      PatternElementSet result = new PatternElementSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.addAll(obj.getElements());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withElements(PatternElement value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withElements(value);
      }
      
      return this;
   }

   public NegativeApplicationConditionSet withoutElements(PatternElement value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withoutElements(value);
      }
      
      return this;
   }

   public PatternSet getPattern()
   {
      PatternSet result = new PatternSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getPattern());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withPattern(Pattern value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withPattern(value);
      }
      
      return this;
   }

   public StringBuilderSet getTrace()
   {
      StringBuilderSet result = new StringBuilderSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getTrace());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withTrace(StringBuilder value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.setTrace(value);
      }
      
      return this;
   }

   public ReachabilityGraphSet getRgraph()
   {
      ReachabilityGraphSet result = new ReachabilityGraphSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getRgraph());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withRgraph(ReachabilityGraph value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.withRgraph(value);
      }
      
      return this;
   }

   public StringList getName()
   {
      StringList result = new StringList();
      
      for (NegativeApplicationCondition obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }

   public NegativeApplicationConditionSet withName(String value)
   {
      for (NegativeApplicationCondition obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }



   public NegativeApplicationConditionPO startModelPattern()
   {
      return new NegativeApplicationConditionPO(this.toArray(new NegativeApplicationCondition[this.size()]));
   }


   public NegativeApplicationConditionSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<NegativeApplicationCondition>)value);
      }
      else if (value != null)
      {
         this.add((NegativeApplicationCondition) value);
      }
      
      return this;
   }
   
   public NegativeApplicationConditionSet without(NegativeApplicationCondition value)
   {
      this.remove(value);
      return this;
   }



   public NegativeApplicationConditionPO hasNegativeApplicationConditionPO()
   {
      return new NegativeApplicationConditionPO(this.toArray(new NegativeApplicationCondition[this.size()]));
   }

   public static final NegativeApplicationConditionSet EMPTY_SET = new NegativeApplicationConditionSet().withReadOnly(true);
   public NegativeApplicationConditionSet hasCurrentSubPattern(Pattern value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value == obj.getCurrentSubPattern())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasDebugMode(int value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value == obj.getDebugMode())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasDebugMode(int lower, int upper)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (lower <= obj.getDebugMode() && obj.getDebugMode() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasName(String value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasName(String lower, String upper)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasModifier(String value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value.equals(obj.getModifier()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasModifier(String lower, String upper)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (lower.compareTo(obj.getModifier()) <= 0 && obj.getModifier().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasHasMatch(boolean value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value == obj.isHasMatch())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasPatternObjectName(String value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value.equals(obj.getPatternObjectName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasPatternObjectName(String lower, String upper)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (lower.compareTo(obj.getPatternObjectName()) <= 0 && obj.getPatternObjectName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public NegativeApplicationConditionSet hasDoAllMatches(boolean value)
   {
      NegativeApplicationConditionSet result = new NegativeApplicationConditionSet();
      
      for (NegativeApplicationCondition obj : this)
      {
         if (value == obj.isDoAllMatches())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

}
