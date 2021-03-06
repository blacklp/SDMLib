package org.sdmlib.models.objects;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import de.uniks.networkparser.interfaces.BaseItem;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.interfaces.UpdateListener;
import de.uniks.networkparser.json.JsonArray;
import de.uniks.networkparser.json.JsonIdMap;
import de.uniks.networkparser.json.JsonObject;

public class Specific2Generic
{
   private class MyUpdateListener implements UpdateListener
   {
      public String firstPropName = null;
      
      public String secondPropName = null;

	@Override
	public boolean update(String typ, BaseItem jsonObject, Object target, String property,
			Object oldValue, Object newValue) {
		Object tmp = jsonObject.getValueItem(JsonIdMap.REMOVE);
         
         if (tmp != null && tmp instanceof JsonObject)
         {
            JsonObject remObj = (JsonObject) tmp;
            
            String propName = remObj.first();
            
            firstPropName = secondPropName;
            
            secondPropName = propName;
         }
         return false;
	}
   }

   public GenericGraph convert(JsonIdMap idMap, Object root)
   {
      GenericGraph graph = new GenericGraph();
      
      LinkedHashMap<String, GenericObject> genObjMap = new LinkedHashMap<String, GenericObject>();
      LinkedHashSet<String> knownLinks = new LinkedHashSet<String>();
      
      MyUpdateListener changeListener = new MyUpdateListener();
      idMap.withUpdateListenerSend(changeListener);
      
      // we go via a json array
      JsonArray jsonArray = idMap.toJsonArray(root);
      
      for (int i = 0; i < jsonArray.size(); i++)
      {
         JsonObject jsonObj = jsonArray.getJSONObject(i);
         
         String currentJsonId = jsonObj.getString(JsonIdMap.ID);
         GenericObject genObj = graph.createObjects()
               .withName(currentJsonId)
               .withType(jsonObj.getString(JsonIdMap.CLASS));
         
         genObjMap.put(genObj.getName(), genObj);
         
         JsonObject jsonProps = (JsonObject) jsonObj.get(JsonIdMap.JSON_PROPS);
         
         if (jsonProps != null)
         {
            for (Iterator<String> iter = jsonProps.keyIterator(); iter.hasNext();)
            {
               String attrName = iter.next();
               
               Object value = jsonProps.get(attrName);
               
               if (value instanceof JsonObject)
               {
                  // this is a reference to another object
                  addOneGenericLink(idMap, graph, genObjMap, changeListener,
                     currentJsonId, genObj, attrName, value, false);
               }
               else if (value instanceof JsonArray)
               {
                  // this is an array of links
                  JsonArray jsonRefs = (JsonArray) value;
                  
                  for (int j = 0; j < jsonRefs.size(); j++)
                  {
                     addOneGenericLink(idMap, graph, genObjMap, changeListener, currentJsonId, genObj, attrName, 
                           jsonRefs.get(j), true);
                  }
               }
               else 
               {
                  // store as attribute
                  genObj.createAttrs()
                  .withName(attrName)
                  .withValue("" + value); 
               }
            }
         }
      }
      
      return graph;
   }

   private void addOneGenericLink(JsonIdMap idMap, GenericGraph graph,
         LinkedHashMap<String, GenericObject> genObjMap,
         MyUpdateListener changeListener, String currentJsonId,
         GenericObject genObj, String attrName, Object value, boolean multi)
   {
      String tgtJsonId = ((JsonObject) value).getString(JsonIdMap.ID);

      GenericObject genTgtObj = genObjMap.get(tgtJsonId);

      if (genTgtObj != null)
      {
         // the other object has already been build, build the edge
         
         // need to know the name of the reverse reference trigger change and catch propertychange messages
         Object specObj = idMap.getObject(currentJsonId);

         SendableEntityCreator creatorClass = idMap.getCreatorClass(specObj);

         Object specTgtObject = idMap.getObject(tgtJsonId);

         if (multi)
         {
            creatorClass.setValue(specObj, attrName + JsonIdMap.REMOVE, specTgtObject, "");
            creatorClass.setValue(specObj, attrName, specTgtObject, "");
         }
         else
         {
            creatorClass.setValue(specObj, attrName, null, null);
            creatorClass.setValue(specObj, attrName, specTgtObject, null);
         }
         
         if (changeListener.firstPropName.compareTo(attrName) <= 0)
         {
            graph.createLinks()
            .withSrc(genObj).withSrcLabel(changeListener.firstPropName)
            .withTgt(genTgtObj).withTgtLabel(attrName);
         }
         else
         {
            graph.createLinks()
            .withTgt(genObj).withTgtLabel(changeListener.firstPropName)
            .withSrc(genTgtObj).withSrcLabel(attrName);
            
         }
         
         // repair object structure
         creatorClass.setValue(specObj, attrName, specTgtObject, null);
      }
   }
}
