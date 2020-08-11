import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Criar o array dinâmicos, as listas
        List<String> nomes = new ArrayList<>();
        List<Integer> idades = new ArrayList<>();

        // Inserir dados nas lista
        String continuar = "s"; // Precisamos criar uma mecânica para conitnuar inserindo dados

        while (continuar.equals("s")) {
            nomes.add(JOptionPane.showInputDialog(null, "Digite o nome"));
            idades.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade")));

            continuar = JOptionPane
                .showInputDialog(null, "Deseja continuar? s-sim")
                .toLowerCase();
        }

        int tamanhoLista = nomes.size();

        for(int i = 0; i < tamanhoLista; i++) {
            System.out.println(nomes.get(i) + " você tem " + idades.get(i) + " anos de idade");
        }
    }
}
