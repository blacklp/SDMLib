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
   
package org.sdmlib.models.pattern.creators;

import java.util.LinkedHashSet;
import org.sdmlib.models.pattern.MatchOtherThen;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.models.modelsets.StringList;
import java.util.List;
import org.sdmlib.models.modelsets.booleanList;
import org.sdmlib.models.pattern.creators.PatternSet;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.creators.PatternObjectSet;
import org.sdmlib.models.pattern.PatternObject;

public class MatchOtherThenSet extends LinkedHashSet<MatchOtherThen> implements org.sdmlib.models.modelsets.ModelSet
{


   public String toString()
   {
      StringList stringList = new StringList();
      
      for (MatchOtherThen elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   public String getEntryType()
   {
      return "org.sdmlib.models.pattern.MatchOtherThen";
   }


   public MatchOtherThenSet with(MatchOtherThen value)
   {
      this.add(value);
      return this;
   }
   
   public MatchOtherThenSet without(MatchOtherThen value)
   {
      this.remove(value);
      return this;
   }
   public ObjectSet getHostGraphSrcObject()
   {
      ObjectSet result = new ObjectSet();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getHostGraphSrcObject());
      }
      
      return result;
   }

   public MatchOtherThenSet withHostGraphSrcObject(Object value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.setHostGraphSrcObject(value);
      }
      
      return this;
   }

   public StringList getModifier()
   {
      StringList result = new StringList();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getModifier());
      }
      
      return result;
   }

   public MatchOtherThenSet withModifier(String value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.setModifier(value);
      }
      
      return this;
   }

   public booleanList getHasMatch()
   {
      booleanList result = new booleanList();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getHasMatch());
      }
      
      return result;
   }

   public MatchOtherThenSet withHasMatch(boolean value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.setHasMatch(value);
      }
      
      return this;
   }

   public StringList getPatternObjectName()
   {
      StringList result = new StringList();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getPatternObjectName());
      }
      
      return result;
   }

   public MatchOtherThenSet withPatternObjectName(String value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.setPatternObjectName(value);
      }
      
      return this;
   }

   public booleanList getDoAllMatches()
   {
      booleanList result = new booleanList();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getDoAllMatches());
      }
      
      return result;
   }

   public MatchOtherThenSet withDoAllMatches(boolean value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.setDoAllMatches(value);
      }
      
      return this;
   }

   public PatternSet getPattern()
   {
      PatternSet result = new PatternSet();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getPattern());
      }
      
      return result;
   }

   public MatchOtherThenSet withPattern(Pattern value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.withPattern(value);
      }
      
      return this;
   }

   public PatternObjectSet getSrc()
   {
      PatternObjectSet result = new PatternObjectSet();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getSrc());
      }
      
      return result;
   }

   public MatchOtherThenSet withSrc(PatternObject value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.withSrc(value);
      }
      
      return this;
   }

   public PatternObjectSet getForbidden()
   {
      PatternObjectSet result = new PatternObjectSet();
      
      for (MatchOtherThen obj : this)
      {
         result.add(obj.getForbidden());
      }
      
      return result;
   }

   public MatchOtherThenSet withForbidden(PatternObject value)
   {
      for (MatchOtherThen obj : this)
      {
         obj.withForbidden(value);
      }
      
      return this;
   }

}
