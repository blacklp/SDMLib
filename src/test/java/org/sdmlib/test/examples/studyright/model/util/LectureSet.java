/*
   Copyright (c) 2014 zuendorf 
   
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
   
package org.sdmlib.test.examples.studyright.model.util;

import java.util.Collection;

import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.test.examples.studyright.model.Lecture;
import org.sdmlib.test.examples.studyright.model.Professor;
import org.sdmlib.test.examples.studyright.model.Room;
import org.sdmlib.test.examples.studyright.model.Student;
import org.sdmlib.test.examples.studyright.model.util.ProfessorSet;
import org.sdmlib.test.examples.studyright.model.util.RoomSet;
import org.sdmlib.test.examples.studyright.model.util.StudentSet;

public class LectureSet extends SDMSet<Lecture>
{


   public LecturePO hasLecturePO()
   {
      return new LecturePO(this.toArray(new Lecture[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.test.examples.studyright.model.Lecture";
   }


   @SuppressWarnings("unchecked")
   public LectureSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Lecture>)value);
      }
      else if (value != null)
      {
         this.add((Lecture) value);
      }
      
      return this;
   }
   
   public LectureSet without(Lecture value)
   {
      this.remove(value);
      return this;
   }

   public StringList getTitle()
   {
      StringList result = new StringList();
      
      for (Lecture obj : this)
      {
         result.add(obj.getTitle());
      }
      
      return result;
   }

   public LectureSet hasTitle(String value)
   {
      LectureSet result = new LectureSet();
      
      for (Lecture obj : this)
      {
         if (value.equals(obj.getTitle()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LectureSet withTitle(String value)
   {
      for (Lecture obj : this)
      {
         obj.setTitle(value);
      }
      
      return this;
   }

   public RoomSet getIn()
   {
      RoomSet result = new RoomSet();
      
      for (Lecture obj : this)
      {
         result.add(obj.getIn());
      }
      
      return result;
   }

   public LectureSet hasIn(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      LectureSet answer = new LectureSet();
      
      for (Lecture obj : this)
      {
         if (neighbors.contains(obj.getIn()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public LectureSet withIn(Room value)
   {
      for (Lecture obj : this)
      {
         obj.withIn(value);
      }
      
      return this;
   }

   public ProfessorSet getHas()
   {
      ProfessorSet result = new ProfessorSet();
      
      for (Lecture obj : this)
      {
         result.add(obj.getHas());
      }
      
      return result;
   }

   public LectureSet hasHas(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      LectureSet answer = new LectureSet();
      
      for (Lecture obj : this)
      {
         if (neighbors.contains(obj.getHas()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public LectureSet withHas(Professor value)
   {
      for (Lecture obj : this)
      {
         obj.withHas(value);
      }
      
      return this;
   }

   public StudentSet getListen()
   {
      StudentSet result = new StudentSet();
      
      for (Lecture obj : this)
      {
         result.add(obj.getListen());
      }
      
      return result;
   }

   public LectureSet hasListen(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      LectureSet answer = new LectureSet();
      
      for (Lecture obj : this)
      {
         if (neighbors.contains(obj.getListen()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public LectureSet withListen(Student value)
   {
      for (Lecture obj : this)
      {
         obj.withListen(value);
      }
      
      return this;
   }


   public static final LectureSet EMPTY_SET = new LectureSet().withReadOnly(true);
   public LectureSet hasTitle(String lower, String upper)
   {
      LectureSet result = new LectureSet();
      
      for (Lecture obj : this)
      {
         if (lower.compareTo(obj.getTitle()) <= 0 && obj.getTitle().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

}
