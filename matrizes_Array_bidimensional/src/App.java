public class App {
    // Em uma matriz 5x4 popular todos pontos
    // 00000
    // 11111
    // 22222
    // 33333
    public static void main(String[] args) throws Exception {
        int[][] numeros = new int[5][4];

        for (int linha = 0; linha < 4; linha++) {
            for(int coluna = 0; coluna < 5; coluna++) {
                numeros[coluna][linha] = linha;
            }
        }

        for (int linha = 0; linha < 4; linha++) {
            System.out.println("");
            for(int coluna = 0; coluna < 5; coluna++) {
                System.out.print(numeros[coluna][linha]);
            }
        }
    }
}
