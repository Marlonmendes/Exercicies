import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _696_CountBinarySubstrings {

    public static int countBinarySubstrings(String s) {

        int count = 0;
        char teste = 0;

        for(int i=0;i<s.length();i++){

            if(teste == s.charAt(i)){
                count++;
            }else {
                teste = s.charAt(i);
            }

        }

        return count;
    }

    static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }


}
