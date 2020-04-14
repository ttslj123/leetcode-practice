// isAdditiveNumber


package java_leetcode;
class Solution0 {
  public boolean isAdditiveNumber(String num) {
    // Write your solution here
    if(num.length() < 3) return false;
    for(int i = 1; i <= num.length()/2; i++){
      String one = num.substring(0, i);
      if(!isValid(one)) continue;
      for(int j = i+1; j < num.length(); j++) {
        String two = num.substring(i, j);
        String rest = num.substring(j);
        if(!isValid(two) || !isValid(rest)) continue;
        if(canadd(one, two, rest)) return true;
      }
    }
    return false;
  }

  private boolean canadd(String a, String b, String c) {
    if(a.length() > c.length() || b.length() > c.length()) {
      return false;
    }
    String t = addstring(a, b);
    if(t == c) return true;
    if(t.length() >= c.length() || t != c.substring(0, t.length())) {
      return false;
    }
    return canadd(b, t, c.substring(t.length()));
  }

  private String addstring(String a, String b) {
    int cr = 0;
    int ai = a.length()-1;
    int bi = b.length()-1;
    StringBuilder sb = new StringBuilder();
    while(ai >= 0 || bi >= 0) {
      int ac = ai >= 0 ? a.charAt(ai)-'0' : 0;
      int bc = bi >= 0 ? b.charAt(bi)-'0' : 0;
      sb.append((char)('0'+(ac+bc+cr)%10));
      cr = (ac+bc+cr)/10;
      ai--;
      bi--;
    }
    if(cr == 1) {
      sb.append('1');
    }
    return sb.reverse().toString();
  }
  private boolean isValid(String s) {
    if(s.length() <= 0) return false;
    if(s.length() > 1 && s.charAt(0) == '0') {
      return false;
    }
    return true;
  }
}
