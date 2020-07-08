import javax.swing.JOptionPane;

public class App {
    /*
     * Escrever um algoritmo que lê o nome de um funcionário, o número de horas
     * trabalhadas, o valor que recebe por hora e o número de filhos. Com estas
     * informações, calcular o salário deste funcionário, sabendo que para cada
     * filho, o funcionário recebe 3% a mais, calculado sobre o salário bruto. Após
     * digitar as informações para um funcionário, o programa deverá dar ao usuário
     * a opção de digitar os dados de outro funcionário. (3 pontos).
     */
    public static void main(String[] args) {
        Integer cadastrarFuncionario = 0;

        while (cadastrarFuncionario != 1) {
            String nome = JOptionPane.showInputDialog(null, "Nome do funcionário");
            float horasTrabalhadas = Float
                    .parseFloat(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas"));
            float valorHoraTrabalhada = Float
                    .parseFloat(JOptionPane.showInputDialog(null, "Digite o valor da hora trabalhada"));
            int filhos = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de filhos do funcionário"));
            float aumento = 1 + (float) (filhos * 0.03);
            float salario = 0F;

            if (filhos > 0) {
                salario = (horasTrabalhadas * valorHoraTrabalhada) * aumento;
            } else {
                salario = horasTrabalhadas * valorHoraTrabalhada;
            }

            System.out.println("Nome: " + nome);
            System.out.println("Salário: " + salario);

            cadastrarFuncionario = JOptionPane.showConfirmDialog(null, "Deseja continuar cadastrando?",
                    "Selecione uma opção", JOptionPane.YES_NO_OPTION);
        }

        System.out.println("Todos os registros foram cadastrados com sucesso");
    }
}
