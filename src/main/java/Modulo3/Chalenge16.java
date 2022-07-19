package Modulo3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chalenge16 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(\\s(([a-z][a-z]\\s)*[A-Z][a-z]+))+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Fulano da Silva Almeida Jesus");
        System.out.println(matcher.find() ? "Válido." : "Inválido.");
    }
}
