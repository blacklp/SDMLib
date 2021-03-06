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
   
package org.sdmlib.storyboards.util;

import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.storyboards.KanbanEntry;
import java.util.Collection;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.ObjectSet;
import java.util.Collections;
import org.sdmlib.storyboards.util.LogEntryStoryBoardSet;
import org.sdmlib.storyboards.LogEntryStoryBoard;

public class KanbanEntrySet extends SDMSet<KanbanEntry>
{

   public static final KanbanEntrySet EMPTY_SET = new KanbanEntrySet().withReadOnly(true);


   public KanbanEntryPO hasKanbanEntryPO()
   {
      return new KanbanEntryPO(this.toArray(new KanbanEntry[this.size()]));
   }


   public String getEntryType()
   {
      return "org.sdmlib.storyboards.KanbanEntry";
   }


   @SuppressWarnings("unchecked")
   public KanbanEntrySet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<KanbanEntry>)value);
      }
      else if (value != null)
      {
         this.add((KanbanEntry) value);
      }
      
      return this;
   }
   
   public KanbanEntrySet without(KanbanEntry value)
   {
      this.remove(value);
      return this;
   }

   public intList getOldNoOfLogEntries()
   {
      intList result = new intList();
      
      for (KanbanEntry obj : this)
      {
         result.add(obj.getOldNoOfLogEntries());
      }
      
      return result;
   }

   public KanbanEntrySet hasOldNoOfLogEntries(int value)
   {
      KanbanEntrySet result = new KanbanEntrySet();
      
      for (KanbanEntry obj : this)
      {
         if (value == obj.getOldNoOfLogEntries())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public KanbanEntrySet hasOldNoOfLogEntries(int lower, int upper)
   {
      KanbanEntrySet result = new KanbanEntrySet();
      
      for (KanbanEntry obj : this)
      {
         if (lower <= obj.getOldNoOfLogEntries() && obj.getOldNoOfLogEntries() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public KanbanEntrySet withOldNoOfLogEntries(int value)
   {
      for (KanbanEntry obj : this)
      {
         obj.setOldNoOfLogEntries(value);
      }
      
      return this;
   }

   public StringList getPhases()
   {
      StringList result = new StringList();
      
      for (KanbanEntry obj : this)
      {
         result.add(obj.getPhases());
      }
      
      return result;
   }

   public KanbanEntrySet hasPhases(String value)
   {
      KanbanEntrySet result = new KanbanEntrySet();
      
      for (KanbanEntry obj : this)
      {
         if (value.equals(obj.getPhases()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public KanbanEntrySet hasPhases(String lower, String upper)
   {
      KanbanEntrySet result = new KanbanEntrySet();
      
      for (KanbanEntry obj : this)
      {
         if (lower.compareTo(obj.getPhases()) <= 0 && obj.getPhases().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public KanbanEntrySet withPhases(String value)
   {
      for (KanbanEntry obj : this)
      {
         obj.setPhases(value);
      }
      
      return this;
   }

   public LogEntryStoryBoardSet getLogEntries()
   {
      LogEntryStoryBoardSet result = new LogEntryStoryBoardSet();
      
      for (KanbanEntry obj : this)
      {
         result.addAll(obj.getLogEntries());
      }
      
      return result;
   }

   public KanbanEntrySet hasLogEntries(Object value)
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
      
      KanbanEntrySet answer = new KanbanEntrySet();
      
      for (KanbanEntry obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getLogEntries()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public KanbanEntrySet withLogEntries(LogEntryStoryBoard value)
   {
      for (KanbanEntry obj : this)
      {
         obj.withLogEntries(value);
      }
      
      return this;
   }

   public KanbanEntrySet withoutLogEntries(LogEntryStoryBoard value)
   {
      for (KanbanEntry obj : this)
      {
         obj.withoutLogEntries(value);
      }
      
      return this;
   }

}
