package db;

import models.Park;
import models.Visitor;

public class DBVisitor {
    public static void addVisitorToPark(Visitor visitor, Park park) {
        park.addVisitor(visitor);
        DBHelper.saveOrUpdate(visitor);
        DBHelper.saveOrUpdate(park);
    }
}
