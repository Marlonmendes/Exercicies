import java.util.ArrayList;
import java.util.List;

public class _401_BinaryWatch {

    static void main(String[] args) {
        System.out.println(readBinaryWatch2(1));
    }

    //Meu Codigo
    public static List<String> readBinaryWatch(int turnedOn) {

        List<String> listBinary = new ArrayList<>();

        for(int i=0;i<=11;i++){
            int bit_I = Integer.bitCount(i);
            for (int j=0;j<=59;j++){
                int bit_J = Integer.bitCount(j);

                if((bit_I + bit_J) == turnedOn){
                    listBinary.add(String.format("%d:%02d", i, j));
                    //System.out.println("BIT i: " + i);
                    //System.out.println("BIT j: " + j);
                }
            }
        }

        return listBinary;
    }

    //Codigo 0 Runtime
    public static List<String> readBinaryWatch2(int turnedOn) {
        List<String> ans = new ArrayList<>();
        if(turnedOn > 8){
            return ans;
        }
        recurhour(ans , new StringBuilder() , 0 , 4 , turnedOn , 0);
        return ans;
    }
    static void recurhour(List<String> ans , StringBuilder ds , int total , int bitno , int limit , int on){
        // System.out.println(total);
        if(bitno == 0){
            if(total > 11){
                return;
            }
            if(total == 11){
                ds.append("11");
            }
            else if(total == 10){
                ds.append("10");
            }else{
                ds.append((char)(total + '0'));
            }
            ds.append(':');
            recurmin(ans , ds , 0 , 6, limit , on , ds.length());
            ds.setLength(0);
            return;
        }
        int ntotal = total + (1<<(bitno-1));
        if(on < limit){
            recurhour(ans , ds , ntotal , bitno-1 , limit , on+1);
        }
        recurhour(ans  , ds , total  , bitno-1, limit , on);
        return;
    }
    static void recurmin( List<String> ans , StringBuilder ds , int total , int bitno , int limit , int on , int len){
        if(bitno == 0){
            if(on!=limit){
                return;
            }
            if(total > 59){
                return;
            }

            if(total >= 10){
                // ds.append("10");
                ds.append((char)(total/10 + '0'));
                ds.append((char)(total%10 + '0'));
            }else{
                ds.append((char)('0'));
                ds.append((char)(total + '0'));
            }
            ans.add(ds.toString());
            ds.setLength(len);
            return;
        }
        int ntotal = total + (1<<(bitno-1));
        if(on < limit){
            recurmin(ans , ds , ntotal , bitno-1, limit , on+1 , len);
        }

        recurmin(ans  , ds , total  , bitno-1, limit , on , len);
    }

}
