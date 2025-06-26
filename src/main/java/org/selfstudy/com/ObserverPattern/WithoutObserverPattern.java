package org.selfstudy.com.ObserverPattern;

class DisplayDevice {
    public void display(float temp) {
        System.out.println("The temps is " + temp);
    }
}

class WeatherStation {
    private float temp;
    private DisplayDevice displayDevice;

    public WeatherStation(DisplayDevice displayDevice) {
        this.displayDevice = displayDevice;
    }

    public void notifyDevice() {
        displayDevice.display(temp);
    }

    public void setTemp(float temp) {
        this.temp = temp;
        notifyDevice();
    }
}

public class WithoutObserverPattern {

    public static void main(String args[]) {
        DisplayDevice displayDevice = new DisplayDevice();
        WeatherStation weatherStation = new WeatherStation(displayDevice);

        weatherStation.setTemp(26);
    }
}
