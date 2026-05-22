package day_053_date_2026_05_22.bitmanipulation;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n){
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n>>i)&1;
            res+= (bit<<(31-i));
        }

        return res;
    }
    public static int reverseBits2(int n){
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if((n&(1<<i))!=0){
                st.append('1');
            }else{
                st.append('0');
            }
        }

        int res = 0;

        //String reverseBinaryString = st.reverse().toString();
        for (int i = 0; i < 32; i++) {
            if(st.charAt(i)=='1'){
                res |= (1<<i);
            }
        }
        return res;
    }
}
