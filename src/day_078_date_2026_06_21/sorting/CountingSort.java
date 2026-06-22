package day_078_date_2026_06_21.sorting;

public class CountingSort {
    public static void main(String[] args) {
        String s1 = "edsab";
        System.out.println("Test 1 ans should be abdes: "+countSort(s1));

        String s2 = "geeksforgeeks";
        System.out.println("Test 2 ans should be geeksforgeeks: "+countSort(s2));
    }
    public static String countSort(String s) {
        // code here
        char[] lettersCount = new char[26];
        
        for (char c : s.toCharArray()) {
            lettersCount[c-'a']++;
        }
        
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int count = lettersCount[i];
            while(count>0){
                st.append((char)('a'+i));
                count--;
            }
        }
        
        
        return st.toString();
    }
}
