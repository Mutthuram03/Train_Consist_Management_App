import java.util.ArrayList;

public class UseCase1TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC1 - Initialize Train Consist");
        System.out.println("====================================\n");

        ArrayList<String> bogies = new ArrayList<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");

        System.out.println("Train Bogie List:");
        System.out.println(bogies);

        System.out.println("\nTotal Bogies: " + bogies.size());
    }
}