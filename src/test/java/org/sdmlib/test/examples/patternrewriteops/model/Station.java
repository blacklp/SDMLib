/*
   Copyright (c) 2014 Stefan 
   
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
   
package org.sdmlib.test.examples.patternrewriteops.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedHashSet;

import org.sdmlib.serialization.PropertyChangeInterface;
import org.sdmlib.test.examples.patternrewriteops.model.util.PersonSet;
import org.sdmlib.test.examples.patternrewriteops.model.util.StationSet;
import org.sdmlib.test.examples.patternrewriteops.model.util.TrainSet;
   /**
    * 
    * @see <a href='../../../../../../../../../src/test/java/org/sdmlib/test/examples/patternrewriteops/TrainModel.java'>TrainModel.java</a>
*/
   public class Station implements PropertyChangeInterface
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
      removeAllFromTrains();
      setNext(null);
      setPrev(null);
      removeAllFromPeople();
      setFlag(null);
      withoutTrains(this.getTrains().toArray(new Train[this.getTrains().size()]));
      withoutPeople(this.getPeople().toArray(new Person[this.getPeople().size()]));
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Station ----------------------------------- Train
    *              station                   trains
    * </pre>
    */
   
   public static final String PROPERTY_TRAINS = "trains";

   private TrainSet trains = null;
   
   public TrainSet getTrains()
   {
      if (this.trains == null)
      {
         return Train.EMPTY_SET;
      }
   
      return this.trains;
   }

   public boolean addToTrains(Train value)
   {
      boolean changed = false;
      
      if (value != null)
      {
         if (this.trains == null)
         {
            this.trains = new TrainSet();
         }
         
         changed = this.trains.add (value);
         
         if (changed)
         {
            value.withStation(this);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_TRAINS, null, value);
         }
      }
         
      return changed;   
   }

   public boolean removeFromTrains(Train value)
   {
      boolean changed = false;
      
      if ((this.trains != null) && (value != null))
      {
         changed = this.trains.remove (value);
         
         if (changed)
         {
            value.setStation(null);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_TRAINS, value, null);
         }
      }
         
      return changed;   
   }

   public Station withTrains(Train... value)
   {
      for (Train item : value)
      {
         addToTrains(item);
      }
      return this;
   } 

   public Station withoutTrains(Train... value)
   {
      for (Train item : value)
      {
         removeFromTrains(item);
      }
      return this;
   }

   public void removeAllFromTrains()
   {
      LinkedHashSet<Train> tmpSet = new LinkedHashSet<Train>(this.getTrains());
   
      for (Train value : tmpSet)
      {
         this.removeFromTrains(value);
      }
   }

   public Train createTrains()
   {
      Train value = new Train();
      withTrains(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Station ----------------------------------- Station
    *              prev                   next
    * </pre>
    */
   
   public static final String PROPERTY_NEXT = "next";

   private Station next = null;

   public Station getNext()
   {
      return this.next;
   }
   public StationSet getNextTransitive()
   {
      StationSet result = new StationSet().with(this);
      return result.getNextTransitive();
   }


   public boolean setNext(Station value)
   {
      boolean changed = false;
      
      if (this.next != value)
      {
         Station oldValue = this.next;
         
         if (this.next != null)
         {
            this.next = null;
            oldValue.setPrev(null);
         }
         
         this.next = value;
         
         if (value != null)
         {
            value.withPrev(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NEXT, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Station withNext(Station value)
   {
      setNext(value);
      return this;
   } 

     /**
    * 
    * @see <a href='../../../../../../../../../src/test/java/org/sdmlib/test/examples/patternrewriteops/TrainStoryboards.java'>TrainStoryboards.java</a>
*/
   public Station createNext()
   {
      Station value = new Station();
      withNext(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Station ----------------------------------- Station
    *              next                   prev
    * </pre>
    */
   
   public static final String PROPERTY_PREV = "prev";

   private Station prev = null;

   public Station getPrev()
   {
      return this.prev;
   }
   public StationSet getPrevTransitive()
   {
      StationSet result = new StationSet().with(this);
      return result.getPrevTransitive();
   }


   public boolean setPrev(Station value)
   {
      boolean changed = false;
      
      if (this.prev != value)
      {
         Station oldValue = this.prev;
         
         if (this.prev != null)
         {
            this.prev = null;
            oldValue.setNext(null);
         }
         
         this.prev = value;
         
         if (value != null)
         {
            value.withNext(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PREV, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Station withPrev(Station value)
   {
      setPrev(value);
      return this;
   } 

   public Station createPrev()
   {
      Station value = new Station();
      withPrev(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Station ----------------------------------- Person
    *              station                   people
    * </pre>
    */
   
   public static final String PROPERTY_PEOPLE = "people";

   private PersonSet people = null;
   
   public PersonSet getPeople()
   {
      if (this.people == null)
      {
         return Person.EMPTY_SET;
      }
   
      return this.people;
   }

   public boolean addToPeople(Person value)
   {
      boolean changed = false;
      
      if (value != null)
      {
         if (this.people == null)
         {
            this.people = new PersonSet();
         }
         
         changed = this.people.add (value);
         
         if (changed)
         {
            value.withStation(this);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_PEOPLE, null, value);
         }
      }
         
      return changed;   
   }

   public boolean removeFromPeople(Person value)
   {
      boolean changed = false;
      
      if ((this.people != null) && (value != null))
      {
         changed = this.people.remove (value);
         
         if (changed)
         {
            value.setStation(null);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_PEOPLE, value, null);
         }
      }
         
      return changed;   
   }

   public Station withPeople(Person... value)
   {
      for (Person item : value)
      {
         addToPeople(item);
      }
      return this;
   } 

   public Station withoutPeople(Person... value)
   {
      for (Person item : value)
      {
         removeFromPeople(item);
      }
      return this;
   }

   public void removeAllFromPeople()
   {
      LinkedHashSet<Person> tmpSet = new LinkedHashSet<Person>(this.getPeople());
   
      for (Person value : tmpSet)
      {
         this.removeFromPeople(value);
      }
   }

     /**
    * 
    * @see <a href='../../../../../../../../../src/test/java/org/sdmlib/test/examples/patternrewriteops/TrainStoryboards.java'>TrainStoryboards.java</a>
*/
   public Person createPeople()
   {
      Person value = new Person();
      withPeople(value);
      return value;
   } 

   
   public static final StationSet EMPTY_SET = new StationSet();

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Station ----------------------------------- SignalFlag
    *              station                   flag
    * </pre>
    */
   
   public static final String PROPERTY_FLAG = "flag";

   private SignalFlag flag = null;

   public SignalFlag getFlag()
   {
      return this.flag;
   }

   public boolean setFlag(SignalFlag value)
   {
      boolean changed = false;
      
      if (this.flag != value)
      {
         SignalFlag oldValue = this.flag;
         
         if (this.flag != null)
         {
            this.flag = null;
            oldValue.withoutStation(this);
         }
         
         this.flag = value;
         
         if (value != null)
         {
            value.withStation(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_FLAG, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Station withFlag(SignalFlag value)
   {
      setFlag(value);
      return this;
   } 

     /**
    * 
    * @see <a href='../../../../../../../../../src/test/java/org/sdmlib/test/examples/patternrewriteops/TrainStoryboards.java'>TrainStoryboards.java</a>
*/
   public SignalFlag createFlag()
   {
      SignalFlag value = new SignalFlag();
      withFlag(value);
      return value;
   } 
}

