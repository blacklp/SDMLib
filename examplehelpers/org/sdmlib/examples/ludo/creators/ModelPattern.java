package org.sdmlib.examples.ludo.creators;

import org.sdmlib.models.pattern.Pattern;
import org.sdmlib.examples.ludo.creators.LudoPO;
import org.sdmlib.examples.ludo.Ludo;
import org.sdmlib.examples.ludo.creators.PlayerPO;
import org.sdmlib.examples.ludo.Player;
import org.sdmlib.examples.ludo.creators.DicePO;
import org.sdmlib.examples.ludo.Dice;
import org.sdmlib.examples.ludo.creators.FieldPO;
import org.sdmlib.examples.ludo.Field;
import org.sdmlib.examples.ludo.creators.PawnPO;
import org.sdmlib.examples.ludo.Pawn;

public class ModelPattern extends Pattern
{
   public ModelPattern()
   {
      super(CreatorCreator.createIdMap("hg"));
   }
   
   public ModelPattern startCreate()
   {
      super.startCreate();
      return this;
   }

   public LudoPO hasElementLudoPO()
   {
      LudoPO value = new LudoPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      this.findMatch();
      
      return value;
   }
   
   public LudoPO hasElementLudoPO(Ludo hostGraphObject)
   {
      LudoPO value = new LudoPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      value.setCurrentMatch(hostGraphObject);
      
      this.findMatch();
      
      return value;
   } 

   public PlayerPO hasElementPlayerPO()
   {
      PlayerPO value = new PlayerPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      this.findMatch();
      
      return value;
   }
   
   public PlayerPO hasElementPlayerPO(Player hostGraphObject)
   {
      PlayerPO value = new PlayerPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      value.setCurrentMatch(hostGraphObject);
      
      this.findMatch();
      
      return value;
   } 

   public DicePO hasElementDicePO()
   {
      DicePO value = new DicePO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      this.findMatch();
      
      return value;
   }
   
   public DicePO hasElementDicePO(Dice hostGraphObject)
   {
      DicePO value = new DicePO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      value.setCurrentMatch(hostGraphObject);
      
      this.findMatch();
      
      return value;
   } 

   public FieldPO hasElementFieldPO()
   {
      FieldPO value = new FieldPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      this.findMatch();
      
      return value;
   }
   
   public FieldPO hasElementFieldPO(Field hostGraphObject)
   {
      FieldPO value = new FieldPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      value.setCurrentMatch(hostGraphObject);
      
      this.findMatch();
      
      return value;
   } 

   public PawnPO hasElementPawnPO()
   {
      PawnPO value = new PawnPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      this.findMatch();
      
      return value;
   }
   
   public PawnPO hasElementPawnPO(Pawn hostGraphObject)
   {
      PawnPO value = new PawnPO();
      this.addToElements(value);
      value.setModifier(this.getModifier());
      
      value.setCurrentMatch(hostGraphObject);
      
      this.findMatch();
      
      return value;
   } 

}

