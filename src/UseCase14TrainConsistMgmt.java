import java.util.*;

public class UseCase14TrainConsistMgmt {

    // -------- CUSTOM EXCEPTION --------
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // -------- PASSENGER BOGIE --------
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity");
        System.out.println("====================================\n");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            bogies.add(b1);
            System.out.println("Created Bogie: " + b1);

            // INVALID CASE
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            bogies.add(b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}