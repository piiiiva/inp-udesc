import javax.swing.JOptionPane;

public class MaisArray {
    public static void main(String[] args) throws Exception {
        int[] numeros = new int[7];
        int tamanhoVetor = numeros.length;

        for(int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Informe números")
            );
        }

        // // Listar os dados do vetor

        // while (tamanhoVetor > 0) {
        //     tamanhoVetor --;
        //     System.out.println("Número["+tamanhoVetor+"]" + numeros[tamanhoVetor]);
        // };

        // System.out.println("-----------------");

        // tamanhoVetor = numeros.length;

        // int controle = 0;
        // while (controle < tamanhoVetor) {
        //     System.out.println("Número["+controle+"]" + numeros[controle]);
        //     controle++;
        // }


        // Copiar os dados do vetor numero e inserir no vetor copiaNumeros a ordem inversa
        int[] copiaNumeros = new int[numeros.length];

        int controleVetor = tamanhoVetor-1;
        int controleCopia = 0;

        while (controleCopia < tamanhoVetor) {
            copiaNumeros[controleCopia] = numeros[controleVetor];

            controleVetor--;
            controleCopia++;
        }

        // listar primero vetor
        for (int numero : numeros) {
            System.out.println("Número " + numero);
        }

        System.out.println("----Cópia----");
        for (int numero : copiaNumeros) {
            System.out.println("Número " + numero);
        }

    }
}
