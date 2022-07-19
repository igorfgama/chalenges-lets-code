package Modulo3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Enunciado
 * A partir de uma lista de pessoas (nome e data nascimento no formato dd-MM-yy), calcular a idade de cada pessoa em referência a data de hoje.
 * A idade maxima das pessoas é de 99 anos.
 */

public class Chalenge11 {
    public static void main(String[] args) {
        Map<String, String> people = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Pessoas a cadastrar: ");
            int q = scanner.nextInt();
            while(q > 0) {
                System.out.print("Nome: ");
                String name = scanner.next();
                System.out.print("Dia: ");
                int day = scanner.nextInt();
                System.out.print("Mês: ");
                int month = scanner.nextInt();
                System.out.print("Ano: ");
                int year = scanner.nextInt();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");

                LocalDate date = LocalDate.of(year, month, day);
                Period period = Period.between(date, LocalDate.now());
                people.put(name, dtf.format(date));
                System.out.println(period.getYears() + " anos.");
                q--;
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException("Deu ruim.");
        }
    }
}
