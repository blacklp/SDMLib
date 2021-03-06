package org.sdmlib.models.taskflows.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import org.sdmlib.models.taskflows.Logger;

import de.uniks.networkparser.json.JsonIdMap;

public class LoggerPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new LoggerPO(new Logger[]{});
      } else {
          return new LoggerPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return CreatorCreator.createIdMap(sessionID);
   }
}
