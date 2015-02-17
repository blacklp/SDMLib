package org.sdmlib.replication.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.replication.SeppelScope;

public class SeppelScopePOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new SeppelScopePO(new SeppelScope[]{});
      } else {
          return new SeppelScopePO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.replication.util.CreatorCreator.createIdMap(sessionID);
   }
}