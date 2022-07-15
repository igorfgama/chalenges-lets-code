package Modulo3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Enunciado
 * Um funcionário recebe uma comissão de 0.5% sobre o valor do seu dia trabalhado.
 * Criar uma função para receber o valor do salário mensal e o ano e partir dessas informações calcular a previsão do salário mês a mês.
 * Considerar apenas os dias úteis (segunda a sexta).
 */
public class Chalenge12 {
    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("6717.17");

        BigDecimal daysWorked = BigDecimal.ZERO;
        for(int i=0;i<12;i++){
            BigDecimal aux = BigDecimal.ZERO;
            aux = aux.add(calculateEarnings(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth().plus(i), LocalDate.now().getDayOfMonth()), value));
            daysWorked = daysWorked.add(aux);
            System.out.println("R$ " + value.multiply(new BigDecimal("0.05").multiply(aux)).setScale(2, RoundingMode.HALF_UP));
        }

        value = value.multiply(daysWorked);
        System.out.println("R$ " + value);
        value = value.setScale(2, RoundingMode.HALF_UP);
        System.out.println("R$ " + value);
    }

    public static BigDecimal calculateEarnings(LocalDate date, BigDecimal earning){
        if(date.lengthOfMonth() == 31){
            if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                return new BigDecimal("21");
            else
                return new BigDecimal("22");
        } else if(date.lengthOfMonth() == 30){
            if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                return new BigDecimal("21");
            else
                return new BigDecimal("22");
        } else return new BigDecimal("20");
    }
}
