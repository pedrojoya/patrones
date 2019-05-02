package es.iessaladillo.pedrojoya.weatherreactobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherreactobserver.weather.observable.WeatherStation;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class SmartWatch implements Subscriber<Float> {

    private final WeatherStation weatherStation;
    private Subscription subscription;

    public SmartWatch(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
        System.out.println("El smart watch ha comenzado a observar la estación de clima");
    }

    public void turnOff() {
        subscription.cancel();
        System.out.println("El smart watch ha dejado de observar la estación de clima");
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(Float item) {
        System.out.printf("El smart watch ha sido notificado de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
