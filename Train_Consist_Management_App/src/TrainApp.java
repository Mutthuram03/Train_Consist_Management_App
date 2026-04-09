import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("====================================\n");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");

        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + exists);

        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }
}