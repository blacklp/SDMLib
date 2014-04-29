package org.sdmlib.examples.ludo.model.creators;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

public class PawnPOCreator extends PatternObjectCreator
{
   public Object getSendableInstance(boolean reference)
   {
      return new PawnPO();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((PawnPO) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      return ((PawnPO) target).set(attrName, value);
   }
}

