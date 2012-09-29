package org.sdmlib.model.taskflows.creators;

import java.util.LinkedHashSet;
import org.sdmlib.serialization.interfaces.SendableEntityCreator;
import org.sdmlib.serialization.json.JsonIdMap;
import org.sdmlib.serialization.json.SDMLibJsonIdMap;

public class CreatorCreator
{
   public static LinkedHashSet<SendableEntityCreator> creatorSet = null;
   
   public static LinkedHashSet<SendableEntityCreator> getCreatorSet()
   {
      if (creatorSet == null)
      {
         creatorSet = new LinkedHashSet<SendableEntityCreator>();
         creatorSet.add(new org.sdmlib.model.taskflows.creators.TaskFlowCreator());
         creatorSet.add(new org.sdmlib.model.taskflows.creators.TaskFlowPOCreator());
         creatorSet.add(new org.sdmlib.model.taskflows.creators.PeerProxyCreator());
         creatorSet.add(new org.sdmlib.model.taskflows.creators.PeerProxyPOCreator());
         creatorSet.add(new org.sdmlib.model.taskflows.creators.SocketThreadCreator());
         creatorSet.add(new org.sdmlib.model.taskflows.creators.SocketThreadPOCreator());
         creatorSet.addAll(org.sdmlib.models.pattern.creators.CreatorCreator.getCreatorSet());
      }
      
      return creatorSet;
   }

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = new SDMLibJsonIdMap().withSessionId(sessionID);
      
      jsonIdMap.addCreator(getCreatorSet());

      return jsonIdMap;
   }
}


