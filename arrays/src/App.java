
public class App {
    public static void main(String[] args) throws Exception {
        int[] a;
        a = new int[3]; // precisa definir um tamanho para o array
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;

        for (int i : a) {
            System.out.println("Valor de a: " + i);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println("Valor de (a) usando for: " + a[i]);
        }

        System.out.println("Tamanho do array: " + a.length);
        // se o tamanho do vetor for maior que a quantidade de itens
        // com valores declarados, vai retornar 0 para os itens sem valor atribuído.
    }
}
