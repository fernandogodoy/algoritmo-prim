# Algoritmo de Prim

Esta aplicação possui a implementação do [Algoritmo de Prim](https://pt.wikipedia.org/wiki/Algoritmo_de_Prim) para geração da árvore mínima, fazendo uso da biblioteca: http://jgrapht.org/ para gerar uma representação gráfica do resultado.

1) Como resultado da execução, terá a escrita no console onde é apresentado: 

 > Caminho 
 
 > Arestas Selecionadas
 
 > Custo total da árvore.
 
 > Ex: ([1, 2, 3, 4, 5, 6], [(2,1), (2,5), (2,4), (4,6), (6,3)]) Z = 12
 

2) Representação gráfica da Árvore Mínima.

<html>
	<img src="https://github.com/fernandogodoy/algoritmo-prim/blob/master/resultado.PNG"/>

</html>

# Arquivo de configuração - Lista de Adjacência:
A arvore mínima é gerada com base no arquivo: https://github.com/fernandogodoy/algoritmo-prim/blob/master/src/main/resources/listaAdjacencia

Este arquivo deve conter a lista de adjacência do grafo ao qual se deseja obter a árvore geradora mínima: 
 > Vetice (->) Vetice (-) Peso (,) ...

 > Ex: 1 -> 2-1,3-5,4-7,5-9
