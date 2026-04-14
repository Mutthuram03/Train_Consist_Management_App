import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmt.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmt.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID(""));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN-1234X"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET-ABC"));
    }
}