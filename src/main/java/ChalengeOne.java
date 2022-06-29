/*
Escreva um algoritmo que receba um parâmetro String.

    Verificar se há 3 letras "X" em sequência entre dois números que somam 8.

Exemplo: frdts2XXX6xxbl2XXXeee5

Retorna true pois a String possui a combinação "2XXX6" (Sequencia de 3 "X" entre os
números 6 e 2 que somam 8).

 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ChalengeOne {
    static private List<String> queue = new ArrayList<>();
    static private List<String> queueNumber = new ArrayList<>();

    public static boolean wordEntry(){
        try {
            Scanner scanner = new Scanner(System.in);
            String word = "";
            while (word.length() < 5) {
                System.out.print("Entre com a palavra (maior que 5 dígitos): ");
                word = scanner.next();
            }

            return Pattern.matches(".*[0-8]XXX[0-8].*", word);
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}
