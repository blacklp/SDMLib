package org.sdmlib.test.examples.patternrewriteops.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import org.sdmlib.test.examples.patternrewriteops.model.Station;

import de.uniks.networkparser.json.JsonIdMap;

public class StationPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new StationPO(new Station[]{});
      } else {
          return new StationPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID)
   {
      return CreatorCreator.createIdMap(sessionID);
   }
}

