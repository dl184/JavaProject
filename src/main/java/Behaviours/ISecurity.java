package Behaviours;

import models.Visitor;

public interface ISecurity{

    boolean isAllowedTo(Visitor visitor);

}