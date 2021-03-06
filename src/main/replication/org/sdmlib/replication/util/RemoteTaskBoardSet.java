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
   
package org.sdmlib.replication.util;

import java.util.Collection;
import java.util.Collections;

import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.replication.Lane;
import org.sdmlib.replication.RemoteTaskBoard;
import org.sdmlib.replication.util.LaneSet;

public class RemoteTaskBoardSet extends SDMSet<RemoteTaskBoard>
{


   public RemoteTaskBoardPO hasRemoteTaskBoardPO()
   {
      return new RemoteTaskBoardPO(this.toArray(new RemoteTaskBoard[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.replication.RemoteTaskBoard";
   }


   @SuppressWarnings("unchecked")
   public RemoteTaskBoardSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<RemoteTaskBoard>)value);
      }
      else if (value != null)
      {
         this.add((RemoteTaskBoard) value);
      }
      
      return this;
   }
   
   public RemoteTaskBoardSet without(RemoteTaskBoard value)
   {
      this.remove(value);
      return this;
   }

   public LaneSet getLanes()
   {
      LaneSet result = new LaneSet();
      
      for (RemoteTaskBoard obj : this)
      {
         result.addAll(obj.getLanes());
      }
      
      return result;
   }

   public RemoteTaskBoardSet hasLanes(Object value)
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
      
      RemoteTaskBoardSet answer = new RemoteTaskBoardSet();
      
      for (RemoteTaskBoard obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getLanes()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public RemoteTaskBoardSet withLanes(Lane value)
   {
      for (RemoteTaskBoard obj : this)
      {
         obj.withLanes(value);
      }
      
      return this;
   }

   public RemoteTaskBoardSet withoutLanes(Lane value)
   {
      for (RemoteTaskBoard obj : this)
      {
         obj.withoutLanes(value);
      }
      
      return this;
   }


   public static final RemoteTaskBoardSet EMPTY_SET = new RemoteTaskBoardSet().withReadOnly(true);
}
