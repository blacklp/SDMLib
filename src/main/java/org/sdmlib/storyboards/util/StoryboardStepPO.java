package org.sdmlib.storyboards.util;

import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.storyboards.Storyboard;
import org.sdmlib.storyboards.StoryboardStep;

public class StoryboardStepPO extends PatternObject<StoryboardStepPO, StoryboardStep>
{
   public StoryboardStepPO(){
      newInstance(CreatorCreator.createIdMap("PatternObjectType"));
   }

   public StoryboardStepPO(StoryboardStep... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return;
      }
      newInstance(CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
  }
   public StoryboardStepSet allMatches()
   {
      this.setDoAllMatches(true);
      
      StoryboardStepSet matches = new StoryboardStepSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((StoryboardStep) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }
   
   public StoryboardStepPO hasText(String value)
   {
      new AttributeConstraint()
      .withAttrName(StoryboardStep.PROPERTY_TEXT)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public String getText()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((StoryboardStep) getCurrentMatch()).getText();
      }
      return null;
   }
   
   public StoryboardStepPO withText(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((StoryboardStep) getCurrentMatch()).setText(value);
      }
      return this;
   }
   
   public StoryboardPO hasStoryboard()
   {
      StoryboardPO result = new StoryboardPO(new org.sdmlib.storyboards.Storyboard[]{});
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(StoryboardStep.PROPERTY_STORYBOARD, result);
      
      return result;
   }

   public StoryboardStepPO hasStoryboard(StoryboardPO tgt)
   {
      return hasLinkConstraint(tgt, StoryboardStep.PROPERTY_STORYBOARD);
   }

   public Storyboard getStoryboard()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((StoryboardStep) this.getCurrentMatch()).getStoryboard();
      }
      return null;
   }

   public StoryboardStepPO hasText(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(StoryboardStep.PROPERTY_TEXT)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public StoryboardStepPO createText(String value)
   {
      this.startCreate().hasText(value).endCreate();
      return this;
   }
   
   public StoryboardPO createStoryboard()
   {
      return this.startCreate().hasStoryboard().endCreate();
   }

   public StoryboardStepPO createStoryboard(StoryboardPO tgt)
   {
      return this.startCreate().hasStoryboard(tgt).endCreate();
   }

}
