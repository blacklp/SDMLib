package org.sdmlib.logger.util;

import org.sdmlib.logger.Logger;
import org.sdmlib.logger.TaskFlow;
import org.sdmlib.serialization.EntityFactory;

public class LoggerCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      TaskFlow.PROPERTY_TASKNO,
      TaskFlow.PROPERTY_IDMAP,
      TaskFlow.PROPERTY_SUBFLOW,
      Logger.PROPERTY_ENTRIES,
      Logger.PROPERTY_STARTPEER,
   };
   
   public String[] getProperties()
   {
      return properties;
   }
   
   public Object getSendableInstance(boolean reference)
   {
      return new Logger();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((Logger) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      return ((Logger) target).set(attrName, value);
   }
   
   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((Logger) entity).removeYou();
   }
}



