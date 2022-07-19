package Modulo3;

/*
Baseado na lista de contatos abaixo, obtenha os nomes de quem possuí o número 7 no seu número de telefone e liste os
respectivos nomes em ordem alfabética.

Apensa utilizando Stream.
 */

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Chalenge15 {
    public static void main(String[] args) {
        List<Map<String, String>> list = List.of(
                Map.of("nome", "João", "telefone", "9329823423"),
                Map.of("nome", "Maria", "telefone", "9124235435"),
                Map.of("nome", "Marta", "telefone", "9456335387"),
                Map.of("nome", "José", "telefone", "9632874738"),
                Map.of("nome", "Judas", "telefone", "9329244683"),
                Map.of("nome", "Francisco", "telefone", "9329247683"),
                Map.of("nome", "Tarcísio", "telefone", "9329244687"),
                Map.of("nome", "Maria", "telefone", "9329244683"),
                Map.of("nome", "Zeca", "telefone", "7329244683")
        );

        list.stream()
                .map(c -> {
                    if (c.get("telefone").contains("7"))
                        return c;
                    return null;
                })
                .filter(Objects::nonNull)
                .sorted((a,b) -> {
                    return Character.compare(a.get("nome").charAt(0), b.get("nome").charAt(0));
                })
                .forEachOrdered(n -> System.out.println(n.get("nome")));

    }
}
