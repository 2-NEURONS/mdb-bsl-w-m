package jdbi.foundations.learn;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;


public class Main
{
    public static void main(String[] args)
    {

        HandlebarsTemplateEngine templating = new HandlebarsTemplateEngine();
        port(8080);
        get("/", (Request req , Response res)->
        {
            Map<String , Object> myMap = new HashMap();
            myMap.put("title","BSL-W-M");
            ModelAndView mv = new ModelAndView(myMap,"index.handlebars");
            return mv;

        } , templating);


    }

}
