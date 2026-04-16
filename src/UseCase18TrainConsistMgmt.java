public class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID");
        System.out.println("========================================\n");

        String[] bogieIds = {"B101", "B205", "B309", "B410", "B512"};

        String searchKey = "B309";

        boolean found = false;

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        System.out.println("\n\nSearching for Bogie ID: " + searchKey);

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(searchKey)) {
                System.out.println("Bogie Found at position: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}