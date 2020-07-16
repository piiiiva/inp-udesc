import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String[] nome = new String[4]; // estático

        List<String> listaNomes = new ArrayList(); // sem limite

        listaNomes.add("Ana");
        listaNomes.add("Pedro");
        listaNomes.add(1, "Antonio");
        // Vai pegar o lugar do Pedro e o Pedro vai ser jogado para frente, no próximo
        // index disponível
        listaNomes.add(2, "Maria");

        // Listar todos os dados
        int tamanho = listaNomes.size();
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Nome[" + i + "] " + listaNomes.get(i));
        }

        // REMOVER DADOS DA LISTA
        System.out.println("-----------------");
        // remove() aceita uma como parâmetro um objeto -> que retorna um boolean
        System.out.println("Remove funcionou: " + listaNomes.remove("Maria"));

        System.out.println("-----------------");
        // remove() pode aceitar como parâmetro um index que retorna o próprio objeto
        // excluido
        System.out.println("Remove funcionou: " + listaNomes.remove(1));

        System.out.println("-----------------");
        System.out.println(listaNomes.toString()); // [Ana, Pedro]
        System.out.println("-----------------");

        for (String cadaNome : listaNomes) { // Ana \n Pedro
            System.out.println(cadaNome);
        }

        // Os ArrayList possuem vários métodos
        // método contains
        System.out.println(listaNomes.contains("Ana")); // true
        System.out.println(listaNomes.contains("Rodrigo")); // false

        // Podemos usar o contais para criar uma condição e cadastrar
        // apenas um nome que não exista na lista, para que não tenhamos
        // nomes repitidos. Nesse caso poderiamos passar cada novo nome
        // para uma variável e depois colocar dentro de contais para verificar
        if (!listaNomes.contains("Ana")) {
            listaNomes.add("Ana");
        }

        if (!listaNomes.contains("Rodrigo")) {
            listaNomes.add("Rodrigo");
        }

        System.out.println("-----------------");
        System.out.println(listaNomes.toString()); // [Ana, Pedro, Rodrigo]

    }
}
