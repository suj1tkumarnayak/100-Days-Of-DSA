package day_075_date_2026_06_17.dailyproblem;

public class ProcessStringWithSpecialOperationsII {
    public static void main(String[] args) {
        String s = "a#b%*";
        long k = 1;
        System.out.println(processStr(s, k));
    }
    public static char processStr(String s, long k) {
        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            if(Character.isLetter(c)){
                st.append(c);
            }else if(c=='#'){
                st.append(st);
            }else if(c=='*'){
                int n = st.length();
                st.deleteCharAt(n-1);
            }else{
                st.reverse();
            }
        }
        int n = st.length();
        if(k>=n){
            return '.';
        }
        char ans;
        for (long i = 0; i < k; i++) {
            //if(i==k-1) return st.charAt(i);
        }
        return ' ';
    }
}
