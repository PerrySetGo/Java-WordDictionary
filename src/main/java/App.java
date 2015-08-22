import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("wordList", request.session().attribute("wordList"));
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          ArrayList<Word> wordList = request.session().attribute("wordList");

           if (wordList == null) {
                 wordList = new ArrayList<Word>();
                request.session().attribute("wordList", wordList);
                }

          String userInputWordName = request.queryParams("addWordName"); 
          String userInputWordDefinition = request.queryParams("addWordDefinition"); 

          Word myWord = new Word(userInputWordName,userInputWordDefinition);
          wordList.add(myWord);
          model.put("wordList", Word.all());
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
            Integer wordId = Integer.parseInt(request.params(":id"));
            Word foundWord = Word.find(wordId);
            model.put("foundWord", foundWord);
            model.put("template", "templates/word_single.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());


        post("/find", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          ArrayList<Word> wordList = request.session().attribute("wordList");
          Integer findId = Integer.parseInt(request.queryParams("findWordById"));
          Word foundWord = Word.find(findId);
          model.put("foundWord", foundWord);
          model.put("template", "templates/find.vtl");
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

    }
  }
