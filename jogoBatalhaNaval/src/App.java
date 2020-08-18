import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    /**
     * Para listar o resumo da jogadas tentei fazer meio visual pelo terminal.
     * Testei o máximo que deu.
     * Tentei usar o switch case para não fazer muito ifelse mas não consegui.
     * Deixei tudo dentro da main, não deu tempo de refatorar, criar classes 
     * e métodos separados, deixar um pouco mais dinânmico.
     * Não fiz um try catch então se digitar uma string
     *  no lugar de int ou um valor null vai quebrar.
     */
    public static void main(String[] args) throws Exception {
        // Definir o tamanho do campo de batalha (10x10 ou dinâmico);

        String jogador = JOptionPane.showInputDialog(null, "Digite o seu nome");
        int tamanhoColunas = 10;
        int tamanhoLinhas = 10;

        int campoDeBatalhaJogador[][] = new int[tamanhoColunas][tamanhoLinhas];
        int campoDeBatalhaComputador[][] = new int[tamanhoColunas][tamanhoLinhas];

        // Variáveis de cada elemento do tabuleiro
        int agua = 0;
        int navio = -2;
        int canhao = -3;

        // Variáveis para cada ação no tabuleiro
        int tiroNavio = 1;
        int tiroCanhao = 2;
        int tiroPerdido = 3;

        // Inicializar dados, mostrar tabuleiro
        System.out.print(
            "\t"+"1"+"\t"+"2"+"\t"+"3"+"\t"+"4"+"\t"+"5"+"\t"+"6"+"\t"+"7"+"\t"+"8"+"\t"+"9"+"\t"+"10"+"\n");

        for(int linha=0 ; linha < 10 ; linha++ ){
            System.out.print((linha+1)+"");
            for(int coluna=0 ; coluna < 10 ; coluna++ ){
                // seria mais interessante um switch mas aparentemente não pode usar switch para var[][]
                if(campoDeBatalhaComputador[coluna][linha] <= 0){ // Aparece água
                    System.out.print("\t"+"~");
                }else if(campoDeBatalhaComputador[coluna][linha] == 3){ // Tiro errado
                    System.out.print("\t"+"*");
                }else if(campoDeBatalhaComputador[coluna][linha] == 1){ // Acertou Navio
                    System.out.print("\t"+"O");
                }else if(campoDeBatalhaComputador[coluna][linha] == 2){ // Acertou Canhao
                    System.out.print("\t"+"o");
                }
            }
            System.out.println();
        }

        // Difinir a quantidade de elementos dentro do jogo Navios(N) e canhões(C);
        int navios = -1;
        int canhoes = -1;

        while (navios <= 0 || navios > 10) {
            navios = Integer.parseInt(
                JOptionPane.showInputDialog(null, 
                "Informe a quantidade de Navios no jogo. \n No máximo 10!"
                ));
        }

        while (canhoes < 0 || canhoes > 10) {
            canhoes = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                "Informe a quantidade de Canhões no jogo. \n No máximo 10!"
                ));
        }

        // Inserir os navios e canhoes no campo JOGADOR
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

        for (int b = 0; b < canhoes; b++) {
            boolean localValido = true;
            int linha = -1;
            int coluna = -1;

            do {
                while (linha < 0 || linha > 9) {
                    linha = Integer.parseInt(
                            JOptionPane.showInputDialog(null,
                            jogador + ", vamos posicionar a Canhao " + (b+1) + ", informe a LINHA desejada. \n Entre 1 e 10."));
                    
                    linha = linha -1;
                }
    
                while (coluna < 0 || coluna > 9) {
                    coluna = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                        jogador + ", vamos posicionar a Canhao " + (b+1) + ", informe a COLUNA desejada. \n Entre 1 e 10."));

                    coluna = coluna -1;
                }
    
            // Verificar se a coluna, linha já não está ocupada;
                if (campoDeBatalhaJogador[coluna][linha] == agua) {
                    localValido = true;
    
                    campoDeBatalhaJogador[coluna][linha] = canhao;
                } else {
                    linha = -1;
                    coluna = -1;
                    localValido = false;
                    JOptionPane.showMessageDialog(null, "Local já preenchido!");
                }
            } while (localValido == false);

        }

        // Inserir os navios e canhoes no campo COMPUTADOR
        for (int n = 0; n < navios; n++) {
            boolean localValido = true;
            int linha = -1;
            int coluna = -1;
            Random aleatorio = new Random();

            do {
                linha = aleatorio.nextInt(tamanhoLinhas);
                coluna = aleatorio.nextInt(tamanhoColunas);
    
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

        for (int b = 0; b < canhoes; b++) {
            boolean localValido = true;
            int linha = -1;
            int coluna = -1;
            Random aleatorio = new Random();

            do {
                linha = aleatorio.nextInt(tamanhoLinhas);
                coluna = aleatorio.nextInt(tamanhoColunas);
    
            // Verificar se a coluna, linha já não está ocupada;
                if (campoDeBatalhaComputador[coluna][linha] == agua) {
                    localValido = true;
    
                    campoDeBatalhaComputador[coluna][linha] = canhao;
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
        boolean vencedor = false;
        boolean localValido = false;
        int pontosJogador = 0;
        int pontosComputador = 0;
 
        List<Integer> disparosJogador = new ArrayList();
        List<Integer> disparosComputador = new ArrayList();
        
        

        while (jogadas > 0) {
            // Jogada Jogador
            do {
                int linha = -1;
                int coluna = -1;

                // Faz a jogada
                while (linha < 0 || linha > (tamanhoLinhas - 1)) {
                    linha = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                null, jogador + ", informe a linha desejada. \n Entre 1 e 10."
                                ));
                    linha = linha -1;
                }

                while (coluna < 0 || coluna > (tamanhoColunas - 1)) {
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

                        System.out.println("Boa! Você acertou um Navio inimigo! + 2pt");

                        pontosJogador = pontosJogador + 2;
                        } else {
                            campoDeBatalhaComputador[coluna][linha] = 2;

                            System.out.println("Boa! Acertou um Canhao inimgo! + 1pt");

                            pontosJogador++;
                        }

                        disparosJogador.add(campoDeBatalhaComputador[coluna][linha]);

                } else {
                    localValido = false;
                    linha = -1;
                    coluna = -1;
                    JOptionPane.showMessageDialog(null, "Esse local já foi destruído! Jogue novamente.");
                }
            } while (localValido == false);

            // Verifica Vencedor
            if (pontosJogador == (navios * 2) + (canhoes)) {
                vencedor = true;

                break;
            }

            // Jogada Computador
            do {
                Random aleatorio = new Random();
                int linha = -1;
                int coluna = -1;

                linha = aleatorio.nextInt(tamanhoLinhas);
                coluna = aleatorio.nextInt(tamanhoColunas);

                if (campoDeBatalhaJogador[coluna][linha] <= 0) {
                    localValido = true;

                    if (campoDeBatalhaJogador[coluna][linha] == agua) {
                        campoDeBatalhaJogador[coluna][linha] = 3;

                        System.out.println("O computador errou o tiro!");
                    } else if(campoDeBatalhaJogador[coluna][linha] == navio) {
                        campoDeBatalhaJogador[coluna][linha] = 1;

                        System.out.println("O computador afundou um navio seu!");

                        pontosComputador = pontosComputador + 2;
                        } else {
                            campoDeBatalhaJogador[coluna][linha] = 2;

                            System.out.println("O computador acertou uma Canhao! ");

                            pontosComputador++;
                        }

                    disparosComputador.add(campoDeBatalhaJogador[coluna][linha]);

                } else {
                    localValido = false;
                    linha = -1;
                    coluna = -1;
                }
    
            
            } while (localValido == false);


            if (jogadas > 1) {
                JOptionPane.showMessageDialog(null, 
                    "Sua vez novamente! Você ainda possui " + jogadas + " jogadas. Boa sorte!"
                );
            }
            
            
            if (pontosComputador == (navios * 2) + (canhoes)) {
                vencedor = true;

                break;
            }

        }

        // Ao final das jogadas retornar um resumo das jogas (disparos, erros, acertos, pontos) 
        // e listar equipamentos não desctruidos;

        System.out.print("\n"+ "\t" + "\t" + "\t" + "CONFIRA O RESUMO DAS SUAS JOGADAS" + "\n");

        System.out.print(
            "\t"+"1"+"\t"+"2"+"\t"+"3"+"\t"+"4"+"\t"+"5"+"\t"+"6"+"\t"+"7"+"\t"+"8"+"\t"+"9"+"\t"+"10"+"\n");

        for(int linha=0 ; linha < 10 ; linha++ ){
            System.out.print((linha+1)+"");
            for(int coluna=0 ; coluna < 10 ; coluna++ ){
                if(campoDeBatalhaComputador[coluna][linha] == agua){ // Aparece água
                    System.out.print("\t"+"~");
                }else if(campoDeBatalhaComputador[coluna][linha] == navio){ // Aparece Navio
                    System.out.print("\t"+"N");
                }else if(campoDeBatalhaComputador[coluna][linha] == canhao){ // Acertou Canhao
                    System.out.print("\t"+"C");
                }else if(campoDeBatalhaComputador[coluna][linha] == tiroPerdido){ // Tiro errado
                    System.out.print("\t"+"*");
                }else if(campoDeBatalhaComputador[coluna][linha] == tiroNavio){ // Acertou Navio
                    System.out.print("\t"+"O");
                }else if(campoDeBatalhaComputador[coluna][linha] == tiroCanhao){ // Acertou Canhao
                    System.out.print("\t"+"o");
                }
            }
            System.out.println();
        }

        System.out.println("~ = Água"+"\n"+
                            "N = Navio"+"\n"+
                            "C = Canhão"+"\n"+
                            "o = Acertou canhão"+"\n"+
                            "O = Acertou navio"+"\n"+
                            "* = Errou o tiro"+"\n");
        
        
        int naviosDestruidos = 0;
        int canhoesDestruidos = 0;
        int disparosErrados = 0;

        for (Integer disparo : disparosJogador) {
            if (disparo == tiroNavio) {
                naviosDestruidos++;
            }

            if (disparo == tiroCanhao) {
                canhoesDestruidos++;
            }

            if (disparo == tiroPerdido) {
                disparosErrados++;
            }
        }

        System.out.println("Jogador errou " + disparosErrados + " disparos.");
        System.out.println("Jogador destruiu " + naviosDestruidos + " navios. -- + " + (naviosDestruidos * 2) + " pts.");
        System.out.println("Jogador destruiu " + canhoesDestruidos + " canhões. -- + " + (canhoesDestruidos * 2) + " pts.");
        System.out.println("Total de pontos Jogador = " + pontosJogador);
        System.out.println("");


        naviosDestruidos = 0;
        canhoesDestruidos = 0;
        disparosErrados = 0;

        for (Integer disparo : disparosComputador) {
            if (disparo == tiroNavio) {
                naviosDestruidos++;
            }

            if (disparo == tiroCanhao) {
                canhoesDestruidos++;
            }

            if (disparo == tiroPerdido) {
                disparosErrados++;
            }
        }

        System.out.println("Computador errou " + disparosErrados + " disparos.");
        System.out.println("Computador destruiu " + naviosDestruidos + " navios. -- + " + (naviosDestruidos * 2) + " pts.");
        System.out.println("Computador destruiu " + canhoesDestruidos + " canhões. -- + " + (canhoesDestruidos * 2) + " pts.");
        System.out.println("Total de pontos Computador = " + pontosComputador);

        // Verifica vencedor geral;
        if (vencedor == false) {
            if (pontosJogador < pontosComputador) {
                System.out.println(jogador + ", infelizmente você perdeu. Mais sorte na próxima!");
            } else if (pontosJogador == pontosComputador) {
                System.out.println("Foi muito disputado, temos um empate!");
            } else {
                System.out.println(jogador + ", você ganhou. PARABÉNS!");
            }
        }

        if (vencedor == true) {
            if (pontosJogador < pontosComputador) {
                System.out.println(jogador + ", infelizmente você perdeu. Mais sorte na próxima!");
            } else {
                System.out.println(jogador + ", você ganhou. PARABÉNS!");
            }
        }
    

    }
}

