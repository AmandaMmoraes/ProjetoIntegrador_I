
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
				
				if(verificacao(perguntas.get(0), resposta)){
					
				}else {
					
				}
				
			} else if (escolha == 2) {
				System.out.println("Ele te traz um bife que parece estar muito suculento, mas você não tem a chance nem de provar,\n"
						+ "pois você morre de sede antes dele finalizar o seu pedido.");
				System.out.println("\n\n\nDica: preste atenção aos detalhes, qualquer erro pode matá-lo!");
			} else if (escolha == 3) {
				System.out.println("Ele te dá toda a informaçãque ele reuniu como trabalhador daquela taverna, mas não adianta\n"
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
		// se retornar true, o jogador vai poder continuar jogando, e no momento que tiver 0 não pode mais errar.
		
		if(pergunta.getResposta().equalsIgnoreCase(pergunta.getAlternativas().get(alternativaSelecionada - 1))) {
			return true;
		}else{
			if(qtdVida > 0) {
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

			pergunta.setPergunta("Somos 3 irmãos: José, Adriano e Caio.\nSabe-se que ou José mais velho ou Adriano é o mais novo.\n"
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

			pergunta.setPergunta("A mãe de Ana tem 5 filhas. Fafá, Fefê, Fifí, Fofó e mais uma.\nQual o nome da quinta filha?");
			pergunta.setResposta("Ana");

			alternativas = new ArrayList<>();
			alternativas.add("Fufu");
			alternativas.add("Clara");
			alternativas.add("Fernanda");
			alternativas.add("Ana");
			alternativas.add("Joana");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("Se durante uma corrida de carros, você ultrapassa o segundo colocado. \nQual a sua posição atual?");
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

			pergunta.setPergunta("Uma borboleta vive 5 dias e a cada dia ela voa 4 metros. \nQuantos metros ela terá percorrido em 1 semana?");
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

			pergunta.setPergunta("");
			pergunta.setResposta("");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);
			
		} else if (dificuldade == 3) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

			pergunta.setAlternativas(alternativas);

			pergunta = new Perguntas();

			pergunta.setPergunta("");
			pergunta.setResposta("");

			alternativas = new ArrayList<>();
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");
			alternativas.add("");

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