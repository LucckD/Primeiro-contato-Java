import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        //Acesso as informações (utilizando equals no lugar de ==, que verifica se o CONTEÚDO é igual).
        String senha = "123456";
        if (senha.equals("123456")){
            System.out.println("Acesso Autorizado!\n");
        } else {
            System.out.println("Senha Incorreta.");
            //Claro que não vou fazer algo realmente funcional.
            //Serviu apenas para aprender o equals.
        }

        //Temperatura de Celsius para Fahrenheit
        int temperatura = 28;
        int temperaturaConvertida = (int) ((temperatura * 1.8) + 32);

        //Dados Usuário
        String nome = "Carlos Eduardo";
        int idade = 19;
        double valorGuardado = 108;
        double valorGasto;
        double valorRestante;
        //System.out.println(String.format("Bem-Vindo %s. Hoje você tem %d anos e possui R$%.2f na conta.", nome, idade, valorGuardado));
        System.out.println(String.format("Bem-Vindo, %s. Hoje está fazendo %d " +
                "graus Celsius (ou %d graus Fahrenheit). Com %d anos, " +
                "você tem R$%.2f Reais na conta.\n", nome, temperatura, temperaturaConvertida, idade, valorGuardado));

        //Real para Dólar
        double real = valorGuardado; //só fiz dessa forma por questão de didática, senão faria direto a conversão
        double reaisEmDólar = real * 0.17;
        System.out.println(String.format("Os seus R$%.2f equivalem a $%.2f na cotação atual.", real, reaisEmDólar ));
        //Dólar para Real
        double dolar = valorGuardado;
        double dolarEmReais = dolar * 5.87;
        System.out.println(String.format("Caso você fosse americano, os seus hipotéticos" +
                " $%.2f iriam equivaler a R$%.2f. Péssimo momento para ser brasileiro, não?\n", dolar, dolarEmReais));

        System.out.println("Ah, você quer ir ao cinema? " +
                "OK! Vamos assistir Meu Malvado Favorito. " +
                "Lembrando que o cinema está com uma promoção: acima de 3 ingressos, você ganha 10% de desconto!\n");

        System.out.println("Mas antes, preciso saber se o filme é bom.\n");

        //Screen Match
        System.out.println("Esse é o Screen Match! Descubra se vale a pena ou não assistir algum filme.");
        System.out.println("\nPesquisando...");
        System.out.println("\nFilme: Meu Malvado Favorito");

        //Sistema Screen Match
        int anoDeLancamento = 2010;
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
        String sinopse = """
                Sinopse: Filme baseado em fatos reais (sim, alguém tentou roubar a lua).""";
        System.out.println(sinopse);
        System.out.println("Classificação: Livre");

        //Notas do filme
        double media = (9.8 + 9.9 + 10 + 8.5 + 7.0) / 5;
        System.out.println(String.format("Nota: %.2f", media));


        //Saber se o filme está em algum streaming
        boolean incluidoStream = false;

        if (incluidoStream == true) {
            System.out.println("Este filme está no catalógo da EXPENSIVEFLIX.\n");
        } else {
            System.out.println("Somente nos cinemas.\n");
        }


        //Cinema

        System.out.println("Chegando no cinema...\n");
        int quantidadeIngressos = 3;
        double valorIngresso = 12;
        double valorDesconto = 10;
        double totalIngressos = quantidadeIngressos * valorIngresso;
        double valorTotal;

        if (quantidadeIngressos >= 3) {
            double valorIngressoDesconto = (totalIngressos * valorDesconto) / 100;
            valorTotal = totalIngressos - valorIngressoDesconto;
            valorGasto = valorTotal;
            System.out.println(String.format("Compro %d ingressos...\n", quantidadeIngressos));
            System.out.println(String.format("Legal! Você desbloqueou o desconto especial" +
                    " por ter comprado 3 ou mais ingressos. O valor total será" +
                    " de R$%.2f (desconto de R$%.2f.)", valorTotal, valorIngressoDesconto));
            valorRestante = valorGuardado - valorGasto;
        } else {
            valorTotal = totalIngressos;
            System.out.println(String.format("O valor total ficou em R$%.2f.", valorTotal));
            valorRestante = valorGuardado - valorTotal;
        }


        double precoOriginal = 5.99;
        double percentualDesconto = 5;
        double valorDoDesconto = (precoOriginal * percentualDesconto) / 100;
        double valorComDesconto = precoOriginal - valorDoDesconto;
        char porcentagem = '%';
        System.out.println(String.format("A barrinha custava R$%.2f antes da promoção," +
                " e agora custa R$%.2f (5%c de desconto), quer levar junto com os ingressos?.\n", precoOriginal, valorComDesconto, porcentagem));

        System.out.println("Não, obrigado.\n");

        System.out.println(String.format("Ainda resta R$%.2f na sua conta.\n", valorRestante));


        //Retornando para casa
        char letra = 'a';
        String lugar = "casa";
        //System.out.println("Vou para " + letra + " " + "minha" + cidade);
        System.out.println("Termino o filme.\n");
        System.out.println(String.format("Vou para %c minha %s.", letra, lugar));
    }
}