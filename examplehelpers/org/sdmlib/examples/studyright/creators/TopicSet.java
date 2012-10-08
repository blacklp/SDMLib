package org.sdmlib.examples.studyright.creators;

import java.util.LinkedHashSet;

import org.sdmlib.examples.studyright.Topic;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.examples.studyright.Professor;

public class TopicSet extends LinkedHashSet<Topic>
{
   public StringList getTitle()
   {
      StringList result = new StringList();
      
      for (Topic obj : this)
      {
         result.add(obj.getTitle());
      }
      
      return result;
   }

   public ProfessorSet getProf()
   {
      ProfessorSet result = new ProfessorSet();
      
      for (Topic obj : this)
      {
         result.add(obj.getProf());
      }
      
      return result;
   }
   public TopicSet withTitle(String value)
   {
      for (Topic obj : this)
      {
         obj.withTitle(value);
      }
      
      return this;
   }

   public TopicSet withProf(Professor value)
   {
      for (Topic obj : this)
      {
         obj.withProf(value);
      }
      
      return this;
   }



   public String toString()
   {
      StringList stringList = new StringList();
      
      for (Topic elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }


   public TopicSet with(Topic value)
   {
      this.add(value);
      return this;
   }
   
   public TopicSet without(Topic value)
   {
      this.remove(value);
      return this;
   }
}



