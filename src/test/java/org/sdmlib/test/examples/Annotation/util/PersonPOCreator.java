package org.sdmlib.test.examples.Annotation.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.test.examples.Annotation.Person;

public class PersonPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new PersonPO(new Person[]{});
      } else {
          return new PersonPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.test.examples.Annotation.util.CreatorCreator.createIdMap(sessionID);
   }
}
