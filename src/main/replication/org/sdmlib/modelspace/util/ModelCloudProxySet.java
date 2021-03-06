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
import org.sdmlib.modelspace.ModelCloudProxy;
import java.util.Collection;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.modelspace.util.ModelCloudSet;
import org.sdmlib.modelspace.ModelCloud;
import java.util.Collections;
import org.sdmlib.modelspace.util.ModelSpaceProxySet;
import org.sdmlib.modelspace.ModelSpaceProxy;

public class ModelCloudProxySet extends SDMSet<ModelCloudProxy>
{

   public static final ModelCloudProxySet EMPTY_SET = new ModelCloudProxySet().withReadOnly(true);


   public ModelCloudProxyPO hasModelCloudProxyPO()
   {
      return new ModelCloudProxyPO(this.toArray(new ModelCloudProxy[this.size()]));
   }


   public String getEntryType()
   {
      return "org.sdmlib.modelspace.ModelCloudProxy";
   }


   @SuppressWarnings("unchecked")
   public ModelCloudProxySet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ModelCloudProxy>)value);
      }
      else if (value != null)
      {
         this.add((ModelCloudProxy) value);
      }
      
      return this;
   }
   
   public ModelCloudProxySet without(ModelCloudProxy value)
   {
      this.remove(value);
      return this;
   }

   public StringList getHostName()
   {
      StringList result = new StringList();
      
      for (ModelCloudProxy obj : this)
      {
         result.add(obj.getHostName());
      }
      
      return result;
   }

   public ModelCloudProxySet hasHostName(String value)
   {
      ModelCloudProxySet result = new ModelCloudProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         if (value.equals(obj.getHostName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ModelCloudProxySet hasHostName(String lower, String upper)
   {
      ModelCloudProxySet result = new ModelCloudProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         if (lower.compareTo(obj.getHostName()) <= 0 && obj.getHostName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ModelCloudProxySet withHostName(String value)
   {
      for (ModelCloudProxy obj : this)
      {
         obj.setHostName(value);
      }
      
      return this;
   }

   public intList getPortNo()
   {
      intList result = new intList();
      
      for (ModelCloudProxy obj : this)
      {
         result.add(obj.getPortNo());
      }
      
      return result;
   }

   public ModelCloudProxySet hasPortNo(int value)
   {
      ModelCloudProxySet result = new ModelCloudProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         if (value == obj.getPortNo())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ModelCloudProxySet hasPortNo(int lower, int upper)
   {
      ModelCloudProxySet result = new ModelCloudProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         if (lower <= obj.getPortNo() && obj.getPortNo() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ModelCloudProxySet withPortNo(int value)
   {
      for (ModelCloudProxy obj : this)
      {
         obj.setPortNo(value);
      }
      
      return this;
   }

   public ModelCloudSet getRoot()
   {
      ModelCloudSet result = new ModelCloudSet();
      
      for (ModelCloudProxy obj : this)
      {
         result.add(obj.getRoot());
      }
      
      return result;
   }

   public ModelCloudProxySet hasRoot(Object value)
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
      
      ModelCloudProxySet answer = new ModelCloudProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         if (neighbors.contains(obj.getRoot()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public ModelCloudProxySet withRoot(ModelCloud value)
   {
      for (ModelCloudProxy obj : this)
      {
         obj.withRoot(value);
      }
      
      return this;
   }

   public ModelSpaceProxySet getProvidedSpaces()
   {
      ModelSpaceProxySet result = new ModelSpaceProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         result.addAll(obj.getProvidedSpaces());
      }
      
      return result;
   }

   public ModelCloudProxySet hasProvidedSpaces(Object value)
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
      
      ModelCloudProxySet answer = new ModelCloudProxySet();
      
      for (ModelCloudProxy obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getProvidedSpaces()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public ModelCloudProxySet withProvidedSpaces(ModelSpaceProxy value)
   {
      for (ModelCloudProxy obj : this)
      {
         obj.withProvidedSpaces(value);
      }
      
      return this;
   }

   public ModelCloudProxySet withoutProvidedSpaces(ModelSpaceProxy value)
   {
      for (ModelCloudProxy obj : this)
      {
         obj.withoutProvidedSpaces(value);
      }
      
      return this;
   }

}
