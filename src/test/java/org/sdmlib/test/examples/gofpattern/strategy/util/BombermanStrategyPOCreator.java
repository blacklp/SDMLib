package org.sdmlib.test.examples.gofpattern.strategy.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.test.examples.gofpattern.strategy.BombermanStrategy;

public class BombermanStrategyPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new BombermanStrategyPO(new BombermanStrategy[]{});
      } else {
          return new BombermanStrategyPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.test.examples.gofpattern.strategy.util.CreatorCreator.createIdMap(sessionID);
   }
}
