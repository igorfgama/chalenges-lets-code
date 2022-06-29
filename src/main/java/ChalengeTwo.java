/*
Enunciado
Crie um programa que recebe duas listas de números separadas por vírgula.
Criar uma terceira lista para unir as duas listas recebidas, eliminando os itens repetidos.
Imprimir a lista final em ordem decrescente.

Entrada:

Lista 1 => 1,2,3,4
Lista 2 => 2,5
Saida: 5,4,3,2,1
*/

import java.util.*;

public class ChalengeTwo {
    public static void entryValuesLists(){
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        System.out.println("LISTA 1");
        addListValues(firstList);
        System.out.println("LISTA 2");
        addListValues(secondList);
        joiningLists(firstList, secondList);
    }

    private static void joiningLists(List<Integer> firstList, List<Integer> secondList) {
        Set<Integer> joinList = new HashSet<>();

        joinList.addAll(firstList);
        joinList.addAll(secondList);

        joinList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(i -> System.out.print(i + ","));
    }

    private static void addListValues(List<Integer> list){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Entre o valor das listas separado por vírgula");

            String line = scanner.nextLine();
            Scanner readLine = new Scanner(line);
            readLine.useDelimiter(",");

            while (readLine.hasNext()) {
                list.add(Integer.parseInt(readLine.next()));
            }
        } catch (InputMismatchException i){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}