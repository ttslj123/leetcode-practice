package java_leetcode;

public class BulbsOn {
    public static void main(String[] args) {
        BulbsOn test = new BulbsOn();
        int n = 3;

        System.out.println(n + "bulbs after " + n + " round is : " + test.bulbSwitch(n));
    }
    public int bulbSwitch(int n) {
        // Write your solution here
        boolean[] bulbs = new boolean[n];
        
        turnbulbs(bulbs, 0, n);
        
        int on_sum = 0;
        for(int i = 0; i < n; i++) {
          if(bulbs[i]) {
            on_sum++;
          }
        }
        return on_sum;
      }
    
      private void turnbulbs(boolean[] bulbs, int i, int n) {
        if(i == n) {
          return;
        }
        for(int j = 0; j < n; j++) {
            if((j+1)%(i+1)==0){
                bulbs[j] = !bulbs[j];
            }
        }
        turnbulbs(bulbs, i+1, n);
      }
}