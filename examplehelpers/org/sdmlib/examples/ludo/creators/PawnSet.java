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

package org.sdmlib.examples.ludo.creators;

import org.sdmlib.models.modelsets.SDMSet;
import org.sdmlib.examples.ludo.Pawn;
import org.sdmlib.models.modelsets.StringList;
import java.util.Collection;
import java.util.List;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.examples.ludo.creators.PlayerSet;
import java.util.Collections;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.examples.ludo.Player;
import org.sdmlib.examples.ludo.creators.FieldSet;
import org.sdmlib.examples.ludo.Field;

public class PawnSet extends SDMSet<Pawn>
{

   public PawnPO hasPawnPO()
   {
      org.sdmlib.examples.ludo.creators.ModelPattern pattern = new org.sdmlib.examples.ludo.creators.ModelPattern();

      PawnPO patternObject = pattern.hasElementPawnPO();

      patternObject.withCandidates(this.clone());

      pattern.setHasMatch(true);
      pattern.findMatch();

      return patternObject;
   }

   @Override
   public String getEntryType()
   {
      return "org.sdmlib.examples.ludo.Pawn";
   }

   public PawnSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Pawn>) value);
      }
      else if (value != null)
      {
         this.add((Pawn) value);
      }

      return this;
   }

   public PawnSet without(Pawn value)
   {
      this.remove(value);
      return this;
   }

   public StringList getColor()
   {
      StringList result = new StringList();

      for (Pawn obj : this)
      {
         result.add(obj.getColor());
      }

      return result;
   }

   public PawnSet hasColor(String value)
   {
      PawnSet result = new PawnSet();

      for (Pawn obj : this)
      {
         if (value.equals(obj.getColor()))
         {
            result.add(obj);
         }
      }

      return result;
   }

   public PawnSet hasColor(String lower, String upper)
   {
      PawnSet result = new PawnSet();

      for (Pawn obj : this)
      {
         if (lower.compareTo(obj.getColor()) <= 0
            && obj.getColor().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }

      return result;
   }

   public PawnSet withColor(String value)
   {
      for (Pawn obj : this)
      {
         obj.setColor(value);
      }

      return this;
   }

   public intList getX()
   {
      intList result = new intList();

      for (Pawn obj : this)
      {
         result.add(obj.getX());
      }

      return result;
   }

   public PawnSet hasX(int value)
   {
      PawnSet result = new PawnSet();

      for (Pawn obj : this)
      {
         if (value == obj.getX())
         {
            result.add(obj);
         }
      }

      return result;
   }

   public PawnSet hasX(int lower, int upper)
   {
      PawnSet result = new PawnSet();

      for (Pawn obj : this)
      {
         if (lower <= obj.getX() && obj.getX() <= upper)
         {
            result.add(obj);
         }
      }

      return result;
   }

   public PawnSet withX(int value)
   {
      for (Pawn obj : this)
      {
         obj.setX(value);
      }

      return this;
   }

   public intList getY()
   {
      intList result = new intList();

      for (Pawn obj : this)
      {
         result.add(obj.getY());
      }

      return result;
   }

   public PawnSet hasY(int value)
   {
      PawnSet result = new PawnSet();

      for (Pawn obj : this)
      {
         if (value == obj.getY())
         {
            result.add(obj);
         }
      }

      return result;
   }

   public PawnSet hasY(int lower, int upper)
   {
      PawnSet result = new PawnSet();

      for (Pawn obj : this)
      {
         if (lower <= obj.getY() && obj.getY() <= upper)
         {
            result.add(obj);
         }
      }

      return result;
   }

   public PawnSet withY(int value)
   {
      for (Pawn obj : this)
      {
         obj.setY(value);
      }

      return this;
   }

   public PlayerSet getPlayer()
   {
      PlayerSet result = new PlayerSet();

      for (Pawn obj : this)
      {
         result.with(obj.getPlayer());
      }

      return result;
   }

   public PawnSet hasPlayer(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection) value);
      }
      else
      {
         neighbors.add(value);
      }

      PawnSet answer = new PawnSet();

      for (Pawn obj : this)
      {
         if (neighbors.contains(obj.getPlayer()))
         {
            answer.add(obj);
         }
      }

      return answer;
   }

   public PawnSet withPlayer(Player value)
   {
      for (Pawn obj : this)
      {
         obj.withPlayer(value);
      }

      return this;
   }

   public FieldSet getPos()
   {
      FieldSet result = new FieldSet();

      for (Pawn obj : this)
      {
         result.with(obj.getPos());
      }

      return result;
   }

   public PawnSet hasPos(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection) value);
      }
      else
      {
         neighbors.add(value);
      }

      PawnSet answer = new PawnSet();

      for (Pawn obj : this)
      {
         if (neighbors.contains(obj.getPos()))
         {
            answer.add(obj);
         }
      }

      return answer;
   }

   public PawnSet withPos(Field value)
   {
      for (Pawn obj : this)
      {
         obj.withPos(value);
      }

      return this;
   }

}



