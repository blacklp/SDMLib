package org.sdmlib.examples.helloworld.creators;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.examples.helloworld.Graph;
import org.sdmlib.models.pattern.PatternLink;
import org.sdmlib.examples.helloworld.creators.NodePO;
import org.sdmlib.models.pattern.LinkConstraint;
import org.sdmlib.examples.helloworld.creators.GraphPO;
import org.sdmlib.examples.helloworld.Node;
import org.sdmlib.examples.helloworld.creators.NodeSet;
import org.sdmlib.examples.helloworld.creators.EdgePO;
import org.sdmlib.examples.helloworld.Edge;
import org.sdmlib.examples.helloworld.creators.EdgeSet;
import org.sdmlib.examples.helloworld.creators.GraphSet;
import org.sdmlib.examples.helloworld.creators.GraphComponentPO;
import org.sdmlib.examples.helloworld.GraphComponent;
import org.sdmlib.examples.helloworld.creators.GraphComponentSet;

public class GraphPO extends PatternObject<GraphPO, Graph>
{
   public NodePO hasNodes()
   {
      NodePO result = new NodePO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Graph.PROPERTY_NODES, result);
      
      return result;   }
   
   public GraphPO hasNodes(NodePO tgt)
   {
      LinkConstraint patternLink = (LinkConstraint) new LinkConstraint()
      .withTgt(tgt).withTgtRoleName(Graph.PROPERTY_NODES)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier());
      
      this.getPattern().addToElements(patternLink);
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public NodeSet getNodes()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Graph) this.getCurrentMatch()).getNodes();
      }
      return null;
   }
   
   public EdgePO hasEdges()
   {
      EdgePO result = new EdgePO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Graph.PROPERTY_EDGES, result);
      
      return result;   }
   
   public GraphPO hasEdges(EdgePO tgt)
   {
      LinkConstraint patternLink = (LinkConstraint) new LinkConstraint()
      .withTgt(tgt).withTgtRoleName(Graph.PROPERTY_EDGES)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier());
      
      this.getPattern().addToElements(patternLink);
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public EdgeSet getEdges()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Graph) this.getCurrentMatch()).getEdges();
      }
      return null;
   }
   
   public GraphComponentPO hasGcs()
   {
      GraphComponentPO result = new GraphComponentPO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Graph.PROPERTY_GCS, result);
      
      return result;
   }
   
   public NodePO hasGcsNode()
   {
      NodePO result = new NodePO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Graph.PROPERTY_GCS, result);
      
      return result;
   }
   
   public EdgePO hasGcsEdge()
   {
      EdgePO result = new EdgePO();
      result.setModifier(this.getPattern().getModifier());
      
      super.hasLink(Graph.PROPERTY_GCS, result);
      
      return result;
   }
   
   public GraphPO hasGcs(GraphComponentPO tgt)
   {
      LinkConstraint patternLink = (LinkConstraint) new LinkConstraint()
      .withTgt(tgt).withTgtRoleName(Graph.PROPERTY_GCS)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier());
      
      this.getPattern().addToElements(patternLink);
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GraphComponentSet getGcs()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Graph) this.getCurrentMatch()).getGcs();
      }
      return null;
   }
   
}

