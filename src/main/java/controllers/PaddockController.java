package controllers;

import db.DBHelper;
import models.Dinosaur;
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

public class PaddockController {
    public PaddockController(){
    this.setupEndpoints();
}

    private void setupEndpoints() {




        get("/paddocks/:id/edit", (req, res) -> {
        String strId = req.params(":id");
        Integer intId = Integer.parseInt(strId);
        Park paddocks = DBHelper.find(Paddock.class, intId);

        Map<String, Object> model = new HashMap<>();
        model.put("paddock", paddocks);
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
        model.put("template", "templates/paddocks/create.vtl.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/paddocks/:id", (req, res) -> {
        String strId = req.params(":id");
        Integer intId = Integer.parseInt(strId);
        Park paddock = DBHelper.find(Paddock.class, intId);
        Visitor visitor = DBHelper.findVisitorInPark(paddock);
        List<Dinosaur> dinosaurs = DBHelper.findDinoInPark(paddock);

        Map<String, Object> model = new HashMap<>();

        model.put("paddock", paddock);
        model.put("visitors", visitor);
        model.put("dinosaurs", dinosaurs);
        model.put("template", "templates/paddocks/show.vtl");

        return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get ("/paddocks/new", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("template", "templates/paddocks/create.vtl.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    post ("/paddocks", (req, res) -> {
        String title = req.queryParams("title");

        Paddock paddock = new Paddock(title);
        DBHelper.save(paddock);
        res.redirect("/paddocks");
        return null;
    }, new VelocityTemplateEngine());

    post ("/paddocks/:id/delete", (req, res) -> {
        int id = Integer.parseInt(req.params(":id"));
        Park paddockToDelete = DBHelper.find(Paddock.class, id);
        DBHelper.delete(paddockToDelete);
        res.redirect("/paddocks");
        return null;
    }, new VelocityTemplateEngine());

}
}

