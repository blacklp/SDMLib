package org.sdmlib.models.pattern.creators;

import org.sdmlib.models.pattern.creators.CreatorCreator;
import org.sdmlib.serialization.interfaces.SendableEntityCreator;
import org.sdmlib.serialization.json.JsonIdMap;
import org.sdmlib.models.pattern.PatternElement;
import org.sdmlib.models.pattern.PatternLink;

public class PatternLinkCreator implements SendableEntityCreator
{
   private final String[] properties = new String[]
   {
      PatternLink.PROPERTY_SRCROLENAME,
      PatternLink.PROPERTY_TGTROLENAME,
      PatternLink.PROPERTY_TGT,
      PatternLink.PROPERTY_SRC,
      PatternLink.PROPERTY_HOSTGRAPHSRCOBJECT,
      PatternElement.PROPERTY_PATTERN, 
      PatternLink.PROPERTY_MODIFIER,
      PatternLink.PROPERTY_HASMATCH,
      PatternLink.PROPERTY_PATTERNOBJECTNAME,
   };
   
   public String[] getProperties()
   {
      return properties;
   }
   
   public Object getSendableInstance(boolean reference)
   {
      return new PatternLink();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((PatternLink) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      return ((PatternLink) target).set(attrName, value);
   }
   
   public static JsonIdMap createIdMap(String sessionID)
   {
      return CreatorCreator.createIdMap(sessionID);
   }

   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((PatternLink) entity).removeYou();
   }
}



