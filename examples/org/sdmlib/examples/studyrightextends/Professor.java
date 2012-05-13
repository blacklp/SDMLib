/*
   Copyright (c) 2012 NeTH 
   
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
   
package org.sdmlib.examples.studyrightextends;

import org.sdmlib.examples.studyrightextends.Female;
import org.sdmlib.utils.PropertyChangeInterface;
import java.beans.PropertyChangeSupport;
import java.util.LinkedHashSet;
import org.sdmlib.serialization.json.JsonIdMap;

public class Professor extends Female implements PropertyChangeInterface
{

   
   //==========================================================================
   
   public Object get(String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (PROPERTY_PERSNR.equalsIgnoreCase(attrName))
      {
         return getPersNr();
      }

      if (PROPERTY_LECTURE.equalsIgnoreCase(attrName))
      {
         return getLecture();
      }
      
      return null;
   }

   
   //==========================================================================
   
   public boolean set(String attrName, Object value)
   {
      if (PROPERTY_PERSNR.equalsIgnoreCase(attrName))
      {
         setPersNr((Integer) value);
         return true;
      }

      if (PROPERTY_LECTURE.equalsIgnoreCase(attrName))
      {
         addToLecture((Lecture) value);
         return true;
      }
      
      if ((PROPERTY_LECTURE + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         removeFromLecture((Lecture) value);
         return true;
      }

      return false;
   }

   
   //==========================================================================
   
   protected final PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }

   
   //==========================================================================
   
   public void removeYou()
   {
      removeAllFromLecture();
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_PERSNR = "PersNr";
   
   private int PersNr;
   
   public int getPersNr()
   {
      return this.PersNr;
   }
   
   public void setPersNr(int value)
   {
      if (this.PersNr != value)
      {
         int oldValue = this.PersNr;
         this.PersNr = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PERSNR, oldValue, value);
      }
   }
   
   public Professor withPersNr(int value)
   {
      setPersNr(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Professor ----------------------------------- Lecture
    *              has                   lecture
    * </pre>
    */
   
   public static final String PROPERTY_LECTURE = "lecture";
   
   private LinkedHashSet<Lecture> lecture = null;
   
   public LinkedHashSet<Lecture> getLecture()
   {
      if (this.lecture == null)
      {
         return Lecture.EMPTY_SET;
      }
   
      return this.lecture;
   }
   
   public boolean addToLecture(Lecture value)
   {
      boolean changed = false;
      
      if (value != null)
      {
         if (this.lecture == null)
         {
            this.lecture = new LinkedHashSet<Lecture>();
         }
         
         changed = this.lecture.add (value);
         
         if (changed)
         {
            value.withHas(this);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_LECTURE, null, value);
         }
      }
         
      return changed;   
   }
   
   public boolean removeFromLecture(Lecture value)
   {
      boolean changed = false;
      
      if ((this.lecture != null) && (value != null))
      {
         changed = this.lecture.remove (value);
         
         if (changed)
         {
            value.setHas(null);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_LECTURE, value, null);
         }
      }
         
      return changed;   
   }
   
   public Professor withLecture(Lecture value)
   {
      addToLecture(value);
      return this;
   } 
   
   public Professor withoutLecture(Lecture value)
   {
      removeFromLecture(value);
      return this;
   } 
   
   public void removeAllFromLecture()
   {
      LinkedHashSet<Lecture> tmpSet = new LinkedHashSet<Lecture>(this.getLecture());
   
      for (Lecture value : tmpSet)
      {
         this.removeFromLecture(value);
      }
   }
}
