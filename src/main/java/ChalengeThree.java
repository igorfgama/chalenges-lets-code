import java.util.InputMismatchException;
import java.util.Scanner;

public class ChalengeThree {

    public static void sumNumbers(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Entre com o 1º valor: ");
            int firstNumber = scanner.nextInt();
            System.out.println("Entre com o 2º valor: ");
            int secondNumber = scanner.nextInt();

            int sum = 0;
            if(firstNumber > secondNumber){
                for(int i=secondNumber;firstNumber >= secondNumber;firstNumber--,i++){
                    sum+=firstNumber;
                    System.out.printf(i + ",");
                }
            } else {
                for(;firstNumber <= secondNumber;firstNumber++){
                    sum+=firstNumber;
                    System.out.printf(firstNumber + ",");
                }
            }
            System.out.printf(" Soma: " + sum);
        } catch (InputMismatchException i){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}
