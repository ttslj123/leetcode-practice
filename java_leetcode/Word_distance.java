package java_leetcode;

import java.util.HashMap;
import java.util.Map;

public class Word_distance {
    public static void main(String[] args) {
        Word_distance test = new Word_distance();
        String[] words = {"practice","makes","perfect","coding","makes"};
        String word1 = "makes";
        String word2 = "coding";

        System.out.println("expected result is :  1");
        System.out.println("your result is :  " + test.shortestDistance(words,word1,word2));
    }
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your solution here
        if(words.length <= 1) return Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
          map.put(words[i], i);
      
          int w1 = map.getOrDefault(word1, Integer.MAX_VALUE);// 3
          int w2 = map.getOrDefault(word2, Integer.MAX_VALUE);// 4
          res = Math.min(Math.abs(w1 - w2), res);
          //res = w2;
        }
        return res;
      }

}