/*
   Copyright (c) 2012 Albert Zündorf

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

package org.sdmlib.models.classes;

import java.util.LinkedHashSet;
import java.util.Set;

import org.sdmlib.StrUtil;
import org.sdmlib.doc.GraphViz.JsonToGraphViz;
import org.sdmlib.models.classes.logic.GenClassModel;
import org.sdmlib.models.classes.util.ClazzSet;

public class ClassModel extends SDMLibClass
{
   public static final String PROPERTY_CLASSES = "classes";
   public static final String PROPERTY_PACKAGENAME = "packageName";
   private Set<Feature> features=Feature.getAll();
   private ClazzSet classes;
   private String packageName;
   private GenClassModel generator;

   public ClassModel(){
      
   }
   public ClassModel(String packageName){
      withPackageName(packageName);
   }
   
	public ClassModel generate()
	{
		return generate("src");
	}

	public ClassModel generate(String rootDir)
	{
	  
	   getGenerator().generate(rootDir);
	   return this;
	}
	public GenClassModel getGenerator(){
	   if(generator==null){
         this.setGenerator(new GenClassModel());
      }
	   return generator;
	}
	
   public void setGenerator(GenClassModel value)
   {
      if (this.generator != value)
      {
         GenClassModel oldValue = this.generator;
         if (this.generator != null)
         {
            this.generator = null;
            oldValue.setModel(null);
         }
         this.generator = value;
         if (value != null)
         {
            value.setModel(this);
         }
      }
   }
	
	public ClazzSet getClasses()
	{
		if (classes == null)
		{
			return new ClazzSet();
		}
		return this.classes;
	}
	
	public Clazz getClazz(String name)
	{
	   for (Clazz c : getClasses())
      {
         if (c.getName().endsWith(name))
         {
            return c;
         }
      }
	   return null;
	}

	public Clazz createClazz(String name)
	{
		Clazz clazz = new Clazz(name);
		clazz.withClassModel(this);
		return clazz;
	}

	public void addToClasses(Clazz value)
	{
		if (this.classes == null)
		{
			this.classes = new ClazzSet();
		}

		this.classes.add(value);
	}

	public boolean removeFromClasses(Clazz value)
	{
		boolean changed = false;

		if ((this.classes != null) && (value != null))
		{
			changed = this.classes.remove(value);

			if (changed)
			{
				value.withClassModel(null);
				getPropertyChangeSupport().firePropertyChange(PROPERTY_CLASSES, value, null);
			}
		}

		return changed;
	}

	public void removeAllFromClasses()
	{
		LinkedHashSet<Clazz> tmpSet = new LinkedHashSet<Clazz>(this.getClasses());

		for (Clazz value : tmpSet)
		{
			this.removeFromClasses(value);
		}
	}

	 public String dumpClassDiagram(String diagName)
	{
		JsonToGraphViz graphViz = new JsonToGraphViz();
		
		return graphViz.dumpClassDiagram(diagName, this);
	}

	// ==========================================================================

	public void removeYou()
	{
		removeAllFromClasses();
		getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
	}

	public void removeAllGeneratedCode()
   {
	   getGenerator().removeAllGeneratedCode("src", "src", "src");
   }
	
	public void removeAllGeneratedCode(String rootDir)
   {
	   getGenerator().removeAllGeneratedCode(rootDir, rootDir, rootDir);
   }

	//==========================================================================
	public String getPackageName()
	{
		return this.packageName;
	}

	public void setPackageName(String value)
	{
		if ( ! StrUtil.stringEquals(this.packageName, value))
		{
			String oldValue = this.packageName;
			this.packageName = value;
			getPropertyChangeSupport().firePropertyChange(PROPERTY_PACKAGENAME, oldValue, value);
		}
	}

	public ClassModel withPackageName(String value)
	{
		setPackageName(value);
		return this;
	} 

	@Override
   public String toString()
	{
		StringBuilder _ = new StringBuilder();

		_.append(" ").append(this.getPackageName());
		return _.substring(1);
	}
   public ClassModel withClasses(Clazz... value)
   {
      for (Clazz item : value)
      {
         addToClasses(item);
      }
      return this;
   } 

   public ClassModel withoutClasses(Clazz... value)
   {
      for (Clazz item : value)
      {
         removeFromClasses(item);
      }
      return this;
   }

   public Set<Feature> getFeatures()
   {
      return features;
   }

   public ClassModel withFeature(Feature value)
   {
      this.features.add(value);
      return this;
   }
   public ClassModel withFeatures(Set<Feature> value)
   {
      this.features = value;
      return this;
   }

   public boolean hasFeature(Feature value)
   {
      return features.contains(value);
   }
}
