package org.sdmlib.examples.groupAccount.model.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.examples.groupAccount.model.Item;
import org.sdmlib.examples.groupAccount.model.util.ItemSet;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.PatternLink;
import org.sdmlib.examples.groupAccount.model.util.GroupAccountPO;
import org.sdmlib.models.pattern.LinkConstraint;
import org.sdmlib.examples.groupAccount.model.util.ItemPO;
import org.sdmlib.examples.groupAccount.model.GroupAccount;
import org.sdmlib.examples.groupAccount.model.util.PersonPO;
import org.sdmlib.examples.groupAccount.model.Person;

public class ItemPO extends PatternObject<ItemPO, Item>
{

    public ItemSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ItemSet matches = new ItemSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Item) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }
   
   public ItemPO hasDescription(String value)
   {
      AttributeConstraint constr = (AttributeConstraint) new AttributeConstraint()
      .withAttrName(Item.PROPERTY_DESCRIPTION)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ItemPO hasDescription(String lower, String upper)
   {
      AttributeConstraint constr = (AttributeConstraint) new AttributeConstraint()
      .withAttrName(Item.PROPERTY_DESCRIPTION)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ItemPO createDescription(String value)
   {
      this.startCreate().hasDescription(value).endCreate();
      return this;
   }
   
   public String getDescription()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Item) getCurrentMatch()).getDescription();
      }
      return null;
   }
   
   public ItemPO withDescription(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Item) getCurrentMatch()).setDescription(value);
      }
      return this;
   }
   
   public ItemPO hasValue(double value)
   {
      AttributeConstraint constr = (AttributeConstraint) new AttributeConstraint()
      .withAttrName(Item.PROPERTY_VALUE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ItemPO hasValue(double lower, double upper)
   {
      AttributeConstraint constr = (AttributeConstraint) new AttributeConstraint()
      .withAttrName(Item.PROPERTY_VALUE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ItemPO createValue(double value)
   {
      this.startCreate().hasValue(value).endCreate();
      return this;
   }
   
   public double getValue()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Item) getCurrentMatch()).getValue();
      }
      return 0;
   }
   
   public ItemPO withValue(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Item) getCurrentMatch()).setValue(value);
      }
      return this;
   }
   
   public GroupAccountPO hasParent()
   {
      GroupAccountPO result = new GroupAccountPO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Item.PROPERTY_PARENT, result);
      
      return result;
   }

   public GroupAccountPO createParent()
   {
      return this.startCreate().hasParent().endCreate();
   }

   public ItemPO hasParent(GroupAccountPO tgt)
   {
      return hasLinkConstraint(tgt, Item.PROPERTY_PARENT);
   }

   public ItemPO createParent(GroupAccountPO tgt)
   {
      return this.startCreate().hasParent(tgt).endCreate();
   }

   public GroupAccount getParent()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Item) this.getCurrentMatch()).getParent();
      }
      return null;
   }

   public PersonPO hasBuyer()
   {
      PersonPO result = new PersonPO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Item.PROPERTY_BUYER, result);
      
      return result;
   }

   public PersonPO createBuyer()
   {
      return this.startCreate().hasBuyer().endCreate();
   }

   public ItemPO hasBuyer(PersonPO tgt)
   {
      return hasLinkConstraint(tgt, Item.PROPERTY_BUYER);
   }

   public ItemPO createBuyer(PersonPO tgt)
   {
      return this.startCreate().hasBuyer(tgt).endCreate();
   }

   public Person getBuyer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Item) this.getCurrentMatch()).getBuyer();
      }
      return null;
   }

}
