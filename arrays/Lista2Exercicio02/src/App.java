import javax.swing.JOptionPane;

public class App {
/*
Faça um algoritmo que armazene em um vetor 5 números inteiros
informado pelo usuário. Após o preenchimento do array, solicite ao
usuário um número inteiro entre 1 e 10. Multiplique o valor informado pelo
usuário por cada número armazenado no vetor. Listar o vetor informado,
e o vetor após a operação de multiplicação (1 ponto) 
*/
    public static void main(String[] args) throws Exception {
        int[] numeros = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número"));
        }

        int multiplica = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor que você quer multiplicar entre 1 e 10:"));
        
        System.out.println("Vetor antes da multiplicação");
        for (int numero : numeros) {
            System.out.println(numero);
        }
        System.out.println("----------------------");

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = numeros[i] *multiplica;
        }

        System.out.println("Vetor depois da multiplicação");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        /*
        Alterei o mesmo vetor porque foi assim que entendi quer era o exercício,
        Se precisasse armazenar o valor multiplicado em um novo vetor eu criaria
        um novo vetor int numerosMultiplicados[] = new int[5] e reservaria a mesma
        quantidade de espaço. Posteriormente faria um laço for tradicional definindo
        o valor de cada elemento como numerosMultiplicados[i] = numeros[i] * multiplica.
        ou algo nesse sentido.
        
        int numerosMultiplicados[] = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            numerosMultiplicados[i] = numeros[i] *multiplica;
        }

        for (int numeroMultiplicado : numerosMultiplicados) {
            System.out.println(numeroMultiplicado);
        }
        */

    }

}
