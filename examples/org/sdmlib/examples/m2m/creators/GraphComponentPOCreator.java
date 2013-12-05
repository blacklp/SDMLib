package org.sdmlib.examples.m2m.creators;

import org.sdmlib.models.pattern.creators.PatternObjectCreator;

public class GraphComponentPOCreator extends PatternObjectCreator
{
   public Object getSendableInstance(boolean reference)
   {
      return new GraphComponentPO();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((GraphComponentPO) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      return ((GraphComponentPO) target).set(attrName, value);
   }
}

