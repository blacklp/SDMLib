package org.sdmlib.models.pattern.util;

import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.MatchOtherThen;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.PatternElement;
import org.sdmlib.models.pattern.PatternObject;
import java.lang.Object;

public class MatchOtherThenPO extends PatternObject<MatchOtherThenPO, MatchOtherThen>
{
   public MatchOtherThenPO(){
      newInstance(CreatorCreator.createIdMap("PatternObjectType"));
   }

   public MatchOtherThenPO(MatchOtherThen... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
  }
   public MatchOtherThenSet allMatches()
   {
      this.setDoAllMatches(true);
      
      MatchOtherThenSet matches = new MatchOtherThenSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((MatchOtherThen) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }
   
   public MatchOtherThenPO hasHostGraphSrcObject(Object value)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_HOSTGRAPHSRCOBJECT)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public Object getHostGraphSrcObject()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) getCurrentMatch()).getHostGraphSrcObject();
      }
      return null;
   }
   
   public MatchOtherThenPO withHostGraphSrcObject(Object value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MatchOtherThen) getCurrentMatch()).setHostGraphSrcObject(value);
      }
      return this;
   }
   
   public MatchOtherThenPO hasModifier(String value)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_MODIFIER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public String getModifier()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) getCurrentMatch()).getModifier();
      }
      return null;
   }
   
   public MatchOtherThenPO withModifier(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MatchOtherThen) getCurrentMatch()).setModifier(value);
      }
      return this;
   }
   
   public MatchOtherThenPO hasHasMatch(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_HASMATCH)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public boolean getHasMatch()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) getCurrentMatch()).getHasMatch();
      }
      return false;
   }
   
   public MatchOtherThenPO withHasMatch(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MatchOtherThen) getCurrentMatch()).setHasMatch(value);
      }
      return this;
   }
   
   public MatchOtherThenPO hasPatternObjectName(String value)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_PATTERNOBJECTNAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public String getPatternObjectName()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) getCurrentMatch()).getPatternObjectName();
      }
      return null;
   }
   
   public MatchOtherThenPO withPatternObjectName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MatchOtherThen) getCurrentMatch()).setPatternObjectName(value);
      }
      return this;
   }
   
   public MatchOtherThenPO hasDoAllMatches(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_DOALLMATCHES)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public boolean getDoAllMatches()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) getCurrentMatch()).getDoAllMatches();
      }
      return false;
   }
   
   public MatchOtherThenPO withDoAllMatches(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MatchOtherThen) getCurrentMatch()).setDoAllMatches(value);
      }
      return this;
   }
   
   public PatternPO hasPattern()
   {
      PatternPO result = new PatternPO();
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(PatternElement.PROPERTY_PATTERN, result);
      
      return result;
   }

   public MatchOtherThenPO hasPattern(PatternPO tgt)
   {
      return hasLinkConstraint(tgt, PatternElement.PROPERTY_PATTERN);
   }

   public Pattern getPattern()
   {
      if (super.getPattern().getHasMatch())
      {
         return ((PatternElement) this.getCurrentMatch()).getPattern();
      }
      return super.getPattern();
   }


   public PatternObjectPO hasSrc()
   {
      PatternObjectPO result = new PatternObjectPO(new PatternObject[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(MatchOtherThen.PROPERTY_SRC, result);
      
      return result;
   }

   public MatchOtherThenPO hasSrc(PatternObjectPO tgt)
   {
      return hasLinkConstraint(tgt, MatchOtherThen.PROPERTY_SRC);
   }

   public PatternObject getSrc()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) this.getCurrentMatch()).getSrc();
      }
      return null;
   }

   public PatternObjectPO hasForbidden()
   {
      PatternObjectPO result = new PatternObjectPO(new PatternObject[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(MatchOtherThen.PROPERTY_FORBIDDEN, result);
      
      return result;
   }

   public MatchOtherThenPO hasForbidden(PatternObjectPO tgt)
   {
      return hasLinkConstraint(tgt, MatchOtherThen.PROPERTY_FORBIDDEN);
   }

   public PatternObject getForbidden()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MatchOtherThen) this.getCurrentMatch()).getForbidden();
      }
      return null;
   }

   public MatchOtherThenPO hasHostGraphSrcObject(Object lower, Object upper)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_HOSTGRAPHSRCOBJECT)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MatchOtherThenPO hasModifier(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_MODIFIER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MatchOtherThenPO hasHasMatch(boolean lower, boolean upper)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_HASMATCH)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MatchOtherThenPO hasPatternObjectName(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_PATTERNOBJECTNAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MatchOtherThenPO hasDoAllMatches(boolean lower, boolean upper)
   {
      new AttributeConstraint()
      .withAttrName(MatchOtherThen.PROPERTY_DOALLMATCHES)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MatchOtherThenPO createHostGraphSrcObject(Object value)
   {
      this.startCreate().hasHostGraphSrcObject(value).endCreate();
      return this;
   }
   
   public MatchOtherThenPO createModifier(String value)
   {
      this.startCreate().hasModifier(value).endCreate();
      return this;
   }
   
   public MatchOtherThenPO createHasMatch(boolean value)
   {
      this.startCreate().hasHasMatch(value).endCreate();
      return this;
   }
   
   public MatchOtherThenPO createPatternObjectName(String value)
   {
      this.startCreate().hasPatternObjectName(value).endCreate();
      return this;
   }
   
   public MatchOtherThenPO createDoAllMatches(boolean value)
   {
      this.startCreate().hasDoAllMatches(value).endCreate();
      return this;
   }
   
   public PatternPO createPattern()
   {
      return (PatternPO) this.startCreate().hasPattern().endCreate();
   }

   public MatchOtherThenPO createPattern(PatternPO tgt)
   {
      return this.startCreate().hasPattern(tgt).endCreate();
   }

   public PatternObjectPO createSrc()
   {
      return (PatternObjectPO) this.startCreate().hasSrc().endCreate();
   }

   public MatchOtherThenPO createSrc(PatternObjectPO tgt)
   {
      return this.startCreate().hasSrc(tgt).endCreate();
   }

   public PatternObjectPO createForbidden()
   {
      return this.startCreate().hasForbidden().endCreate();
   }

   public MatchOtherThenPO createForbidden(PatternObjectPO tgt)
   {
      return this.startCreate().hasForbidden(tgt).endCreate();
   }

}



