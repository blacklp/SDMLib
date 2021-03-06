package org.sdmlib.models.pattern.util;

import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.models.pattern.PatternElement;
import org.sdmlib.models.pattern.PatternLink;
import org.sdmlib.models.pattern.PatternObject;
import java.lang.Object;

public class AttributeConstraintPO extends PatternObject<AttributeConstraintPO, AttributeConstraint>
{
   public AttributeConstraintPO(){
      newInstance(CreatorCreator.createIdMap("PatternObjectType"));
   }

   public AttributeConstraintPO(AttributeConstraint... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
  }
   public AttributeConstraintPO hasAttrName(String value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_ATTRNAME)
      .withTgtValue(value)
      .withSrc(this)
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO withAttrName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).withAttrName(value);
      }
      return this;
   }
   
   public AttributeConstraintPO hasTgtValue(Object value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_TGTVALUE)
      .withTgtValue(value)
      .withSrc(this)
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO withTgtValue(Object value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).withTgtValue(value);
      }
      return this;
   }
   
   public AttributeConstraintPO hasHostGraphSrcObject(Object value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_HOSTGRAPHSRCOBJECT)
      .withTgtValue(value)
      .withSrc(this)
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO withHostGraphSrcObject(Object value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).withHostGraphSrcObject(value);
      }
      return this;
   }
   
   public AttributeConstraintPO hasModifier(String value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_MODIFIER)
      .withTgtValue(value)
      .withSrc(this)
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO withModifier(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).withModifier(value);
      }
      return this;
   }
   
   public AttributeConstraintPO hasHasMatch(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_HASMATCH)
      .withTgtValue(value)
      .withSrc(this)
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO withHasMatch(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).withHasMatch(value);
      }
      return this;
   }
   
   public PatternObjectPO hasSrc()
   {
      PatternObjectPO result = new PatternObjectPO();
      
      PatternLink patternLink = new PatternLink()
      .withTgt(result).withTgtRoleName(AttributeConstraint.PROPERTY_SRC)
      .withSrc(this);
      
      this.getPattern().addToElements(patternLink);
      
      this.getPattern().addToElements(result);
      
      this.getPattern().findMatch();
      
      return result;
   }
   
   public AttributeConstraintPO hasSrc(PatternObjectPO tgt)
   {
      return hasLinkConstraint(tgt, AttributeConstraint.PROPERTY_SRC);
   }
   
   public AttributeConstraintPO withSrc(PatternObjectPO tgtPO)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) this.getCurrentMatch()).withSrc((PatternObject) tgtPO.getCurrentMatch());
      }
      return this;
   }
   
   public String getAttrName()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getAttrName();
      }
      return null;
   }
   
   public Object getTgtValue()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getTgtValue();
      }
      return null;
   }
   
   public Object getHostGraphSrcObject()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getHostGraphSrcObject();
      }
      return null;
   }
   
   public String getModifier()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getModifier();
      }
      return null;
   }
   
   public boolean getHasMatch()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getHasMatch();
      }
      return false;
   }
   
   public PatternObject getSrc()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) this.getCurrentMatch()).getSrc();
      }
      return null;
   }
   
   public AttributeConstraintPO hasDoAllMatches(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_DOALLMATCHES)
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
         return ((AttributeConstraint) getCurrentMatch()).getDoAllMatches();
      }
      return false;
   }
   
   public AttributeConstraintPO hasPatternObjectName(String value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_PATTERNOBJECTNAME)
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
         return ((AttributeConstraint) getCurrentMatch()).getPatternObjectName();
      }
      return null;
   }
   
   public PatternPO hasPattern()
   {
      PatternPO result = new PatternPO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(PatternElement.PROPERTY_PATTERN, result);
      
      return result;
   }

   public AttributeConstraintPO hasPattern(PatternPO tgt)
   {
      return hasLinkConstraint(tgt, PatternElement.PROPERTY_PATTERN);
   }

   @Override
   public Pattern getPattern()
   {
      if (super.getPattern().getHasMatch())
      {
         return ((PatternElement) this.getCurrentMatch()).getPattern();
      }
      return super.getPattern();
   }

   public AttributeConstraintPO hasCmpOp(String value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_CMPOP)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public String getCmpOp()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getCmpOp();
      }
      return null;
   }
   
   public AttributeConstraintPO withCmpOp(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).setCmpOp(value);
      }
      return this;
   }
   
   public AttributeConstraintPO hasUpperTgtValue(Object value)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_UPPERTGTVALUE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public Object getUpperTgtValue()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((AttributeConstraint) getCurrentMatch()).getUpperTgtValue();
      }
      return null;
   }
   
   public AttributeConstraintPO withUpperTgtValue(Object value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((AttributeConstraint) getCurrentMatch()).setUpperTgtValue(value);
      }
      return this;
   }
   
   public AttributeConstraintPO hasAttrName(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_ATTRNAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasTgtValue(Object lower, Object upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_TGTVALUE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasUpperTgtValue(Object lower, Object upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_UPPERTGTVALUE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasCmpOp(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_CMPOP)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasHostGraphSrcObject(Object lower, Object upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_HOSTGRAPHSRCOBJECT)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasModifier(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_MODIFIER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasHasMatch(boolean lower, boolean upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_HASMATCH)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasPatternObjectName(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_PATTERNOBJECTNAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO hasDoAllMatches(boolean lower, boolean upper)
   {
      new AttributeConstraint()
      .withAttrName(AttributeConstraint.PROPERTY_DOALLMATCHES)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public AttributeConstraintPO createAttrName(String value)
   {
      this.startCreate().hasAttrName(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createTgtValue(Object value)
   {
      this.startCreate().hasTgtValue(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createUpperTgtValue(Object value)
   {
      this.startCreate().hasUpperTgtValue(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createCmpOp(String value)
   {
      this.startCreate().hasCmpOp(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createHostGraphSrcObject(Object value)
   {
      this.startCreate().hasHostGraphSrcObject(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createModifier(String value)
   {
      this.startCreate().hasModifier(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createHasMatch(boolean value)
   {
      this.startCreate().hasHasMatch(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createPatternObjectName(String value)
   {
      this.startCreate().hasPatternObjectName(value).endCreate();
      return this;
   }
   
   public AttributeConstraintPO createDoAllMatches(boolean value)
   {
      this.startCreate().hasDoAllMatches(value).endCreate();
      return this;
   }
   
   public PatternPO createPattern()
   {
      return (PatternPO) this.startCreate().hasPattern().endCreate();
   }

   public AttributeConstraintPO createPattern(PatternPO tgt)
   {
      return this.startCreate().hasPattern(tgt).endCreate();
   }

   public PatternObjectPO createSrc()
   {
      return (PatternObjectPO) this.startCreate().hasSrc().endCreate();
   }

   public AttributeConstraintPO createSrc(PatternObjectPO tgt)
   {
      return this.startCreate().hasSrc(tgt).endCreate();
   }

}










