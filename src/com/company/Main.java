package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static String russianAlphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
    static String GammaAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя_0123456789";
    static String BitwiseAdditionAlphabet = "!абвгдеёжзийклмнопрстуфхцчшщъыьэюя_0123456789abcdefghijklmnopqrstuvwxyz";

    public static String BitwiseAddition(String text,String gamma){
        String newText="";
        List <Integer> textCharsToInteger= new ArrayList<>();
        List <String> textIntegerToBytes=new ArrayList<>();
        List <Integer> gammaCharsToInteger = new ArrayList<>();
        List <String> gammaIntegerToBytes=new ArrayList<>();
        List <String> codingText= new ArrayList<>();
        List <Integer> codingTextInteger= new ArrayList<>();
        for(int i = 0;i<text.length();i++){
            textCharsToInteger.add(BitwiseAdditionAlphabet.indexOf(text.charAt(i)));
            if(Integer.toBinaryString(textCharsToInteger.get(i)).length()<6){
                int temp1= 6-Integer.toBinaryString(textCharsToInteger.get(i)).length();
                String temp2=Integer.toBinaryString(textCharsToInteger.get(i));
                for(int j=0;j<temp1;j++){
                    temp2="0"+temp2;
                }
                textIntegerToBytes.add(temp2);
            }
            else {
                textIntegerToBytes.add(Integer.toBinaryString(textCharsToInteger.get(i)));
            }
        }

        for(int i = 0;i<gamma.length();i++){
            gammaCharsToInteger.add(BitwiseAdditionAlphabet.indexOf(gamma.charAt(i)));
            if(Integer.toBinaryString(gammaCharsToInteger.get(i)).length()<6){
                int temp1= 6-Integer.toBinaryString(gammaCharsToInteger.get(i)).length();
                String temp2=Integer.toBinaryString(gammaCharsToInteger.get(i));
                for(int j=0;j<temp1;j++){
                    temp2="0"+temp2;
                }
                gammaIntegerToBytes.add(temp2);
            }
            else {
                gammaIntegerToBytes.add(Integer.toBinaryString(gammaCharsToInteger.get(i)));
            }
        }

        for(int i=0;i<textIntegerToBytes.size();i++){
            for (int j=0;j<gammaIntegerToBytes.size();j++){
                String temp ="";
                for(int z=0;z<6;z++){
                    if(gammaIntegerToBytes.get(j).charAt(z)=='0' && textIntegerToBytes.get(i).charAt(z)=='0'){
                        temp=temp+"1";
                    }
                    if(gammaIntegerToBytes.get(j).charAt(z)=='1' && textIntegerToBytes.get(i).charAt(z)=='0'){
                        temp=temp+"0";
                    }
                    if(gammaIntegerToBytes.get(j).charAt(z)=='0' && textIntegerToBytes.get(i).charAt(z)=='1'){
                        temp=temp+"0";
                    }
                    if(gammaIntegerToBytes.get(j).charAt(z)=='1' && textIntegerToBytes.get(i).charAt(z)=='1'){
                        temp=temp+"1";
                    }
                }
                codingText.add(temp);
                i++;
                if(i==textIntegerToBytes.size()){break;}
            }
            if(i==textIntegerToBytes.size()){break;}
            else {
                i--;
            }
        }

        for(int i = 0;i<codingText.size();i++){
            newText+=BitwiseAdditionAlphabet.charAt(Integer.parseInt(codingText.get(i), 2));
        }

        return newText;
    }

    public static String GammaMethod(String text,String gamma){
        StringBuilder newText = new StringBuilder();
        List <Integer> textCharsToInteger= new ArrayList<>();
        List <Integer> gammaCharsToInteger = new ArrayList<>();
        for(int i = 0;i<text.length();i++){
            textCharsToInteger.add(GammaAlphabet.indexOf(text.charAt(i)));
        }
        for(int i = 0;i<gamma.length();i++){
            gammaCharsToInteger.add(GammaAlphabet.indexOf(gamma.charAt(i)));
        }
        for(int i = 0;i<textCharsToInteger.size();i++){
            for (Integer integer : gammaCharsToInteger) {
                int temp1 = textCharsToInteger.get(i);
                int temp2 = integer;
                textCharsToInteger.set(i, temp1 - temp2);
                textCharsToInteger.set(i, textCharsToInteger.get(i) + 44);
                if (textCharsToInteger.get(i) % GammaAlphabet.length() == 0) {
                    textCharsToInteger.set(i, GammaAlphabet.length()-1);
                } else {
                    textCharsToInteger.set(i, textCharsToInteger.get(i) % GammaAlphabet.length()-1);
                }
                i++;
                if(i==textCharsToInteger.size()){break;}
            }
            if(i==textCharsToInteger.size()){break;}
            else {
                i--;
            }
        }
        for (Integer integer : textCharsToInteger) {
            newText.append(GammaAlphabet.charAt(integer));
        }
        return newText.toString();
    }

    public static String BlockMethod(String text, String keyword) {
        String newText = "";
        String sortedKey = Stream.of(keyword.split("")).sorted().collect(Collectors.joining());
        HashMap<Integer,Integer> places= new HashMap<>();
        for(int i =0;i<keyword.length();i++){
            places.put(i,i);
        }
        for(int i =0;i<sortedKey.length();i++){
            for(int j=0;j<keyword.length();j++){
                if(sortedKey.charAt(i)==keyword.charAt(j)){
                    places.replace(j,i);
                    if(i!=sortedKey.length()-1){
                        if(sortedKey.charAt(i)==sortedKey.charAt(i+1)){
                            i++;
                        }
                        else{break;}
                    }
                    else {
                        break;
                    }
                }
            }
        }
        for(int i=0;i<text.length();i++){
            String temp=text.substring(i,i+keyword.length());
            i=i+keyword.length()-1;
            for(int j =0;j<temp.length();j++){
                newText+=temp.charAt(places.get(j));
            }
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
        System.out.println("5.Метод побитового сложения сообщения и гаммы");
        System.out.println("Метод шифрования:");
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
                System.out.println("Введите зашифрованный текст:");
                String text = scanner.next();
                System.out.println("Введите гамму:");
                String gamma = scanner.next();
                System.out.println("Дешифрованный текст:"+GammaMethod(text,gamma));
            }
            if (punct == 5) {
                System.out.println("Введите зашифрованный текст:");
                String text = scanner.next();
                System.out.println("Введите гамму:");
                String gamma = scanner.next();
                System.out.println("Дешифрованный текст:"+BitwiseAddition(text,gamma));
            }
        }
    }
}

