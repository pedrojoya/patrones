package es.iessaladillo.pedrojoya.weatherreactobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherreactobserver.weather.observable.WeatherStation;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class MobileWeatherApp implements Subscriber<Float> {

    private final WeatherStation weatherStation;
    private Flow.Subscription subscription;

    public MobileWeatherApp(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
        System.out.println("La aplicación del móvil ha comenzado a observar la estación meteorológica");
    }

    public void close() {
        subscription.cancel();
        System.out.println("La aplicación del móvil ha dejado de observar la estación meteorológica");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(Float item) {
        System.out.printf("La aplicación del móvil ha sido notificada de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

}
