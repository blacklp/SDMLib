package org.sdmlib.storyboards.creators;

import java.util.LinkedHashSet;

import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.storyboards.KanbanEntry;
import org.sdmlib.storyboards.LogEntry;

public class KanbanEntrySet extends LinkedHashSet<KanbanEntry>
{
   private static final long serialVersionUID = 1L;

   public LogEntrySet getLogEntries()
   {
      LogEntrySet result = new LogEntrySet();
      
      for (KanbanEntry obj : this)
      {
         result.addAll(obj.getLogEntries());
      }
      
      return result;
   }
   public KanbanEntrySet withLogEntries(LogEntry value)
   {
      for (KanbanEntry obj : this)
      {
         obj.withLogEntries(value);
      }
      
      return this;
   }

   public KanbanEntrySet withoutLogEntries(LogEntry value)
   {
      for (KanbanEntry obj : this)
      {
         obj.withoutLogEntries(value);
      }
      
      return this;
   }



   public String toString()
   {
      StringList stringList = new StringList();
      
      for (KanbanEntry elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   public String getEntryType()
   {
      return "org.sdmlib.storyboards.KanbanEntry";
   }


   public KanbanEntrySet with(KanbanEntry value)
   {
      this.add(value);
      return this;
   }
   
   public KanbanEntrySet without(KanbanEntry value)
   {
      this.remove(value);
      return this;
   }
}


