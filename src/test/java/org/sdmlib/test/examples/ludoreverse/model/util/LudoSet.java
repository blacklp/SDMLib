/*
   Copyright (c) 2014 NeTH 
   
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
   
package org.sdmlib.test.examples.ludoreverse.model.util;

import java.util.Collection;

import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.test.examples.ludoreverse.model.Ludo;
import org.sdmlib.test.examples.ludoreverse.model.Player;
import org.sdmlib.test.examples.ludoreverse.model.util.PlayerSet;

public class LudoSet extends SDMSet<Ludo>
{


   public LudoPO hasLudoPO()
   {
      return new LudoPO(this.toArray(new Ludo[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.test.examples.ludoreverse.model.Ludo";
   }


   @SuppressWarnings("unchecked")
   public LudoSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Ludo>)value);
      }
      else if (value != null)
      {
         this.add((Ludo) value);
      }
      
      return this;
   }
   
   public LudoSet without(Ludo value)
   {
      this.remove(value);
      return this;
   }

   public StringList getStyle()
   {
      StringList result = new StringList();
      
      for (Ludo obj : this)
      {
         result.add(obj.getStyle());
      }
      
      return result;
   }

   public LudoSet hasStyle(String value)
   {
      LudoSet result = new LudoSet();
      
      for (Ludo obj : this)
      {
         if (value.equals(obj.getStyle()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LudoSet withStyle(String value)
   {
      for (Ludo obj : this)
      {
         obj.setStyle(value);
      }
      
      return this;
   }

   public intList getAge()
   {
      intList result = new intList();
      
      for (Ludo obj : this)
      {
         result.add(obj.getAge());
      }
      
      return result;
   }

   public LudoSet hasAge(int value)
   {
      LudoSet result = new LudoSet();
      
      for (Ludo obj : this)
      {
         if (value == obj.getAge())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LudoSet withAge(int value)
   {
      for (Ludo obj : this)
      {
         obj.setAge(value);
      }
      
      return this;
   }

   public PlayerSet getGame()
   {
      PlayerSet result = new PlayerSet();
      
      for (Ludo obj : this)
      {
         result.add(obj.getGame());
      }
      
      return result;
   }

   public LudoSet hasGame(Object value)
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
      
      LudoSet answer = new LudoSet();
      
      for (Ludo obj : this)
      {
         if (neighbors.contains(obj.getGame()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public LudoSet withGame(Player value)
   {
      for (Ludo obj : this)
      {
         obj.withGame(value);
      }
      
      return this;
   }


   public static final LudoSet EMPTY_SET = new LudoSet().withReadOnly(true);
   public LudoSet hasStyle(String lower, String upper)
   {
      LudoSet result = new LudoSet();
      
      for (Ludo obj : this)
      {
         if (lower.compareTo(obj.getStyle()) <= 0 && obj.getStyle().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public LudoSet hasAge(int lower, int upper)
   {
      LudoSet result = new LudoSet();
      
      for (Ludo obj : this)
      {
         if (lower <= obj.getAge() && obj.getAge() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

}
