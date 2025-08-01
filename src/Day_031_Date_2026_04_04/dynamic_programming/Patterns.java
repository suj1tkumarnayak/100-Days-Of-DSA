package Day_031_Date_2026_04_04.dynamic_programming;

public class Patterns {
    public static void main(String[] args) {
        pattern19(5);
    }

    private static void pattern19(int n) {
        for(int i = n; i>=1; i--){
            int num = 2*(n-i+1);
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < 1; j++) {

            }
        }

        for(int i = 1; i<=n; i++){

        }
    }

    public static void pattern7(int n) {
        for(int i = n-1; i>=0 ; i--){
            for(int j = 0; j < i ; j++){
                System.out.print(" ");
            }
            int num = 2*(n-i-1)+1;
            for(int j = 0; j < num; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern12(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            int num = 2*(n-i);
            for (int j = 1; j <= num; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
