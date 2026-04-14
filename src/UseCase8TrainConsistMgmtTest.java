import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    List<UseCase8TrainConsistMgmt.Bogie> getSampleBogies() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("General", 90));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(getSampleBogies(), 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(getSampleBogies(), 72);

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(getSampleBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(getSampleBogies(), 50);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(getSampleBogies(), 200);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(new ArrayList<>(), 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmt.Bogie> original = getSampleBogies();
        UseCase8TrainConsistMgmt.filterBogies(original, 60);

        assertEquals(4, original.size());
    }
}