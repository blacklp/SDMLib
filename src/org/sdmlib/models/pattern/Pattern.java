/*
   Copyright (c) 2012 zuendorf 
   
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
   
package org.sdmlib.models.pattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.sdmlib.codegen.CGUtil;
import org.sdmlib.models.objects.GenericObject;
import org.sdmlib.models.pattern.creators.PatternElementSet;
import org.sdmlib.scenarios.JsonToImg;
import org.sdmlib.serialization.IdMap;
import org.sdmlib.serialization.interfaces.SendableEntityCreator;
import org.sdmlib.serialization.json.JsonArray;
import org.sdmlib.serialization.json.JsonFilter;
import org.sdmlib.serialization.json.JsonIdMap;
import org.sdmlib.utils.PropertyChangeInterface;
import java.beans.PropertyChangeSupport;
import org.sdmlib.models.pattern.Pattern;

public class Pattern extends PatternElement<Pattern> implements PropertyChangeInterface
{
   public static final String CREATE = "create";
   public static final String BOUND = "bound";

   
   private JsonIdMap jsonIdMap;
   
   public JsonIdMap getJsonIdMap()
   {
      return jsonIdMap;
   }

   public void setJsonIdMap(JsonIdMap jsonIdMap)
   {
      this.jsonIdMap = jsonIdMap;
   }
   
   //==========================================================================
   
   public Pattern(JsonIdMap createIdMap)
   {
      jsonIdMap = createIdMap;
      setHasMatch(true);
   }
   
   public Pattern()
   {
   }

   public Pattern startCreate()
   {
      this.setModifier(Pattern.CREATE);
      return this;
   }
   
   public Pattern matchIsomorphic()
   {
      MatchIsomorphicConstraint isoConstraint = new MatchIsomorphicConstraint();
      
      this.addToElements(isoConstraint);
      
      this.findMatch();
      
      return this;
   }
   
   //==========================================================================
   public int allMatches()
   {
      this.setDoAllMatches(true);
      
      int result = 0;
      
      while (getHasMatch())
      {
         result++;
         findMatch();
      }
      
      return result;
   }
   
   public boolean findMatch()
   {
      boolean done = false; 
      
      // start with the last element and go backward until a new choice is made, then go forward to propagate the new choice
      int i = this.getElements().size() - 1;
      
      if (restartSearchAtIndex0)
      {
         restartSearchAtIndex0 = false;
         
         i = 0;
      }
      
      PatternElement currentPE = null;
      while (i >= 0 && i < this.getElements().size())
      {
         currentPE = this.getElements().get(i);
         
         boolean hasNextMatch = currentPE.findNextMatch();
         
         if (hasNextMatch)
         {
            i++;
         }
         else
         {
            i--;
         }
      }
      
      setHasMatch( i >= this.getElements().size());
      
      return getHasMatch();
   }
   
   public boolean findNextMatch()
   {
      return findMatch();
   } 

   private boolean restartSearchAtIndex0 = false;

   public void resetSearch()
   {
      restartSearchAtIndex0 = true;
      
      for (PatternElement pe : this.getElements())
      {
         pe.resetSearch();
      }
   }

   public Object get(String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (PROPERTY_ELEMENTS.equalsIgnoreCase(attrName))
      {
         return getElements();
      }

      if (PROPERTY_HASMATCH.equalsIgnoreCase(attrName))
      {
         return getHasMatch();
      }

      if (PROPERTY_MODIFIER.equalsIgnoreCase(attribute))
      {
         return getModifier();
      }

      if (PROPERTY_DOALLMATCHES.equalsIgnoreCase(attribute))
      {
         return getDoAllMatches();
      }

      if (PROPERTY_PATTERNOBJECTNAME.equalsIgnoreCase(attribute))
      {
         return getPatternObjectName();
      }

      if (PROPERTY_CURRENTSUBPATTERN.equalsIgnoreCase(attribute))
      {
         return getCurrentSubPattern();
      }
      
      return null;
   }

   
   //==========================================================================
   
   public boolean set(String attrName, Object value)
   {
      if (PROPERTY_ELEMENTS.equalsIgnoreCase(attrName))
      {
         addToElements((PatternElement) value);
         return true;
      }
      
      if ((PROPERTY_ELEMENTS + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         removeFromElements((PatternElement) value);
         return true;
      }

      if (PROPERTY_HASMATCH.equalsIgnoreCase(attrName))
      {
         setHasMatch((Boolean) value);
         return true;
      }

      if (PROPERTY_MODIFIER.equalsIgnoreCase(attrName))
      {
         setModifier((String) value);
         return true;
      }

      if (PROPERTY_DOALLMATCHES.equalsIgnoreCase(attrName))
      {
         setDoAllMatches((Boolean) value);
         return true;
      }

      if (PROPERTY_PATTERNOBJECTNAME.equalsIgnoreCase(attrName))
      {
         setPatternObjectName((String) value);
         return true;
      }

      if (PROPERTY_CURRENTSUBPATTERN.equalsIgnoreCase(attrName))
      {
         setCurrentSubPattern((Pattern) value);
         return true;
      }

      return false;
   }

   
  //==========================================================================
   
   public void removeYou()
   {
      removeAllFromElements();
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Pattern ----------------------------------- PatternElement
    *              pattern                   elements
    * </pre>
    */
   
   public static final String PROPERTY_ELEMENTS = "elements";
   
   private PatternElementSet elements = null;
   private int objNo;
   
   public PatternElementSet getElements()
   {
      if (this.elements == null)
      {
         return PatternElement.EMPTY_SET;
      }
   
      return this.elements;
   }
   
   public boolean addToElements(PatternElement value)
   {
      boolean changed = false;
      
      if (currentSubPattern != null)
      {
         // add element to nac
         changed = currentSubPattern.addToElements(value);
      }
      else
      {
         if (value != null)
         {
            if (this.elements == null)
            {
               this.elements = new PatternElementSet();
            }

            if ( ! this.elements.contains(value))
            {
               changed = this.elements.add (value);

               value.withPattern(this);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_ELEMENTS, null, value);
            }

            if (value instanceof Pattern)
            {
               this.setCurrentSubPattern((Pattern) value);
               ((Pattern) value).setJsonIdMap(jsonIdMap);
            }
         }
      }
         
      return changed;   
   }
   
   public boolean removeFromElements(PatternElement value)
   {
      boolean changed = false;
      
      if ((this.elements != null) && (value != null))
      {
         changed = this.elements.remove (value);
         
         if (changed)
         {
            value.setPattern(null);
            getPropertyChangeSupport().firePropertyChange(PROPERTY_ELEMENTS, value, null);
         }
      }
         
      return changed;   
   }
   
   public Pattern withElements(PatternElement value)
   {
      addToElements(value);
      return this;
   } 
   
   public Pattern withoutElements(PatternElement value)
   {
      removeFromElements(value);
      return this;
   } 
   
   public void removeAllFromElements()
   {
      LinkedHashSet<PatternElement> tmpSet = new LinkedHashSet<PatternElement>(this.getElements());
   
      for (PatternElement value : tmpSet)
      {
         this.removeFromElements(value);
      }
   }

   public String getPOClassName(String modelClassName)
   {
      int pos = modelClassName.lastIndexOf('.');
      return modelClassName.substring(0, pos+1) + "creators." + modelClassName.substring(pos+1, modelClassName.length()) + "PO";
   }

   public PatternObject bind(Object hostGraphObject)
   {
      SendableEntityCreator creatorClass = jsonIdMap.getCreatorClasses(getPOClassName(hostGraphObject.getClass().getName()));
      
      PatternObject po = (PatternObject) creatorClass.getSendableInstance(false);
      
      this.addToElements(po);
      
      po.setCurrentMatch(hostGraphObject);
      
      return po;
   }

   public String dumpDiagram(String diagramName)
   {
      return dumpDiagram(diagramName, true);
   }
   
   public String dumpDiagram(String diagramName, boolean showMatch)
   {
      objNo = 0;
      
      LinkedHashSet<Object> matchedObjects = new LinkedHashSet<Object>();
      
      String imgLink = "<embed type=\"image/svg+xml\"src='<imagename>'>\n"
            .replaceFirst("<imagename>", diagramName + ".svg");
      
      // generate dot file
      String fileText = "graph ObjectDiagram {\n" +
            "   node [shape = none, fontsize = 10];\n" +
            "   edge [fontsize = 10];\n\n" +
            "<nodes>\n" +
            "<edges>" +
            "}\n";
        
      // nodes
      StringBuilder nodeBuilder = new StringBuilder();
      StringBuilder edgeBuilder = new StringBuilder();
      
      dumpPatternObjects(nodeBuilder, edgeBuilder, showMatch, matchedObjects);
      
      if (getDoAllMatches())
      {
         String allMatchesLine = "allMatches;\n";
         nodeBuilder.append(allMatchesLine);
      }
      
      
      // edges
      for (PatternElement patElem : this.getElementsTransitive(null))
      {
         if (patElem instanceof PatternLink)
         {
            PatternLink patLink = (PatternLink) patElem;
            
            String color = "black";
            
            if (Pattern.CREATE.equals(patLink.getModifier()))
            {
               color = "green";
            }
            
            StringBuilder oneEdgeLine = new StringBuilder(
               "<srcId> -- <tgtId> [headlabel = \"headText\" taillabel = \"tailText\" color=\"black\" fontcolor=\"black\"];\n"
                  );
            
            String tgtRoleName = patLink.getTgtRoleName();
            if (tgtRoleName == null)
            {
               tgtRoleName = "";
            }
            
            String srcRoleName = patLink.getSrcRoleName();
            if (srcRoleName == null)
            {
               srcRoleName = "";
            }
            
            CGUtil.replaceAll(oneEdgeLine, 
               "<srcId>", nameForPatElem(patLink.getSrc()),
               "<tgtId>", nameForPatElem(patLink.getTgt()),
               "headText", tgtRoleName,
               "tailText", srcRoleName,
               "black", color
               );
            
            edgeBuilder.append(oneEdgeLine.toString());
         }
      }
      
      // hostgraph
      if ( showMatch && ! matchedObjects.isEmpty())
      {
         JsonArray jsonArray = jsonIdMap.toJsonArray(matchedObjects.iterator().next()); 
      
         JsonToImg.fillNodeAndEdgeBuilders(jsonArray, nodeBuilder, edgeBuilder);
      }
      
      fileText = fileText.replaceFirst("<nodes>", nodeBuilder.toString());
      
      fileText = fileText.replaceFirst("<edges>", edgeBuilder.toString());
      
      dumpDiagram(diagramName, fileText);
      
      return imgLink;
   }

   public PatternElementSet getElementsTransitive(PatternElementSet result)
   {
      if (result == null)
      {
         result = new PatternElementSet();
      }
      
      for (PatternElement patternElement : this.getElements())
      {
         boolean isNewElem = result.add(patternElement);
         
         if (isNewElem && patternElement instanceof Pattern)
         {
            result = ((Pattern)patternElement).getElementsTransitive(result);
         }
      }
      
      return result;
   }

   public void dumpPatternObjects(StringBuilder nodeBuilder,
         StringBuilder edgeBuilder, boolean showMatch,
         LinkedHashSet<Object> matchedObjects)
   {
      for (PatternElement patElem : this.getElements())
      {
         if (patElem instanceof PatternObject)
         {
            PatternObject patObject = (PatternObject) patElem;
            
            StringBuilder nodeLine = new StringBuilder 
                  ("<id> [label=<<table border='0' cellborder='1' cellspacing='0' color='black' bgcolor='aliceblue'> " +
                  		"<modifier> <tr> <td align='center'> <font color='black'> <id> :<classname> </font></td></tr> " +
                  		"<tr> <td align='left'> <table border='0' cellborder='0' cellspacing='0' color='black'> <tr> <td>  </td></tr></table></td></tr></table>>];\n");
            
            String id = nameForPatElem(patObject);
            
            String color = "black";
            String modifier = "";
            
            if (Pattern.CREATE.equals(patObject.getModifier()))
            {
               color = "green";
               modifier = "<tr> <td border='0' align='right'><font color='green'>&laquo;create&raquo;</font></td></tr>";
            }
            else if (Pattern.BOUND.equals(patObject.getModifier()))
            {
               modifier = "<tr> <td border='0' align='right'><font color='black'>&laquo;bound&raquo;</font></td></tr>";
            }
            
            CGUtil.replaceAll(nodeLine, 
               "<id>", id, 
               "<classname>", CGUtil.shortClassName(patElem.getClass().getName()), 
               "black", color,
               "<modifier>", modifier
                  );
            
            if ( ! patObject.getAttrConstraints().isEmpty())
            {
               StringBuilder allAttrLines = new StringBuilder();

               // add attribute constraints
               for (AttributeConstraint attrConstr : patObject.getAttrConstraints())
               {
                  StringBuilder oneAttrLine = new StringBuilder(
                     "<tr><td><font color='black'> attrName Op value </font></td></tr>"
                        );
                  
                  String op = "==";
                  color = "black";
                  
                  if (Pattern.CREATE.equals(attrConstr.getModifier()))
                  {
                     op = ":=";
                     color = "green";
                  }
                  
                  CGUtil.replaceAll(oneAttrLine, 
                     "attrName", attrConstr.getAttrName(),
                     "black", color, 
                     "Op", op,
                     "value", "" + attrConstr.getTgtValue()
                        );
                  
                  allAttrLines.append(oneAttrLine.toString());
               }
               
               CGUtil.replaceAll(nodeLine, "<tr> <td>  </td></tr>", allAttrLines.toString());
            }
            
            nodeBuilder.append(nodeLine.toString());

            if (patObject.getDoAllMatches())
            {
               // add an "allMatches" node and a link to the current patObject
               StringBuilder allMatchesBuilder = new StringBuilder(
                  "allMatches_patElemId [label=allMatches];\n"
                  );
               
               CGUtil.replaceAll(allMatchesBuilder, 
                  "patElemId", id);
               
               nodeBuilder.append(allMatchesBuilder.toString());
               
               edgeBuilder.append("" + id + " -- allMatches_" + id + " [style=\"dotted\"];\n");
            }
            
            if (showMatch)
            {
               if (patObject.getCurrentMatch() != null)
               {
                  matchedObjects.add(patObject.getCurrentMatch());
                  StringBuilder matchEdge = new StringBuilder(
                        "<srcId> -- <tgtId> [headlabel = \\\"match\\\" style=\"dotted\" color=\"black\" fontcolor=\"black\"];\n");
                  
                  CGUtil.replaceAll(matchEdge, 
                     "<srcId>", id, 
                     "<tgtId>", nameForPatElem(patObject.getCurrentMatch()), 
                     "black", color);
                  
                  edgeBuilder.append(matchEdge.toString());
               }
               
               if (patObject.getCandidates() != null)
               {
                  if (patObject.getCandidates() instanceof Collection)
                  {
                     for (Object candidate : (Collection) patObject.getCandidates())
                     {
                        matchedObjects.add(candidate);
                        StringBuilder matchEdge = new StringBuilder(
                              "<srcId> -- <tgtId> [headlabel = \\\"candidate\\\" style=\"dotted\" color=\"black\" fontcolor=\"black\"];\n");
                        
                        CGUtil.replaceAll(matchEdge, 
                           "<srcId>", id, 
                           "<tgtId>", nameForPatElem(candidate), 
                           "black", color);
                        
                        edgeBuilder.append(matchEdge.toString());
                     }
                  }
                  else // single candidate
                  {
                     matchedObjects.add(patObject.getCandidates());
                     StringBuilder matchEdge = new StringBuilder(
                           "<srcId> -- <tgtId> [headlabel = \\\"candidate\\\" style=\"dotted\" color=\"black\" fontcolor=\"black\"];\n");
                     
                     CGUtil.replaceAll(matchEdge, 
                        "<srcId>", id, 
                        "<tgtId>", nameForPatElem(patObject.getCandidates()), 
                        "black", color);
                     
                     edgeBuilder.append(matchEdge.toString());
                  }
               }
            }
            
         }
         else if (patElem instanceof MatchIsomorphicConstraint)
         {
            nodeBuilder.append("matchIsomorphic;\n");
         }
         else if (patElem instanceof DestroyObjectElem)
         {
            DestroyObjectElem destroyElem = (DestroyObjectElem) patElem;
            
            StringBuilder destroyBuilder = new StringBuilder(
               "id [label=\"destroy\" fontcolor=\"red\"]\n");
            
            CGUtil.replaceAll(destroyBuilder, 
               "id", nameForPatElem(destroyElem));
            
            nodeBuilder.append(destroyBuilder.toString());
            
            StringBuilder destroyEdgeBuilder = new StringBuilder(
                  "<srcId> -- <tgtId> [style=\"dotted\" color=\"red\" fontcolor=\"red\"];\n");
            
            CGUtil.replaceAll(destroyEdgeBuilder, 
               "<srcId>", nameForPatElem(destroyElem.getPatternObject()), 
               "<tgtId>", nameForPatElem(destroyElem));
            
            edgeBuilder.append(destroyEdgeBuilder.toString());
         }
         else if (patElem instanceof NegativeApplicationCondition)
         {
            NegativeApplicationCondition nac = (NegativeApplicationCondition) patElem;
            
            // create nested NAC subgraph
            StringBuilder nacBuilder = new StringBuilder(
               "subgraph cluster_nacId \n" + 
               "{\n" + 
               "   label=<<table border='0' cellborder='0'><tr><td><img src='forbiddensign.svg'/></td><td>NAC nacId</td></tr></table>>;\n" + 
               "   color=grey;\n" +
               "\n");
            
            CGUtil.replaceAll(nacBuilder, 
               "nacId", nameForPatElem(nac));
            
            nodeBuilder.append(nacBuilder.toString());
            
            // dump contained pattern objects
            nac.dumpPatternObjects(nodeBuilder, edgeBuilder, showMatch, matchedObjects);
            
            nodeBuilder.append("}\n\n");
         }
         else if (patElem instanceof OptionalSubPattern)
         {
            OptionalSubPattern optSubPattern = (OptionalSubPattern) patElem;
            
            // create nested subgraph
            StringBuilder optSubBuilder = new StringBuilder(
               "subgraph cluster_nacId \n" + 
               "{\n" + 
               "   label=<<table border='0' cellborder='0'><tr><td>optional nacId</td></tr></table>>;\n" + 
               "   color=grey;\n" +
               "\n");
            
            CGUtil.replaceAll(optSubBuilder, 
               "nacId", nameForPatElem(optSubPattern));
            
            nodeBuilder.append(optSubBuilder.toString());
            
            // dump contained pattern objects
            optSubPattern.dumpPatternObjects(nodeBuilder, edgeBuilder, showMatch, matchedObjects);
            
            nodeBuilder.append("}\n\n");
         }
      }
   }

   private String nameForPatElem(Object patElem)
   {
      if (patElem instanceof PatternObject)
      {
         PatternObject patObj = (PatternObject) patElem;
         
         if (patObj.getPatternObjectName() != null)
         {
            return patObj.getPatternObjectName();
         }
      }
      return jsonIdMap.getId(patElem).split("\\.")[1].toLowerCase();
   }

   private void dumpDiagram(String diagramName, String fileText)
   {
      File docDir = new File("doc");
      
      docDir.mkdir();
      
      String command = "";
      
      if ((System.getProperty("os.name").toLowerCase()).contains("mac")) 
      {
         command = "../SDMLib/tools/Graphviz/osx_lion/makeimage.command " + diagramName;
      } 
      else 
      {
         command = "../SDMLib/tools/makeimage.bat " + diagramName;
      }
      
      try {
         writeToFile(diagramName + ".dot", fileText);
         
         Process child = Runtime.getRuntime().exec(command);
         
         Thread.sleep(500);
         
         // int result = child.waitFor();
         
         // System.out.println("Graphviz for " + diagramName + " returns " + result);
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      }
   }
   
   private void writeToFile(String imgName, String fileText)
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter("doc/" + imgName));

         out.write(fileText);
         out.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }

   
   //==========================================================================
   
   public static final String PROPERTY_CURRENTSUBPATTERN = "currentSubPattern";
      
   private Pattern currentSubPattern;

   public Pattern getCurrentSubPattern()
   {
      return this.currentSubPattern;
   }
   
   public void setCurrentSubPattern(Pattern value)
   {
      if (this.currentSubPattern != value)
      {
         Pattern oldValue = this.currentSubPattern;
         this.currentSubPattern = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_CURRENTSUBPATTERN, oldValue, value);
      }
   }
   
   public Pattern withCurrentSubPattern(Pattern value)
   {
      setCurrentSubPattern(value);
      return this;
   } 
}
