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

import org.sdmlib.replication.LogEntry;
import org.sdmlib.replication.Task;
import org.sdmlib.serialization.EntityFactory;

import de.uniks.networkparser.json.JsonIdMap;

public class LogEntryCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      LogEntry.PROPERTY_STEPNAME,
      LogEntry.PROPERTY_EXECUTEDBY,
      LogEntry.PROPERTY_TIMESTAMP,
      LogEntry.PROPERTY_TASK,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new LogEntry();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (LogEntry.PROPERTY_STEPNAME.equalsIgnoreCase(attribute))
      {
         return ((LogEntry) target).getStepName();
      }

      if (LogEntry.PROPERTY_EXECUTEDBY.equalsIgnoreCase(attribute))
      {
         return ((LogEntry) target).getExecutedBy();
      }

      if (LogEntry.PROPERTY_TIMESTAMP.equalsIgnoreCase(attribute))
      {
         return ((LogEntry) target).getTimeStamp();
      }

      if (LogEntry.PROPERTY_TASK.equalsIgnoreCase(attribute))
      {
         return ((LogEntry) target).getTask();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (JsonIdMap.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (LogEntry.PROPERTY_STEPNAME.equalsIgnoreCase(attrName))
      {
         ((LogEntry) target).withStepName((String) value);
         return true;
      }

      if (LogEntry.PROPERTY_EXECUTEDBY.equalsIgnoreCase(attrName))
      {
         ((LogEntry) target).withExecutedBy((String) value);
         return true;
      }

      if (LogEntry.PROPERTY_TIMESTAMP.equalsIgnoreCase(attrName))
      {
         ((LogEntry) target).withTimeStamp(Long.parseLong(value.toString()));
         return true;
      }

      if (LogEntry.PROPERTY_TASK.equalsIgnoreCase(attrName))
      {
         ((LogEntry) target).setTask((Task) value);
         return true;
      }
      
      return false;
   }
   public static JsonIdMap createIdMap(String sessionID)
   {
      return CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((LogEntry) entity).removeYou();
   }
}
