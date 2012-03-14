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

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.sdmlib.codegen.CGUtil;

public class University
{
   private String dummy2 = "otto ist /* */  // \" \\\"  \n ";
   
   private CGUtil dummy = new CGUtil(){

      @Override
      public String toString()
      {
         return ";;;;";
      }
      
   };
   
   protected HashMap<String, Integer>[] d3;

   public void m(HashMap<String, org.sdmlib.codegen.Fragment>[]... formParam) // throws IOException, OutOfMemoryError
   {
      // just some other comment // /* " 
   }
   
   public static final String PROPERTY_NAME = "name";
 
   private String name;
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String value)
   {
      this.name = value;
   }
   
   public University withName(String value)
   {
      setName(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * University ----------------------------------- Student
    *              uni                   students
    * </pre>
    */
   
   public static final String PROPERTY_STUDENTS = "students";
   
   private LinkedHashSet<Student> students = null;
   
   public LinkedHashSet<Student> getStudents()
   {
      if (this.students == null)
      {
         return Student.EMPTY_SET;
      }
   
      return this.students;
   }
   
   public boolean addToStudents(Student value)
   {
      boolean changed = false;
      
      if (value != null)
      {
         if (this.students == null)
         {
            this.students = new LinkedHashSet<Student>();
         }
         
         changed = this.students.add (value);
         
         if (changed)
         {
            value.withUni(this);
            // getPropertyChangeSupport().firePropertyChange(PROPERTY_STUDENTS, null, value);
         }
      }
         
      return changed;   
   }
   
   public boolean removeFromStudents(Student value)
   {
      boolean changed = false;
      
      if ((this.students != null) && (value != null))
      {
         changed = this.students.remove (value);
         
         if (changed)
         {
            value.setUni(null);
            // getPropertyChangeSupport().firePropertyChange(PROPERTY_STUDENTS, null, value);
         }
      }
         
      return changed;   
   }
   
   public University withStudents(Student value)
   {
      addToStudents(value);
      return this;
   } 
   
   public University withoutStudents(Student value)
   {
      removeFromStudents(value);
      return this;
   } 
   
   public void removeAllFromStudents()
   {
      LinkedHashSet<Student> tmpSet = new LinkedHashSet<Student>(this.getStudents());
   
      for (Student value : tmpSet)
      {
         this.removeFromStudents(value);
      }
   }
}
