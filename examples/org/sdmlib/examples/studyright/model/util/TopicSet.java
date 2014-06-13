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
   
package org.sdmlib.examples.studyright.model.util;

import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.examples.studyright.model.Topic;
import java.util.Collection;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.examples.studyright.model.Professor;

public class TopicSet extends SDMSet<Topic>
{


   public TopicPO hasTopicPO()
   {
      return new TopicPO(this.toArray(new Topic[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.examples.studyright.model.Topic";
   }


   @SuppressWarnings("unchecked")
   public TopicSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Topic>)value);
      }
      else if (value != null)
      {
         this.add((Topic) value);
      }
      
      return this;
   }
   
   public TopicSet without(Topic value)
   {
      this.remove(value);
      return this;
   }

   public StringList getTitle()
   {
      StringList result = new StringList();
      
      for (Topic obj : this)
      {
         result.add(obj.getTitle());
      }
      
      return result;
   }

   public TopicSet hasTitle(String value)
   {
      TopicSet result = new TopicSet();
      
      for (Topic obj : this)
      {
         if (value.equals(obj.getTitle()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public TopicSet withTitle(String value)
   {
      for (Topic obj : this)
      {
         obj.setTitle(value);
      }
      
      return this;
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

   public TopicSet hasProf(Object value)
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
      
      TopicSet answer = new TopicSet();
      
      for (Topic obj : this)
      {
         if (neighbors.contains(obj.getProf()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public TopicSet withProf(Professor value)
   {
      for (Topic obj : this)
      {
         obj.withProf(value);
      }
      
      return this;
   }

}
