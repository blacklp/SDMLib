package org.sdmlib.test.examples.maumau.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.test.examples.maumau.model.Duty;

public class DutyPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new DutyPO(new Duty[]{});
      } else {
          return new DutyPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.test.examples.maumau.model.util.CreatorCreator.createIdMap(sessionID);
   }
}
