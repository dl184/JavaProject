import controllers.DinosaurController;
import controllers.PaddockController;
import controllers.ParkController;
import controllers.VisitorController;
import db.*;
import models.Dinosaur;
import models.Paddock;
import models.Park;
import models.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class Runner {

    public static void main(String[] args) {

        Seeds.seedData();

        DinosaurController dinosaurController = new DinosaurController();
        PaddockController paddockController = new PaddockController();
        ParkController parkController = new ParkController();
        VisitorController visitorController = new VisitorController();

//        get("/home", (req, res) -> {
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("template", "templates/home.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, new VelocityTemplateEngine());

    }
}
