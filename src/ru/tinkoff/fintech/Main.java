package ru.tinkoff.fintech;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int index = 0;
    private static final int SIZE_ARRAY = 10; // строго больше нуля!

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Random random = new Random();

        ArraysGenerator arrayProcessingPrinciple1 = (sizeArray, usersInput) -> input + index;

        ArraysGenerator arrayProcessingPrinciple2 = (sizeArray, usersInput) -> input * index;

        ArraysGenerator arrayProcessingPrinciple3 = (sizeArray, usersInput) -> {
            if (index % 2 == 0) {
                return index / 2 + input;
            } else {
                return index * index - input;
            }
        };
        //Рандомно заполняет массив (input + рандомное число (от 0 до index).
        ArraysGenerator arrayProcessingPrinciple4 = (sizeArray, usersInput) -> input + random.nextInt(index);
        //Просто проверка если input - index < sizeArray то часло равно sizeArray + рандомное число (от 0 до sizeArray).
        ArraysGenerator arrayProcessingPrinciple5 = (sizeArray, usersInput) -> {
            if (input - index < sizeArray) {
                return sizeArray + random.nextInt(sizeArray);
            } else {
                return sizeArray + index - input;
            }
        };

        int[] arr1 = getFilledArray(SIZE_ARRAY, input, arrayProcessingPrinciple1);
        int[] arr2 = getFilledArray(SIZE_ARRAY, input, arrayProcessingPrinciple2);
        int[] arr3 = getFilledArray(SIZE_ARRAY, input, arrayProcessingPrinciple3);
        int[] arr4 = getFilledArray(SIZE_ARRAY, input, arrayProcessingPrinciple4);
        int[] arr5 = getFilledArray(SIZE_ARRAY, input, arrayProcessingPrinciple5);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
        scanner.close();

    }

    public static int[] getFilledArray(final int sizeArray, final int usersInput, final ArraysGenerator lambda) {
        int[] filledArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            filledArray[i] = lambda.process(sizeArray, usersInput);
            index++;
        }
        index = 0;
        return filledArray;
    }

}
