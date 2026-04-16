import java.util.Arrays;

public class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("============================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        for (String name : bogieNames) {
            System.out.print(name + " ");
        }

        Arrays.sort(bogieNames);

        System.out.println("\n\nSorted Bogie Names (Alphabetical):");
        for (String name : bogieNames) {
            System.out.print(name + " ");
        }

        System.out.println("\n\nUC17 sorting completed...");
    }
}