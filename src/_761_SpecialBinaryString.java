import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _761_SpecialBinaryString {

    public static String makeLargestSpecial(String s) {

        StringBuilder groupBinary = new StringBuilder();
        String groupFinal = "";

        int count = 0;

        for(int i=1;i<s.length()-1;i++){

            if(s.charAt(i) == '1'){
                groupBinary.append(1);
                count++;
            }else if(s.charAt(i) == '0' && !groupBinary.isEmpty()){
                groupBinary.append(0);
                count--;
            }

            if(count == 0){
                if(groupBinary.isEmpty()){
                    groupFinal = s.substring(1,s.length()-1);
                    continue;
                }
                if(groupFinal.isEmpty() || Integer.parseInt(groupFinal) < Integer.parseInt(String.valueOf(groupBinary))){
                    System.out.println("GrupoFinal Antes: " + groupFinal);
                    System.out.println("GrupoBinario: " + groupBinary);
                    groupFinal =  groupBinary + groupFinal;
                    System.out.println("Grupo Final: " + groupFinal);
                }else{
                    System.out.println("GrupoBinario no ELSE: " + groupBinary);
                    System.out.println("GrupoFinal antes no ELSE: " + groupFinal);
                }

                groupBinary = new StringBuilder();
            }
        }
        return 1 + groupFinal + 0;
    }

    public static String makeLargestSpecial2(String s) {

        StringBuilder groupBinary = new StringBuilder();
        String groupFinal = "";
        List<String> listBinary = new ArrayList<>();

        int count = 0;

        for(int i=0;i<s.length();i++) {

            if (s.charAt(i) == '1') {
                groupBinary.append("1");
                count++;
            } else if (s.charAt(i) == '0') {
                groupBinary.append("0");
                count--;
            }

            if(count == 0){
                groupFinal = groupBinary.toString();
                groupBinary = new StringBuilder(makeLargestSpecial2(groupFinal.substring(1, groupFinal.length() - 1)));

                listBinary.add(1 + groupBinary.toString() + 0);
                groupBinary = new StringBuilder();

            }
        }

        listBinary.sort(Comparator.reverseOrder());
        String finalString = String.join("", listBinary);

        return finalString;
    }
    static void main(String[] args) {
        System.out.println(makeLargestSpecial2("1010101100"));
    }
}