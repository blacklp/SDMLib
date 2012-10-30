package org.sdmlib.examples.chats.creators;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.examples.chats.CSClientTask;
import org.sdmlib.examples.chats.creators.CSClientTaskSet;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.PatternLink;
import org.sdmlib.examples.chats.creators.CSVisitAllClientsFlowPO;
import org.sdmlib.models.pattern.LinkConstraint;
import org.sdmlib.examples.chats.creators.CSClientTaskPO;
import org.sdmlib.examples.chats.CSVisitAllClientsFlow;

public class CSClientTaskPO extends PatternObject<CSClientTaskPO, CSClientTask>
{
   public CSClientTaskSet allMatches()
   {
      this.setDoAllMatches(true);
      
      CSClientTaskSet matches = new CSClientTaskSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((CSClientTask) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }
   
   public CSClientTaskPO hasTaskNo(int value)
   {
      AttributeConstraint constr = (AttributeConstraint) new AttributeConstraint()
      .withAttrName(CSClientTask.PROPERTY_TASKNO)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public int getTaskNo()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((CSClientTask) getCurrentMatch()).getTaskNo();
      }
      return 0;
   }
   
   public CSVisitAllClientsFlowPO hasParent()
   {
      CSVisitAllClientsFlowPO result = new CSVisitAllClientsFlowPO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(CSClientTask.PROPERTY_PARENT, result);
      
      return result;
   }
   
   public CSClientTaskPO hasParent(CSVisitAllClientsFlowPO tgt)
   {
      LinkConstraint patternLink = (LinkConstraint) new LinkConstraint()
      .withTgt(tgt).withTgtRoleName(CSClientTask.PROPERTY_PARENT)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier());
      
      this.getPattern().addToElements(patternLink);
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public CSVisitAllClientsFlow getParent()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((CSClientTask) this.getCurrentMatch()).getParent();
      }
      return null;
   }
   
}
