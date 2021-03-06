/*
   Copyright (c) 2015 zuendorf
   
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
   
package org.sdmlib.test.examples.studyrightWithAssignments.model.util;

import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.test.examples.studyrightWithAssignments.model.Assignment;
import java.util.Collection;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.test.examples.studyrightWithAssignments.model.util.RoomSet;
import org.sdmlib.test.examples.studyrightWithAssignments.model.Room;
import java.util.Collections;
import org.sdmlib.test.examples.studyrightWithAssignments.model.util.StudentSet;
import org.sdmlib.test.examples.studyrightWithAssignments.model.Student;

public class AssignmentSet extends SDMSet<Assignment>
{

   public static final AssignmentSet EMPTY_SET = new AssignmentSet().withReadOnly(true);


   public AssignmentPO hasAssignmentPO()
   {
      return new AssignmentPO(this.toArray(new Assignment[this.size()]));
   }


   public String getEntryType()
   {
      return "org.sdmlib.test.examples.studyrightWithAssignments.model.Assignment";
   }


   @SuppressWarnings("unchecked")
   public AssignmentSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Assignment>)value);
      }
      else if (value != null)
      {
         this.add((Assignment) value);
      }
      
      return this;
   }
   
   public AssignmentSet without(Assignment value)
   {
      this.remove(value);
      return this;
   }

   public StringList getContent()
   {
      StringList result = new StringList();
      
      for (Assignment obj : this)
      {
         result.add(obj.getContent());
      }
      
      return result;
   }

   public AssignmentSet hasContent(String value)
   {
      AssignmentSet result = new AssignmentSet();
      
      for (Assignment obj : this)
      {
         if (value.equals(obj.getContent()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public AssignmentSet hasContent(String lower, String upper)
   {
      AssignmentSet result = new AssignmentSet();
      
      for (Assignment obj : this)
      {
         if (lower.compareTo(obj.getContent()) <= 0 && obj.getContent().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public AssignmentSet withContent(String value)
   {
      for (Assignment obj : this)
      {
         obj.setContent(value);
      }
      
      return this;
   }

   public intList getPoints()
   {
      intList result = new intList();
      
      for (Assignment obj : this)
      {
         result.add(obj.getPoints());
      }
      
      return result;
   }

   public AssignmentSet hasPoints(int value)
   {
      AssignmentSet result = new AssignmentSet();
      
      for (Assignment obj : this)
      {
         if (value == obj.getPoints())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public AssignmentSet hasPoints(int lower, int upper)
   {
      AssignmentSet result = new AssignmentSet();
      
      for (Assignment obj : this)
      {
         if (lower <= obj.getPoints() && obj.getPoints() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public AssignmentSet withPoints(int value)
   {
      for (Assignment obj : this)
      {
         obj.setPoints(value);
      }
      
      return this;
   }

   /**
    * @see <a href='../../../../../../../../../../src/test/java/org/sdmlib/test/examples/studyrightWithAssignments/StoryboardTests.java'>StoryboardTests.java</a>
    */
   public RoomSet getRoom()
   {
      RoomSet result = new RoomSet();
      
      for (Assignment obj : this)
      {
         result.add(obj.getRoom());
      }
      
      return result;
   }

   public AssignmentSet hasRoom(Object value)
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
      
      AssignmentSet answer = new AssignmentSet();
      
      for (Assignment obj : this)
      {
         if (neighbors.contains(obj.getRoom()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public AssignmentSet withRoom(Room value)
   {
      for (Assignment obj : this)
      {
         obj.withRoom(value);
      }
      
      return this;
   }

   public StudentSet getStudents()
   {
      StudentSet result = new StudentSet();
      
      for (Assignment obj : this)
      {
         result.addAll(obj.getStudents());
      }
      
      return result;
   }

   public AssignmentSet hasStudents(Object value)
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
      
      AssignmentSet answer = new AssignmentSet();
      
      for (Assignment obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getStudents()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public AssignmentSet withStudents(Student value)
   {
      for (Assignment obj : this)
      {
         obj.withStudents(value);
      }
      
      return this;
   }

   public AssignmentSet withoutStudents(Student value)
   {
      for (Assignment obj : this)
      {
         obj.withoutStudents(value);
      }
      
      return this;
   }

}
