public class App {
    public static void main(String[] args) throws Exception {
        float quantidade = 10;
        float preco = 20;
        int x = 10;

        soma(quantidade, preco, "batata");
        
        System.out.println("X = " + x);
        incrementa(x);
        System.out.println("X = " + x);

    }

    public static void incrementa (int x) {
        x++;
        System.out.println("Xdentro = " + x);
    }

    public static void soma(float n1, float n2, String item) {
        float resultado = n1 + n2;
        System.out.println("Soma " + resultado);
        System.out.println("Item " + item);
    }
}
