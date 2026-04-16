import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 50);

        assertEquals(50, bogie.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("AC", -10)
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("AC", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("AC", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmt.PassengerBogie("First Class", 30);

        assertEquals("First Class", bogie.type);
        assertEquals(30, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b1 =
                new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 40);

        UseCase14TrainConsistMgmt.PassengerBogie b2 =
                new UseCase14TrainConsistMgmt.PassengerBogie("AC", 60);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}