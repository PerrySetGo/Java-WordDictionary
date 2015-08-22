import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


/* I had this project working really well  - and then I realized late in the game that I had forgotten about 
needing a definition class as well as a word class. I added in a definition class but as a consequence things don't
work as well as they did before, including the definitions not showing up on sub pages, which is something I 
tried and tried to make work but couldn't! If you have the time/interest, take a look at my earlier commit:

33e53876e09c8c551de1573f7d3863fa2296838a

as it shows that the whole project did work much better before I introduced the definition class :CC */


public class App {
  public static void main(String[] args) {

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("wordList", request.session().attribute("wordList"));
          model.put("definitionList", request.session().attribute("definitionList"));
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          ArrayList<Word> wordList = request.session().attribute("wordList");
          ArrayList<Definition> definitionList = request.session().attribute("definitionList");

           if (wordList == null && definitionList == null) {
                wordList = new ArrayList<Word>();
                request.session().attribute("wordList", wordList);
                definitionList = new ArrayList<Definition>();
                request.session().attribute("definitionList", definitionList);
                }

          String userInputWordName = request.queryParams("addWordName"); 
          String userInputWordDefinition = request.queryParams("addWordDefinition"); 

          Word myWord = new Word(userInputWordName);
          Definition myDefinition = new Definition(userInputWordDefinition);
          wordList.add(myWord);
          definitionList.add(myDefinition);

          model.put("wordList", Word.all());
          model.put("definitionList", Definition.all());

          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());

        post("/delete", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            ArrayList<Word> wordList = request.session().attribute("wordList");

            for (Iterator<Word> iterator = wordList.iterator(); iterator.hasNext();) {
            Word word = iterator.next();
            boolean delete = Boolean.parseBoolean(request.queryParams("delete-"+word.getWordId()));
            if (delete) {
              iterator.remove();
              }
            }

            model.put("template", "templates/deleted.vtl");
            return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());

        get("/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            ArrayList<Word> wordList = request.session().attribute("wordList");
            ArrayList<Definition> definitionList = request.session().attribute("definitionList");

            Integer wordId = Integer.parseInt(request.params(":id"));

            Word foundWord = Word.find(wordId);
            Definition foundDefinition = Definition.find(wordId);
            model.put("foundWord", foundWord);
            model.put("foundDefinition", foundDefinition);
            model.put("template", "templates/word_single.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());


        post("/find", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          ArrayList<Word> wordList = request.session().attribute("wordList");
          ArrayList<Definition> definitionList = request.session().attribute("definitionList");

          Integer findId = Integer.parseInt(request.queryParams("findWordById"));
          Word foundWord = Word.find(findId);
          Definition foundDefinition = Definition.find(findId);
          model.put("foundWord", foundWord);
          model.put("foundDefinition", foundDefinition);
          model.put("template", "templates/find.vtl");
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

    }
  }
