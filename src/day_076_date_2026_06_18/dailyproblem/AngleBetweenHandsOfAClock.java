package day_076_date_2026_06_18.dailyproblem;

public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        // Test Case 0: 08:07 should give 158.5 degrees
        System.out.println("Test 0 (08:07): " + angleClock(8, 7) + "° (Expected: 158.5°)");

        // Test Case 1: 12:30 should give 165 degrees
        System.out.println("Test 1 (12:30): " + angleClock(12, 30) + "° (Expected: 165.0°)");

        // Test Case 2: 3:30 should give 75 degrees
        System.out.println("Test 2 (3:30): " + angleClock(3, 30) + "° (Expected: 75.0°)");

        // Test Case 3: 3:15 should give 7.5 degrees
        System.out.println("Test 3 (3:15): " + angleClock(3, 15) + "° (Expected: 7.5°)");
    }

    public static double angleClock(int hour, int minutes) {
        double clockWise = clockWiseCalcs(hour, minutes);
        //double antiClockWise = antiClockWiseCalcs(hour, minutes);
        return Math.min(clockWise, 360-clockWise);
    }
    public static double clockWiseCalcs(int hour, int minutes) {
        // each hour has 30 degrees angle
        // each minute has 6 degrees of angle
        // speed of hour hand is (1/2)*(minutes)
        double minutesAngle = minutes*6;

        // each hour consumes 30 degree from the 12the position
        double hoursAngle;
        if(hour!=12){
            hoursAngle = (hour*30)+(0.5)*minutes;
        }else{
            hoursAngle = (0.5)*minutes;
        }
        return Math.abs(minutesAngle-hoursAngle);
    }
    public static double antiClockWiseCalcs(int hour, int minutes) {
        // each hour has 30 degrees angle
        // each minute has 6 degrees of angle
        // speed of hour hand is (1/2)*(minutes)
        double minutesAngle = 360-(minutes*6);

        // each hour consumes 30 degree from the 12the position
        double hoursAngle;
        if(hour!=12){
            hoursAngle = (hour*30)+(0.5)*minutes;
        }else{
            hoursAngle = (0.5)*minutes;
        }
        return Math.abs(minutesAngle+hoursAngle);
    }
}
