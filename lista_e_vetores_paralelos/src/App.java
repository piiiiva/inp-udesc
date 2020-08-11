import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Criar vetor estático
        int tamanho = 3;

        String[] nomes = new String[tamanho];
        int[] idades = new int[tamanho];

        for(int i = 0; i < tamanho; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "Informe o nome");
            idades[i] = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Informe a idade"));
        }

        // Listar vetor estático
        for(int i = 0; i < tamanho; i++) {
            System.out.println(nomes[i] + " você tem " + idades[i] + " anos de idade");
        }
    }
}
