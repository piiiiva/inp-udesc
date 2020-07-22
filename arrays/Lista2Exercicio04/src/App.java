import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class App {
    /*
    Escrever um algoritmo que leia e armazene em uma estrutura de array, o
    nome de um funcionário, o número de horas trabalhadas, o valor que
    recebe por hora e o número de filhos. Com estas informações, calcular o
    salário deste funcionário, sabendo que para cada filho, o funcionário
    recebe 3% a mais, calculado sobre o salário bruto. Após digitar as
    informações para um funcionário, o programa deverá dar ao usuário a
    opção de digitar os dados de outro funcionário. Após digitar os dados,
    listar o nome, valor hora, horas trabalhadas, salario, número de filhos
    salário após acrescentar percentual pelo número de filhos (3 pontos). 
     */
    public static void main(String[] args) throws Exception {
        List<String> listaNome = new ArrayList();
        List<Float> listaHorasTrabalhadas = new ArrayList();
        List<Float> listaValorHoraTrabalhada = new ArrayList(); // Nesse caso todos os funcionários serão iguais
        List<Integer> listaNumeroDeFilhos = new ArrayList();

        int inserirNovoFuncionário = 0;

        while (inserirNovoFuncionário != 1) {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário:");
            Float horasTrabalhadas = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas:").replaceAll(",", "."));
            Float valorHoraTrabalhada = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor da hora trabalhada:").replaceAll(",", "."));
            int numeroDeFilhos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de filhos do funcionário:"));

            listaNome.add(nome);
            listaHorasTrabalhadas.add(horasTrabalhadas);
            listaValorHoraTrabalhada.add(valorHoraTrabalhada);
            listaNumeroDeFilhos.add(numeroDeFilhos);

            inserirNovoFuncionário = JOptionPane.showConfirmDialog(null, "Deseja inserir um novo funcionário?", "Continuação", JOptionPane.YES_NO_OPTION);
        }

        for (int i = 0; i < listaNome.size(); i++) {
            Float salarioBase = listaHorasTrabalhadas.get(i) *listaValorHoraTrabalhada.get(i);
            Float salarioFamilia = 0F;
            
            System.out.println("Nome: " + listaNome.get(i));
            System.out.println("Valor Hora Trabalhada: R$ " + listaValorHoraTrabalhada.get(i));
            System.out.println("Horas Trabalhadas: " + listaHorasTrabalhadas.get(i));
            
            if (listaNumeroDeFilhos.get(i) != 0) {
                Float acrescimo = 0.03F;
                salarioFamilia = (listaNumeroDeFilhos.get(i) * acrescimo) * salarioBase;
                System.out.println("Salário Base: R$ " + salarioBase);
                System.out.println("Número de Filhos: " + listaNumeroDeFilhos.get(i));
            }
            
            Float salarioTotal = salarioBase + salarioFamilia;

            System.out.println("Salário Total: R$ " + salarioTotal);
            System.out.println("--------------------------------");

        }

    }
}
