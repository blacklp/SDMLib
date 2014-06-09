package org.sdmlib.examples.m2m.model.util;

import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.serialization.SDMLibJsonIdMap;

class CreatorCreator{

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = (JsonIdMap) new SDMLibJsonIdMap().withSessionId(sessionID);
      
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.GraphComponentCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.GraphComponentPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.GraphCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.GraphPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.PersonCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.PersonPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.RelationCreator());
      jsonIdMap.withCreator(new org.sdmlib.examples.m2m.model.util.RelationPOCreator());

      return jsonIdMap;
   }
}
