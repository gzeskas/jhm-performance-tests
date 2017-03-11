package lt.gzeska;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Random;

public class PerformanceBenchmark {

    private static final Random rand = new Random();

    @Benchmark
    public void findByIdInMap() {
        SimpleEnum.forId(getRandomIndex());
    }

    @Benchmark
    public void findByIdInStream() {
        SimpleEnum.forIdStream(getRandomIndex());
    }

    @Benchmark
    public void findByNameInMap() {
        SimpleEnum.forName(getRandomName());
    }

    @Benchmark
    public void findByNameInStream() {
        SimpleEnum.forNameStream(getRandomName());
    }

    private int getRandomIndex() {
        return rand.nextInt((4 - 1) + 1) + 1;
    }

    private String getRandomName() {
        int index = getRandomIndex();
        switch (index) {
            case 1:
                return "FIRST";
            case 2:
                return "SECOND";
            case 3:
                return "THIRD";
            case 4:
                return "FOURTH";
            default:
                return "FIRST";
        }
    }

}
