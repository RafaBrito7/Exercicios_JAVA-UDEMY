			<h1>Anotações da Aula</h1>

Quando usar os Default Methods

- Intenção Básica é prover implementação padrão para métodos, de modo a evitar:
	- Repetição de implementação em toda classe que implemente a interface
	- Necessidade de se criar classes abstratas para prover reuso da implementação
- Outras Vantagens 
	- Manter a retrocompatibilidade com sistemas existentes
	- Permitir que interfaces funcionais (que devem conter apenas um método) possam prover outras 
	  operações padrão reutilizáveis

			<h2>Problema Exemplo</h2>

Fazer um programa para ler uma quantia e a duração em meses de um
empréstimo. Informar o valor a ser pago depois de decorrido o prazo do
empréstimo, conforme regras de juros do Brasil. A regra de cálculo de
juros do Brasil é juro composto padrão de 2% ao mês.