import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Variáveis
        double saldo = 2700.00;
        String nome = "Anna Karolina";
        String tipoConta = "Corrente";

        //Dados Iniciais do Cliente
        System.out.println("\n********************");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println(String.format("Saldo em conta: R$%.2f", saldo));
        System.out.println("********************\n");

        //Chama as operações
        operacoes();
        int opcao = input.nextInt();
        input.nextLine();

        //Rodar o código
        //Enquanto a opção não for SAIR, continua rodando o código.
        while (opcao != 4) {
            //Escolha de Operação
            switch (opcao) {
                case 1:
                    //Consultar valor
                    System.out.println(String.format("Seu saldo atual é: R$%.2f", saldo));
                    break;

                case 2:
                    //Receber valor
                    System.out.println("Ótimo! Quanto deseja receber?");

                    double receberValor = input.nextDouble();
                    input.nextLine();

                    //Confirmação
                    if (receberValor > 1000) {
                        System.out.println("No momento, você só pode receber até R$1000,00 por vez.");
                    } else {
                        System.out.println(String.format("Seu saldo atual será de R$%.2f", saldo + receberValor));
                        System.out.println("Deseja confirmar sua operação? 1 para sim, 2 para não.");
                        int opcaoSaldo = input.nextInt();

                        if (opcaoSaldo == 1) {
                            saldo += receberValor;
                            System.out.println(String.format("Certo. Seu novo saldo é de R$%.2f", saldo));

                        } else if (opcaoSaldo != 1 && opcaoSaldo != 2) {
                            System.out.println("Não foi possível receber a transferência. Insira apenas 1 ou 2.");

                        } else {
                            System.out.println(String.format("Ok. Seu saldo continua sendo R$%.2f", saldo));
                        }
                    }
                    break;

                case 3:
                    //Transferir valor
                    System.out.println("Quanto você deseja transferir?");

                    double transferirValor = input.nextDouble();
                    input.nextLine();

                    //Confirmação
                    System.out.println(String.format("Você está transferindo R$%.2f", transferirValor));
                    System.out.println("Deseja continuar? 1 para sim, 2 para não");
                    int opcaoTransferir = input.nextInt();
                    if (opcaoTransferir == 1) {

                        //Verificar saldo
                        if (transferirValor > saldo) {
                            System.out.println("Você não tem saldo suficiente para transferir.");
                            System.out.println(String.format("Seu saldo: R$%.2f", saldo));
                        } else {
                            saldo -= transferirValor;
                            System.out.println(String.format("Você transferiu R$%.2f", transferirValor));
                            System.out.println(String.format("Saldo restante: R$%.2f", saldo));
                        }
                        //Final verificação saldo

                    } else if (opcaoTransferir != 1 && opcaoTransferir != 2) {
                        System.out.println("Transferência cancelada. Insira apenas 1 ou 2.");
                    } else {
                        System.out.println("Transferência cancelada.");
                        //Final confirmação
                    }
                    break;

                case 4:
                    System.out.println("Encerrando aplicativo.");
                    break;

                default:
                    System.out.println("Por favor, insira uma operção válida.");
                    break;
            }
            operacoes(); //Mostra as operações
            opcao = input.nextInt(); //Serve para que o loop se mantenha até que seja digitado 4.
            input.nextLine(); //Limpa o input (buffer)
        }
    }

    static void operacoes() {
        System.out.println("\nOperações\n");
        System.out.println("1- Consultar saldo");
        System.out.println("2- Receber valor");
        System.out.println("3- Transferir valor");
        System.out.println("4- Sair\n");
        System.out.println("Qual operação deseja fazer?");
    }
}