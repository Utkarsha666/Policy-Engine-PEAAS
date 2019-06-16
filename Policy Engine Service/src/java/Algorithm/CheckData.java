package Algorithm;

import java.util.Random;


public class CheckData {

    public String privateKey() {

        final String alphabet = "0123456789abcdef";
        final int N = alphabet.length();
        String str="";
        int count=0;
        Random r = new Random();
      char arr[] = new char[60];
        for (int i = 0; i < 60; i++) {
            System.out.print(alphabet.charAt(r.nextInt(N)));
             arr[i] = alphabet.charAt(r.nextInt(N));
            System.out.println("keysccc = " + arr[i]);
            System.out.println(count++);
       
        }
        System.out.println("start");
        for(int i=0; i < arr.length; i++)
        {
            System.out.println("end");
       
          str+=arr[i];  
        }
        System.out.println("str = " + str);
        return str;

    }
}
