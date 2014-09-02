package org.sdmlib.examples.mancala.referencemodel.util;

import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.serialization.SDMLibJsonIdMap;

public class CreatorCreator{

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = (JsonIdMap) new SDMLibJsonIdMap().withSessionId(sessionID);
      
      jsonIdMap.withCreator(new org.sdmlib.examples.mancala.referencemodel.util.ColorCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.mancala.referencemodel.util.ColorPOCreator());

      return jsonIdMap;
   }
}
