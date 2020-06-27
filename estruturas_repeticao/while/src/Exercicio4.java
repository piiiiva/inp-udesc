import javax.swing.JOptionPane;

/**
 * Desenvolva um algoritmo para calcular o total de uma compra.
 * Deverá ser informado a descrição do produto, o preço e a quantidade de cada item.
 * A quantidade de itens a serem cadastrados deve ser informada pelo usuário.
 */

public class Exercicio4 {
    public static void main(String[] args) {
        String itensParaCadastrar = JOptionPane.showInputDialog(null, "Digite a quantidade de items!");
        int totalItens = Integer.parseInt(itensParaCadastrar);
        int item = 0;
        float total = 0;
        String descricaoItem = "";
        float totalItem = 0;
        float valor = 0;

        while (item <= totalItens - 1) {
            descricaoItem = JOptionPane.showInputDialog(null, "Informe o nome ou descrição básica do item!");
            valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor unitário de cada item")); 
            int quantidadeItem = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade para esse item"));
            
            totalItem = valor * quantidadeItem;

            total += totalItem; 

            System.out.println("Item: " + descricaoItem);
            System.out.println("Quantidade: " + quantidadeItem);
            System.out.println("Total: " + totalItem);

            item ++;
        };

        System.out.println("Total da Compra: " + total);

    }
}