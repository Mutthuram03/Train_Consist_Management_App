import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    List<UseCase9TrainConsistMgmt.Bogie> getSampleBogies() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(getSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(getSampleBogies());

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(getSampleBogies());

        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmt.Bogie> original = getSampleBogies();
        UseCase9TrainConsistMgmt.groupBogies(original);

        assertEquals(4, original.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(getSampleBogies());

        assertTrue(result.keySet().contains("Sleeper"));
        assertTrue(result.keySet().contains("AC Chair"));
        assertTrue(result.keySet().contains("First Class"));
    }
}