
import java.util.Scanner;

public class MiniGame {

    //separar meu jogo em outra função?//

    //Variáveis estáticas, ou seja, eu não as perco entre as chamadas

    static String nomeCadastro = "";
    static String senhaCadastro = "";
    static String nome = "";
    static boolean cadastro = false;

    //Final Variáveis estáticas

    public static void main(String[] args) {

        //Próxima fase será tentar quebrar o jogo em métodos (retirando os if e else). E, MAIS DEPOIS AINDA, tentar focar em fazer com while e switch.

        Scanner input = new Scanner(System.in);
        boolean acesso = login(input);

        if (!acesso) {
            return; //Caso não possua login ou encerre o aplicativo, o programa irá fechar
        }

        System.out.println("\nAcesso Autorizado!\n");
        System.out.println(String.format("Seja bem-vindo, %s.", nome));
        System.out.println("Você possui R$108,00 na sua conta.");
        double valorGuardado = 108;

        System.out.println("Você deseja ir ao cinema hoje?");
        String respostaCinema = input.next(); //next pega apenas uma palavra, enquanto o nextLine pega a linha inteira.
        input.nextLine();

        if (respostaCinema.equalsIgnoreCase("Sim")) {
            System.out.println("OK! Vamos lá.");
            System.out.println("Qual filme você quer assistir?");
            //Adicionar: mostrar quais filmes estão no cartaz
            String filme = input.nextLine();
            boolean confirmacaoFilme;

            switch (filme.toLowerCase()) {
                case "bolt":
                    confirmacaoFilme = true;
                    filme = "Bolt";
                    break;
                case "meu malvado favorito":
                    confirmacaoFilme = true;
                    filme = "Meu Malvado Favorito";
                    break;
                case "marley e eu":
                    confirmacaoFilme = true;
                    filme = "Marley & Eu";
                    break;
                case "a culpa é das estrelas":
                    confirmacaoFilme = true;
                    filme = "A Culpa é das Estrelas";
                    break;
                default:
                    System.out.println("Este filme não está no cartaz");
                    confirmacaoFilme = false;
                    break;
            }


            if (confirmacaoFilme) {
                System.out.println("Ok, vamos assistir " + filme + ".\n");
                System.out.println("Indo ao cinema... \n");

                System.out.println("Você passa por um mendigo. \n");
                System.out.println("-Ei, você poderia me ajudar com 2 reais? (1 para sim, 2 para não)");
                int respostaMendigo = input.nextInt();
                input.nextLine();


                //Historinha
                if (respostaMendigo == 1) {
                    System.out.println("\nMUITO OBRIGADO!");
                    System.out.println("Deus lembrará disso.");
                    System.out.println("Sorte: +10%\n");
                    //fazer uma variavel que mede o meu nivel de sorte ajudando aos outros.
                    //podendo me fazer liberar promoções caso minha sorte seja alta, por exemplo.
                    //ou me trazendo recompensas quando eu ajudo alguém.
                } else if (respostaMendigo == 2) {
                    System.out.println("\nTudo bem. Obrigado.");
                    System.out.println("Felicidade: -7%\n");
                } else {
                    System.out.println("\nVocê o ignorou.");
                    System.out.println("Deus lembrará disso.\n");
                    System.out.println("Sorte: -2%");
                }

                System.out.println("Chegando no cinema...");
                System.out.println("Quantos ingressos deseja?");
                int ingressos = input.nextInt();
                input.nextLine();
                double valorIngresso = 12;
                double totalIngresso = ingressos * valorIngresso;

                if (ingressos >= 3) {
                    System.out.println("\nVocê descobriu uma promoção: acima de 3 ingressos, um é grátis!");
                    System.out.println("""
                            Você economizou.
                            Felicidade: +5%
                            """);
                    totalIngresso -= 12; //valor de desconto, ou seja, o total do ingresso menos o ingresso que vai sair de graça.
                    valorGuardado -= totalIngresso; //subtrai do meu total.
                    System.out.println("Você gastou: " + totalIngresso);
                    System.out.println("Ainda te resta: " + valorGuardado + "\n");
                } else {
                    valorGuardado -= totalIngresso;
                    System.out.println("\nVocê gastou: " + totalIngresso);
                    System.out.println("Ainda te resta: " + valorGuardado + "\n");
                    //continuar
                }
            } else {
                System.out.println("Você ficou em casa.");
                System.out.println("Felicidade: -10%");
            }

        } else {
            System.out.println("\nCerto. Você quem manda.\n");
            System.out.println("Você não gastou dinheiro. Sua avó lhe deu mais R$50,00.");
            valorGuardado += 50;
            System.out.println(String.format("Seu saldo final foi de R$%.2f.", valorGuardado));
        }
    }

    static boolean login(Scanner input) {

        //while true NUNCA para, a menos que receba break ou return.
        while (true) {

            menu();
            int resposta = input.nextInt();
            input.nextLine();

            switch (resposta) {

                case 1:

                    //!cadastro é a mesma coisa que cadastro == false
                    if (!cadastro) {
                        System.out.println("-----------------------------------------------");
                        System.out.println("Você não possui cadastro. Crie um antes de logar.");
                        System.out.println("-----------------------------------------------\n");

                    } else {

                        System.out.print("Digite seu usuário: "); //PRINT SEM O LN PERMITE QUE EU DIGITE AO LADO, NÃO ABAIXO.
                        String nomeLogin = input.nextLine();

                        //Confirmação usuário
                        while (!nomeLogin.equals(nomeCadastro)) {
                            System.out.print("Usuário incorreto. Tente novamente: ");
                            nomeLogin = input.nextLine();
                        }


                        System.out.print("\nDigite a sua senha: ");
                        String senhaLogin = input.nextLine();

                        //Confirmação senha
                        while (!senhaLogin.equals(senhaCadastro)) {
                            System.out.print("Senha incorreta. Tente novamente: ");
                            senhaLogin = input.nextLine();
                        }
                        return true;
                    }
                    break;
                case 2:

                    if (cadastro == true) {
                        System.out.println("\n---------------------------------");
                        System.out.println("Você já possui uma conta criada.");
                        System.out.println("---------------------------------\n");
                    } else {

                        System.out.println("Vamos criar a sua conta!\n");

                        System.out.println("Como devo te chamar?");
                        nome = input.nextLine();


                        System.out.println("É um prazer, " + nome + "!\n");

                        System.out.print("Digite o seu nome de usuário (será usado para acessar a sua conta): ");
                        nomeCadastro = input.nextLine();
                        System.out.print("\nAgora digite a sua senha de acesso: ");
                        senhaCadastro = input.nextLine();

                        System.out.print("Confirme sua senha: ");
                        String confirmacao = input.nextLine();


                        while (!confirmacao.equals(senhaCadastro)) { //equals vai comparar se são iguais, mas o ! antes, faz comparar se eles são DIFERENTES.
                            System.out.print("Senha incorreta. Tente novamente: ");
                            confirmacao = input.nextLine();
                        }

                        System.out.println("\n----------------------");
                        System.out.println("Cadastro criado.");
                        System.out.println("Retornando ao Menu...");
                        System.out.println("----------------------\n");
                        cadastro = true;
                    }
                    break;
                case 3:
                    System.out.println("Encerrando aplicativo.");
                    return false;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        }

    }


    static void menu() {
        System.out.println("-------MENU-------");
        System.out.println("1- Fazer login");
        System.out.println("2- Cadastrar");
        System.out.println("3- Sair");
        System.out.print("Escolha: ");
    }
}

