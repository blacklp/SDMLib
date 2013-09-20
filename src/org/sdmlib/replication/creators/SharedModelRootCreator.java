package org.sdmlib.replication.creators;

import org.sdmlib.replication.creators.CreatorCreator;
import org.sdmlib.serialization.interfaces.EntityFactory;
import org.sdmlib.serialization.json.JsonIdMap;
import org.sdmlib.replication.SharedModelRoot;

public class SharedModelRootCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      SharedModelRoot.PROPERTY_CONTENT,
   };
   
   public String[] getProperties()
   {
      return properties;
   }
   
   public Object getSendableInstance(boolean reference)
   {
      return new SharedModelRoot();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((SharedModelRoot) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (JsonIdMap.REMOVE.equals(type))
      {
         attrName = attrName + type;
      }
      return ((SharedModelRoot) target).set(attrName, value);
   }
   
   public static JsonIdMap createIdMap(String sessionID)
   {
      return CreatorCreator.createIdMap(sessionID);
   }

   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((SharedModelRoot) entity).removeYou();
   }
}

