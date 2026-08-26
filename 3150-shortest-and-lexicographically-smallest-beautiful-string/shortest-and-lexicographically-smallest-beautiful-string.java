class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        String ans = "";
        int ones = 0;
        for(int right = 0; right < s.length(); right++)
        {
            if(s.charAt(right) == '1')
            {
                ones++;
            }
            while(ones > k){
                if(s.charAt(left) == '1')
                {
                    ones--;
                }
                  left++;
            }
            if(ones == k){
                while(s.charAt(left) == '0'){
                    left++;
                }
                String candidate = s.substring(left , right+1);
                if(candidate.length() < ans.length()|| ans.equals("") || (candidate.length() == ans.length() &&  candidate.compareTo(ans)< 0 ) ){
                    ans = candidate;
                }
            }
        } 
        return ans;
    }
}