package org.sdmlib.models.pattern.creators;

import org.sdmlib.models.pattern.creators.CreatorCreator;
import org.sdmlib.serialization.interfaces.SendableEntityCreator;
import org.sdmlib.serialization.json.JsonIdMap;
import org.sdmlib.models.pattern.OptionalSubPattern;

public class OptionalSubPatternCreator implements SendableEntityCreator
{
   private final String[] properties = new String[]
   {
      OptionalSubPattern.PROPERTY_MODIFIER,
      OptionalSubPattern.PROPERTY_HASMATCH,
      OptionalSubPattern.PROPERTY_PATTERNOBJECTNAME,
      OptionalSubPattern.PROPERTY_DOALLMATCHES,
      OptionalSubPattern.PROPERTY_MATCHFORWARD,
      OptionalSubPattern.PROPERTY_CURRENTSUBPATTERN,
   };
   
   public String[] getProperties()
   {
      return properties;
   }
   
   public Object getSendableInstance(boolean reference)
   {
      return new OptionalSubPattern();
   }
   
   public Object getValue(Object target, String attrName)
   {
      return ((OptionalSubPattern) target).get(attrName);
   }
   
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      return ((OptionalSubPattern) target).set(attrName, value);
   }
   
   public static JsonIdMap createIdMap(String sessionID)
   {
      return CreatorCreator.createIdMap(sessionID);
   }

   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((OptionalSubPattern) entity).removeYou();
   }
}

