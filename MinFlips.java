class Solution {
    public int minimumFlips(int n) {
        String bString = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(bString);
        
        String reversed = sb.reverse().toString();
        int cnt = 0;
        for(int i = 0 ; i < reversed.length() ; i++){
            if(reversed.charAt(i) != bString.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
}
