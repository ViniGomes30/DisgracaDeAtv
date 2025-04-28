import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static String getOutcome() {
        int result = random.nextInt(3); // 0, 1, or 2
        switch (result) {
            case 0:
                return "Missed";
            case 1:
                return "Save";
            case 2:
                return "Goal";
            default:
                return "Unknown";
        }
    }
}