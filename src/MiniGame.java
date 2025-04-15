import java.util.Scanner;

    public class MiniGame {
        public static void main(String[] args) {

            //Próxima fase será tentar quebrar o jogo em métodos (retirando os if e else). E, MAIS DEPOIS AINDA, tentar focar em fazer com while e switch.

            Scanner inputTeclado = new Scanner(System.in);
            System.out.println("Digite a sua senha");
            //dar dicas da senha mais pra frente, conforme tentativa e erro

            int senha = inputTeclado.nextInt();
            inputTeclado.nextLine(); //serve para consumir o ENTER do nextInt, já que ele não o consome, passando uma string vazia
            //para o próximo scanner

            //criar um sistema de felicidade que impacta diretamente nas escolhas

            if (senha == 2025) {
                System.out.println("Acesso Autorizado!\n");
                System.out.println("Seja Bem-vindo, Carlos Eduardo.");
                System.out.println("Você possui R$108,00 na sua conta.");

                double valorGuardado = 108;

                System.out.println("Você deseja ir ao cinema hoje?");
                String respostaCinema = inputTeclado.next(); //next pega apenas uma palavra, enquanto o nextLine pega a linha inteira.
                inputTeclado.nextLine();

                if (respostaCinema.equalsIgnoreCase("Sim")) {
                    System.out.println("OK! Vamos lá.");
                    System.out.println("Qual filme você quer assistir?");
                    //Adicionar: mostrar quais filmes estão no cartaz
                    String filme = inputTeclado.nextLine();
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
                        int respostaMendigo = inputTeclado.nextInt();
                        inputTeclado.nextLine();


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
                        int ingressos = inputTeclado.nextInt();
                        inputTeclado.nextLine();
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
            } else {
                System.out.println("Senha incorreta. Acesso negado.");
            }
        }
    }
