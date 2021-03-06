/*
   Copyright (c) 2012 zuendorf 
   
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
package org.sdmlib.models.classes;

import org.sdmlib.StrUtil;
import org.sdmlib.models.classes.DataType;
   /**
    * 
    * @see <a href='../../../../../../../src/test/java/org/sdmlib/test/examples/SDMLib/ClassModelTest.java'>ClassModelTest.java</a>
*/
   public abstract class Value extends SDMLibClass
{
   public static final String PROPERTY_INITIALIZATION = "initialization";
   public static final String PROPERTY_TYPE = "type";
   
   protected String initialization = null;

   protected DataType type = null;
   
   public boolean setType(DataType value)
   {
      if (( this.type==null && value!=null) || (this.type!=null && this.type!=value))
      {
         DataType oldValue = this.type;
         this.type = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_TYPE, oldValue, value);
         return true;
      }
      return false;
   }
   
   public Value with(DataType value)
   {
      setType(value);
      return this;
   } 
   
   public Value withInitialization(String value)
   {
      setInitialization(value);
      return this;
   }

   public DataType getType()
   {
      return type;
   }

   public String getInitialization()
   {
      return this.initialization;
   }

   public boolean setInitialization(String value)
   {
      if ( ! StrUtil.stringEquals(this.initialization, value))
      {
         String oldValue = this.initialization;
         this.initialization = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_INITIALIZATION, oldValue, value);
         return true;
      }
      return false;
   }

   @Override
   public void removeYou()
   {
      super.removeYou();
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getInitialization());
      result.append(" ").append(this.getName());
      return result.substring(1);
   }

   
   //==========================================================================
   
   public Value withType(DataType value)
   {
      setType(value);
      return this;
   } 
}
