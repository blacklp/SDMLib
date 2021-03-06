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

import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.booleanList;
import org.sdmlib.models.modelsets.longList;
import org.sdmlib.models.pattern.CardinalityConstraint;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.PatternObject;
import java.lang.Object;
import org.sdmlib.models.pattern.util.PatternSet;
import org.sdmlib.models.pattern.util.PatternObjectSet;

public class CardinalityConstraintSet extends SDMSet<CardinalityConstraint> implements org.sdmlib.models.modelsets.ModelSet
{
   private static final long serialVersionUID = 1L;

   @Override
   public String toString()
   {
      StringList stringList = new StringList();
      
      for (CardinalityConstraint elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.models.pattern.CardinalityConstraint";
   }


   public StringList getTgtRoleName()
   {
      StringList result = new StringList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getTgtRoleName());
      }
      
      return result;
   }

   public CardinalityConstraintSet withTgtRoleName(String value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setTgtRoleName(value);
      }
      
      return this;
   }

   public ObjectSet getHostGraphSrcObject()
   {
      ObjectSet result = new ObjectSet();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getHostGraphSrcObject());
      }
      
      return result;
   }

   public CardinalityConstraintSet withHostGraphSrcObject(Object value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setHostGraphSrcObject(value);
      }
      
      return this;
   }

   public longList getMinCard()
   {
      longList result = new longList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getMinCard());
      }
      
      return result;
   }

   public CardinalityConstraintSet withMinCard(long value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setMinCard(value);
      }
      
      return this;
   }

   public longList getMaxCard()
   {
      longList result = new longList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getMaxCard());
      }
      
      return result;
   }

   public CardinalityConstraintSet withMaxCard(long value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setMaxCard(value);
      }
      
      return this;
   }

   public StringList getModifier()
   {
      StringList result = new StringList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getModifier());
      }
      
      return result;
   }

   public CardinalityConstraintSet withModifier(String value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setModifier(value);
      }
      
      return this;
   }

   public booleanList getHasMatch()
   {
      booleanList result = new booleanList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getHasMatch());
      }
      
      return result;
   }

   public CardinalityConstraintSet withHasMatch(boolean value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setHasMatch(value);
      }
      
      return this;
   }

   public StringList getPatternObjectName()
   {
      StringList result = new StringList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getPatternObjectName());
      }
      
      return result;
   }

   public CardinalityConstraintSet withPatternObjectName(String value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setPatternObjectName(value);
      }
      
      return this;
   }

   public booleanList getDoAllMatches()
   {
      booleanList result = new booleanList();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getDoAllMatches());
      }
      
      return result;
   }

   public CardinalityConstraintSet withDoAllMatches(boolean value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.setDoAllMatches(value);
      }
      
      return this;
   }

   public PatternSet getPattern()
   {
      PatternSet result = new PatternSet();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getPattern());
      }
      
      return result;
   }

   public CardinalityConstraintSet withPattern(Pattern value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.withPattern(value);
      }
      
      return this;
   }

   public PatternObjectSet getSrc()
   {
      PatternObjectSet result = new PatternObjectSet();
      
      for (CardinalityConstraint obj : this)
      {
         result.add(obj.getSrc());
      }
      
      return result;
   }

   public CardinalityConstraintSet withSrc(PatternObject value)
   {
      for (CardinalityConstraint obj : this)
      {
         obj.withSrc(value);
      }
      
      return this;
   }



   public CardinalityConstraintPO startModelPattern()
   {
      return new CardinalityConstraintPO(this.toArray(new CardinalityConstraint[this.size()]));
   }


   public CardinalityConstraintSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<CardinalityConstraint>)value);
      }
      else if (value != null)
      {
         this.add((CardinalityConstraint) value);
      }
      
      return this;
   }
   
   public CardinalityConstraintSet without(CardinalityConstraint value)
   {
      this.remove(value);
      return this;
   }



   public CardinalityConstraintPO hasCardinalityConstraintPO()
   {
      return new CardinalityConstraintPO(this.toArray(new CardinalityConstraint[this.size()]));
   }

   public static final CardinalityConstraintSet EMPTY_SET = new CardinalityConstraintSet().withReadOnly(true);
   public CardinalityConstraintSet hasTgtRoleName(String value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value.equals(obj.getTgtRoleName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasTgtRoleName(String lower, String upper)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (lower.compareTo(obj.getTgtRoleName()) <= 0 && obj.getTgtRoleName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasHostGraphSrcObject(Object value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value == obj.getHostGraphSrcObject())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasMinCard(long value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value == obj.getMinCard())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasMinCard(long lower, long upper)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (lower <= obj.getMinCard() && obj.getMinCard() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasMaxCard(long value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value == obj.getMaxCard())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasMaxCard(long lower, long upper)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (lower <= obj.getMaxCard() && obj.getMaxCard() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasModifier(String value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value.equals(obj.getModifier()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasModifier(String lower, String upper)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (lower.compareTo(obj.getModifier()) <= 0 && obj.getModifier().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasHasMatch(boolean value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value == obj.isHasMatch())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasPatternObjectName(String value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value.equals(obj.getPatternObjectName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasPatternObjectName(String lower, String upper)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (lower.compareTo(obj.getPatternObjectName()) <= 0 && obj.getPatternObjectName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public CardinalityConstraintSet hasDoAllMatches(boolean value)
   {
      CardinalityConstraintSet result = new CardinalityConstraintSet();
      
      for (CardinalityConstraint obj : this)
      {
         if (value == obj.isDoAllMatches())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

}
