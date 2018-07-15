package controllers;

import db.DBHelper;
import models.Dinosaur;
import models.Park;
import models.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class DinosaurController {
    public DinosaurController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/dinosaurs", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            model.put("template", "templates/visitors/index.vtl");
            model.put("dinosaurs", dinosaurs);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        get("/templates/dinosaurs", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
//            model.put("template", "templates/dinosaurs/index.vtl");
//            model.put("dinosaurs", dinosaurs);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, new VelocityTemplateEngine());

        get("/dinosaurs/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            model.put("dinosaurs", dinosaurs);
            model.put("template", "templates/dinosaurs/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/dinosaurs/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Park park = DBHelper.find(Park.class, intId);

            Map<String, Object> model = new HashMap<>();
            model.put("dinosaurs", park);
            model.put("template", "templates/dinosaurs/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/dinosaurs", (req, res) -> {
            String name = req.queryParams("name");

            Dinosaur dinosaur = new Dinosaur();
            DBHelper.save(dinosaur);
            res.redirect("/dinosaurs");
            return null;
        }, new VelocityTemplateEngine());

        post("/dinosaurs/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Park visitorToDelete = DBHelper.find(Visitor.class, id);
            DBHelper.delete(visitorToDelete);
            res.redirect("/dinosaurs");
            return null;
        }, new VelocityTemplateEngine());

    }


}




