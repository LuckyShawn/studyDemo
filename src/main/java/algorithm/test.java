package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @title: test
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/2/5
 */
public class test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("11","11");
        map.put("22","22");
        map.put("33","33");
        map.put("44","44");

        for(String s : map.keySet()){
            System.out.println(map.get(s));
        }

        System.out.println(1 << 4); //16
        System.out.println(1 << 30);//1073741824

        System.out.println(2^3);  //10 ^ 11 = 01 = 1
        System.out.println(1^2);  //01 ^ 10 = 11 = 3
        int a = 15,b = 11;
        int temp = a ^ b;
        a = temp ^ a;
        b = temp ^ b;
        System.out.println("a:"+a);
        System.out.println("b:"+b);


    }
}
