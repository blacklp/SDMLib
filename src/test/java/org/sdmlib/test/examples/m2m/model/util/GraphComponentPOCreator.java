package org.sdmlib.test.examples.m2m.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import org.sdmlib.test.examples.m2m.model.GraphComponent;

import de.uniks.networkparser.json.JsonIdMap;

public class GraphComponentPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new GraphComponentPO(new GraphComponent[]{});
      } else {
          return new GraphComponentPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return CreatorCreator.createIdMap(sessionID);
   }
}
