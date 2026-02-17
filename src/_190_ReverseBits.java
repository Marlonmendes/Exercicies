public class _190_ReverseBits {

        public static int reverseBits(int n) {

            String intParaBits = Integer.toBinaryString(n);

            System.out.println(intParaBits);

            return n;
        }

    static void main(String[] args) {
        int n = 43261596;

        System.out.println(reverseBits(n));
    }


}
