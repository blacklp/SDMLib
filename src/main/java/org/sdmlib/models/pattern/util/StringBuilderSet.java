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

import java.util.LinkedHashSet;

import org.sdmlib.models.modelsets.StringList;

public class StringBuilderSet extends LinkedHashSet<StringBuilder> implements org.sdmlib.models.modelsets.ModelSet
{
   private static final long serialVersionUID = 7211481052043245973L;

   @Override
   public String toString()
   {
      StringList stringList = new StringList();
      
      for (StringBuilder elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   @Override
   public String getEntryType()
   {
      return "java.lang.StringBuilder";
   }


   public StringBuilderSet with(StringBuilder value)
   {
      this.add(value);
      return this;
   }
   
   public StringBuilderSet without(StringBuilder value)
   {
      this.remove(value);
      return this;
   }


   public StringBuilderPO startModelPattern()
   {
      return null;
   }


   public StringBuilderSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         for(Object item : (java.util.Collection<?>)value) {
            this.add((StringBuilder) item);
         }
      }
      else if (value != null)
      {
         this.add((StringBuilder) value);
      }
      
      return this;
   }
   
   public StringBuilderPO hasStringBuilderPO()
   {
      return new StringBuilderPO(this.toArray(new StringBuilder[this.size()]));
   }
}
