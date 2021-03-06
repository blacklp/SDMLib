package org.sdmlib.test.examples.studyrightWithAssignments.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.test.examples.studyrightWithAssignments.model.Assignment;

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
      return org.sdmlib.test.examples.studyrightWithAssignments.model.util.CreatorCreator.createIdMap(sessionID);
   }
}
