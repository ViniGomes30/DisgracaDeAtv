import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Player> players = new LinkedList<>();
        
        System.out.println("Welcome to Chute a Gol! Please enter the names of 10 players:");
        
        // Collect player names
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        
        Game game = new Game(players);
        game.start();
        
        scanner.close();
    }
}