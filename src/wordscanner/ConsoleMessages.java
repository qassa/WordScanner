/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordscanner;

import java.util.Scanner;
import java.io.*;
import static wordscanner.Checks.name;

/**
 *
 * @author Max
 */
public class ConsoleMessages {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.print("Welcome! ");
        Checks.newFileName();
        File textFile = new File(name);
        while(Checks.fileChecks(textFile)==false)
        {
            Checks.newFileName();
        }
        
        String i;
        System.out.println("Введите длину слов: ");
        Scanner sc1 = new Scanner(System.in);
        i=sc1.nextLine();
        
        while(Checks.wordLength(i)==false)
        {
            i = sc1.nextLine();
        }
        int length = Integer.parseInt(i);
        System.out.println("Нужные данные получены. Идет подсчет...");
        
        int count = 0;
        try
        {
            count = WordScanner.searchWords(textFile, length);
        }
        catch(IOException e)
        {
            System.out.println("IO Error!!");
        }
        
        if(count==0) System.out.println("Слов заданной длины не найдено!!");
        else System.out.println("В текстовом документе "+count+" слов с указанной длиной.");
        
        System.exit(0);
    }
    
}
