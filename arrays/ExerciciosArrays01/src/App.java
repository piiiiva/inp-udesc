import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String[] nomes = new String[2];
        Float[] medias = new Float[2];
        String[] situacaoAluno = new String[2];

        Float[] notas = new Float[3];

        int tamanhoArray = nomes.length;
        int variavelControle = 0;

        while (variavelControle < tamanhoArray) {

            nomes[variavelControle] = JOptionPane.showInputDialog(null, "Digite o nome");

            float somaNotas = 0F;
            int notasVariavelControle = 0;

            while (notasVariavelControle < notas.length) {
                float nota = Float.parseFloat(JOptionPane.showInputDialog(null, "Digita a nota do aluno"));
                somaNotas += nota;

                notasVariavelControle++;
            }

            float media = (float) somaNotas / notas.length;

            medias[variavelControle] = media;

            if (media < 7) {
                situacaoAluno[variavelControle] = "REPROVADO";
            } else {
                situacaoAluno[variavelControle] = "APROVADO";
            }

            variavelControle++;
        }

        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Nome: " + nomes[i]);
            System.out.println("Média: " + medias[i]);
            System.out.println("Situação: " + situacaoAluno[i]);
            System.out.println("-----------------------------");
        }
    }
}
