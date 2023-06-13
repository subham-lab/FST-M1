package activities;

public class Activity1 {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Red", "Automatic", 2022);
        car.displayCharacteristics();
        car.accelerate();
        car.brake();
    }
}
public class Car {
    private String color;
    private String transmission;
    private int make;
    private int tyres;
    private int doors;

    // Constructor
    public Car(String color, String transmission, int make) {
        this.color = color;
        this.transmission = transmission;
        this.make = make;
        this.tyres = 4;
        this.doors = 4;
    }

    // Method to display car characteristics
    public void displayCharacteristics() {
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }

    // Method to accelerate
    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    // Method to brake
    public void brake() {
        System.out.println("Car has stopped.");
    }
}
