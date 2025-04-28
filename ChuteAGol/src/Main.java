import java.util.Random;
import java.util.Scanner;
/*
Diego Estevão Lopes de Queiroz - 10419038
Ricardo Andre Lopes Ikeda - 10390256
Vinicius Gutierrez Gomes - 10425609
*/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Queue jogadores = new Queue(10);

        System.out.println("Chute a gol - insira o nome dos 10 jogadores:");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Jogador %d: ", i + 1);
            String nome = scanner.nextLine();
            jogadores.enqueue(nome);
        }

        System.out.println("\nComeça o desafio!");
        Random random = new Random();
        int rodada = 1;

        while (jogadores.size() > 2) {
            System.out.printf("\n----- Rodada %d -----\n", rodada++);
            String jogadorDaVez = jogadores.front();
            System.out.printf("%s, prepare-se para o chute!\n", jogadorDaVez);

            int resultado = random.nextInt(3); // 0: errou, 1: defendeu, 2: gol

            switch (resultado) {
                case 0:
                    System.out.printf("%s errou o chute e está fora!\n", jogadorDaVez);
                    jogadores.dequeue();
                    break;
                case 1:
                    System.out.printf("Que defesa do goleiro! %s está fora!\n", jogadorDaVez);
                    jogadores.dequeue();
                    break;
                case 2:
                    System.out.printf("GOOOOOL! %s marcou e volta para o final da fila!\n", jogadorDaVez);
                    jogadores.dequeue();
                    jogadores.enqueue(jogadorDaVez);
                    break;
            }
            System.out.printf("Jogadores restantes na fila: %d\n", jogadores.size());
        }

        // Última rodada com os dois finalistas
        System.out.println("\n----- Última Rodada! -----\n");
        String jogador1 = jogadores.front();
        jogadores.dequeue();
        String jogador2 = jogadores.front();
        jogadores.dequeue();

        System.out.printf("%s e %s são os finalistas!\n", jogador1, jogador2);

        // Chute do jogador 1
        System.out.printf("\n%s, é a sua vez de chutar para vencer!\n", jogador1);
        int resultadoJogador1 = random.nextInt(3);
        boolean jogador1Venceu = false;

        if (resultadoJogador1 == 2) {
            System.out.printf("GOOOOOL! %s acertou o chute!\n", jogador1);
            // Chute do jogador 2
            System.out.printf("%s, agora você precisa errar ou ter a bola defendida para %s vencer!\n", jogador2, jogador1);
            int resultadoJogador2 = random.nextInt(2); // 0: errou/defendeu

            if (resultadoJogador2 == 0) {
                System.out.printf("%s não marcou! %s é o campeão do Chute a Gol!\n", jogador2, jogador1);
                jogador1Venceu = true;
            } else {
                System.out.printf("Incrível defesa do goleiro em cima de %s! %s é o campeão do Chute a Gol!\n", jogador2, jogador1);
                jogador1Venceu = true;
            }
        } else {
            String resultadoTexto = (resultadoJogador1 == 0) ? "errou o chute" : "teve o chute defendido";
            System.out.printf("%s %s!\n", jogador1, resultadoTexto);
            // Chute do jogador 2
            System.out.printf("%s, agora é a sua chance de vencer!\n", jogador2);
            int resultadoJogador2 = random.nextInt(3);

            if (resultadoJogador2 == 2) {
                System.out.printf("GOOOOOL! %s marcou e é o campeão do Chute a Gol!\n", jogador2);
            } else {
                String resultadoTexto2 = (resultadoJogador2 == 0) ? "errou o chute" : "teve o chute defendido";
                System.out.printf("%s %s também! Ninguém venceu nesta rodada.\n", jogador2, resultadoTexto2);
            }
        }

        if (!jogador1Venceu && random.nextInt(2) == 0) { // Simulação de um desempate simples
            System.out.println("\n--- Desempate ---\n");
            System.out.printf("%s, chute para o desempate!\n", jogador1);
            if (random.nextInt(3) == 2) {
                System.out.printf("GOOOOOL! %s vence o desempate e é o campeão!\n", jogador1);
            } else {
                System.out.printf("%s não marcou.\n", jogador1);
                System.out.printf("%s, chute para o desempate!\n", jogador2);
                if (random.nextInt(3) == 2) {
                    System.out.printf("GOOOOOL! %s vence o desempate e é o campeão!\n", jogador2);
                } else {
                    System.out.printf("%s não marcou. O desafio termina sem um campeão claro.\n", jogador2);
                }
            }
        } else if (!jogador1Venceu) {
            System.out.println("\n--- Desempate ---\n");
            System.out.printf("%s, chute para o desempate!\n", jogador2);
            if (random.nextInt(3) == 2) {
                System.out.printf("GOOOOOL! %s vence o desempate e é o campeão!\n", jogador2);
            } else {
                System.out.printf("%s não marcou.\n", jogador2);
                System.out.printf("%s, chute para o desempate!\n", jogador1);
                if (random.nextInt(3) == 2) {
                    System.out.printf("GOOOOOL! %s vence o desempate e é o campeão!\n", jogador1);
                } else {
                    System.out.printf("%s não marcou. O desafio termina sem um campeão claro.\n", jogador1);
                }
            }
        }

        scanner.close();
    }
}