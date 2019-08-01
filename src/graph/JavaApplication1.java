package code;

import java.util.Scanner;
/**
 *
 * @author SU393542
 */
public class JavaApplication1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.println("enter the String");        
        String str = sc.nextLine();
        String s[] = new String[str.length()];
        int b=0;
        
        for(int i=0;i<str.length();i++){
            int c=i;
            int a = Integer.parseInt(String.valueOf(str.charAt(i)));
            while(i<str.length()-1 && Integer.parseInt(String.valueOf(str.charAt(i+1)))==(a+1) ){
                i++;
                a++;                
            }
            s[b]=str.substring(c,i+1);
            b++;
        }
        int max = s[0].length();
        System.out.println(max);
        for(int j=1;j<b;j++){
            if(max<s[j].length())
                max = s[j].length();
        }
        
        for(int k=0;k<b;k++){
            int l = s[k].length();
            if(l==max){
                System.out.println(s[k]);
                break;
        }}
        
        
    } 
}
