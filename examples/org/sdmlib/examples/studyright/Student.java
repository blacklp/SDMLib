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
   
package org.sdmlib.examples.studyright;

import java.util.LinkedHashSet;

public class Student
{ 
   /********************************************************************
    * <pre>
    *              many                       one
    * Student ----------------------------------- University
    *              students                   uni
    * </pre>
    */
   
   public static final String PROPERTY_UNI = "uni";
   
   private University uni = null;
   
   public University getUni()
   {
      return this.uni;
   }
   
   public boolean setUni(University value)
   {
      boolean changed = false;
      
      if (this.uni != value)
      {
         University oldValue = this.uni;
         
         if (this.uni != null)
         {
            this.uni = null;
            oldValue.withoutStudents(this);
         }
         
         this.uni = value;
         
         if (value != null)
         {
            value.withStudents(this);
         }
         
         // getPropertyChangeSupport().firePropertyChange(PROPERTY_UNI, null, value);
         changed = true;
      }
      
      return changed;
   }
   
   public Student withUni(University value)
   {
      setUni(value);
      return this;
   } 

   
   public static final LinkedHashSet<Student> EMPTY_SET = new LinkedHashSet<Student>();
}




