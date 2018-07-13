package controllers;

import db.DBHelper;
import models.Paddock;
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

        get("/visitor", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> visitors = DBHelper.getAll(Visitor.class);
            model.put("template", "templates/visitor/index.vtl");
            model.put("visitors", visitors);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/visitors/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("paddocks", paddocks);
            model.put("template", "templates/visitors/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/visitors", (req, res) -> {
            int paddockId = Integer.parseInt(req.queryParams("paddock"));
            Paddock paddock = DBHelper.find(Paddock.class, paddockId);
            String name = req.queryParams("Name");
            int capacity = Integer.parseInt(req.queryParams("capacity"));
            String food = req.queryParams("food");
            paddock = new Paddock(name, capacity, food);
            DBHelper.save(paddock);
            res.redirect("/visitors");
            return null;
        }, new VelocityTemplateEngine());
    }
}
