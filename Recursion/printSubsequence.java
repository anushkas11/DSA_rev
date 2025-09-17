import java.util.*;
public class printSubsequence{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String up=sc.next();
        String p="";
        subseq(p,up);
    }
    public static void subseq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }

}