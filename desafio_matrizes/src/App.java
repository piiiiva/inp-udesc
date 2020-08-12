import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String matriz[][] = new String[3][3];

        // Inicializar dados

        for(int linha = 0; linha < 3; linha++) {
            for(int coluna = 0; coluna < 3; coluna++) {
                matriz[linha][coluna] = "-";
            }
        }

        // Listar os dados da matriz
    
        boolean continuar = true;
        while(continuar) {
            String simbolo = JOptionPane.showInputDialog(null, "informe o símbolo");
            int linha = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a linha"));
            int coluna = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a coluna"));
            
           if (matriz[linha][coluna].equals("-")) {

               matriz[linha][coluna] = simbolo;
           } else {
               JOptionPane.showMessageDialog(null, "Local já preenchido!");
           }

            String scontinuar = JOptionPane.showInputDialog(null, "Deseja continuar?");
            continuar = scontinuar.toLowerCase().equals("s");
        }

        for (int linha = 0; linha < 3; linha++) {
            for(int coluna = 0; coluna < 3; coluna++) {
                System.out.print(matriz[coluna][linha]);
            }

            System.out.println("");
        }
    }
}
