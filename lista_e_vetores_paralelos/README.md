## Lista e vetores paralelos

> Sempre que vamos trabalhar com vetores precisamos definir se é um vetor estático ou dinâmico

<br>

### Vetor estático

#### Definindo um vetor estático

String[] nomes;
int[] idades;
>Isso define que é um vetor e é estático

#### Criando um vetor estático
nomes = new String[5];
idades = new int[5];

<br>
Podemos fazer tudo de uma vez só
String[] nomes = new String[5];

>Antes foi definido que é um vetor estático. Agora estamos de fato criando esse vetor e dizendo que ele possui 5 posições.

#### Inserindo dados no array estático
nomes[0] = "Fulano";
idade[0] = 25;
>Cada vez que precisar inserir algum dado eu informo o array e a posição que vou inserir o dado.

<br>

### Vetor dinâmico

List<String> nomes;
List<int> idades;
>Sempre que falamos em vetor dinâmico estamos falando em listas. Dessa forma estamos declarando um lista com o valor nomes

#### Criando um vetor dinâmico
nomes = new ArrayList();
idades = new ArrayList();

<br>
Podemos fazer tudo de uma vez só
List<String> nomes = new ArrayList();

#### Inserindo dados no array dinâmico
nomes.add("Fulano");
idades.add(25);
>Insere o dados na próxima posição não ocupada do array