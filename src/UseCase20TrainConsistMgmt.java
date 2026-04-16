public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC20 - Exception Handling During Search");
        System.out.println("========================================\n");

        String[] bogieIds = {}; // EMPTY ARRAY (to trigger exception)

        String searchKey = "B309";

        try {

            if (bogieIds.length == 0) {
                throw new IllegalStateException("No bogies available for search!");
            }

            boolean found = false;

            for (String id : bogieIds) {
                if (id.equals(searchKey)) {
                    System.out.println("Bogie Found: " + searchKey);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Bogie ID not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }
}