package es.iessaladillo.pedrojoya.carfactory.product;

@SuppressWarnings("unused")
public abstract class Car {

    private final String modelName;

    protected Car(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    @Override
    public String toString() {
        return modelName;
    }

}
