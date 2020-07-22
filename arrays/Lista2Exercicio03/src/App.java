import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    /*
    Criar um algoritmo que solicita ao usuário a descrição do produto, o preço
    unitário e a quantidade. Armazenar os dados em estrutura de array. O
    usuário deverá decidir se deseja inserir mais produtos. Após a inserção
    dos dados deverá ser listado os dados mostrando a descrição produto, a
    quantidade, o preço e o subtotal (quantidade*preço) (2 pontos). 
    */
    public static void main(String[] args) throws Exception {
        
        List<String> listaDescricao = new ArrayList();
        List<Float> listaPreco = new ArrayList();
        List<Integer> listaQuantidade = new ArrayList();

        int inserirProdutos = 0;

        while (inserirProdutos != 1) {
            String descricao = JOptionPane.showInputDialog(null, "Insira a descrição do produto:");
            Float preco = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o valor unitário do produto:").replaceAll(",", "."));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade do produto:"));

            listaDescricao.add(descricao);
            listaPreco.add(preco);
            listaQuantidade.add(quantidade);

            inserirProdutos = JOptionPane.showConfirmDialog(null, "Deseja inserir mais produtos?", "Confirmação", JOptionPane.YES_NO_OPTION);
        }

        for (int i = 0; i < listaDescricao.size(); i++) {
            Float subtotal = listaPreco.get(i) * listaQuantidade.get(i);

            System.out.println("Descrição: " + listaDescricao.get(i));
            System.out.println("Preço: " + listaPreco.get(i));
            System.out.println("Quantidade: " + listaQuantidade.get(i));
            System.out.println("Subtotal: " + subtotal);
            System.out.println("----------------------------");
        }
    }
}
