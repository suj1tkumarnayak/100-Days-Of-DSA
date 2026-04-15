package day_036_date_2026_04_15.arrays;

public class ShortestDistanceToTargetStringInACircularArray {
    public static void main(String[] args) {
        String[] words = { "hello","i","am","leetcode","hello" };
        int startIndex = 1;
        String target = "hello";
        System.out.println(closestTarget(words, target, startIndex));
    }
    public static int closestTarget(String[] words, String target, int startIndex) {
        int dist = Integer.MAX_VALUE, len = words.length;
        if(words[startIndex].equals(target)){
            return 0;
        }
        for (int i = startIndex; i < len+startIndex; i++) {
            if(words[i%len].equals(target)){
                //dist = Math.min();

            }
        }

        return dist==Integer.MAX_VALUE?-1:dist;
    }
}
