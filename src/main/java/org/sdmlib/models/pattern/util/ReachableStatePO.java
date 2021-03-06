package org.sdmlib.models.pattern.util;

import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.models.pattern.ReachabilityGraph;
import org.sdmlib.models.pattern.ReachableState;
import org.sdmlib.models.pattern.RuleApplication;
import java.lang.Object;

public class ReachableStatePO extends PatternObject<ReachableStatePO, ReachableState>
{
   public ReachableStatePO(){
      newInstance(CreatorCreator.createIdMap("PatternObjectType"));
   }

   public ReachableStatePO(ReachableState... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
  }
   public ReachableStateSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ReachableStateSet matches = new ReachableStateSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((ReachableState) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }
   
   public ReachabilityGraphPO hasParent()
   {
      ReachabilityGraphPO result = new ReachabilityGraphPO(new ReachabilityGraph[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ReachableState.PROPERTY_PARENT, result);
      
      return result;
   }

   public ReachableStatePO hasParent(ReachabilityGraphPO tgt)
   {
      return hasLinkConstraint(tgt, ReachableState.PROPERTY_PARENT);
   }

   public ReachabilityGraph getParent()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ReachableState) this.getCurrentMatch()).getParent();
      }
      return null;
   }

   public ReachabilityGraphPO hasMaster()
   {
      ReachabilityGraphPO result = new ReachabilityGraphPO(new ReachabilityGraph[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ReachableState.PROPERTY_MASTER, result);
      
      return result;
   }

   public ReachableStatePO hasMaster(ReachabilityGraphPO tgt)
   {
      return hasLinkConstraint(tgt, ReachableState.PROPERTY_MASTER);
   }

   public ReachabilityGraph getMaster()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ReachableState) this.getCurrentMatch()).getMaster();
      }
      return null;
   }

   public ReachableStatePO hasGraphRoot(Object value)
   {
      new AttributeConstraint()
      .withAttrName(ReachableState.PROPERTY_GRAPHROOT)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public Object getGraphRoot()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ReachableState) getCurrentMatch()).getGraphRoot();
      }
      return null;
   }
   
   public ReachableStatePO withGraphRoot(Object value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ReachableState) getCurrentMatch()).setGraphRoot(value);
      }
      return this;
   }
   
   public ReachableStatePO hasNumber(long value)
   {
      new AttributeConstraint()
      .withAttrName(ReachableState.PROPERTY_NUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public long getNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ReachableState) getCurrentMatch()).getNumber();
      }
      return 0;
   }
   
   public ReachableStatePO withNumber(long value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ReachableState) getCurrentMatch()).setNumber(value);
      }
      return this;
   }
   
   public RuleApplicationPO hasRuleapplications()
   {
      RuleApplicationPO result = new RuleApplicationPO(new RuleApplication[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ReachableState.PROPERTY_RULEAPPLICATIONS, result);
      
      return result;
   }

   public ReachableStatePO hasRuleapplications(RuleApplicationPO tgt)
   {
      return hasLinkConstraint(tgt, ReachableState.PROPERTY_RULEAPPLICATIONS);
   }

   public RuleApplicationSet getRuleapplications()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ReachableState) this.getCurrentMatch()).getRuleapplications();
      }
      return null;
   }

   public RuleApplicationPO hasResultOf()
   {
      RuleApplicationPO result = new RuleApplicationPO(new RuleApplication[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ReachableState.PROPERTY_RESULTOF, result);
      
      return result;
   }

   public ReachableStatePO hasResultOf(RuleApplicationPO tgt)
   {
      return hasLinkConstraint(tgt, ReachableState.PROPERTY_RESULTOF);
   }

   public RuleApplicationSet getResultOf()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ReachableState) this.getCurrentMatch()).getResultOf();
      }
      return null;
   }

   public ReachableStatePO hasNumber(long lower, long upper)
   {
      new AttributeConstraint()
      .withAttrName(ReachableState.PROPERTY_NUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ReachableStatePO hasGraphRoot(Object lower, Object upper)
   {
      new AttributeConstraint()
      .withAttrName(ReachableState.PROPERTY_GRAPHROOT)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ReachableStatePO createNumber(long value)
   {
      this.startCreate().hasNumber(value).endCreate();
      return this;
   }
   
   public ReachableStatePO createGraphRoot(Object value)
   {
      this.startCreate().hasGraphRoot(value).endCreate();
      return this;
   }
   
   public ReachabilityGraphPO createParent()
   {
      return this.startCreate().hasParent().endCreate();
   }

   public ReachableStatePO createParent(ReachabilityGraphPO tgt)
   {
      return this.startCreate().hasParent(tgt).endCreate();
   }

   public RuleApplicationPO createRuleapplications()
   {
      return this.startCreate().hasRuleapplications().endCreate();
   }

   public ReachableStatePO createRuleapplications(RuleApplicationPO tgt)
   {
      return this.startCreate().hasRuleapplications(tgt).endCreate();
   }

   public RuleApplicationPO createResultOf()
   {
      return this.startCreate().hasResultOf().endCreate();
   }

   public ReachableStatePO createResultOf(RuleApplicationPO tgt)
   {
      return this.startCreate().hasResultOf(tgt).endCreate();
   }

   public ReachabilityGraphPO createMaster()
   {
      return this.startCreate().hasMaster().endCreate();
   }

   public ReachableStatePO createMaster(ReachabilityGraphPO tgt)
   {
      return this.startCreate().hasMaster(tgt).endCreate();
   }

}







