import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(final String[] args) throws Exception {

        // Informar o nome do jogar
        // Qual símbolo vai utilizar? Automaticamente o outro jogador vai usar o outro
        // símbolo
        // Indicar o local da jogada, linha coluna
        // usar o math.ramdom para linha e coluna para o computador (verficar se está
        // ocupada)

        // A cada jogada verificar se tem uma trilha só com X ou só com Y

        final String matriz[][] = new String[3][3];
        final String jogador = JOptionPane.showInputDialog(null, "Digite o seu nome");
        final String simbolo = JOptionPane.showInputDialog(null, jogador + ", informe o símbolo desejado: X ou O")
                .toUpperCase();
        String simboloComputador = "-";

        if (simbolo.equals("X")) {
            simboloComputador = "O";
        } else {
            simboloComputador = "X";
        }

        // Inicializar dados
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                matriz[coluna][linha] = "-";
            }
        }

        // Listar os dados da matriz

        boolean continuar = true;
        boolean vencedor = false;
        boolean jogadaValida = true;
        int jogadas = 0;
        Random aleatorio = new Random();

        while (continuar && !vencedor && jogadas < 9) {

            do {
                jogadaValida = false;

                int linha = -1;
                while (linha < 0 || linha > 2) {
                    linha = Integer.parseInt(
                            JOptionPane.showInputDialog(null, jogador + ", informe a linha desejada. \n Entre 0 e 2."));
                }

                int coluna = -1;
                while (coluna < 0 || coluna > 2) {
                    coluna = Integer.parseInt(
                            JOptionPane.showInputDialog(null, jogador + ", informe a coluna desejada. \n Entre 0 e 2"));
                }

                if (matriz[coluna][linha].equals("-")) {
                    jogadaValida = true;

                    matriz[coluna][linha] = simbolo;
                } else {
                    JOptionPane.showMessageDialog(null, "Local já preenchido!");
                }

            } while (!jogadaValida);

            System.out.println("Você fez sua jogada!");

            for (int linha = 0; linha < 3; linha++) {

                for (int coluna = 0; coluna < 3; coluna++) {
                    System.out.print(matriz[coluna][linha]);
                }

                System.out.println("");
            }

            // Verifica se tem vencedor - Linha
            for (int linha = 0; linha < 3; linha++) {
                if (matriz[0][linha].equals(simbolo) && matriz[0][linha] == matriz[1][linha]
                        && matriz[2][linha] == matriz[1][linha]) {
                    if (matriz[0][linha].equals(simbolo)) {
                        System.out.println("Parabéns, você ganhou!");
                    } else {
                        System.out.println("Que pena! Mais sorte na próxima!");
                    }

                    vencedor = true;
                }
            }

            // Verifica se tem vencedor - Coluna
            for (int coluna = 0; coluna < 3; coluna++) {
                if (matriz[coluna][0].equals(simbolo) && matriz[coluna][0] == matriz[coluna][1]
                        && matriz[coluna][0] == matriz[1][2]) {
                    if (matriz[coluna][0].equals(simbolo)) {
                        System.out.println("Parabéns, você ganhou!");
                    } else {
                        System.out.println("Que pena! Mais sorte na próxima!");
                    }

                    vencedor = true;
                }
            }

            // Verifica se tem vencedor diagonal
            if (matriz[1][1].equals(simbolo) && ((matriz[0][0] == matriz[1][1] && matriz[2][2] == matriz[1][1])
                    || (matriz[2][0] == matriz[1][1] && matriz[0][2] == matriz[1][1]))) {

                if (matriz[1][1].equals(simbolo)) {
                    System.out.println("Parabéns, você ganhou!");
                } else {
                    System.out.println("Que pena! Mais sorte na próxima!");
                }

                vencedor = true;
            }

            if (!vencedor) { // computador faz a jogada
                do {
                    jogadaValida = false;

                    final int linha = aleatorio.nextInt(3);
                    final int coluna = aleatorio.nextInt(3);

                    if (matriz[linha][coluna].equals("-")) {
                        jogadaValida = true;

                        matriz[linha][coluna] = simboloComputador;
                    }

                } while (!jogadaValida);

                System.out.println("O computador fez sua jogada!");
                for (int linha = 0; linha < 3; linha++) {

                    for (int coluna = 0; coluna < 3; coluna++) {
                        System.out.print(matriz[coluna][linha]);
                    }

                    System.out.println("");
                }

                // Verifica se tem vencedor - Linha
                for (int linha = 0; linha < 3; linha++) {
                    if (matriz[1][linha].equals(simboloComputador)
                            && (matriz[0][linha] == matriz[1][linha] && matriz[2][linha] == matriz[1][linha])) {

                        if (matriz[0][linha].equals(simbolo)) {
                            System.out.println("Parabéns, você ganhou!");
                        } else {
                            System.out.println("Que pena, o computador ganhou! Mais sorte na próxima!");
                        }

                        vencedor = true;
                    }
                }

                // Verifica se tem vencedor - Coluna
                for (int coluna = 0; coluna < 3; coluna++) {
                    if (matriz[coluna][1].equals(simboloComputador)
                            && (matriz[coluna][0] == matriz[coluna][1] && matriz[coluna][0] == matriz[1][2])) {

                        if (matriz[coluna][0].equals(simbolo)) {
                            System.out.println("Parabéns, você ganhou!");
                        } else {
                            System.out.println("Que pena, o computador ganhou! Mais sorte na próxima!");
                        }

                        vencedor = true;
                    }
                }

                // Verifica se tem vencedor diagonal
                if (matriz[1][1].equals(simboloComputador)
                        && ((matriz[0][0] == matriz[1][1] && matriz[2][2] == matriz[1][1])
                                || (matriz[2][0] == matriz[1][1] && matriz[0][2] == matriz[1][1]))) {

                    if (matriz[1][1].equals(simbolo)) {
                        System.out.println("Parabéns, você ganhou!");
                    } else {
                        System.out.println("Que pena, o computador ganhou! Mais sorte na próxima!");
                    }

                    vencedor = true;
                }
            }

            jogadas++;

            if (!vencedor && jogadas < 9) {
                String scontinuar = JOptionPane.showInputDialog(null, "Deseja continuar?");
                continuar = scontinuar.toLowerCase().equals("s");
            }

        }

    }
}
