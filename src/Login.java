import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        //Inicializa o menu de opções
        menu();

        /*Próximas att

        Verificação para variável vazia
        Salvar login em .txt, para quando fechar o app, continuar com o cadastro criado
        Sistema de tentativas totais mais tarde.

        */

        //Variáveis cadastro

        String nomeCadastro = "HOUSEFLIPERapenasSER8912"; //Fatores didáticos
        String senhaCadastro;
        String confirmacaoSenhaCadastro = "FLI891SER8"; //Fatores didáticos
        String nomeLogin = "OUSEFLIPERapenasSER8912"; //Fatores didáticos
        String senhaLogin = "penasSER891"; //Fatores didáticos
        boolean cadastro = false;

        //Váriaveis cadastro

        Scanner input = new Scanner(System.in);
        int resposta = input.nextInt();
        input.nextLine();


        while (resposta != 3) {

            switch (resposta) {

                case 1:

                    if (cadastro == false) {
                        System.out.println("-----------------------------------------------");
                        System.out.println("Você não possui cadastro. Bora criar uma conta!");
                        System.out.println("-----------------------------------------------\n");
                        menu();
                    } else {

                        while (!nomeLogin.equals(nomeCadastro) && !senhaLogin.equals(confirmacaoSenhaCadastro)) {

                            //Confirmação usuário
                            System.out.println("Digite seu usuário: ");
                            nomeLogin = input.nextLine();
                            while (!nomeLogin.equals(nomeCadastro)) {
                                System.out.println("Usuário incorreto. Tente novamente");
                                nomeLogin = input.nextLine();
                            }

                            //Confirmação senha
                            System.out.println("\nDigite a sua senha: ");
                            senhaLogin = input.nextLine();
                            while (!senhaLogin.equals(confirmacaoSenhaCadastro)) {
                                System.out.println("Senha incorreta. Tente novamente.");
                                senhaLogin = input.nextLine();
                            }

                        }

                        System.out.println("Você está logado.");
                    }
                    break;
                case 2:

                    if (cadastro == true) {
                        System.out.println("\n---------------------------------");
                        System.out.println("Você já possui uma conta criada.");
                        System.out.println("---------------------------------\n");
                    } else {

                        System.out.println("Ok, vamos criar a sua conta!\n");
                        System.out.println("Digite o seu nome de usuário (será usado para acessar a sua conta).");
                        nomeCadastro = input.nextLine();
                        System.out.println("\nAgora digite a sua senha de acesso.");
                        senhaCadastro = input.nextLine();

                        System.out.println("Confirme sua senha.");
                        confirmacaoSenhaCadastro = input.nextLine();


                        while (!confirmacaoSenhaCadastro.equals(senhaCadastro)) { //equals vai comparar se são iguais, mas o ! antes, faz comparar se eles são DIFERENTES.
                            System.out.println("Senha incorreta. Tente novamente.");
                            confirmacaoSenhaCadastro = input.nextLine();
                        }

                        System.out.println("\n----------------------");
                        System.out.println("Cadastro criado.");
                        System.out.println("Retornando ao Menu...");
                        System.out.println("----------------------\n");
                        cadastro = true;
                    }
                    menu();
                    break;
                default:
                    System.out.println("Por favor, digite uma das opções indicadas.");
                    break;
            }
            resposta = input.nextInt();
            input.nextLine();
        }

        if (resposta == 3) {
            System.out.println("Encerrando aplicativo.");
        }
    }

    static void menu() {
        System.out.println("Olá, tudo bem? Já possui uma conta?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        System.out.println("3- Sair");
    }
}