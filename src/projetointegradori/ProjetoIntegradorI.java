
package projetointegradori;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProjetoIntegradorI {
	private static int qtdVida = 3; // essa variavel é global, para quantidade de vida
	private static String nomeJogador = null; // essa variavel é global, para o nome do jogador

	private static Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	// para o menu do jogo
	public static void menu() {
		int opcao;

		List<Perguntas> perguntas = new ArrayList<Perguntas>();

		do {
			System.out.println("-----ESCARAVELHO RUBI-----");
			System.out.println();
			System.out.println("1 - Jogar");
			System.out.println("2 - Instruções");
			System.out.println("3 - Creditos");
			System.out.println("4 - Sair");
			System.out.print("\nEscolha opção: ");

			opcao = leitor.nextInt();
			System.out.println();

			switch (opcao) {
			case 1:
				System.out.println("1 - Fácil");
				System.out.println("2 - Média");
				System.out.println("3 - Difícil");
				System.out.print("\nSelecione a dificuldade: ");

				int dificuldade = leitor.nextInt();
				ajustarPerguntas(perguntas, dificuldade);

				jogo(perguntas); // Aqui vai chamar o metodo do inicio do jogo

				break;

			case 2:
				instrucoes(); // Aqui vai chamar o método da instruções
				break;

			case 3:
				creditos(); // Aqui vai chamar o método dos creditos
				break;

			case 4:
				System.out.println("\nObrigado por jogar!! *-*");
				break;

			}
		} while (opcao != 4); // laço para mostra mais vezes o menu

	}

	// essa função é para o jogador colocar o nome e uma pequena introdução do jogo,
	// e ja chama o metodo desafio para comecar o jogo
	public static void jogo(List<Perguntas> perguntas) {
		int escolha = 0;
		int resposta = 0;

		System.out.print("\n\nInsira o nome do jogador(a): ");
		nomeJogador = leitor.next();
		System.out.println("\n\nOlá " + nomeJogador + "!\n\n"
				+ " O jogo o escaravelho rubi, você terá que descobrir como e porque você foi parar naquela jornada,\n"
				+ "além de procurar o significado de sua busca. Nesse jogo vamos mostrar a sua evolução quantos os níveis de dificuldade dos Desafios.\n"
				+ "Eai, vamos começar os desafios " + nomeJogador + "?");

		System.out.println("\n\nEra dia, por volta de Setembro de 1978, você se encontra perdido em meio a um deserto."
				+ "Você olha para os lados e vê apenas areia,\n mas forçando um pouco mais sua vista, enxerga longinquamente "
				+ "à esquerda uma lagoa e para trás de você, acha-se uma taverna. Para onde deseja ir?");
		System.out.println("\n1 - Em direção à lagoa");
		System.out.println("2 - Em direção à taverna\n");

		System.out.print("Resposta: ");
		escolha = leitor.nextInt();

		if (escolha == 1) {
			System.out.println("Seguiremos então para a lagoa!\n\n\n");
			System.out.println("Depois de muito caminhar e nunca chegar à tal lagoa, você morre de sede.\n\n");
			System.out.println("Dica: cuidado com as miragens, elas podem fazer com que você morra rapidamente.");
		} else if (escolha == 2) {
			System.out.println("Seguiremos então para a taverna!");
			System.out.println("Depois de caminhar por volta de 35 minutos, você chega ao lugar desejado.\n\n"
					+ "Morrendo de sede e sem uma gota de água sequer, você entra desesperado na taverna.\n\n"
					+ "Todos param ao te ver entrar bruscamente.\n\n Um homem se aproxima e pergunta se deseja algo. "
					+ "O que você responde?");
			System.out.println("\n1 - Pede um copo de água");
			System.out.println("2 - Pede comida");
			System.out.println("3 - Pede uma informação");
			System.out.print("\nResposta: ");
			escolha = leitor.nextInt();

			if (escolha == 1) {
				System.out.println(
						"O bom senhor responde que lhe dará água apenas se acertar uma pergunta que ele fará.\n");
				System.out.println("Sem mais opções, você aceita a proposta! Logo o senhor faz a pergunta:\n");
				System.out.println("\"" + perguntas.get(0).getPergunta() + "\" \n");
				System.out.println(
						"Para lhe facilitar a resposta o bom senhor lhe dá alternativas para responder a pergunta:\n");
				System.out.println(perguntas.get(0).getAlternativasEmString());
				System.out.println();
				System.out.print("Resposta: ");
				resposta = leitor.nextInt();

				if (verificacao(perguntas.get(0), resposta)) {

				} else {

				}

			} else if (escolha == 2) {
				System.out.println(
						"Ele te traz um bife que parece estar muito suculento, mas você não tem a chance nem de provar,\n"
								+ "pois você morre de sede antes dele finalizar o seu pedido.");
				System.out.println("\n\n\nDica: preste atenção aos detalhes, qualquer erro pode matá-lo!");
			} else if (escolha == 3) {
				System.out.println(
						"Ele te dá toda a informaçãque ele reuniu como trabalhador daquela taverna, mas não adianta\n"
								+ "de nada, pois você morreu de sede antes do primeiro fato.");
				System.out.println("\n\n\nDica: preste atenção aos detalhes, qualquer erro pode matá-lo!");
			}
		} else {
			System.out.println("Comando errado! Reinicie o jogo!");
			System.exit(0);
		}
	}

	// Aqui é para mostra a instruções do jogo
	public static void instrucoes() {
		System.out.println("Após clicar em jogar, você vai começar com 3 vidas para passar por 10 desafios. \n"
				+ "Tendo que escolher o nivel de dificuldade que será composta por: fácil, médio e difícil.\n"
				+ "E as perguntas decidirão se ele continua prosseguindo com a história caso acertar ou perderá a vida. \n"
				+ "Então você deverá fazer as escolhas e decisões corretas para conseguir avançar \n"
				+ "para objetivo do jogo. Mas como ja explicado tenha calma e muito cuidado, você vai encontrar difuculdades no seu caminho.\n"
				+ "Resolva os enigmas e conclua sua aventura. Tesouros lhe aguardam.\n\n"
				+ "Para voltar ao menu principal, digite voltar.");

		leitor.next();
		System.out.println();
	}

	// Nessa função vamos ver quantas questao foram acertadas ou erradas, e mostra
	// se o jogador tem vida
	public static boolean verificacao(Perguntas pergunta, int alternativaSelecionada) {
		// se retornar true, o jogador vai poder continuar jogando, e no momento que
		// tiver 0 não pode mais errar.

		if (pergunta.getResposta().equalsIgnoreCase(pergunta.getAlternativas().get(alternativaSelecionada - 1))) {
			return true;
		} else {
			if (qtdVida > 0) {
				qtdVida--;
			}
			return false;
		}
	}

	// Essa função é para mostra que o jogador perdeu todas as vidas
	public static void gameOver() {
		System.out.println("Gamer Over");
		System.out.println("Que pena, " + nomeJogador + "! Mas não desanima, na vida encontramos dificuldades, /n"
				+ "mas não podemos desistir. Bora correr atras do prejuízo?? =(");
	}

	public static void creditos() {

	}

	private static void ajustarPerguntas(List<Perguntas> perguntas, int dificuldade) {
		if (dificuldade == 1) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta("Sr. Smith tem 4 filhas. Cada uma de suas filhas tem um irmão.\n "
					+ "Quantos filhos o Sr. Smith tem ao todo?");
			pergunta.setResposta("5");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("5");
			alternativas.add("4");
			alternativas.add("6");
			alternativas.add("7");
			alternativas.add("8");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Somos 3 irmãos: José, Adriano e Caio.\nSabe-se que ou José mais velho ou Adriano é o mais novo.\n"
							+ "Sabe-se também que ou Adriano é o mais velho ou Caio é o mais velho."
							+ "\nQuem é o mais velho e o mais novo, respectivamente?");
			pergunta.setResposta("Caio e Adriano");

			alternativas = new ArrayList<>();
			alternativas.add("Caio e Adriano");
			alternativas.add("Adriano e José");
			alternativas.add("Caio e José");
			alternativas.add("José e Adriano");
			alternativas.add("Adriano e Caio");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"A mãe de Ana tem 5 filhas. Fafá, Fefê, Fifí, Fofó e mais uma.\nQual o nome da quinta filha?");
			pergunta.setResposta("Ana");

			alternativas = new ArrayList<>();
			alternativas.add("Fufu");
			alternativas.add("Clara");
			alternativas.add("Fernanda");
			alternativas.add("Ana");
			alternativas.add("Joana");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Se durante uma corrida de carros, você ultrapassa o segundo colocado. \nQual a sua posição atual?");
			pergunta.setResposta("Segundo");

			alternativas = new ArrayList<>();
			alternativas.add("Segundo");
			alternativas.add("Quarto");
			alternativas.add("Primeiro");
			alternativas.add("Terceiro");
			alternativas.add("Quinto");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Se meu pai é irmão da sua irmã. O que eu sou seu?");
			pergunta.setResposta("Sobrinho");

			alternativas = new ArrayList<>();
			alternativas.add("Tio");
			alternativas.add("Genro");
			alternativas.add("Sobrinho");
			alternativas.add("Filho");
			alternativas.add("Primo");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Uma mulher vai ao mercado. No caminho de ida, ela conta 10 árvores à sua direita.\n"
					+ "E no caminho de volta, ela conta 10 árvores à sua esquerda. Por quantas árvores ela passou naquele dia?");
			pergunta.setResposta("10");

			alternativas = new ArrayList<>();
			alternativas.add("20");
			alternativas.add("10");
			alternativas.add("15");
			alternativas.add("25");
			alternativas.add("5");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Uma borboleta vive 5 dias e a cada dia ela voa 4 metros. \nQuantos metros ela terá percorrido em 1 semana?");
			pergunta.setResposta("20");

			alternativas = new ArrayList<>();
			alternativas.add("28");
			alternativas.add("16");
			alternativas.add("22");
			alternativas.add("20");
			alternativas.add("24");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Uma lesma sobe 2 metros de uma parede por dia e por noite ela escorrega 1 metro.\n"
					+ "Levando em conta que ela está escalando uma parede de 20 metros, quantos dias serão necessários para escalar toda a parede?");
			pergunta.setResposta("19");

			alternativas = new ArrayList<>();
			alternativas.add("19");
			alternativas.add("20");
			alternativas.add("21");
			alternativas.add("18");
			alternativas.add("17");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Num carro entraram um avô, dois pais, dois filhos e um neto.\n"
					+ "Qual o número mínimo de pessoas no carro?");
			pergunta.setResposta("3");

			alternativas = new ArrayList<>();
			alternativas.add("1");
			alternativas.add("3");
			alternativas.add("5");
			alternativas.add("7");
			alternativas.add("9");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Se o amanhã de ontem era sexta-feira, que dia é o dia depois de amanhã de ontem?");
			pergunta.setResposta("Sábado");

			alternativas = new ArrayList<>();
			alternativas.add("Sexta");
			alternativas.add("Terça");
			alternativas.add("Quinta");
			alternativas.add("Domingo");
			alternativas.add("Sábado");

			pergunta.setAlternativas(alternativas);

		} else if (dificuldade == 2) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta("Atente-se para a expressão: \"C * (B – A) <= D – B / C.\"\n"
					+ "Qual seria o resultado da execução dessa expressão, caso o valor das variáveis fossem: A=3; B=6; C=2 e D=9 ?");
			pergunta.setResposta("true");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("true");
			alternativas.add("false");
			alternativas.add("error");
			alternativas.add("9");
			alternativas.add("6");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Considerando os fundamentos de lógica de programação, considere as afirmativas abaixo:\n"
							+ "I - Toda expressão que possui um operador relacional, necessariamente, tem como resultado um valor do tipo “lógico”.\n"
							+ "II - As funções \"do-while\" e \"while\" são ambas de repetição.\n"
							+ "III - É adequado o uso de variáveis cujo tipo de dados seja “inteiro” para armazenar nomes de pessoas.\n");
			pergunta.setResposta("Apenas as afirmativas I e II são verdadeiras.");

			alternativas = new ArrayList<>();
			alternativas.add("Apenas a afirmativa I é verdadeira.");
			alternativas.add("Apenas as afirmativas I e II são verdadeiras.");
			alternativas.add("Todas são falsas.");
			alternativas.add("Apenas a afirmativa II é verdadeira.");
			alternativas.add("Todas são verdadeiras.");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Considere a sub-rotina abaixo:\n\n" + "1. Programa\n"
					+ "2. Declare X, Y e Z numérico\n" + "3. Leia X\n" + "4. Leia Y\n" + "5. Z:= (X + Y) x Y\n"
					+ "6. Escreva Z\n" + "7. Fim programa\n\n"
					+ "Supondo que o valor fornecido para X seja 3 e o valor fornecido para Y seja 4\n"
					+ "Qual o valor de Z?");
			pergunta.setResposta("28");

			alternativas = new ArrayList<>();
			alternativas.add("21");
			alternativas.add("28");
			alternativas.add("19");
			alternativas.add("36");
			alternativas.add("25");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Analise o seguinte programa:\n\n" + "int a = 5;\n" 
					+ "for(int i = 0; i <= 4; i++){\n" 
					+ "  a += 3;\n" 
					+ "}\n"
					+ "System.out.println(a)\n\n"
					+ "Ao final da execução desse programa, o valor impresso da variável a será:");
			pergunta.setResposta("Syntax error");

			alternativas = new ArrayList<>();
			alternativas.add("Syntax error");
			alternativas.add("20");
			alternativas.add("15");
			alternativas.add("24");
			alternativas.add("18");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Supondo que a cada semestre temos 2 provas, como faríamos o cálculo da média final?\n");
			pergunta.setResposta("media = (p1 + p2) /2");

			alternativas = new ArrayList<>();
			alternativas.add("media = p1 * p2 - 10");
			alternativas.add("media = p1/p2 + 10/2");
			alternativas.add("media = (p1-p2) * 2");
			alternativas.add("media = p1 + p2 /2");
			alternativas.add("media = (p1 + p2) /2");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Como se escreve a raiz quadrada de N no java?");
			pergunta.setResposta("Math.sqrt(N);");

			alternativas = new ArrayList<>();
			alternativas.add("Math.round(N);");
			alternativas.add("Math.sqrt(N);");
			alternativas.add("Math.pow(N,2);");
			alternativas.add("Math.random(N);");
			alternativas.add("Math.raizQuadrada(N);");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Como arredondar um número N em java?");
			pergunta.setResposta("Math.round(N);");

			alternativas = new ArrayList<>();
			alternativas.add("Math.sqrt(N);");
			alternativas.add("Math.round(N);");
			alternativas.add("Math.pow(N,2);");
			alternativas.add("Math.random(N);");
			alternativas.add("Math.arredondar(N);");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Como fazer a potenciação de N por X?");
			pergunta.setResposta("Math.pow(N,X);");

			alternativas = new ArrayList<>();
			alternativas.add("Math.sqrt(N,X);");
			alternativas.add("Math.round(N,X);");
			alternativas.add("Math.pow(N,X);");
			alternativas.add("Math.random(N,X);");
			alternativas.add("Math.potenciar(N,X);");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Para o que é usada a função \"do-while\"?");
			pergunta.setResposta("Repetição com verificação após a execução");

			alternativas = new ArrayList<>();
			alternativas.add("Repetição com verificação antes da execução");
			alternativas.add("Repetição com verificação após a execução");
			alternativas.add("Repetição sem verificação");
			alternativas.add("Repetição com verificação antes e depois da execução");
			alternativas.add("Nenhuma das alternativas");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Qual a utilidade do \"mod\"?");
			pergunta.setResposta("Retornar o resto da divisão de um número pelo outro");

			alternativas = new ArrayList<>();
			alternativas.add("Retornar o resultado da divisão de um número pelo outro");
			alternativas.add("Retornar o resultado da soma de um número ao outro");
			alternativas.add("Retornar o resto da divisão de um número pelo outro");
			alternativas.add("Retornar o resto da subtração de um número pelo outro");
			alternativas.add("Retornar o resultado da multiplicação de um número pelo outro");

			pergunta.setAlternativas(alternativas);

		} else if (dificuldade == 3) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta("Um programador Java, na tentativa de armazenar quatro valores inteiros referentes a números de contas bancárias em um array, utilizou as instruções abaixo."
					+ "\nI- int [] contas = {1234, 3451, 2341, 3214};"
					+ "\nII- int contas = {1234, 3451, 2341, 3214};"
					+ "\nIII- int [] contas; contas = {1234, 3451, 2341, 3214};"
					+ "\nIV- contas = new int[4]; contas[1] = 1234; contas[2] = 3451; contas[3] = 2341; contas[4] = 3214;");
			pergunta.setResposta("I e III");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("I e III");
			alternativas.add("II e IV");
			alternativas.add("III e IV");
			alternativas.add("I e II");
			alternativas.add("II, III e IV");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Dos trechos de códigos abaixo, extraídos de um arquivo fonte escrito para a versão 8 da linguagem Java, o único que compila corretamente é");
			pergunta.setResposta("public static void main(String args[]){}");

			alternativas = new ArrayList<>();
			alternativas.add("String x = (String) (b > c) ? \"true\" : \"false\"");
			alternativas.add("public static void main(String args[]){}");
			alternativas.add("final enum letra {A, B, C}");
			alternativas.add("Boolean bool = new Boolean()");
			alternativas.add("Integer inteiro[] = new List[]");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("São tipos primitivos da linguagem Java:");
			pergunta.setResposta("boolean, double, float e byte.");

			alternativas = new ArrayList<>();
			alternativas.add("int, string, long e real.");
			alternativas.add("char, int, real e bit.");
			alternativas.add("boolean, double, float e byte.");
			alternativas.add("real, short, long e char.");
			alternativas.add("string, long int, short int e float.");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Em Java 8, qual modificador de acesso torna um membro disponível somente para classes dentro do mesmo pacote ou subclasses?");
			pergunta.setResposta("protected");

			alternativas = new ArrayList<>();
			alternativas.add("public");
			alternativas.add("default");
			alternativas.add("private");
			alternativas.add("protected");
			alternativas.add("package-private");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Qual o resultado do código abaixo?\n"
					+ "public class Desafio{"
					+ "\n"
					+ "\tpublic static void main(String[] args){"
					+ "\n"
					+ "\t\tint value = 554;"
					+ "\n\t\tString var = (String)value; //linha 1"
					+ "\n\t\tString temp= ''123'';"
					+ "\n\t\tint data = (int)temp; //linha 2"
					+ "\n\t\tSystem.out.println(data+var);"
					+ "\n\t}"
					+ "\n}");
			pergunta.setResposta("Erro de compilação devido as linhas 1 e 2");

			alternativas = new ArrayList<>();
			alternativas.add("Erro de compilação devido as linhas 1 e 2");
			alternativas.add("Erro de compilação devido à linha 1");
			alternativas.add("Erro de compilação devido à linha 2");
			alternativas.add("''554123''");
			alternativas.add("677");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Qual o resultado do código abaixo?\n\n"
					+ "public class Desafio{\n"
					+ "\n\n"
					+ "\tpublic static void main(String[] args){\n"
					+ "\n\n"
					+ "\t\tList<Integer> elements = new ArrayList<>();\n"
					+ "\n\t\telements.add(10);\n"
					+ "\n\t\tint firstElmnt = elements.get(1);\n"
					+ "\n\t\tSystem.out.println(firstElmnt);\n"
					+ "\n\t}\n"
					+ "\n}");
			pergunta.setResposta("Será lançada uma exceção IndexOutOfBoundsException em tempo de execução.");

			alternativas = new ArrayList<>();
			alternativas.add("0");
			alternativas.add("10");
			alternativas.add("null");
			alternativas.add("Será lançada uma exceção IndexOutOfBoundsException em tempo de execução.");
			alternativas.add("Será lançada uma exceção ArrayIndexOutOfBoundsException em tempo de execução.");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Observe o código a seguir na linguagem de programação Java.\n\n"
					+ "public class Exemplo{\n"
					+ "\n\n"
					+ "\tpublic static void main(String[] args){\n"
					+ "\n\n"
					+ "\t\tfor(int count = 1; count <= 10; count++){\n"
					+ "\n\t\t\tif(count % 2 == 0){\n"
					+ "\n\t\t\t\tSystem.out.printf(\"%d\", count);\n"
					+ "\n\t\t\t}\n"
					+ "\n\t}\n"
					+ "\n}");
			pergunta.setResposta("2 4 6 8 10");

			alternativas = new ArrayList<>();
			alternativas.add("1 3 4 5 6 7 8 9 10");
			alternativas.add("2 4 6 8 10");
			alternativas.add("null");
			alternativas.add("1 3 5 7 9");
			alternativas.add("1");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Considere os seguintes fragmentos de código Java:"
					+ "\nI- int sum = 7; if(sum > 20){"
					+ "\nSystem.out.print(\"ganhou \");} else{"
					+ "\nSystem.out.print(\"perdeu \");} System.out.print(\"o bônus.\");"
					+ "\n\n"
					+ "II- int sum = 21; if(sum != 20)"
					+ "\nSystem.out.print(\"ganhou \"); else"
					+ "\nSystem.out.print(\"perdeu \"); System.out.print(\"o bônus.\");"
					+ "\n\nO resultado da execução dos fragmentos em I e II será, respectivamente,");
			pergunta.setResposta("perdeu o bônus e ganhou o bônus.");

			alternativas = new ArrayList<>();
			alternativas.add("ganhou e ganhou.");
			alternativas.add("perdeu e perdeu.");
			alternativas.add("perdeu o bônus e ganhou o bônus.");
			alternativas.add("perdeu o bônus e ganhou.");
			alternativas.add("perdeu e ganhou o bônus.");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Assinale a alternativa INCORRETA acerca dos operadores lógicos da linguagem de programação Java.");
			pergunta.setResposta("são operadores de deslocamento de bits.");

			alternativas = new ArrayList<>();
			alternativas.add("são operadores de deslocamento de bits.");
			alternativas.add("~ é operador lógico de negação.");
			alternativas.add("&, |, ^ são operadores lógicos E, OU e OU-exclusivo");
			alternativas.add("==, != são operadores de igualdade e diferença.");
			alternativas.add("nenhuma das alternativas.");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("public static double desafio() {\n"
					+ "\tSystem.out.println(\"Digite o numero a ser potenciado\");\n"
					+ "\tdouble X = scanner.nextDouble();\n"
					+ "\tSystem.out.println();\n"
					+ "\tSystem.out.println(\"Digite a potência\");\n"
					+ "\tdouble Z = scanner.nextInt();\n"
					+ "\tSystem.out.println();\n"
					+ "\tdouble resultado = X;\n\n"
					+ "\tif (Z == 0) {\n"
					+ "\t\treturn 0;\n"
					+ "\t} else if (Z == 1) {\n"
					+ "\t\treturn X;\n"
					+ "\t} else {\n"
					+ "\t\tfor (int i = 1; i < Z; i++) {\n"
					+ "\t\t\tresultado = resultado * X;\n"
					+ "\t\t}\n"
					+ "\t\treturn resultado;\n"
					+ "\t}\n"
					+ "}"
					+ "\n\nSe X é igual a 3 e Z igual a 4, qual será o resultado?");
			pergunta.setResposta("81");

			alternativas = new ArrayList<>();
			alternativas.add("64");
			alternativas.add("27");
			alternativas.add("81");
			alternativas.add("243");
			alternativas.add("256");

			pergunta.setAlternativas(alternativas);
		}
	}

}

class Perguntas {
	private String pergunta;
	private String resposta;
	private List<String> alternativas;

	public Perguntas() {
		alternativas = new ArrayList<>();
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public List<String> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public String getAlternativasEmString() {
		Collections.shuffle(this.alternativas);

		return "1) " + this.alternativas.get(0) + "\n" + "2) " + this.alternativas.get(1) + "\n" + "3) "
				+ this.alternativas.get(2) + "\n" + "4) " + this.alternativas.get(3) + "\n" + "5) "
				+ this.alternativas.get(4);
	}
}