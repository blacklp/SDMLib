package org.sdmlib.test.examples.studyrightWithAssignments.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import org.sdmlib.test.examples.studyrightWithAssignments.model.University;

import de.uniks.networkparser.json.JsonIdMap;

public class UniversityPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new UniversityPO(new University[]{});
      } else {
          return new UniversityPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.test.examples.studyrightWithAssignments.model.util.CreatorCreator.createIdMap(sessionID);
   }
}