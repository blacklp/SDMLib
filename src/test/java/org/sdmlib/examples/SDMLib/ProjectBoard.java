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

package org.sdmlib.examples.SDMLib;

import org.junit.Test;
import org.sdmlib.models.classes.Association;
import org.sdmlib.models.classes.Card;
import org.sdmlib.models.classes.ClassModel;
import org.sdmlib.models.classes.Clazz;
import org.sdmlib.models.classes.DataType;
import org.sdmlib.models.classes.Role;
import org.sdmlib.storyboards.Kanban;
import org.sdmlib.storyboards.KanbanEntry;
import org.sdmlib.storyboards.Storyboard;
import org.sdmlib.storyboards.StoryboardWall;

public class ProjectBoard
{
   @Test
   public void testProjectManagement()
   {
      Storyboard story = new Storyboard();

      story = new Storyboard("examples", "MiniTutorials");
      story.setSprint("ToDo");
      story.addLogEntry(BACKLOG, "zuendorf", "06.03.2014 14:13:42", 0, 12, "high priority");
      story.dumpHTML();
      
      story = new Storyboard("examples", "FeatureList");
      story.setSprint("ToDo");
      story.addLogEntry(BACKLOG, "zuendorf", "06.03.2014 14:25:42", 0, 6, "medium priority");
      story.dumpHTML();
      
      story = new Storyboard("examples", "POJO Code enhancer");
      story.setSprint("ToDo");
      story.addLogEntry(BACKLOG, "zuendorf", "06.03.2014 22:25:42", 0, 6, "high priority");
      story.dumpHTML();
   }
   
   
   @Test
   public void testFeatures()
   {
      Storyboard story = new Storyboard();

      story = new Storyboard("examples", "GenerateTransitiveClosureGetter");
      story.setSprint("Features");
      story.add("This feature has been tested within <a href='StudyRight%20with%20assignments%20class%20generation.html'>StudyRight with assignments class generation</a> ");
      story.addLogEntry(BACKLOG, "zuendorf", "06.03.2014 14:05:42", 0, 4, "high priority");
      story.addLogEntry(Kanban.DONE, "zuendorf", "11.03.2014 12:55:42", 4, 0, "works like a charm");
      story.addLogEntry(Kanban.DONE, "zuendorf", "11.03.2014 18:12:42", 2, 0, "well some legacy problems had to be fixed");
      story.dumpHTML();
      
   }

   
   @Test
   public void testExtendStoryboardByAddToDoMethod()
   {
      Storyboard storyboard = new Storyboard();
      
      storyboard.add("Start situation: ",
         DONE, "zuendorf", "01.11.2012 12:33:42", 1, 0);
      
      storyboard.dumpHTML();
   }

   public static final String MODELING = "modeling";
   public static final String ACTIVE = "active";
   public static final String DONE = "done";
   public static final String IMPLEMENTATION = "implementation";
   public static final String BACKLOG = "backlog";

   @Test
   public void testTodoEntries()
   {
      Storyboard story = new Storyboard();
      
      story.add("Internal things.");
      
      story.add("It should be possible to add todo entries to the kanban board without adding a storyboard for them. "
         , DONE, "zuendorf", "08.10.2013 13:30:42", 1, 0);
      
      story.addToDo("ExtendStoryboardByAddToDoMethod", DONE, "zuendorf", "21.08.2012 17:53:42", 2, 0)
      .linkToTest("examples", this.getClass().getName());
      
      story.dumpHTML();
      
   }
   
   
   @Test
   public void testStoryboardInfrastructure()
   {
      // file:///C:/Users/zuendorf/eclipseworkspaces/indigo/SDMLib/doc/StoryboardInfrastructure.html
      Storyboard storyboard = new Storyboard();
      
      storyboard.setProjectName("SDMLibProject");
      
      storyboard.setSprint("Sprint.001.Booting");
      
      storyboard.add("This storyboard tests the storyboard infrastructure. ");
      storyboard.addStep("At first creating the html file just with text should work. ");
      storyboard.addStep("Next we need to create some class model. This will be done in a parallel activity.");
      storyboard.addStep("With the class model we create an object model and try to dump it here.");
      storyboard.addStep("Well, dumping the class model would be great, either.");

      storyboard.add("need to restructure design: logentries shall be direct kids of kanbanentries. \n" +
            "(has been below phase entries before.)\n" +
            "phase entries will be used for planning, in future");
      
      ClassModel model = new ClassModel("org.sdmlib.storyboards"); 
      
      Clazz kanbanEntryClass = model.createClazz("org.sdmlib.storyboards.KanbanEntry")
         .withAttribute("oldNoOfLogEntries", DataType.INT)
         .withAttribute("phases", DataType.STRING);

      Clazz logEntryClass = model.createClazz("org.sdmlib.storyboards.LogEntryStoryBoard");
      
      new Association()
      .withSource(new Role(kanbanEntryClass, "kanbanEntry", Card.ONE).withKind(Role.AGGREGATION))
      .withTarget(logEntryClass, "logEntries", Card.MANY);
      
      // Clazz phaseEntryClass = kanbanEntryClass.createClassAndAssoc(PhaseEntry.class.getName(), "phaseEntries", R.MANY, "kanbanEntry", R.ONE);
      
      Clazz storyboardWallClass = model.createClazz("StoryboardWall");
      
      Clazz storyboardClass = model.createClazz(Storyboard.class.getName())
            .withAttribute("rootDir", DataType.STRING)
            .withAttribute("stepCounter", DataType.INT) 
            .withAttribute("stepDoneCounter", DataType.INT);
      
      storyboardWallClass.withAssoc(storyboardClass, "storyboard", Card.ONE, "wall", Card.ONE);
      
      Clazz storyboardStepClass = model.createClazz("StoryboardStep")
         .withAssoc(storyboardClass, "storyboard", Card.ONE, "storyboardSteps", Card.MANY)
         .withAttribute("text", DataType.STRING);
      
      storyboard.addClassDiagram(model);
      
      model.generate("src/main/java");

      storyboard.add(" Editing the log entries works now fine as part of the add method. " , 
            DONE, "zuendorf", "07.05.2012 23:36:42", 0, 0);
      
      storyboard.add("Seems that we have solved the problem with the sorting of log entries after loading. " , 
         DONE, "zuendorf", "19.05.2012 19:22:42", 1, 0);
      
      storyboard.addStep("Show some internals");
      
      storyboard.add("Internally, the class model looks like:");
      
      storyboard.addClassDiagram(model, "src");
      
      storyboard.addLogEntry(Kanban.DONE, "zuendorf", "24.02.2014 18:38:00", 1, 0, "resolved old style admin to new storyboard features.");
      storyboard.addLogEntry(Kanban.DONE, "stefan, zuendorf", "28.02.2014 18:31:42", 23, 0, "switched to open source charts.");
   
      storyboard.dumpHTML();
   }
   
   @Test
   public void testStoryboardInfrastructureInternals()
   {
      Storyboard storyboard = new Storyboard();
      
      storyboard.add("Internals.");
      
      storyboard.add("Object diagram for storyboard and KanbanEntry:" , 
         DONE, "zuendorf", "08.10.2013 13:22:42", 1, 0);
      
      StoryboardWall storyboardWall = new StoryboardWall().withStoryboard(storyboard);
      
      KanbanEntry parent = new KanbanEntry();
      
      KanbanEntry kanbanEntry = new KanbanEntry()
      .withHoursRemaining(1)
      .withHoursSpend(2)
      .withLastDeveloper("zuendorf")
      .withName("name")
      .withPhase(DONE)
      .withParent(parent);
      
//FIXME ALBERT      LinkedHashMap<String, LogEntry> newLogEntries = storyboard.getNewLogEntries();
//      for (LogEntry entry : newLogEntries.values())
//      {
//         kanbanEntry.addToLogEntries(entry);
//      }
      
      
      
      storyboard.addObjectDiagram(storyboardWall, kanbanEntry);
      
      
      storyboard.dumpHTML();
   }
}



