import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        /*Próximas att

        Verificação para variável vazia
        Salvar login em .txt, para quando fechar o app, continuar com o cadastro criado
        Sistema de tentativas totais mais tarde.

        */

        //Variáveis cadastro

        String nomeCadastro = "";
        String senhaCadastro = "";
        boolean cadastro = false;

        //Váriaveis cadastro

        Scanner input = new Scanner(System.in);

        while (true) {
            //Mover de lugar para que leia somente no while, ao invés do switch
            menu();
            int resposta = input.nextInt();
            input.nextLine();

            switch (resposta) {

                case 1:

                    if (cadastro == false) {
                        System.out.println("-----------------------------------------------");
                        System.out.println("Você não possui cadastro. Bora criar uma conta!");
                        System.out.println("-----------------------------------------------\n");
                    } else {

                        System.out.println("Digite seu usuário: ");
                        String nomeLogin = input.nextLine();


                        //Confirmação usuário
                        while (!nomeLogin.equals(nomeCadastro)) {
                            System.out.println("Usuário incorreto. Tente novamente");
                            nomeLogin = input.nextLine();
                        }

                        //Confirmação senha
                        System.out.println("\nDigite a sua senha: ");
                        String senhaLogin = input.nextLine();

                        while (!senhaLogin.equals(senhaCadastro)) {
                            System.out.println("Senha incorreta. Tente novamente.");
                            senhaLogin = input.nextLine();
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
                        String confirmacao = input.nextLine();


                        while (!confirmacao.equals(senhaCadastro)) { //equals vai comparar se são iguais, mas o ! antes, faz comparar se eles são DIFERENTES.
                            System.out.println("Senha incorreta. Tente novamente.");
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
                    System.out.println("Ok. Encerrando aplicativo!");
                    return;
                default:
                    System.out.println("Por favor, digite uma das opções indicadas.");
                    break;
            }
        }
    }

    static void menu() {
        System.out.println("Olá, tudo bem? Já possui uma conta?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        System.out.println("3- Sair");
    }
}

