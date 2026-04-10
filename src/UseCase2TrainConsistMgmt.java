import java.util.ArrayList;

public class UseCase2TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC2 - Allow Duplicate Bogie IDs");
        System.out.println("====================================\n");

        ArrayList<String> bogies = new ArrayList<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG101");
        bogies.add("BG103");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nObservation:");
        System.out.println("Duplicates are allowed in ArrayList.");
    }
}