package org.sdmlib.test.examples.modelspace.chat.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.test.examples.modelspace.chat.MSChatMsg;

public class MSChatMsgPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new MSChatMsgPO(new MSChatMsg[]{});
      } else {
          return new MSChatMsgPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.test.examples.modelspace.chat.util.CreatorCreator.createIdMap(sessionID);
   }
}
