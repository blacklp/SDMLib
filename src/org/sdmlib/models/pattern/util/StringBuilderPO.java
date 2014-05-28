package org.sdmlib.models.pattern.util;

import org.sdmlib.models.pattern.PatternObject;

public class StringBuilderPO extends PatternObject<StringBuilderPO, StringBuilder>
{
   public StringBuilderSet allMatches()
   {
      this.setDoAllMatches(true);
      
      StringBuilderSet matches = new StringBuilderSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((StringBuilder) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }
   
}
