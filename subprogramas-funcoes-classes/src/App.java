public class App {
    /**
     * Subprograma é um pequeno programa que executa um código,
     * muitas vezes repetitivos e que pode ser invocado várias vezes.
     * Temos dois métodos nesse subprograma -> Procedure e Função
     * 
     * Procedure executa o código sem retornar qualquer valor a quem chamou (void)
     * Função executa o trecho de código e retorna um valor a quem chamou
     */

     static String nome;
     static String sobrenome;

    public static void main(String[] args) throws Exception {
        nome = "Rodrigo ";
        sobrenome = "Piva";

        //chamada da procedure
        retornaNomeCompleto();

        //chamada da função
        String retorno = retornaNomeCompleto2();
        System.out.println(retorno);
    }

    // Procedure - método que não retorna valor
    public static void retornaNomeCompleto () {
        String nomeCompleto = nome + sobrenome;

        System.out.println(nomeCompleto);
    }

    public static String retornaNomeCompleto2() {
        String resultado = nome + sobrenome;

        return resultado;
    }
}
