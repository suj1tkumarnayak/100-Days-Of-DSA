package day_027_date_2025_09_27.pattern;

//                  *
//                 * *
//                *   *
//               *     *
//              *       *
//             *         *
//            *************

public class HollowTraingle {
    public static void main(String[] args) {
        int n = 7;
        hollowTriangle(n);
    }

    private static void hollowTriangle(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= 2*n-1 ; j++) {
                if(j<= n-i){
                    System.out.print(" ");
                }
                else if (j==n-i+1 || j==n+i-1 || i==n) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
