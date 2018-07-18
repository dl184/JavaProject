package controllers;

import db.DBHelper;
import models.Dinosaur;
import models.Emergency;
import models.Paddock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class EmergencyController {
    public EmergencyController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {


        get("/emergency", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            List<Emergency> emergency = DBHelper.getAll(Emergency.class);
            model.put("template", "templates/emergency/index.vtl");
            model.put("emergency", emergency);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/emergency", (req, res) -> {
            int paddock_id = Integer.parseInt(req.queryParams("emergency"));
            Emergency emergency = DBHelper.find(paddock_id, Emergency.class);
            DBHelper.saveOrUpdate(emergency);
            res.redirect("/emergency");
            return null;
        }, new VelocityTemplateEngine());

    }
}
