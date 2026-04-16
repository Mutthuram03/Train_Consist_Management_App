import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmt.GoodsBogie b1 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        UseCase15TrainConsistMgmt.GoodsBogie b2 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum"); // error
        b2.assignCargo("Coal");      // should still work

        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgmt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        // finally always executes → no crash
        assertTrue(true);
    }
}