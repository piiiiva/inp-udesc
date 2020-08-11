## Matrizes - Array bidimensional

Vamos trabalhar com a ideia de matrizes

<div>
  <img src="https://user-images.githubusercontent.com/60410507/89858764-d0dca880-db75-11ea-9192-db0df452655e.png" />
</div>

Precisamos popular os dados dessa matriz 

<div>
  <img src="https://user-images.githubusercontent.com/60410507/89859020-5f512a00-db76-11ea-92df-d6b309dae497.png" />
</div>

<p>
  Para fazer isso precisamos criar um `array` bidimensional, onde vamos inserir colunas e linhas. <br>
  💡 Podemos pensar em um array dentro de outro, ou seja, um array de linhas e cada linha com um array de colunas.
</p>

### Criando um array bidimensional
<p>
  Para criar um array bidimensional indicamos o tipo seguido de duas instruções de array, sendo o primeiro o eixo y e o segundo o eixo x, coluna e linha.
</p>

~~~javascrip
int[][] numeros = new int[5][4]
~~~

<p>
  Para percorrer e trabalhar com essa matriz/array de acordo com o proposto na imagem vamos trabalhar com a estrutura de repetição <strong>for</strong><br>

  <br>
  Vamos inicialmente percorrer cada linha
</p>

~~~javascrip
for (int linha = 0; linha < 4; linha++) {
  (Para cada linha vamos executar um código aqui)
}
~~~

<p>
  Agora vamos criar uma estrutura de repetição para percorrer todas as posições do array de colunas que será o código executado em cada linha.
</p>

~~~javascrip
for (int linha = 0; linha < 4; linha++) { // percorre cada linha
    for(int coluna = 0; coluna < 5; coluna++) { // percorre cada coluna
        numeros[coluna][linha] = linha;
    }
}
~~~