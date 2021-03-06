/*
   Copyright (c) 2014 zuendorf 
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package org.sdmlib.storyboards;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.sdmlib.StrUtil;
import org.sdmlib.serialization.PropertyChangeInterface;
import org.sdmlib.storyboards.util.StoryboardStepSet;
   /**
    * 
    * @see <a href='../../../../../../src/test/java/org/sdmlib/test/kanban/ProjectBoard.java'>ProjectBoard.java</a>
*/
   public class StoryboardStep implements PropertyChangeInterface
{
   //==========================================================================
   
   protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   @Override
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }
   
   public void addPropertyChangeListener(PropertyChangeListener listener) 
   {
      getPropertyChangeSupport().addPropertyChangeListener(listener);
   }

   
   //==========================================================================
   
   public void removeYou()
   {
      setStoryboard(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_TEXT = "text";
   
   private String text;

   public String getText()
   {
      return this.text;
   }
   
   public void setText(String value)
   {
      if ( ! StrUtil.stringEquals(this.text, value))
      {
         String oldValue = this.text;
         this.text = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_TEXT, oldValue, value);
      }
   }
   
   public StoryboardStep withText(String value)
   {
      setText(value);
      return this;
   } 

   @Override
   public String toString()
   {
      StringBuilder s = new StringBuilder();
      
      s.append(" ").append(this.getText());
      return s.substring(1);
   }


   
   public static final StoryboardStepSet EMPTY_SET = new StoryboardStepSet();

   
   /********************************************************************
    * <pre>
    *              many                       one
    * StoryboardStep ----------------------------------- Storyboard
    *              storyboardSteps                   storyboard
    * </pre>
    */
   
   public static final String PROPERTY_STORYBOARD = "storyboard";
   
   private Storyboard storyboard = null;
   
   public Storyboard getStoryboard()
   {
      return this.storyboard;
   }
   
   public boolean setStoryboard(Storyboard value)
   {
      boolean changed = false;
      
      if (this.storyboard != value)
      {
         Storyboard oldValue = this.storyboard;
         
         if (this.storyboard != null)
         {
            this.storyboard = null;
            oldValue.withoutStoryboardSteps(this);
         }
         
         this.storyboard = value;
         
         if (value != null)
         {
            value.withStoryboardSteps(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_STORYBOARD, oldValue, value);
         changed = true;
      }
      
      return changed;
   }
   
   public StoryboardStep withStoryboard(Storyboard value)
   {
      setStoryboard(value);
      return this;
   } 
   
   public Storyboard createStoryboard()
   {
      Storyboard value = new Storyboard();
      withStoryboard(value);
      return value;
   } 
}

