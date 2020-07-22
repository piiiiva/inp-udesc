import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    /*
    Faça um algoritmo que lê 3 notas de um aluno e seu percentual de
    frequência. O algoritmo deverá calcular a média do aluno, e a sua
    condição. Para que o aluno esteja na condição de APROVADO ele deverá
    ter média igual ou superior a 7 e frequência mínima de 75%. Considere
    que a frequência deve ser um valor inteiro, enquanto que a nota pode ser
    qualquer valor entre 0 e 10. O usuário precisa informar quantos alunos
    tem na turma e, portanto, deve ser realizada a digitação para todos os
    alunos da turma. O nome, média, frequência e situação devem ser
    armazenadas em vetor. Após a digitação os dados devem ser listados (3
    pontos). 
    */
    public static void main(String[] args) throws Exception {
        List<String> listaNome = new ArrayList();
        List<Float> listaMedia = new ArrayList();
        List<Integer> listaFrequencia = new ArrayList();
        List<String> listaSituacao = new ArrayList();

        int alunos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de alunos:"));
        int avaliacoes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de avaliações:"));


        for (int i = 0; i < alunos; i++) {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno " + (i+1) + " :");
            int frequencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a frequencia do aluno (número inteiro):"));
            
            Float media = 0F;
            Float notas = 0F;
            for (int j = 0; j < avaliacoes; j++) {
                Float nota = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a nota " + (j+1) + " do aluno:").replaceAll(",", "."));
                
                notas = notas + nota;
                media = notas / avaliacoes;
            }

            listaNome.add(nome);
            listaMedia.add(media);
            listaFrequencia.add(frequencia);

            if (media >= 7 && frequencia >= 75) {
                listaSituacao.add("APROVADO");
            } else {
                listaSituacao.add("REPROVADO");
            }
        }

        for (int i = 0; i < listaNome.size(); i++) {
            System.out.println("Nome: " + listaNome.get(i));
            System.out.println("Média: " + listaMedia.get(i));
            System.out.println("Frequência: " + listaFrequencia.get(i));
            System.out.println("Situação: " + listaSituacao.get(i));
            System.out.println("--------------------------");
        }

    }
}
