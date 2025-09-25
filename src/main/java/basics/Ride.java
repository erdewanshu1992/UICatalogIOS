package basics;

public class Ride {

    String driverName;

    // 1. Constructor वाला (Driver fix ho gaya)
    // Constructor injection
    public Ride(String driverName) {
        this.driverName = driverName;   // fix kar liya driver ka naam
    }

    public void startRide(String passenger) {
        System.out.println(driverName + " ne " + passenger + " ko pick kiya 🚕");
    }

    // Ye entry point hoga program run karne ka
    public static void main(String[] args) {
        Ride ride1 = new Ride("Rahul");
        ride1.startRide("Dewanshu"); // Output: Rahul ne Dewanshu ko pick kiya 🚕
    }
}


/*
1. Constructor वाला (Driver fix ho gaya)

👉 Concept:

driverName ek state hai jo object ke andar save ho gaya.

Har ride object ka apna driver hoga.

Ye hai OOP + constructor injection.
 */