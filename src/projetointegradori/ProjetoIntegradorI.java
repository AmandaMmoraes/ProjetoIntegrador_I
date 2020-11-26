
package projetointegradori;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProjetoIntegradorI {
	private static int posicao = 0; // essa variavel é global, essa variavel é para guarda o posicionamento do
									// desafio dentro da função de validação do vetor
	private static int qtdVida = 3; // essa variavel é global, para quantidade de vida
	private static String nomeJogador = null; // essa variavel é global, para o nome do jogador

	private static Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {
		menu();

	}

	// para o menu do jogo
	public static void menu() {
		int opcao;

		do {
			System.out.println("1 - Jogar");
			System.out.println("2 - Instruções");
			System.out.println("3 - Creditos");
			System.out.println("4 - Sair");
			System.out.print("\nEscolha opção: ");

			opcao = leitor.nextInt();
			System.out.println();
			
			switch (opcao) {
			case 1:
				jogo(); // Aqui vai chamar o metodo do inicio do jogo

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
	public static void jogo() {
		System.out.println("Insira o nome do jogador(a)");
		nomeJogador = leitor.next();
		System.out.println("");
		System.out.println("Olá " + nomeJogador
				+ "! O jogo o escaravelho rubi, você terá que descobrir como e porque você foi parar naquela jornada,\n"
				+ "além de procurar o significado de sua busca. Nesse jogo vamos mostrar a sua evolução quantos os níveis de dificuldade dos Desafios.\n"
				+ "Eai vamos começar os desafios " + nomeJogador + "?");

	}

	// Aqui é para mostra a instruções do jogo
	public static void instrucoes() {
		System.out.println("Após clicar em jogar, você vai começar com 3 vidas para passar por 10 desafios. \n"
				+ "Tendo que escolher o nivel de dificuldade que será composta por: Fácil, médio e difícil.\n"
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
	public static boolean verificacao(String questoes) {
		// se retornar true, o jogador vai poder continuar jogando, e no momento que
		// tiver 0 nao pode mais errar.
		if (questoes.equalsIgnoreCase("errada") && qtdVida >= 1) {

			qtdVida -= 1;
			return true;
		} else if (questoes.equalsIgnoreCase("correta") && qtdVida >= 0) {

			return true;
		} else {
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

}

class ListaPerguntas {
	private String pergunta;
	private String resposta;
	private List<String> alternativas;

	public ListaPerguntas() {
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
}