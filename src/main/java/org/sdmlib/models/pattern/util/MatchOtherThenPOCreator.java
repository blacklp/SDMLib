package org.sdmlib.models.pattern.util;

import org.sdmlib.models.pattern.MatchOtherThen;

import de.uniks.networkparser.json.JsonIdMap;


public class MatchOtherThenPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
         return new MatchOtherThenPO(new MatchOtherThen[]{});
      } else {
         return new MatchOtherThenPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID)
   {
      return CreatorCreator.createIdMap(sessionID);
   }
}
