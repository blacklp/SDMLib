package de.kassel.test.roombook.util;

import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.PatternObject;

import de.kassel.test.roombook.Building;
import de.kassel.test.roombook.Floor;

public class FloorPO extends PatternObject<FloorPO, Floor>
{

    public FloorSet allMatches()
   {
      this.setDoAllMatches(true);
      
      FloorSet matches = new FloorSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Floor) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public FloorPO(){
      newInstance(CreatorCreator.createIdMap("PatternObjectType"));
   }

   public FloorPO(Floor... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public FloorPO hasLevel(int value)
   {
      new AttributeConstraint()
      .withAttrName(Floor.PROPERTY_LEVEL)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FloorPO hasLevel(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Floor.PROPERTY_LEVEL)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FloorPO createLevel(int value)
   {
      this.startCreate().hasLevel(value).endCreate();
      return this;
   }
   
   public int getLevel()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Floor) getCurrentMatch()).getLevel();
      }
      return 0;
   }
   
   public FloorPO withLevel(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Floor) getCurrentMatch()).setLevel(value);
      }
      return this;
   }
   
   public FloorPO hasName(String value)
   {
      new AttributeConstraint()
      .withAttrName(Floor.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FloorPO hasName(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(Floor.PROPERTY_NAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FloorPO createName(String value)
   {
      this.startCreate().hasName(value).endCreate();
      return this;
   }
   
   public String getName()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Floor) getCurrentMatch()).getName();
      }
      return null;
   }
   
   public FloorPO withName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Floor) getCurrentMatch()).setName(value);
      }
      return this;
   }
   
   public FloorPO hasGuest(String value)
   {
      new AttributeConstraint()
      .withAttrName(Floor.PROPERTY_GUEST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FloorPO hasGuest(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(Floor.PROPERTY_GUEST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FloorPO createGuest(String value)
   {
      this.startCreate().hasGuest(value).endCreate();
      return this;
   }
   
   public String getGuest()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Floor) getCurrentMatch()).getGuest();
      }
      return null;
   }
   
   public FloorPO withGuest(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Floor) getCurrentMatch()).setGuest(value);
      }
      return this;
   }
   
   public BuildingPO hasBuildings()
   {
      BuildingPO result = new BuildingPO(new de.kassel.test.roombook.Building[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Floor.PROPERTY_BUILDINGS, result);
      
      return result;
   }

   public BuildingPO createBuildings()
   {
      return this.startCreate().hasBuildings().endCreate();
   }

   public FloorPO hasBuildings(BuildingPO tgt)
   {
      return hasLinkConstraint(tgt, Floor.PROPERTY_BUILDINGS);
   }

   public FloorPO createBuildings(BuildingPO tgt)
   {
      return this.startCreate().hasBuildings(tgt).endCreate();
   }

   public Building getBuildings()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Floor) this.getCurrentMatch()).getBuildings();
      }
      return null;
   }

}
