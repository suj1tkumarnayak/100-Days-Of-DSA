package day_075_date_2026_06_17.dailyproblem;

public class ProcessStringWithSpecialOperations {
    public static void main(String[] args) {
        String s = "a#b%*";
        System.out.println(processStr(s));
    }
    public static String processStr(String s) {
        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            if(Character.isLetter(c)){
                st.append(c);
            }else if(c=='#'){
                st.append(st);
            }else if(c=='*'){
                int n = st.length();
                if(n>0){
                    st.deleteCharAt(n-1);
                }
            }else{
                st.reverse();
            }
        }
        return st.toString();
    }
}
