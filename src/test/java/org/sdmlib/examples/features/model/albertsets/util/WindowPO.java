package org.sdmlib.examples.features.model.albertsets.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.examples.features.model.albertsets.Window;
import org.sdmlib.examples.features.model.albertsets.util.HousePO;
import org.sdmlib.examples.features.model.albertsets.House;
import org.sdmlib.examples.features.model.albertsets.util.WindowPO;

public class WindowPO extends PatternObject<WindowPO, Window>
{

    public WindowSet allMatches()
   {
      this.setDoAllMatches(true);
      
      WindowSet matches = new WindowSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Window) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public WindowPO(){
      newInstance(org.sdmlib.examples.features.model.albertsets.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public WindowPO(Window... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.examples.features.model.albertsets.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public HousePO hasHouse()
   {
      HousePO result = new HousePO(new House[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Window.PROPERTY_HOUSE, result);
      
      return result;
   }

   public HousePO createHouse()
   {
      return this.startCreate().hasHouse().endCreate();
   }

   public WindowPO hasHouse(HousePO tgt)
   {
      return hasLinkConstraint(tgt, Window.PROPERTY_HOUSE);
   }

   public WindowPO createHouse(HousePO tgt)
   {
      return this.startCreate().hasHouse(tgt).endCreate();
   }

   public House getHouse()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Window) this.getCurrentMatch()).getHouse();
      }
      return null;
   }

}