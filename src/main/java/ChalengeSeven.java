import java.text.Normalizer;
import java.util.Scanner;

public class ChalengeSeven {
    public void choiceType(){
        String emailBody = "Esse é um teste de e-mail a ser alterado, com acentuação e caixa alta e baixa.";
        Scanner scanner = new Scanner(System.in);

        System.out.println("/// ESCOLHA A OPÇÃO ///");
        System.out.println("1. CAIXA ALTA");
        System.out.println("2. caixa baixa");
        System.out.println("3. estiloCamelo");
        System.out.println("4. Sem Acentuacao");

        int choice = 0;

        while (choice != 5){
            System.out.print("Nº -> ");
            choice = scanner.nextInt();
            sendEMail(emailBody, choice);
        }
    }

    public void sendEMail(String emailBody, int choice){
        switch (choice){
            case 1 -> System.out.println(emailBody.toUpperCase());
            case 2 -> System.out.println(emailBody.toLowerCase());
            case 3 -> toCamelCase(emailBody);
            case 4 -> System.out.println(Normalizer
                        .normalize(emailBody, Normalizer.Form.NFD)
                        .replaceAll("[^\\p{ASCII}]", ""));
            default -> { System.out.println("Entrada inválida"); choiceType(); }
        }
    }

    public static void toCamelCase(String emailBody){
        char[] arrayEmail = emailBody.toCharArray();
        StringBuilder emailCameled = new StringBuilder();

        for (int i=0;i<arrayEmail.length-1;i++) {
            String letter = String.valueOf(arrayEmail[i]);

            if(i==0){
                letter.toLowerCase();
            }

            if (letter.isBlank()) {
                letter.replace(" ", "");
                if(!String.valueOf(arrayEmail[i+1]).isBlank()){
                    letter = String.valueOf(arrayEmail[i+1]).toUpperCase();
                    arrayEmail[i] = arrayEmail[i+1];
                }
            }
            emailCameled.append(letter);
        }
        System.out.println(emailCameled);
    }
}
