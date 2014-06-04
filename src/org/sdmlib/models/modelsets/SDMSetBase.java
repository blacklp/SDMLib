package org.sdmlib.models.modelsets;

import java.util.Collection;

import org.sdmlib.CGUtil;

import de.uniks.networkparser.gui.ItemList;


public class SDMSetBase<T> extends ItemList<T>
{
   @Override
   protected boolean initAllowDuplicate()
   {
      return false;
   }
   @Override
   public String toString()
   {
      StringList stringList = new StringList();
      
      for (T elem : this)
      {
         stringList.add(elem.toString());
      }
      
      return "(" + stringList.concat(", ") + ")";
   }
   
   public <ST extends SDMSet<T>> ST instanceOf(ST target)
   {
      String className = target.getClass().getName();
      className = CGUtil.baseClassName(className, "Set");
      try
      {
         Class<?> targetClass = target.getClass().getClassLoader().loadClass(className);
         for (T elem : this)
         {
            if (targetClass.isAssignableFrom(elem.getClass()))
            {
               target.add(elem);
            }
         }
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return target;
   }
   
   public <ST extends SDMSet<T>> ST union(ST other)
   {
      ST result = (ST) this.getNewInstance();
      result.addAll(other);
      
      return result;
   }
   
   
   public <ST extends SDMSetBase<T>> ST intersection(ST other)
   {
      ST result = (ST) this.getNewInstance();
      result.retainAll(other);
      return result;
   }
   
   
   public <ST extends SDMSetBase<T>> ST minus(Object other)
   {
      ST result = (ST) this.getNewInstance();
      if (other instanceof Collection)
      {
         result.removeAll((Collection) other);
      }
      else
      {
         result.remove(other);
      }
      
      return result;
   }

   public <ST extends SDMSet<T>> ST has(Condition condition)
   {
      ST result = (ST) this.getNewInstance();
      
      for (T elem : this)
      {
         if ( ! condition.check(elem))
         {
            result.remove(elem);
         }
      };
      return result;
   }
   
   public abstract class Condition
   {
      public abstract boolean check(T elem);
   }
   @Override
   public SDMSetBase<T> getNewInstance() {
      return new SDMSetBase<T>();
   }

   @SuppressWarnings("unchecked")
   @Override
   public SDMSetBase<T> with(Object... values) {
       for(Object item : values){
           this.add((T) item);
       }
       return this;
   }
}