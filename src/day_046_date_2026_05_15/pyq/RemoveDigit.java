package day_046_date_2026_05_15.pyq;

public class RemoveDigit {
    public static void main(String[] args) {
        String number = "1231";
        char digit = '1';
        System.out.println(removeDigitBrute(number, digit));
    }
    private static String removeDigitBrute(String number, char digit){
        String maxResult = "";
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i)==digit){
                String current = number.substring(0, i)+number.substring(i+1);
                if(maxResult.isEmpty() || current.compareTo(maxResult)>0){
                    maxResult = current;
                }
            }
        }

        return maxResult;
    }
    private static String removeDigit(String number, char digit) {
        String s1 = "";
        String s2 = "";
        int len = number.length();
        for (int i = 0; i < len-1; i++) {
            number.charAt(i);
        }

        if(Integer.parseInt(s1)>Integer.parseInt(s2)){
            return s1;
        }else{
            return s2;
        }
    }
}
