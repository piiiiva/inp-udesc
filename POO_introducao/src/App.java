public class App {
    public static void main(String[] args) throws Exception {
        Pessoa objeto = new Pessoa();
        objeto.nome = "Rodrigo";;
        objeto.cpf = "000.222.111-55";
        objeto.fone = "2255-1010";

        objeto.correr();
        objeto.falar();

        //instanciar outro objeto
        Pessoa ob = new Pessoa();
        ob.nome = "Diego";
        ob.cpf = "000.000.000-11";
        ob.fone = "3333-5555";
        ob.correr();
        ob.falar();

        objeto.falar();
        ob.falar();

    }
}
