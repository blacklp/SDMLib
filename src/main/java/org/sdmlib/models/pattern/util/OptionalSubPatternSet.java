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
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.pattern.OptionalSubPattern;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.PatternElement;
import org.sdmlib.models.pattern.ReachabilityGraph;
import org.sdmlib.models.pattern.util.PatternElementSet;
import org.sdmlib.models.pattern.util.PatternSet;
import org.sdmlib.models.pattern.util.ReachabilityGraphSet;

public class OptionalSubPatternSet extends SDMSet<OptionalSubPattern>
{
   public StringList getModifier()
   {
      StringList result = new StringList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getModifier());
      }
      
      return result;
   }

   public OptionalSubPatternSet withModifier(String value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withModifier(value);
      }
      
      return this;
   }

   public booleanList getHasMatch()
   {
      booleanList result = new booleanList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getHasMatch());
      }
      
      return result;
   }

   public OptionalSubPatternSet withHasMatch(boolean value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withHasMatch(value);
      }
      
      return this;
   }

   public StringList getPatternObjectName()
   {
      StringList result = new StringList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getPatternObjectName());
      }
      
      return result;
   }

   public OptionalSubPatternSet withPatternObjectName(String value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withPatternObjectName(value);
      }
      
      return this;
   }

   public booleanList getDoAllMatches()
   {
      booleanList result = new booleanList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getDoAllMatches());
      }
      
      return result;
   }

   public OptionalSubPatternSet withDoAllMatches(boolean value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withDoAllMatches(value);
      }
      
      return this;
   }

   public booleanList getMatchForward()
   {
      booleanList result = new booleanList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getMatchForward());
      }
      
      return result;
   }

   public OptionalSubPatternSet withMatchForward(boolean value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withMatchForward(value);
      }
      
      return this;
   }

   public PatternSet getCurrentSubPattern()
   {
      PatternSet result = new PatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getCurrentSubPattern());
      }
      
      return result;
   }

   public OptionalSubPatternSet withCurrentSubPattern(Pattern value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withCurrentSubPattern(value);
      }
      
      return this;
   }



   @Override
   public String toString()
   {
      StringList stringList = new StringList();
      
      for (OptionalSubPattern elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   public String getEntryType()
   {
      return "org.sdmlib.models.pattern.OptionalSubPattern";
   }

   public intList getDebugMode()
   {
      intList result = new intList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getDebugMode());
      }
      
      return result;
   }

   public OptionalSubPatternSet withDebugMode(int value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.setDebugMode(value);
      }
      
      return this;
   }

   public PatternElementSet getElements()
   {
      PatternElementSet result = new PatternElementSet();
      
      for (OptionalSubPattern obj : this)
      {
         result.addAll(obj.getElements());
      }
      
      return result;
   }

   public OptionalSubPatternSet withElements(PatternElement value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withElements(value);
      }
      
      return this;
   }

   public OptionalSubPatternSet withoutElements(PatternElement value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withoutElements(value);
      }
      
      return this;
   }

   public PatternSet getPattern()
   {
      PatternSet result = new PatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getPattern());
      }
      
      return result;
   }

   public OptionalSubPatternSet withPattern(Pattern value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withPattern(value);
      }
      
      return this;
   }

   public StringBuilderSet getTrace()
   {
      StringBuilderSet result = new StringBuilderSet();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getTrace());
      }
      
      return result;
   }

   public OptionalSubPatternSet withTrace(StringBuilder value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.setTrace(value);
      }
      
      return this;
   }

   public ReachabilityGraphSet getRgraph()
   {
      ReachabilityGraphSet result = new ReachabilityGraphSet();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getRgraph());
      }
      
      return result;
   }

   public OptionalSubPatternSet withRgraph(ReachabilityGraph value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.withRgraph(value);
      }
      
      return this;
   }

   public StringList getName()
   {
      StringList result = new StringList();
      
      for (OptionalSubPattern obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }

   public OptionalSubPatternSet withName(String value)
   {
      for (OptionalSubPattern obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }



   public OptionalSubPatternPO startModelPattern()
   {
      return new OptionalSubPatternPO(this.toArray(new OptionalSubPattern[this.size()]));
   }


   public OptionalSubPatternSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<OptionalSubPattern>)value);
      }
      else if (value != null)
      {
         this.add((OptionalSubPattern) value);
      }
      
      return this;
   }
   
   public OptionalSubPatternSet without(OptionalSubPattern value)
   {
      this.remove(value);
      return this;
   }



   public OptionalSubPatternPO hasOptionalSubPatternPO()
   {
      return new OptionalSubPatternPO(this.toArray(new OptionalSubPattern[this.size()]));
   }

   public static final OptionalSubPatternSet EMPTY_SET = new OptionalSubPatternSet().withReadOnly(true);
   public OptionalSubPatternSet hasMatchForward(boolean value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value == obj.isMatchForward())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasCurrentSubPattern(Pattern value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value == obj.getCurrentSubPattern())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasDebugMode(int value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value == obj.getDebugMode())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasDebugMode(int lower, int upper)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (lower <= obj.getDebugMode() && obj.getDebugMode() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasName(String value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasName(String lower, String upper)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasModifier(String value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value.equals(obj.getModifier()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasModifier(String lower, String upper)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (lower.compareTo(obj.getModifier()) <= 0 && obj.getModifier().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasHasMatch(boolean value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value == obj.isHasMatch())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasPatternObjectName(String value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value.equals(obj.getPatternObjectName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasPatternObjectName(String lower, String upper)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (lower.compareTo(obj.getPatternObjectName()) <= 0 && obj.getPatternObjectName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public OptionalSubPatternSet hasDoAllMatches(boolean value)
   {
      OptionalSubPatternSet result = new OptionalSubPatternSet();
      
      for (OptionalSubPattern obj : this)
      {
         if (value == obj.isDoAllMatches())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

}
