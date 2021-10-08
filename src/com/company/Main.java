package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

   static char[] russianAlphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    public static String caesarAlphabet(String text,int countOfSymbols,String direction){
       text=text.toLowerCase(Locale.ROOT);
        String newText="";
        for(int i=0;i<text.length();i++){
            if(direction.equals("L")){
                int temp_int=text.indexOf(i);
                if(temp_int-countOfSymbols<0){
                   temp_int=russianAlphabet.length-countOfSymbols-temp_int;
                }
                else{
                    temp_int=temp_int-countOfSymbols;
                }
                newText+=russianAlphabet[temp_int];
            }
            else {

                int temp_int=text.indexOf(i);
                if(temp_int+countOfSymbols>russianAlphabet.length){
                    temp_int=(russianAlphabet.length-countOfSymbols-temp_int)*-1;
                }
                else{
                    temp_int=temp_int+countOfSymbols;
                }
                newText+=russianAlphabet[temp_int];
            }
            }
        return newText;
        }

    public static void main(String[] args) {
        int punct=0;
        System.out.println("Методы дешифрования:");
        System.out.println("1.Метод Цезаря");
        System.out.println("2.Многоалфавитное");
        System.out.println("3.Блочная перестановка");
        System.out.println("4.Гамма по модулю n");
        Scanner scanner=new Scanner(System.in);
	    while(punct==0){
	        punct=scanner.nextInt();
	    if(punct==1){
            System.out.println("Введите зашифрованный текст:");
	        String text=scanner.next();
            System.out.println("Введите количество символов, на которое сдвинут алфавит:");
	        int countOfSymbols=scanner.nextInt();
            System.out.println("Введите направление сдвига(L или R):");
	        String direction=scanner.next();
	        System.out.println(caesarAlphabet(text,countOfSymbols,direction));

        }
	    if(punct==2){

            }
	    if(punct==3){

            }

	    if(punct==4){

            }
        }
    }
}

