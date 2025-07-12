package day_027_date_2025_09_27.pattern;

public class EquilateralTriangle {
    public static void main(String[] args) {
        int n = 5;
        //printStarPatter(n);
        //EquilateralTriangle.main2();
        EquilateralTriangle obj = new EquilateralTriangle();
        obj.printStarPatter3(n);
    }
//                 *
//                * *
//               * * *
//              * * * *
//             * * * * *

    private  void printStarPatter(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            boolean star = true;
            for (int j = 0; j < 2*i-1; j++) {
                if(star){
                    System.out.print("*");
                    star = false;
                }else {
                    System.out.print(" ");
                    star = true;
                }
            }
            System.out.println();
        }
    }

    private  void printStarPatter2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2*n-1; j++) {
                if(j<=n-i){
                    System.out.print(" ");
                }else if(j%2==1 && j<=2*i-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    private  void printStarPatter3(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(n-i));
            System.out.println("* ".repeat(i));
        }
    }
}
