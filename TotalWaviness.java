class Solution {
    public int totalWaviness(int num1, int num2) {
        String s = String.valueOf(num2);
        if(s.length() < 3) return 0;
        int cnt = 0;
        for(int i = num1 ; i <= num2 ; i++){
            String str = String.valueOf(i);
            char[] charArray = str.toCharArray();
            for(int j = 1 ; j < charArray.length-1 ; j++){
                int numMiddle = Character.getNumericValue(charArray[j]);
                int numLeft = Character.getNumericValue(charArray[j-1]);
                int numRight = Character.getNumericValue(charArray[j+1]);
                if((numMiddle > numLeft && numMiddle > numRight) ||
                  (numMiddle < numLeft && numMiddle < numRight)){
                    cnt++;
                  }
            }
        }
        return cnt;
    }
}
