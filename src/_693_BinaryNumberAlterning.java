public class _693_BinaryNumberAlterning {

    public static void main(String[] args) {
        hasAlternatingBits(5);
    }

    public static boolean hasAlternatingBits(int n) {
        String strBinary = Integer.toBinaryString(n);
        for(int i=1;i<strBinary.length();i++){
            if(strBinary.charAt(i) == strBinary.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}
