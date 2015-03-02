package org.sdmlib.examples.studyrightWithAssignments.model.util;

import org.sdmlib.examples.studyrightWithAssignments.model.Assignment;
import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;

public class AssignmentPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new AssignmentPO(new Assignment[]{});
      } else {
          return new AssignmentPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.examples.studyrightWithAssignments.model.util.CreatorCreator.createIdMap(sessionID);
   }
}
