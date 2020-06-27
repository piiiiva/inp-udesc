import javax.swing.JOptionPane;

/**
 * Exercicio3 Desenvolva um algoritmo que permita ao usuário incrementar um
 * valor numérico em uma sequência, definindo a escala de incremento. Por
 * exemplo, quero listar os números entre 0 e 10 incrementando de 5 em 5.
 */
public class Exercicio3 {

    public static void main(String[] args) {

        String totalNumeros = JOptionPane.showInputDialog(null, "Digite o valor máximo da verificação!");
        int numero = 0;
        int varControle = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor do incremento"));

        while (numero <= Integer.parseInt(totalNumeros)) {
            System.out.println("O número agora é: " + numero);

            numero = numero + varControle;
        }
    }
}