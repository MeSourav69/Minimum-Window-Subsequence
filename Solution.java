class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int minLen = Integer.MAX_VALUE;
        int start = -1;

        int i = 0;
        while (i < n) {
            int j = 0;
            int k = i;

            while (k < n && j < m) {
                if (s1.charAt(k) == s2.charAt(j)) j++;
                k++;
            }

            if (j == m) {
                int end = k - 1;
                j = m - 1;
                k = end;

                while (k >= i) {
                    if (s1.charAt(k) == s2.charAt(j)) {
                        j--;
                        if (j < 0) break;
                    }
                    k--;
                }

                if (end - k + 1 < minLen) {
                    minLen = end - k + 1;
                    start = k;
                }

                i = k + 1;
            } else {
                break;
            }
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }
}
