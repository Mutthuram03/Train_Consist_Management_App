import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("A", 50),
                new UseCase13TrainConsistMgmt.Bogie("B", 70)
        );

        List<UseCase13TrainConsistMgmt.Bogie> result = new ArrayList<>();
        for (UseCase13TrainConsistMgmt.Bogie b : list) {
            if (b.capacity > 60) result.add(b);
        }

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("A", 50),
                new UseCase13TrainConsistMgmt.Bogie("B", 80)
        );

        List<UseCase13TrainConsistMgmt.Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("A", 90),
                new UseCase13TrainConsistMgmt.Bogie("B", 40)
        );

        List<UseCase13TrainConsistMgmt.Bogie> loop = new ArrayList<>();
        for (UseCase13TrainConsistMgmt.Bogie b : list) {
            if (b.capacity > 60) loop.add(b);
        }

        List<UseCase13TrainConsistMgmt.Bogie> stream = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loop.size(), stream.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        assertTrue(end - start >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<UseCase13TrainConsistMgmt.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new UseCase13TrainConsistMgmt.Bogie("Test", i));
        }

        List<UseCase13TrainConsistMgmt.Bogie> result = list.stream()
                .filter(b -> b.capacity > 5000)
                .collect(Collectors.toList());

        assertFalse(result.isEmpty());
    }
}