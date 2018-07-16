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

        get("/visitors/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(intId, Visitor.class);
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);

            Map<String, Object> model = new HashMap<>();
            model.put("paddock", paddocks);
            model.put("template", "templates/managers/edit.vtl");
            model.put("visitor", visitor);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/visitors", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> visitors = DBHelper.getAll(Visitor.class);
            model.put("template", "templates/visitors/index.vtl");
            model.put("visitors", visitors);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/visitors/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("paddock", paddocks);
            model.put("template", "templates/visitors/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/visitors/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(intId, Visitor.class);
            List<Paddock> paddocks = (List<Paddock>) DBHelper.findVisitorInPark(visitor.getPark());

            Map<String, Object> model = new HashMap<>();

            model.put("visitor", visitor);
            model.put("paddock", paddocks);
            model.put("template", "templates/visitors/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/visitors", (req, res) -> {
            int paddockId = Integer.parseInt(req.queryParams("paddock"));
            Paddock paddock = DBHelper.find(paddockId, Paddock.class);
            String Name = req.queryParams("Name");
            int age = Integer.parseInt(req.queryParams("age"));
            int wallet = Integer.parseInt(req.queryParams("wallet"));
            int height = Integer.parseInt(req.queryParams("height"));
            Visitor visitor = new Visitor(Name, age, wallet, height);
            DBHelper.save(visitor);
            res.redirect("/visitors");
            return null;
        }, new VelocityTemplateEngine());

        post ("/visitors/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Visitor visitorToDelete = DBHelper.find(id, Visitor.class);
            DBHelper.delete(visitorToDelete);
            res.redirect("/visitors");
            return null;
        }, new VelocityTemplateEngine());

        post ("/visitors/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(intId, Visitor.class);
            int paddockId = Integer.parseInt(req.queryParams("department"));
            Paddock paddock = DBHelper.find(paddockId, Paddock.class);
            String Name = req.queryParams("Name");
            int age = Integer.parseInt(req.queryParams("age"));
            int wallet = Integer.parseInt(req.queryParams("wallet"));
            int height = Integer.parseInt(req.queryParams("height"));

            visitor.setName(Name);
            visitor.setAge(age);
            visitor.setHeight(height);
            visitor.setWallet(wallet);
            DBHelper.save(visitor);
            res.redirect("/visitors");
            return null;

        }, new VelocityTemplateEngine());
    }
}