package org.sdmlib.models.classes.logic;

import java.util.ArrayList;
import java.util.Set;

import org.sdmlib.codegen.Parser;
import org.sdmlib.codegen.SymTabEntry;
import org.sdmlib.models.classes.Annotation;
import org.sdmlib.models.classes.Attribute;
import org.sdmlib.models.classes.Clazz;
import org.sdmlib.models.classes.Method;

public class GenAnnotation extends Generator<Annotation>
{
   public GenAnnotation generate(String rootDir, String helperDir)
   {
      if (model.getOwner() instanceof Clazz)
         return generate((Clazz)model.getOwner(), rootDir, helperDir);
      if (model.getOwner() instanceof Method)
         return generate((Method)model.getOwner(), rootDir, helperDir);
      if (model.getOwner() instanceof Attribute)
         return generate((Attribute)model.getOwner(), rootDir, helperDir);
      return this;
   }

   private GenAnnotation generate(Attribute attribute, String rootDir, String helperDir)
   {
      Parser parser = getGenerator(attribute.getClazz()).getOrCreateParser(rootDir);
      parser.parse();

      // ArrayList<SymTabEntry> tabEntries =
      // parser.getSymTabEntriesFor(attribute.getName());
      return generate(parser, getStartPos(parser));
   }

   private int getStartPos(Parser parser)
   {
      return parser.indexOf(Parser.ATTRIBUTE + ":" + model.getOwner().getName());
   }

   private GenAnnotation generate(Method method, String rootDir, String helperDir)
   {
      Parser parser = getGenerator(method.getClazz()).getOrCreateParser(rootDir);
      parser.parse();

      ArrayList<SymTabEntry> tabEntries = parser.getSymTabEntriesFor(method.getSignature(false));
      return generate(parser, getStartPos(tabEntries));
   }

   private GenAnnotation generate(Clazz clazz, String rootDir, String helperDir)
   {
      Parser parser = getGenerator(clazz).getOrCreateParser(rootDir);
      parser.parse();

      ArrayList<SymTabEntry> tabEntries = parser.getSymTabEntriesFor(clazz.getName());
      return generate(parser, getStartPos(tabEntries));
   }

   private int getStartPos(ArrayList<SymTabEntry> tabEntries)
   {
      SymTabEntry symTabEntry = null;

      if (tabEntries.size() > 0)
      {
         symTabEntry = tabEntries.get(0);
      }

      if (symTabEntry == null || annotationAlreadyInserted(symTabEntry))
         return -1;

      return symTabEntry.getStartPos();
   }

   private boolean annotationAlreadyInserted(SymTabEntry symTabEntry)
   {
      boolean inserted = false;
      if (symTabEntry.getAnnotations() != null && symTabEntry.getAnnotations().contains(model.getName()))
      {
         inserted = true;
         for (String value : model.getValues())
         {
            if (!symTabEntry.getAnnotations().contains(value))
            {
               inserted = false;
               break;
            }
         }
      }

      return inserted;
   }

   private GenAnnotation generate(Parser parser, int startPos)
   {

      if (startPos == -1)
      {
         return this;
      }

      StringBuilder sb = new StringBuilder();
      if(!model.getName().startsWith("@")) {
    	  sb.append("@");
      }
      sb.append(model.getName());

      Set<String> values = model.getValues();
      if (values.size() == 1)
      {
         sb.append("(");
         sb.append(values.toArray(new String[values.size()])[0]);
         sb.append(")");
      }
      else if (values.size() > 1)
      {
         sb.append("({");
         for (String value : values)
         {
            sb.append("\"");
            sb.append(value);
            sb.append("\", ");
         }
         sb.replace(sb.length() - 2, sb.length(), "");
         sb.append("})");
      }

      sb.append("\n");
      // CGUtil
      
      String newAnnotation = sb.toString();
      int indexOf = parser.getFileBody().indexOf(newAnnotation, startPos-newAnnotation.length()-5);
      if (indexOf < 0 || indexOf > startPos)
      {
         parser.insert(startPos, newAnnotation);
         parser.parse();
      }

      return this;
   }

}
