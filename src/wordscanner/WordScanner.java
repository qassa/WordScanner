/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordscanner;
import java.io.*;

/**
 *
 * @author Max
 */
public class WordScanner {
    public static int searchWords(File textFile, int length) throws IOException
    {
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(textFile)))
        {
            String line = null;
            while ((line = reader.readLine()) != null) 
            {
                String[] words = line.split("[^ъхзщшгнекуцйэждлорпавыфячсмитьбюqwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ]");
                for(String s : words)
                {
                    if (s.length() == length)
                    {
                        count++;
                        System.out.println(s);
                    }
                }
            }
        }
        return count;
    }
}
