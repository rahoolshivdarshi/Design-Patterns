package org.selfstudy.com.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Subject {
    void addObservers(Observer observer);
    void removeObservers(Observer observer);
    void notifyObservers();
}

// Observer Interface
interface Observer {
    void update(float temp);
}


//Concrete Class
class WeatherStation1 implements Subject {

    private float temp;
    private List<Observer> displayDevices;

    public WeatherStation1() {
        this.displayDevices = new ArrayList<>();
    }

    @Override
    public void addObservers(Observer displayDevice) {
        displayDevices.add(displayDevice);
    }

    @Override
    public void removeObservers(Observer displayDevice) {
        displayDevices.remove(displayDevice);
    }

    @Override
    public void notifyObservers() {
        for(Observer displayDevice : displayDevices) {
            displayDevice.update(temp); // displayDevice - runtime polymorphism
        }
    }

    public void setTemp(float temp) {
        this.temp = temp;
        notifyObservers();
    }
}

class MobileDevice implements Observer {

    private String name;

    public MobileDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(float temp) {
        System.out.println("Temp in " + name + " is " + temp);
    }
}

class TV implements Observer {

    private String name;

    public TV(String name) {
        this.name = name;
    }

    @Override
    public void update(float temp) {
        System.out.println("Temp in " + name + " is " + temp);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {

        // Create Publisher
        WeatherStation1 weatherStation = new WeatherStation1();

        // Create Subscriber
        MobileDevice mobileDevice = new MobileDevice("Pixel");
        TV tv = new TV("Samsung");

        // Attach
        weatherStation.addObservers(mobileDevice);
        weatherStation.addObservers(tv);

        weatherStation.setTemp(27);

        // Detach
        weatherStation.removeObservers(tv);

        weatherStation.setTemp(29);
    }
}
