package org.sdmlib.model.test.methods.creators;

import org.sdmlib.serialization.json.JsonIdMap;
import org.sdmlib.serialization.json.SDMLibJsonIdMap;

public class CreatorCreator
{
   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = new SDMLibJsonIdMap().withSessionId(sessionID);
      
      jsonIdMap.withCreator(new org.sdmlib.model.test.methods.creators.PlaceCreator());
      return jsonIdMap;
   }
}

