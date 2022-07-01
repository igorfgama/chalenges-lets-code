import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Enunciado
 *
 * Criar um programa que converta moedas. Dado um número limitado de conversões:
 *
 * USD - AUD: 1.44
 * USD - BRL: 5.15
 * BRL - EUR: 0.18
 * EUR - GBP: 0.86
 *
 * Encontre a conversão para outras combinações não listadas:
 *
 * Entrada:
 *
 * USD - AUD: 1.44
 * USD - BRL: 5.15
 * BRL - EUR: 0.18
 * EUR - GBP: 0.86
 *
 * GBP - USD
 *
 * Saida:
 *
 * GBP - USD: 1.25
 */
public class ChalengeFive {
    public enum currencies{
        AUD("Dólar Australiano"),
        BRL("Real"),
        CNY("Iuane Chinês"),
        EUR("Euro"),
        GBP("Libra Esterlina"),
        RUB("Rublo Russo"),
        USD("Dólar");

        private String currency;

        currencies(String currency){
            this.currency = currency;
        }

        public String getCurrency() {
            return currency;
        }
    }

    public static BigDecimal convertion(currencies currencies){
        switch (currencies){
            case AUD -> { return new BigDecimal(3.61); }
            case BRL -> { return new BigDecimal(1.00); }
            case CNY -> { return new BigDecimal(0.79); }
            case EUR -> { return new BigDecimal(5.52); }
            case GBP -> { return new BigDecimal(6.39); }
            case RUB -> { return new BigDecimal(0.095); }
            case USD -> { return new BigDecimal(5.31); }
            default -> System.out.println("Moeda não registrada.");
        }
        return null;
    }

    public static void convertionMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("/// CONVERSÃO DE MOEDAS ///\n\n\n");

        System.out.println("AUD (Dólar Australiano),\n" +
                "        BRL (Real)\n" +
                "        CNY (Iuane Chinês)\n" +
                "        EUR (Euro)\n" +
                "        GBP (Libra Esterlina)\n" +
                "        RUB (Rublo Russo)\n" +
                "        USD (Dólar)");

        System.out.println("Sair para fechar o programa");
        String currencyIn = new String("");
        String currencyOut = new String("");
        while(!(currencyIn.equals("Sair")) || !(currencyOut.equals("Sair"))){
            System.out.print("Selecione a moeda a ser convertida: ");
             currencyIn = scanner.nextLine();

            BigDecimal value = new BigDecimal("0");

            switch (currencyIn){
                case "AUD" -> value = convertion(currencies.AUD);
                case "BRL" -> value = convertion(currencies.BRL);
                case "CNY" -> value = convertion(currencies.CNY);
                case "EUR" -> value = convertion(currencies.EUR);
                case "GBP" -> value = convertion(currencies.GBP);
                case "RUB" -> value = convertion(currencies.RUB);
                case "USD" -> value = convertion(currencies.USD);
                default -> System.out.println("Valor inválido.");
            }

            System.out.print("Selecione a outra moeda: ");
            currencyOut = scanner.nextLine();

            switch (currencyOut){
                case "AUD" -> value = value.divide(convertion(currencies.AUD), 2, RoundingMode.HALF_UP);
                case "BRL" -> value = value.divide(convertion(currencies.BRL), 2, RoundingMode.HALF_UP);
                case "CNY" -> value = value.divide(convertion(currencies.CNY), 2, RoundingMode.HALF_UP);
                case "EUR" -> value = value.divide(convertion(currencies.EUR), 2, RoundingMode.HALF_UP);
                case "GBP" -> value = value.divide(convertion(currencies.GBP), 2, RoundingMode.HALF_UP);
                case "RUB" -> value = value.divide(convertion(currencies.RUB), 2, RoundingMode.HALF_UP);
                case "USD" -> value = value.divide(convertion(currencies.USD), 2, RoundingMode.HALF_UP);
                default -> System.out.println("Valor inválido.");
                    
            }

            System.out.println(currencyIn + " - " + currencyOut + ": " + value);
        }

    }
}
