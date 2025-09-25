package basics;

public class RideUtils {

    // 2. Static वाला (Utility function – har bar driver pass karna hoga)
    // Static method (direct class ke naam se call karenge)
    public static void startRide(String driverName, String passenger) {
        System.out.println(driverName + " ne " + passenger + " ko pick kiya 🚕");
    }

    // Main method to test
    public static void main(String[] args) {
        RideUtils.startRide("Amit", "QA Dev");
        RideUtils.startRide("Rohan", "Ankit");
    }
}



/*
🔑 Concept samajh:

Pehle waale Ride class me constructor use karke driverName fix kar rahe the aur har object alag driver ke saath ban raha tha.
👉 Matlab Object-Oriented style.

Ab waale RideUtils me tu static method use kar raha hai jo bas ek kaam karta hai aur har baar driverName + passenger pass karna padta hai.
👉 Matlab Utility style / Helper function, jisme state (driver ka naam) store nahi hota.

💡 Simple soch:

Agar tujhe state hold karni hai (driver fix ho ek baar ke liye) → Constructor waala use kar.

Agar bas quick calculation/operation karna hai bina object banaye → Static method use kar.

👉 Concept:

Yaha driverName koi state store nahi ho raha.

Har call ke time tu driver ka naam pass karega.

Ye bas ek utility function hai jo direct kaam kar dega, object kaam me nahi aata.

Difference ko real life se relate kar 👇

Constructor style = Ola driver fix kar diya (ek baar assign → har jagah wahi driver use hoga).

Static style = Ola app khud nahi hai, bas ek function hai → har bar tu bata driver kaun hai.

 */