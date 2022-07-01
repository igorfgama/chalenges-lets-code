import java.util.Scanner;

/*
ENUNCIADO:
Una dois arrays de inteiros em um unico array

Regras:
    Nao é permitido uso de Collections ou java.util.Arrays
    Nao é permitido uso de arrays temporários, com exceçao do arrayConsolidado

Ex.: ENTRADA
    [1, 3, 5, 7]
    [2, 4, 6, 8, 12, 15]

SAIDA
    [1, 2, 3, 4, 5, 6, 7, 8, 12, 15]
 */
public class ChalengeFour {
    public static void joinArrays(){
        int MAX_SIZE_ARRAY = defineSizeArrays();

        int[] array1 = new int[MAX_SIZE_ARRAY];
        int[] array2 = new int[MAX_SIZE_ARRAY*2];

        entryValuesArray(array1, 0, MAX_SIZE_ARRAY);
        addValueToArray(array1, array2, MAX_SIZE_ARRAY);
        entryValuesArray(array2, MAX_SIZE_ARRAY, (MAX_SIZE_ARRAY*2));

        quickSort(array2, 0, (MAX_SIZE_ARRAY*2-1));

        int index = 0;
        System.out.print("[");
        while(index < MAX_SIZE_ARRAY*2){
            System.out.printf("%d", array2[index]);
            if(index < MAX_SIZE_ARRAY*2-1)
                System.out.print(", ");
            index++;
        }
        System.out.print("]");
    }

    private static int defineSizeArrays() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Define o tamanho dos arrays: ");
        return scanner.nextInt();
    }

    private static void entryValuesArray(int[] array, int index, int size) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Você pode adicionar até " + size + " valores.");
        System.out.println("Adicione valor negativo para sair.");

        int value;
        do {
            System.out.print("Valor " + (index+1) + ": ");
            value = scanner.nextInt();
            if(value > 0)
                array[index] = value;
            index++;
        } while(index < size || value < 0);
    }

    public static void addValueToArray(int[] array, int[] array2, int size){
        int index = 0;
        while (index < size) {
            array2[index] = array[index];
            index++;
        }
    }

    // ABAIXO, CÓDIGO ADAPTADO EXTRAÍDO DE: http://www.universidadejava.com.br/pesquisa_ordenacao/quick-sort/
    private static void quickSort(int[] array, int bottom, int end) {
        if(end > bottom) {
            int indexPivot = divide(array, bottom, end);
            quickSort(array, bottom, indexPivot - 1);
            quickSort(array, indexPivot + 1, end);
        }
    }

    private static int divide(int[] array, int bottom, int end) {
        int pivot, leftSide, rightSide = end;
        leftSide = bottom + 1;
        pivot = array[bottom];

        while(leftSide <= rightSide) {
            while(leftSide <= rightSide && array[leftSide] <= pivot) {
                leftSide++;
            }
            while(rightSide >= leftSide && array[rightSide] > pivot) {
                rightSide--;
            }
            if(leftSide < rightSide) {
                change(array, rightSide, leftSide);
                leftSide++;
                rightSide--;
            }
        }
        change(array, bottom, rightSide);
        return rightSide;
    }

    private static void change(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
