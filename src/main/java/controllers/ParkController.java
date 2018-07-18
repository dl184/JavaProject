package controllers;//package controllers;

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

        get("/parks/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(intId, Visitor.class);
            List<Park> parks = DBHelper.getAll(Park.class);
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/parks/edit.vtl");
            model.put("visitor", visitor);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/parks", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("template", "templates/parks/index.vtl");
            model.put("park", parks);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/parks/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("parks", parks);
            model.put("template", "templates/parks/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/parks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(intId, Visitor.class);
            List<Park> parks = (List<Park>) DBHelper.findVisitorInPark(visitor.getPark());

            Map<String, Object> model = new HashMap<>();

            model.put("park", parks);
            model.put("template", "templates/parks/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post ("/parks/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Visitor visitorToDelete = DBHelper.find(id, Visitor.class);
            DBHelper.delete(visitorToDelete);
            res.redirect("/parks");
            return null;
        }, new VelocityTemplateEngine());

        post ("/parks", (req, res) -> {
            String name = req.queryParams("name");
            int wallet = Integer.parseInt(req.queryParams("wallet"));
            int age =  Integer.parseInt(req.queryParams("age"));
            Park park = new Park(name, wallet, age);
            DBHelper.saveOrUpdate(park);
            res.redirect("/parks");
            return null;
        }, new VelocityTemplateEngine());


        post ("/parks/:id", (req, res) -> {
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
            DBHelper.saveOrUpdate(visitor);
            res.redirect("/visitors");
            return null;

        }, new VelocityTemplateEngine());
    }
}