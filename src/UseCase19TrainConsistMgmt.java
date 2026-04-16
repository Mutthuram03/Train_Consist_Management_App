import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID");
        System.out.println("========================================\n");

        String[] bogieIds = {"B101", "B205", "B309", "B410", "B512"};

        // IMPORTANT: Binary search requires sorted array
        Arrays.sort(bogieIds);

        String searchKey = "B309";

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        System.out.println("\n\nSearching for Bogie ID: " + searchKey);

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = bogieIds[mid].compareTo(searchKey);

            if (result == 0) {
                System.out.println("Bogie Found at position: " + mid);
                found = true;
                break;
            }
            else if (result < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}