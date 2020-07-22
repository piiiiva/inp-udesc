import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int tamanhoArray = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de alunos"));

        String[] nomesArr = new String[tamanhoArray];

        for (int i = 0; i < nomesArr.length; i++) {
            nomesArr[i] = JOptionPane.showInputDialog(null, "Digite o nome do aluno");
        }

        for (String nome : nomesArr) {
            System.out.println(nome);
        }
    }
}
