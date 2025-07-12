package day_027_date_2025_09_27.pattern;

public class EquilateralDiamond {
    public static void main(String[] args) {
        int n = 5 ;
        equilateralDiamond(n);
    }

    private static void equilateralDiamond(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n+i-1 ; j++) {
                if(j<=n-i){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = n+i-2; j > 0  ; j--) {
                if(j<=n-j){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
