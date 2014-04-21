/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordscanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Checks {
    
    static String name;
    
    public static boolean isTextName(String name)
    {
        Pattern p = Pattern.compile("^([A-Z]:(\\\\[^\\\\/:?*\"<>]+)+\\.txt)|([^\\\\/:?*\"<>]+\\.txt)$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
    public static boolean fileChecks(File file){
        if(file.exists()) System.out.println("Файл существует.. OK");
        else 
        {
            System.out.println("Файл не существует!! Введите новый адрес или создайте файл");
            return false;
        }
        if(file.canRead()) System.out.println("Файл читаем.. ОК");
        else
        {
            System.out.println("Файл не читаем!! Введите адрес другого файла или измените атрибуты существующего");
            return false;
        }
        return true;
    }
    
    public static void newFileName() //для одного метода newFileName нецелесообразно создавать целый отдельный класс, так что пусть он будет в Checks
    {
        System.out.print("Введите адрес текстового файла для продолжения.. ");
        Scanner sc = new Scanner(System.in);
        name=sc.nextLine();
        while(Checks.isTextName(name)==false)
        {
            System.out.println("Некорректное имя файла. Повторите ввод!");
            name = sc.nextLine();
        }
    }
    
    public static boolean wordLength(String i)
    {
        if(isDigit(i)==false) return false;
        else
                {
                    int digit = Integer.parseInt(i);
                    if(digit<1) {System.out.println("Длина слова не может быть меньше 1"); return false;}
                    return true;
                }
    }
    
    public static boolean isDigit(String str)
    {
        try
        {
            Integer.parseInt(str);
        }
        catch(Exception e)
        {
            System.out.println("Ошибка при вводе! Введена строка!!.....");
            return false;
        }
        return true;
    }
}
