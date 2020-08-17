import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Definir o tamanho do campo de batalha (10x10 ou dinâmico);
        int campoDeBatalha[][] = new int[10][10];

        String jogador = JOptionPane.showInputDialog(null, "Digite o seu nome");
        int campoDeBatalhaJogador[][] = campoDeBatalha;
        int campoDeBatalhaComputador[][] = campoDeBatalha;

        // Variáveis de cada elemento do tabuleiro
        int agua = 0;
        int navio = -2;
        int bomba = -3;

        // Variáveis para cada ação no tabuleiro
        int tiroCerto = 1;
        int tiroBomba = 2;
        int tiroPerdido = 3;

        // Inicializar dados, mostrar tabuleiro
        for(int linha=0 ; linha < 10 ; linha++ ){
            System.out.print((linha+1)+"");
            for(int coluna=0 ; coluna < 10 ; coluna++ ){
                // seria mais interessante um switch mas aparentemente não pode usar switch para var[][]
                if(campoDeBatalhaComputador[coluna][linha] <= 0){ // Aparece água
                    System.out.print("\t"+"~");
                }else if(campoDeBatalhaComputador[coluna][linha] == 3){ // Tiro errado
                    System.out.print("\t"+"~");
                }else if(campoDeBatalhaComputador[coluna][linha] == 1){ // Acertou Navio
                    System.out.print("\t"+"X");
                }else if(campoDeBatalhaComputador[coluna][linha] == 2){ // Acertou Bomba
                    System.out.print("\t"+"B");
                }
            }
            System.out.println();
        }

        // Difinir a quantidade de elementos dentro do jogo Navios(N) e canhões(C);
        int navios = -1;
        int bombas = -1;

        while (navios <= 0 || navios > 10) {
            navios = Integer.parseInt(
                JOptionPane.showInputDialog(null, 
                "Informe a quantidade de Navios no jogo. \n No máximo 10!"
                ));
        }

        while (bombas < 0 || bombas > 10) {
            bombas = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                "Informe a quantidade de Bombas no jogo. \n No máximo 10!"
                ));
        }

        // Inserir os navios e bombas no campo JOGADOR
        for (int n = 0; n < navios; n++) {
            boolean localValido = false;
            int linha = -1;
            int coluna = -1;

            do {
                while (linha < 0 || linha > 9) {
                    linha = Integer.parseInt(
                            JOptionPane.showInputDialog(null,
                            jogador + ", vamos posicionar o NAVIO " + (n+1) + ", informe a LINHA desejada. \n Entre 1 e 10."));
                    
                    linha = linha -1;
                }
    
                while (coluna < 0 || coluna > 9) {
                    coluna = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                        jogador + ", vamos posicionar o NAVIO " + (n+1) + ", informe a COLUNA desejada. \n Entre 1 e 10."));

                    coluna = coluna -1;
                    }
    
            // Verificar se a coluna, linha já não está ocupada;
                if (campoDeBatalhaJogador[coluna][linha] == agua) {
                    localValido = true;
    
                    campoDeBatalhaJogador[coluna][linha] = navio;
                } else {
                    linha = -1;
                    coluna = -1;
                    localValido = false;
                    JOptionPane.showMessageDialog(null, "Local já preenchido!");
                }
            } while(localValido == false);

        }

        for (int b = 0; b < bombas; b++) {
            boolean localValido = true;
            int linha = -1;
            int coluna = -1;

            do {
                while (linha < 0 || linha > 9) {
                    linha = Integer.parseInt(
                            JOptionPane.showInputDialog(null,
                            jogador + ", vamos posicionar a BOMBA " + (b+1) + ", informe a LINHA desejada. \n Entre 1 e 10."));
                    
                    linha = linha -1;
                }
    
                while (coluna < 0 || coluna > 9) {
                    coluna = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                        jogador + ", vamos posicionar a BOMBA " + (b+1) + ", informe a COLUNA desejada. \n Entre 1 e 10."));

                    coluna = coluna -1;
                }
    
            // Verificar se a coluna, linha já não está ocupada;
                if (campoDeBatalhaJogador[coluna][linha] == agua) {
                    localValido = true;
    
                    campoDeBatalhaJogador[coluna][linha] = bomba;
                } else {
                    linha = -1;
                    coluna = -1;
                    localValido = false;
                    JOptionPane.showMessageDialog(null, "Local já preenchido!");
                }
            } while (localValido == false);

        }

        // Inserir os navios e bombas no campo COMPUTADOR
        for (int n = 0; n < navios; n++) {
            boolean localValido = true;
            int linha = -1;
            int coluna = -1;
            Random aleatorio = new Random();

            do {
                linha = aleatorio.nextInt(10);
                coluna = aleatorio.nextInt(10);
    
            // Verificar se a coluna, linha já não está ocupada;
                if (campoDeBatalhaComputador[coluna][linha] == agua) {
                    localValido = true;
    
                    campoDeBatalhaComputador[coluna][linha] = navio;
                } else {
                    linha = -1;
                    coluna = -1;
                    localValido = false;
                }
            } while (localValido == false);

        }

        for (int b = 0; b < bombas; b++) {
            boolean localValido = true;
            int linha = -1;
            int coluna = -1;
            Random aleatorio = new Random();

            do {
                linha = aleatorio.nextInt(10);
                coluna = aleatorio.nextInt(10);
    
            // Verificar se a coluna, linha já não está ocupada;
                if (campoDeBatalhaComputador[coluna][linha] == agua) {
                    localValido = true;
    
                    campoDeBatalhaComputador[coluna][linha] = bomba;
                } else {
                    linha = -1;
                    coluna = -1;
                    localValido = false;
                }
            } while (localValido == false);

        }

        // Definir a quantidade de turnos
        int jogadas = 0;
        while (jogadas < 5 || jogadas > 10) {
            jogadas = Integer.parseInt(
                JOptionPane.showInputDialog(null, 
                "Informe a quantidade de jogadas. \n Entre 5 e 10!"
                ));
        }       

        // Iniciar jogo - começa pelo usuário;

        int disparosRestantes = jogadas;
        boolean vencedor = false;
        boolean jogadaValida = false;
        boolean localValido = false;
        int pontosJogador = 0;
        int pontosComputador = 0;
        
        while (jogadas > 0) {
            // Jogada Jogador
            do {
                int linha = -1;
                int coluna = -1;

                // Faz a jogada
                while (linha < 0 || linha > 9) {
                    linha = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                null, jogador + ", informe a linha desejada. \n Entre 1 e 10."
                                ));
                    linha = linha -1;
                }

                while (coluna < 0 || coluna > 9) {
                    coluna = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                null, jogador + ", informe a coluna desejada. \n Entre 1 e 10"
                                ));
                    coluna = coluna -1;
                }

                // Valida a jogada
                if (campoDeBatalhaComputador[coluna][linha] <= 0) {
                    localValido = true;
                    jogadas--;

                    if (campoDeBatalhaComputador[coluna][linha] == agua) {
                        campoDeBatalhaComputador[coluna][linha] = 3;

                        System.out.println("Tiro na água!");
                    } else if(campoDeBatalhaComputador[coluna][linha] == navio) {
                        campoDeBatalhaComputador[coluna][linha] = 1;

                        System.out.println("Você acertou!");

                        pontosJogador++;
                        } else {
                            campoDeBatalhaComputador[coluna][linha] = 2;

                            System.out.println("Vish! Acertou uma bomba! ");

                            pontosJogador--;
                        }

                } else {
                    localValido = false;
                    linha = -1;
                    coluna = -1;
                    JOptionPane.showMessageDialog(null, "Esse local já foi destruído! Jogue novamente.");
                }
            } while (localValido == false);

            if (jogadas > 1) {
                JOptionPane.showMessageDialog(null, 
                    "Você ainda possui " + jogadas + " jogadas. Boa sorte!"
                );
            }
            // lógica para checar se tem vencedor;
        }
    

    }
}


        // Sistema de pontos, cada navio gera um ponto;
        // Cada jogada retorna um alerta e a matriz novamente?
            // após o tiro ser dado, o tabuleiro é alterado, mostrando o tiro que foi dado(se acertou ou errou)
        // Ao final das jogadas retornar um resumo das jogas (disparos, erros, acertos, pontos);
            // Armazenar esses tiros em um array de resultado?
        // Listar todas as posições e quipamentos que não foram atingidos
