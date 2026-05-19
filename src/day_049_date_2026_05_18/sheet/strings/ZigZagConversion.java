package day_049_date_2026_05_18.sheet.strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
    private static String convert(String s, int numRows){
        //Edge case
        if(numRows == 1 || s.length()<=numRows){
            return s;
        }

        // Create Stringbuilder for each row
        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean isGoingDown = false;
        
        for (char ch : s.toCharArray()) {
            rows.get(currRow).append(ch);
            if(currRow==0 || currRow==numRows-1){
                isGoingDown = !isGoingDown;
            }

            currRow += isGoingDown?1:-1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder st : rows) {
            result.append(st);
        }

        
        return result.toString();
    }
}
