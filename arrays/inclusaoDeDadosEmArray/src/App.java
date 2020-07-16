import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String[] nome = new String[4]; // estático

        List<String> listaNomes = new ArrayList();

        listaNomes.add("Ana");
        listaNomes.add("Pedro");
        listaNomes.add(1, "Antonio");
        // Vai pegar o lugar do Pedro e o Pedro vai ser jogado para frente, no próximo
        // index disponível
        listaNomes.add(2, "Maria");

        System.out.println(listaNomes.toString()); // [Ana, Pedro]

        for (String cadaNome : listaNomes) { // Ana \n Pedro
            System.out.println(cadaNome);
        }
    }
}
