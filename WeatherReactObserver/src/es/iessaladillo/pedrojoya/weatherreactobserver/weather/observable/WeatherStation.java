package es.iessaladillo.pedrojoya.weatherreactobserver.weather.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class WeatherStation implements Publisher<Float> {

    private final List<Subscriber<? super Float>> observers = new ArrayList<>();
    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Float> subscriber) {
        observers.add(subscriber);
        subscriber.onSubscribe(new WeatherSubscription(subscriber));
    }

    private void notifyObservers() {
        for (Subscriber<? super Float> observer : observers) {
            observer.onNext(temperature);
        }
    }

    private class WeatherSubscription implements Subscription {

        private final Subscriber<? super Float> observer;

        private WeatherSubscription(Subscriber<? super Float> observer) {
            this.observer = observer;
        }

        @Override
        public void request(long n) {
            observer.onNext(getTemperature());
        }

        @Override
        public void cancel() {
            observers.remove(observer);
            System.out.println("Un obserador ha dejado de observar la estación meteorológica");
        }

    }

}
