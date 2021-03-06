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
import org.sdmlib.models.pattern.LinkConstraint;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.PatternObject;
import java.lang.Object;
import org.sdmlib.models.pattern.util.PatternSet;

public class LinkConstraintSet extends SDMSet<LinkConstraint>
{
   private static final long serialVersionUID = 1L;

   public StringList getTgtRoleName()
   {
      StringList result = new StringList();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getTgtRoleName());
      }
      
      return result;
   }

   public ObjectSet getHostGraphSrcObject()
   {
      ObjectSet result = new ObjectSet();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getHostGraphSrcObject());
      }
      
      return result;
   }

   public LinkConstraintSet withTgtRoleName(String value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withTgtRoleName(value);
      }
      
      return this;
   }

   public LinkConstraintSet withHostGraphSrcObject(Object value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withHostGraphSrcObject(value);
      }
      
      return this;
   }

   public StringList getModifier()
   {
      StringList result = new StringList();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getModifier());
      }
      
      return result;
   }

   public LinkConstraintSet withModifier(String value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withModifier(value);
      }
      
      return this;
   }

   public booleanList getHasMatch()
   {
      booleanList result = new booleanList();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getHasMatch());
      }
      
      return result;
   }

   public LinkConstraintSet withHasMatch(boolean value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withHasMatch(value);
      }
      
      return this;
   }

   public booleanList getDoAllMatches()
   {
      booleanList result = new booleanList();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getDoAllMatches());
      }
      
      return result;
   }

   public LinkConstraintSet withDoAllMatches(boolean value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withDoAllMatches(value);
      }
      
      return this;
   }

   public StringList getPatternObjectName()
   {
      StringList result = new StringList();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getPatternObjectName());
      }
      
      return result;
   }

   public LinkConstraintSet withPatternObjectName(String value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withPatternObjectName(value);
      }
      
      return this;
   }



   public String toString()
   {
      StringList stringList = new StringList();
      
      for (LinkConstraint elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   public String getEntryType()
   {
      return "org.sdmlib.models.pattern.LinkConstraint";
   }


   public PatternSet getPattern()
   {
      PatternSet result = new PatternSet();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getPattern());
      }
      
      return result;
   }

   public LinkConstraintSet withPattern(Pattern value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withPattern(value);
      }
      
      return this;
   }

   public PatternObjectSet getTgt()
   {
      PatternObjectSet result = new PatternObjectSet();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getTgt());
      }
      
      return result;
   }

   public LinkConstraintSet withTgt(PatternObject value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withTgt(value);
      }
      
      return this;
   }

   public PatternObjectSet getSrc()
   {
      PatternObjectSet result = new PatternObjectSet();
      
      for (LinkConstraint obj : this)
      {
         result.add(obj.getSrc());
      }
      
      return result;
   }

   public LinkConstraintSet withSrc(PatternObject value)
   {
      for (LinkConstraint obj : this)
      {
         obj.withSrc(value);
      }
      
      return this;
   }



   public LinkConstraintPO startModelPattern()
   {
      return new LinkConstraintPO(this.toArray(new LinkConstraint[this.size()]));
   }


   public LinkConstraintSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<LinkConstraint>)value);
      }
      else if (value != null)
      {
         this.add((LinkConstraint) value);
      }
      
      return this;
   }
   
   public LinkConstraintSet without(LinkConstraint value)
   {
      this.remove(value);
      return this;
   }



   public LinkConstraintPO hasLinkConstraintPO()
   {
      return new LinkConstraintPO(this.toArray(new LinkConstraint[this.size()]));
   }

   public static final LinkConstraintSet EMPTY_SET = new LinkConstraintSet().withReadOnly(true);
   public LinkConstraintSet hasTgtRoleName(String value)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (value.equals(obj.getTgtRoleName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasTgtRoleName(String lower, String upper)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (lower.compareTo(obj.getTgtRoleName()) <= 0 && obj.getTgtRoleName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasHostGraphSrcObject(Object value)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (value == obj.getHostGraphSrcObject())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasModifier(String value)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (value.equals(obj.getModifier()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasModifier(String lower, String upper)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (lower.compareTo(obj.getModifier()) <= 0 && obj.getModifier().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasHasMatch(boolean value)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (value == obj.isHasMatch())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasPatternObjectName(String value)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (value.equals(obj.getPatternObjectName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasPatternObjectName(String lower, String upper)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (lower.compareTo(obj.getPatternObjectName()) <= 0 && obj.getPatternObjectName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LinkConstraintSet hasDoAllMatches(boolean value)
   {
      LinkConstraintSet result = new LinkConstraintSet();
      
      for (LinkConstraint obj : this)
      {
         if (value == obj.isDoAllMatches())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

}
