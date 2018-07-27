package controllers;

import db.DBHelper;
import db.DBPaddock;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class DinosaurController {

    public DinosaurController() {

        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/dinosaurs/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Dinosaur dinosaur = DBHelper.find(intId, Dinosaur.class);
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            Map<String, Object> model = new HashMap<>();
            model.put("dinosaur", dinosaur);
            model.put("paddocks", paddocks);
            model.put("template", "templates/dinosaurs/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/dinosaurs", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            /* set avoids duplicates*/
            Set<Dinosaur> dinosaurs = new HashSet<>(DBHelper.getAll(Dinosaur.class));
            model.put("template", "templates/dinosaurs/index.vtl");
            model.put("dinosaurs", dinosaurs);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/dinosaurs/new", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("dinosaurs", dinosaurs);
            model.put("paddocks", paddocks);
            model.put("template", "templates/dinosaurs/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/dinosaurs/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Dinosaur dinosaur = DBHelper.find(intId, Dinosaur.class);
            Map<String, Object> model = new HashMap<>();
            model.put("dinosaur", dinosaur);
            model.put("template", "templates/dinosaurs/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/dinosaurs", (req, res) -> {
            int paddock_id = Integer.parseInt(req.queryParams("paddock"));
            Paddock paddock = DBHelper.find(paddock_id, Paddock.class);
            String type = req.queryParams("type");
            String diet = req.queryParams("diet");
            int height = Integer.parseInt(req.queryParams("height"));
            String color = req.queryParams("color");
            Dinosaur dinosaur = new Dinosaur(paddock,type,diet,height,color);
            DBHelper.saveOrUpdate(dinosaur);
            res.redirect("/dinosaurs");
            return null;
        }, new VelocityTemplateEngine());

        post("/dinosaurs/:id/feed", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Dinosaur dinosaurToFeed = DBHelper.find(id, Dinosaur.class);
            DinosaurFood dinosaurFood = dinosaurToFeed.getPaddock().getFood();
            dinosaurToFeed.feedDinosaur(dinosaurFood);
            DBHelper.saveOrUpdate(dinosaurToFeed);
            res.redirect("/dinosaurs/" + id);
            return null;
        }, new VelocityTemplateEngine());

        post ("/dinosaurs/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Dinosaur dinosaurToDelete = DBHelper.find(id, Dinosaur.class);
            DBHelper.delete(dinosaurToDelete);
            res.redirect("/dinosaurs");
            return null;
        }, new VelocityTemplateEngine());

        post ("/dinosaurs/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Dinosaur dinosaur = DBHelper.find(intId, Dinosaur.class);
            String type = req.queryParams("type");
            String diet = req.queryParams("diet");
            int height = Integer.parseInt(req.queryParams("height"));
            String color = req.queryParams("Color");

            dinosaur.setType(type);
            dinosaur.setHeight(height);
            dinosaur.setDiet(diet);
            dinosaur.setColor(color);
            DBHelper.saveOrUpdate(dinosaur);
            res.redirect("/dinosaurs");
            return null;

        }, new VelocityTemplateEngine());
    }
}