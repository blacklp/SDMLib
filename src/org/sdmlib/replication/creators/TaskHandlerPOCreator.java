package org.sdmlib.replication.creators;

import org.sdmlib.models.pattern.creators.PatternObjectCreator;

public class TaskHandlerPOCreator extends PatternObjectCreator
{
   public Object getSendableInstance(boolean reference)
   {
      return new TaskHandlerPO();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((TaskHandlerPO) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      return ((TaskHandlerPO) target).set(attrName, value);
   }
}

