import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Queue<Player> players;
    private int totalPlayers;

    public Game(int totalPlayers) {
        this.totalPlayers = totalPlayers;
        players = new LinkedList<>();
    }

    public void addPlayer(Player player) {
        if (players.size() < totalPlayers) {
            players.offer(player);
        } else {
            System.out.println("Maximum number of players reached.");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting the penalty shootout challenge: Chute a Gol!");

        while (!players.isEmpty()) {
            Player currentPlayer = players.poll();
            System.out.println(currentPlayer.getName() + "'s turn to shoot!");

            String outcome = RandomGenerator.getOutcome();
            System.out.println("Outcome: " + outcome);

            if (outcome.equals("Goal")) {
                System.out.println(currentPlayer.getName() + " scored a goal!");
            } else if (outcome.equals("Save")) {
                System.out.println(currentPlayer.getName() + "'s shot was saved!");
            } else {
                System.out.println(currentPlayer.getName() + " missed the shot!");
            }

            System.out.println("Press Enter for the next player...");
            scanner.nextLine();
        }

        System.out.println("The penalty shootout has ended!");
        scanner.close();
    }
}