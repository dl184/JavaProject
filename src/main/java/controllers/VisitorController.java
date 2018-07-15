package controllers;

import db.DBHelper;
import models.DinosaurFood;
import models.Paddock;
import models.Park;
import models.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class VisitorController {

    public VisitorController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/visitors/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Park visitor = DBHelper.find(Visitor.class, intId);
            List<Park> park = DBHelper.getAll(Visitor.class);

            Map<String, Object> model = new HashMap<>();
            model.put("park", park);
            model.put("template", "templates/visitors/edit.vtl");
            model.put("visitors", visitor);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/visitors", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> visitors = DBHelper.getAll(Visitor.class);
            model.put("template", "templates/visitors/index.vtl");
            model.put("visitors", visitors);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/visitors/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("parks", parks);
            model.put("template", "templates/visitors/create.vtl.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/visitors", (req, res) -> {
            int parkId = Integer.parseInt(req.queryParams("park"));
            Park park = DBHelper.find(Park.class, parkId);
            String Name = req.queryParams("Name");
            int wallet = Integer.parseInt(req.queryParams("wallet"));
            int age = Integer.parseInt(req.queryParams("age"));
            int height = Integer.parseInt(req.queryParams("height"));
            Visitor visitor = new Visitor(Name, wallet, age, height);
            DBHelper.save(visitor);
            res.redirect("/visitors");
            return null;
        }, new VelocityTemplateEngine());

        post("/visitors/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Park visitorToDelete = DBHelper.find(Visitor.class, id);
            DBHelper.delete(visitorToDelete);
            res.redirect("/visitors");
            return null;
        }, new VelocityTemplateEngine());

    }
}
