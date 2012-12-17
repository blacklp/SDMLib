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
   
package org.sdmlib.model.classes.test;

import org.sdmlib.utils.PropertyChangeInterface;
import java.beans.PropertyChangeSupport;
import org.sdmlib.utils.StrUtil;

public class Parent implements PropertyChangeInterface
{

   
   //==========================================================================
   
   public Object get(String attrName)
   {
      if (PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         return getName();
      }

      if (PROPERTY_UNCLE.equalsIgnoreCase(attrName))
      {
         return getUncle();
      }

      return null;
   }

   
   //==========================================================================
   
   public boolean set(String attrName, Object value)
   {
      if (PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         setName((String) value);
         return true;
      }

      if (PROPERTY_UNCLE.equalsIgnoreCase(attrName))
      {
         setUncle((Uncle) value);
         return true;
      }

      return false;
   }

   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }

   
   //==========================================================================
   
   public void removeYou()
   {
      setUncle(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_NAME = "name";
   
   private String name;

   public String getName()
   {
      return this.name;
   }
   
   public void setName(String value)
   {
      if ( ! StrUtil.stringEquals(this.name, value))
      {
         String oldValue = this.name;
         this.name = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NAME, oldValue, value);
      }
   }
   
   public Parent withName(String value)
   {
      setName(value);
      return this;
   } 

   public String toString()
   {
      StringBuilder _ = new StringBuilder();
      
      _.append(" ").append(this.getName());
      return _.substring(1);
   }
   
   /********************************************************************
    * <pre>
    *              one                       one
    * Parent ----------------------------------- Uncle
    *              brother                   uncle
    * </pre>
    */
   
   public static final String PROPERTY_UNCLE = "uncle";
   
   private Uncle uncle = null;
   
   public Uncle getUncle()
   {
      return this.uncle;
   }
   
   public boolean setUncle(Uncle value)
   {
      boolean changed = false;
      
      if (this.uncle != value)
      {
         Uncle oldValue = this.uncle;
         
         if (this.uncle != null)
         {
            this.uncle = null;
            oldValue.setBrother(null);
         }
         
         this.uncle = value;
         
         if (value != null)
         {
            value.withBrother(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_UNCLE, oldValue, value);
         changed = true;
      }
      
      return changed;
   }
   
   public Parent withUncle(Uncle value)
   {
      setUncle(value);
      return this;
   } 
   
   public Uncle createUncle()
   {
      Uncle value = new Uncle();
      withUncle(value);
      return value;
   } 
}
