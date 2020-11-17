
package projetointegradori;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.util.Random;
import java.util.Scanner;

public class ProjetoIntegradorI {
    public static int opcao; // essa variavel é global, para a opção do menu
    static int[] desafioVet = new int[10]; //essa variavel é global, criando o vetor para guarda os desafios que estão sendo utilizados
    static int posicao = 0; //essa variavel é global, essa variavel é para guarda o posicionamento do desafio dentro da função de validação do vetor
    static boolean validacao; //essa variavel é global,para retorna o true ou false do numero gerado
    static int qtdVida = 3; //essa variavel é global, para quantidade de vida 
    static int certo = 0; //essa variavel é global,para guarda os numeros de acertos
    static int erro =0; //essa variavel é global,para guarda os numeros de erros
    static int controlarJogos = 0; //essa variavel é global, para controlar as vezes que vai chamar os desafios
    static String nomeJogador = null; //essa variavel é global, para o nome do jogador
    static String escolherLetra;
    
    static Scanner leitor = new Scanner(System.in);
    
    //para o menu do jogo
    public static void menu(){
        do{
        System.out.println("1 - Jogar");
        System.out.println("2 - Instrução");
        System.out.println("3 - Creditos");
        System.out.println("4 - Sair");
        opcao = leitor.nextInt();
        
       
        switch(opcao) {
            case 1:
                jogo(); // Aqui vai chamar o metodo do inicio do jogo
                
                break;
                
            case 2:
                instrucoes(); // Aqui vai chamar o método da instruções
                break;
                
            case 3:
               creditos(); //Aqui vai chamar o método dos creditos
                break;
                
            default:
                if(opcao == 4){ //Aqui é a opção de sair do jogo
                    System.out.println("saindo");
                }
                
        }
    } while (opcao < 3); // laço para mostra mais vezes o menu
    
    }
    
    //essa função é para o jogador colocar o nome e uma pequena introdução do jogo, e ja chama o metodo desafio para comecar o jogo
    public static void jogo(){
        System.out.println("Insira o nome do jogador(a)");
        nomeJogador = leitor.next();
        System.out.println("");
        System.out.println("Olá " + nomeJogador + "O jogo o escaravelho rubi você terá que descobrir como e o por quê você foi parar naquela jornada,\n"
                + "além de procurar o significado de sua busca. Nesse jogo vamos mostra a sua evolução quantos os niveis de dificuldade dos Desafios.\n"
                + "Eai vamos começar os desafios " + nomeJogador + " ? ");
   
    }
    
   
    
    //Aqui é para mostra a instruções do jogo
    public static void instrucoes(){
        System.out.println("Após clicar em jogar,você vai começar com 3 vidas para passar por 10 desafios. \n"
                + "Tendo que escolher o nivel de dificuldade que será composta por: Fácil, médio e difícil.\n"
                + "E as perguntas decidirão se ele continua prosseguindo com a história caso acertar ou perderá a vida. \n"
                + "Então você deverá fazer as escolhas e decisões corretas para conseguir avançar \n"
                + "para objetivo do jogo. Mas como ja explicado tenha calma e muito cuidado, você vai encontrar difuculdades no seu caminho.\n"
                + "esolva os enigmas e conclua sua aventura. Tesouros lhe aguardam.\n\n" 
                + "Para voltar ao menu principal, digita M.");
        
        String letra;//aqui é para ter a opção de voltar para o menu 
        letra = leitor.next();
    }
    
    //Essa é a função rendomica, para mostrar os desafios
    public static int random(){
        int desafios;
        
        Random aleatorio = new Random();
        desafios = aleatorio.nextInt(10)+1;
        
        return desafios;
                
    }
    
    // essa função vai ver se o desafio ja foi usado ou não
    public static Boolean validarVetor(int questoes){
        //esse if vai ler todas as posições do vetor, e se for verdadeiro ele vai setar o num do desafio e retorna o vdd
        if(questoes != desafioVet[0] && questoes != desafioVet[1] && questoes != desafioVet[2]
                && questoes != desafioVet[3] && questoes != desafioVet[4] && questoes != desafioVet[5] 
                && questoes != desafioVet[6] && questoes != desafioVet[7] && questoes != desafioVet[8] 
                && questoes != desafioVet[9] && questoes != desafioVet[10]) {
            desafioVet[posicao] = questoes;
            posicao++;
            return true;
            // se nao for falso ele vai retorna para função randomica para ter outro numero 
        } else {
            return false;
        }
    }
    
    //Nessa função vamos ver quantas questao foram acertadas ou erradas, e mostra se o jogador tem vida
    public static Boolean verificacao(String questoes){
        //se o jogador acertou vai ter uma variavel correta para mostra no final
        if(questoes.equalsIgnoreCase("correta")){
            
            certo +=1;
        } else {
            //se o jogador errou vai ter uma variavel erro para mostra no final
            erro +=1;
        }
        // se retornar true, o jogador vai poder continuar jogando, e no momento que tiver 0 nao pode mais errar.
        if (questoes.equalsIgnoreCase("errada") && qtdVida >=1) {
            
            qtdVida -=1;
            return true;
        } else if (questoes.equalsIgnoreCase("correta") && qtdVida >=0) {
            
            return true;
        } else {
            return false;
        
        }
    }
    
    //Essa função é para mostra que o jogador perdeu todas as vidas
    public static void gameOver(){
        System.out.println("Gamer Over");
        System.out.println("Que pena " + nomeJogador + "Mas não desanima, na vida encontramos dificuldades, /n"
                + "mas não podemos desistir. Bora correr atras do prejuízo ?? ");
        controlarJogos = 11; // aqui colocamos o 11 para controlar no metodo do desafios 
    }
    
    public static void creditos(){
        
    }
    
    public static void desafio() {
        System.out.println("Desafio Facil ? (S/N");
        escolherLetra = leitor.next();
        do{
      boolean validacao;
      String resposta;
     
      
     
       
        
        
    }while(controlarJogos < 3);
    }
    
    public static void desafioFacil() {
        System.out.println("sai");
       
    }
    public static void main(String[] args) {
        menu();
        
    }
    
}
