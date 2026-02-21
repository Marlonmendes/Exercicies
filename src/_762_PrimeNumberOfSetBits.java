public class _762_PrimeNumberOfSetBits {

    public static int countPrimeSetBits(int left, int right) {

        int count = 0;

        for(int i=left;i<=right;i++){
            int valor = Integer.bitCount(i);
            boolean primo = true;

            if (valor <= 1) {
                primo = false;
            } else {
                for (int j = 2; j <= Math.sqrt(valor); j++) {
                    if (valor % j == 0) {
                        primo = false;
                        break;
                    }
                }
            }

            if (primo) {
                count++;
            }
        }
        return count;
    }

    static void main(String[] args) {
        countPrimeSetBits(10,15);
    }

}
