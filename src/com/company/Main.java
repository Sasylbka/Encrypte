package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static String russianAlphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя";

    public static String BlockMethod(String text, String keyword){
        String newText="";
        List<Integer> places=new ArrayList<>();
        int j=0;
        String sortedKey = Stream.of(keyword.split("")).sorted().collect(Collectors.joining());
        for(int i =0;i<text.length();i++){
        }
        return newText;
    }
    public static String Multialphabetic(String text, String keyWord) {
        String alphabets[] = new String[keyWord.length()];
        for (int i = 0; i < keyWord.length(); i++) {
            alphabets[i] = russianAlphabet.substring(russianAlphabet.indexOf(keyWord.charAt(i)), russianAlphabet.length()) +
                    russianAlphabet.substring(0, russianAlphabet.indexOf(keyWord.charAt(i)));
        }
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alphabets.length; j++) {

                newText += russianAlphabet.charAt(alphabets[j].indexOf(text.charAt(i)));
                i++;
                if (j == alphabets.length - 1) {
                    if (i != text.length()) {
                        j = -1;
                    }
                }
                if(i == text.length()){
                    break;
                }
            }

        }
        return newText;
    }

    public static String caesarAlphabet(String text, int countOfSymbols, String direction) {
        text = text.toLowerCase(Locale.ROOT);
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if (direction.equals("R")) {
                int temp_int = russianAlphabet.indexOf(text.charAt(i));
                if (temp_int - countOfSymbols < 0) {
                    temp_int = russianAlphabet.length() - countOfSymbols - temp_int;
                } else {
                    temp_int = temp_int - countOfSymbols;
                }
                newText += russianAlphabet.charAt(temp_int);
            } else {

                int temp_int = russianAlphabet.indexOf(text.charAt(i));
                if (temp_int + countOfSymbols > russianAlphabet.length() - 1) {
                    temp_int = (russianAlphabet.length() - countOfSymbols - temp_int) * -1;
                } else {
                    temp_int = temp_int + countOfSymbols;
                }
                newText += russianAlphabet.charAt(temp_int);
            }
        }
        return newText;
    }

    public static void main(String[] args) {
        int punct = 0;
        System.out.println("Методы дешифрования:");
        System.out.println("1.Метод Цезаря");
        System.out.println("2.Многоалфавитное");
        System.out.println("3.Блочная перестановка");
        System.out.println("4.Гамма по модулю n");
        Scanner scanner = new Scanner(System.in);
        while (punct == 0) {
            punct = scanner.nextInt();
            if (punct == 1) {
                System.out.println("Введите зашифрованный текст:");
                String text = scanner.next();
                System.out.println("Введите количество символов, на которое сдвинут алфавит:");
                int countOfSymbols = scanner.nextInt();
                System.out.println("Введите направление сдвига(L или R):");
                String direction = scanner.next();
                System.out.println("Дешифрованный текст:" + caesarAlphabet(text, countOfSymbols, direction));
            }
            if (punct == 2) {
                System.out.println("Введите зашифрованный текст:");
                String text = scanner.next();
                System.out.println("Введите кодовое слово:");
                String keyWord = scanner.next();
                System.out.println("Дешифрованный текст:"+Multialphabetic(text, keyWord));
            }
            if (punct == 3) {
                System.out.println("Введите зашифрованный текст:");
                String text = scanner.next();
                System.out.println("Введите кодовое слово:");
                String keyWord = scanner.next();
                System.out.println("Дешифрованный текст:"+BlockMethod(text, keyWord));
            }

            if (punct == 4) {

            }
        }
    }
}

