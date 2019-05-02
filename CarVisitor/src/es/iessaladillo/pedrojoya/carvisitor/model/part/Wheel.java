package es.iessaladillo.pedrojoya.carvisitor.model.part;

import es.iessaladillo.pedrojoya.carvisitor.model.visitor.Visitor;

public class Wheel extends Part {

    public Wheel(String description) {
        super(description);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
