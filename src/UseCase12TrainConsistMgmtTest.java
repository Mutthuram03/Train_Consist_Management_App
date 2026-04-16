import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal")
        );

        assertTrue(UseCase12TrainConsistMgmt.isSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(UseCase12TrainConsistMgmt.isSafe(list));
    }

    @Test
    void testSafety_NonCylindricalAllowed() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Grain")
        );

        assertTrue(UseCase12TrainConsistMgmt.isSafe(list));
    }

    @Test
    void testSafety_MixedViolation() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(UseCase12TrainConsistMgmt.isSafe(list));
    }

    @Test
    void testSafety_EmptyList() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();

        assertTrue(UseCase12TrainConsistMgmt.isSafe(list));
    }
}