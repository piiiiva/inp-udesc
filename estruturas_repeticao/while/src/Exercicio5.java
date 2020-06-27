import javax.swing.JOptionPane;

/**
 * esenvolva um algoritmo para calcular o total de uma compra.
 * Deverá ser informado a descrição do produto, o preço e a quantidade de cada item.
 * Quando o valor do itemfor acima de R$ 10,00 aplique um desconto de 5%.
 * A cada ciclo, deve ser solicitado ao usuário se deseja inserir novo item.
 */

public class Exercicio5 {
    public static void main(String[] args) {
        float total = 0;
        String descricaoItem = "";
        float totalItem = 0;
        float valor = 0;
        int adicionarItem = 0;

        do {
            descricaoItem = JOptionPane.showInputDialog(null, "Informe o nome ou descrição básica do item!");
            valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor unitário de cada item")); 
            int quantidadeItem = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade para esse item"));
            
            if (valor >= 10) {
               valor = valor * 0.95F;
            };

            totalItem = valor * quantidadeItem;
    
            total += totalItem; 
    
            System.out.println("Item: " + descricaoItem);
            System.out.println("Quantidade: " + quantidadeItem);
            System.out.println("Total: " + totalItem);
    
            adicionarItem = JOptionPane.showConfirmDialog(null, "Deseja continuar comprando?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);

        } while (adicionarItem == 0);

        System.out.println("Total da Compra: " + total);

    }
}