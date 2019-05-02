package es.iessaladillo.pedrojoya.weatherreactobserver;

import es.iessaladillo.pedrojoya.weatherreactobserver.weather.observable.WeatherStation;
import es.iessaladillo.pedrojoya.weatherreactobserver.weather.observer.MobileWeatherApp;
import es.iessaladillo.pedrojoya.weatherreactobserver.weather.observer.SmartWatch;

class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        MobileWeatherApp mobileWeatherApp = new MobileWeatherApp(weatherStation);
        SmartWatch smartWatch = new SmartWatch(weatherStation);

        weatherStation.setTemperature(25.06f);
        weatherStation.setTemperature(24.08f);
        weatherStation.setTemperature(23.21f);

        mobileWeatherApp.close();
        smartWatch.turnOff();
    }

}
