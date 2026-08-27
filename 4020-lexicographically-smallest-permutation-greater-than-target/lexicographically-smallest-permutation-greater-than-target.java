class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int[][] freqStates = new int[n + 1][];
        freqStates[0] = freq.clone();
        int maxFeasible = n;

        for (int j = 0; j < n; j++) {
            int idx = target.charAt(j) - 'a';
            if (freqStates[j][idx] > 0) {
                freqStates[j + 1] = freqStates[j].clone();
                freqStates[j + 1][idx]--;
            } else {
                maxFeasible = j;
                break;
            }
        }

        for (int i = Math.min(maxFeasible, n - 1); i >= 0; i--) {
            int[] state = freqStates[i];
            int tChar = target.charAt(i) - 'a';

            for (int c = tChar + 1; c < 26; c++) {
                if (state[c] > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(target, 0, i);
                    sb.append((char) ('a' + c));

                    int[] remaining = state.clone();
                    remaining[c]--;
                    for (int k = 0; k < 26; k++) {
                        for (int cnt = 0; cnt < remaining[k]; cnt++) {
                            sb.append((char) ('a' + k));
                        }
                    }
                    return sb.toString();
                }
            }
        }
        return "";
    }
}