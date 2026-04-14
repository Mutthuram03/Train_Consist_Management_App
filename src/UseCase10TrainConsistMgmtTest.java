import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    List<UseCase10TrainConsistMgmt.Bogie> getSampleBogies() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int result = UseCase10TrainConsistMgmt.totalCapacity(getSampleBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = UseCase10TrainConsistMgmt.totalCapacity(getSampleBogies());
        assertTrue(result > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmt.Bogie> list = new ArrayList<>();
        list.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 100));

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);
        assertEquals(100, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = UseCase10TrainConsistMgmt.totalCapacity(new ArrayList<>());
        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        int result = UseCase10TrainConsistMgmt.totalCapacity(getSampleBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int result = UseCase10TrainConsistMgmt.totalCapacity(getSampleBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmt.Bogie> original = getSampleBogies();
        UseCase10TrainConsistMgmt.totalCapacity(original);

        assertEquals(4, original.size());
    }
}