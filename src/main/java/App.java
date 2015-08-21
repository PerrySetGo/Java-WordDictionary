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

        post("/words", (request, response) -> {
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

          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



        get("/output", (request, response) -> {
          //set up the hashmap and set the output
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/output.vtl");
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

      }
    }
