import java.util.*;

public class UseCase15TrainConsistMgmt {

    // -------- CUSTOM RUNTIME EXCEPTION --------
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // -------- GOODS BOGIE --------
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                // RULE: Rectangular cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("====================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");

        // VALID CASE
        cylindrical.assignCargo("Petroleum");

        // INVALID CASE
        rectangular.assignCargo("Petroleum");

        System.out.println("UC15 runtime handling completed...");
    }
}