
/**
 * Exercicio2 Desenvolva um algoritmo que permita ao usuário verificar se uma
 * sequência (de 0 a 100 por exemplo) de números são pares ou impares.
 */
public class Exercicio2 {
    public static void main(String[] args) {

        int variavel = 0;

        while (variavel <= 100) {
            if (variavel % 2 == 0) {
                System.out.println(variavel + " é par.");
            } else {
                System.out.println(variavel + " é impar.");
            }

            variavel++;
        }
    }
}