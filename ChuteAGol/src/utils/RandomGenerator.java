import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static String generateOutcome() {
        int outcome = random.nextInt(3); // 0: miss, 1: save, 2: goal
        switch (outcome) {
            case 0:
                return "miss";
            case 1:
                return "save";
            case 2:
                return "goal";
            default:
                return "unknown"; // This should never happen
        }
    }
}