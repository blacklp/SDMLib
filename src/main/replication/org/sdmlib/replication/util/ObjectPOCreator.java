package org.sdmlib.replication.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;

public class ObjectPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ObjectPO(new Object[]{});
      } else {
          return new ObjectPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.replication.util.CreatorCreator.createIdMap(sessionID);
   }
}
