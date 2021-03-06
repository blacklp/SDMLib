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
   
package org.sdmlib.modelspace.util;

import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.modelspace.Task;
import java.util.Collection;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.modelspace.util.TaskLaneSet;
import org.sdmlib.modelspace.TaskLane;
import org.sdmlib.models.modelsets.longList;

public class TaskSet extends SDMSet<Task>
{

   public static final TaskSet EMPTY_SET = new TaskSet().withReadOnly(true);


   public TaskPO hasTaskPO()
   {
      return new TaskPO(this.toArray(new Task[this.size()]));
   }


   public String getEntryType()
   {
      return "org.sdmlib.modelspace.Task";
   }


   @SuppressWarnings("unchecked")
   public TaskSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Task>)value);
      }
      else if (value != null)
      {
         this.add((Task) value);
      }
      
      return this;
   }
   
   public TaskSet without(Task value)
   {
      this.remove(value);
      return this;
   }

   public TaskLaneSet getLane()
   {
      TaskLaneSet result = new TaskLaneSet();
      
      for (Task obj : this)
      {
         result.add(obj.getLane());
      }
      
      return result;
   }

   public TaskSet hasLane(Object value)
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
      
      TaskSet answer = new TaskSet();
      
      for (Task obj : this)
      {
         if (neighbors.contains(obj.getLane()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public TaskSet withLane(TaskLane value)
   {
      for (Task obj : this)
      {
         obj.withLane(value);
      }
      
      return this;
   }

   public StringList getState()
   {
      StringList result = new StringList();
      
      for (Task obj : this)
      {
         result.add(obj.getState());
      }
      
      return result;
   }

   public TaskSet hasState(String value)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (value.equals(obj.getState()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet hasState(String lower, String upper)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (lower.compareTo(obj.getState()) <= 0 && obj.getState().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet withState(String value)
   {
      for (Task obj : this)
      {
         obj.setState(value);
      }
      
      return this;
   }

   public StringList getSpaceName()
   {
      StringList result = new StringList();
      
      for (Task obj : this)
      {
         result.add(obj.getSpaceName());
      }
      
      return result;
   }

   public TaskSet hasSpaceName(String value)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (value.equals(obj.getSpaceName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet hasSpaceName(String lower, String upper)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (lower.compareTo(obj.getSpaceName()) <= 0 && obj.getSpaceName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet withSpaceName(String value)
   {
      for (Task obj : this)
      {
         obj.setSpaceName(value);
      }
      
      return this;
   }

   public StringList getFileName()
   {
      StringList result = new StringList();
      
      for (Task obj : this)
      {
         result.add(obj.getFileName());
      }
      
      return result;
   }

   public TaskSet hasFileName(String value)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (value.equals(obj.getFileName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet hasFileName(String lower, String upper)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (lower.compareTo(obj.getFileName()) <= 0 && obj.getFileName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet withFileName(String value)
   {
      for (Task obj : this)
      {
         obj.setFileName(value);
      }
      
      return this;
   }

   public longList getLastModified()
   {
      longList result = new longList();
      
      for (Task obj : this)
      {
         result.add(obj.getLastModified());
      }
      
      return result;
   }

   public TaskSet hasLastModified(long value)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (value == obj.getLastModified())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet hasLastModified(long lower, long upper)
   {
      TaskSet result = new TaskSet();
      
      for (Task obj : this)
      {
         if (lower <= obj.getLastModified() && obj.getLastModified() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TaskSet withLastModified(long value)
   {
      for (Task obj : this)
      {
         obj.setLastModified(value);
      }
      
      return this;
   }

   public TaskLaneSet getFileTargetCloud()
   {
      TaskLaneSet result = new TaskLaneSet();
      
      for (Task obj : this)
      {
         result.add(obj.getFileTargetCloud());
      }
      
      return result;
   }

   public TaskSet hasFileTargetCloud(Object value)
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
      
      TaskSet answer = new TaskSet();
      
      for (Task obj : this)
      {
         if (neighbors.contains(obj.getFileTargetCloud()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public TaskSet withFileTargetCloud(TaskLane value)
   {
      for (Task obj : this)
      {
         obj.withFileTargetCloud(value);
      }
      
      return this;
   }

}
