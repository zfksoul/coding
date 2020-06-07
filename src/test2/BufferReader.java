package test2;

import java.io.*;
import java.util.Scanner;

public class BufferReader {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\1.txt"))));
        Scanner in = new Scanner(new FileInputStream(new File("D:\\1.txt")));
        String s;
        while(in.hasNext()){
            s = in.nextLine();
            System.out.println(s);
        }
    }
}
