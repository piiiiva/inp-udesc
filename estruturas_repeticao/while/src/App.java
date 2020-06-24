import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String quantidadeNotas = JOptionPane.showInputDialog(null, "Informe número de notas");
		int notas = Integer.parseInt(quantidadeNotas);
		float nota = 0;
		float media = 0;
		int varControle = 1;//variável de controle
		
		while(varControle <= notas) {// teste lógico
		    nota = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor para a nota " + varControle));
		    System.out.println("Nota digitada: " + nota);
		    
		    media = media + nota;
		    System.out.println("Acumulado notas " + media);
		    
            System.out.println("");

            varControle++; 
        }
     
        System.out.println("Media " + (media/notas));
    }
}
