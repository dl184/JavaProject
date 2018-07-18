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

public class PaddockController {

    public PaddockController(){
    this.setupEndpoints();
}

    private void setupEndpoints() {

        get("/paddocks/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(intId, Paddock.class);
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);

            Map<String, Object> model = new HashMap<>();
            model.put("paddock", paddock);
            model.put("paddocks", paddocks);
            model.put("template", "templates/paddocks/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/paddocks", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("template", "templates/paddocks/index.vtl");
            model.put("paddocks", paddocks);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/paddocks/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("paddocks", paddocks);
            model.put("template", "templates/paddocks/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/paddocks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(intId, Paddock.class);

            Map<String, Object> model = new HashMap<>();

            model.put("paddock", paddock);
            model.put("template", "templates/paddocks/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/paddocks", (req, res) -> {
            String name = req.queryParams("name");
            int capacity = Integer.parseInt(req.queryParams("capacity"));
            Paddock paddock = new Paddock(name, capacity, DinosaurFood.COW);
            DBHelper.saveOrUpdate(paddock);
            res.redirect("/paddocks");
            return null;
        }, new VelocityTemplateEngine());

        post ("/paddocks/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Paddock paddockToDelete = DBHelper.find(id, Paddock.class);
            DBHelper.delete(paddockToDelete);
            res.redirect("/paddocks");
            return null;
        }, new VelocityTemplateEngine());

        post ("/paddocks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(intId, Paddock.class);
            String Name = req.queryParams("name");
            int capacity = Integer.parseInt(req.queryParams("capacity"));
            String food = req.queryParams("food");

            paddock.setName(Name);
            paddock.setCapacity(capacity);
            paddock.setFood(DinosaurFood.PLANTS);
            DBHelper.saveOrUpdate(paddock);
            res.redirect("/paddocks");
            return null;

        }, new VelocityTemplateEngine());
    }
}