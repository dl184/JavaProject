package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ParkController {


    public ParkController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {


        get("/park/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Park park = DBHelper.find(Park.class, intId);

            Map<String, Object> model = new HashMap<>();
            model.put("park", park);
            model.put("template", "templates/parks/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/parks", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("template", "templates/parks/index.vtl");
            model.put("parks", parks);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/parks/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/parks/create.vtl.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/parks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Park park = DBHelper.find(Park.class, intId);
            Visitor visitor = DBHelper.findVisitorInPark(park);
            List<Dinosaur> dinosaurs = DBHelper.findDinoInPark(park);

            Map<String, Object> model = new HashMap<>();

            model.put("park", park);
            model.put("visitors", visitor);
            model.put("dinosaurs", dinosaurs);
            model.put("template", "templates/park/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/parks/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/parks/create.vtl.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/parks", (req, res) -> {
            String title = req.queryParams("title");

            Park park = new Park(title);
            DBHelper.save(park);
            res.redirect("/parks");
            return null;
        }, new VelocityTemplateEngine());

        post ("/parks/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Park parkToDelete = DBHelper.find(Park.class, id);
            DBHelper.delete(parkToDelete);
            res.redirect("/parks");
            return null;
        }, new VelocityTemplateEngine());

        post ("/parks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Park park = DBHelper.find(Park.class, intId);
            String title = req.queryParams("title");
            park.setTitle(title);
            DBHelper.save(park);
            res.redirect("/parks");
            return null;

        }, new VelocityTemplateEngine());

    }
}