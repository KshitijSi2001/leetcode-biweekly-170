 **LeetCode Biweekly Contest 170 — My Solutions**

This repository contains my Java solutions for the first two problems of **LeetCode Biweekly Contest 170**.

 **Contest Performance**  
- **Solved:** 2 / 4 problems  
- **Global Rank:** **10,050 / 26,806**  
- **Language Used:** Java  
- These solutions are correctness-focused, simple, and beginner-friendly.

---

# Problem 1 — Minimum Number of Flips to Reverse Binary String  
  Problem Link: https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/

# Problem Summary  
You are given an integer 'n'.  
Convert it to a binary string 'b', reverse that string, and then determine how many bit flips are needed to convert the **original** string into the **reversed** one.

A flip means changing '0' → '1' or '1' → '0'.

---

# My Approach  
1. Convert 'n' into its binary representation.  
2. Reverse that string using `StringBuilder`.  
3. Compare each index of the original and reversed strings.  
4. Every mismatch means **one** required flip.  
5. Sum all such mismatches.

This approach is straightforward and works well for this problem size.

---

# Java Solution  

class Solution {
    public int minimumFlips(int n) {
        // Convert number to binary string
        String bString = Integer.toBinaryString(n);

        // Reverse the string
        StringBuilder sb = new StringBuilder(bString);
        String reversed = sb.reverse().toString();

        // Count mismatches between original and reversed versions
        int cnt = 0;
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) != bString.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}


# Problem 2 - Total Waviness of Numbers in Range I
  Problem Link: https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/

# Problem Summary
Given a range [num1,num2], a number is considered “wavy” at position i if:
digit at i is strictly greater than both neighbors: local maximum OR
digit at i is strictly smaller than both neighbors: local minimum
Count all such positions for every number in the range.

---

# My Approach
1. Iterate from num1 to num2.
2. Convert each number into a string (array of digits).
3. For every index i from 1 to len-2:
4. Compare digit[i] with digit  and digit[i+1]
5. Check if it forms a local maxima or local minima
6. If yes, increase cnt.

This brute-force solution is simple and easy to understand.
(For larger constraints, an optimized digit-DP approach is needed.)

---

# Java Solution

class Solution {
    public int totalWaviness(int num1, int num2) {
        // If num2 has fewer than 3 digits, waviness is impossible
        String s = String.valueOf(num2);
        if (s.length() < 3) return 0;

        int cnt = 0;

        // Iterating through all numbers in the range
        for (int i = num1; i <= num2; i++) {
            String str = String.valueOf(i);
            char[] charArray = str.toCharArray();

            // Checking for local minima or maxima
            for (int j = 1; j < charArray.length - 1; j++) {
                int numMiddle = Character.getNumericValue(charArray[j]);
                int numLeft = Character.getNumericValue(charArray[j - 1]);
                int numRight = Character.getNumericValue(charArray[j + 1]);

                // Local max or local min
                if ((numMiddle > numLeft && numMiddle > numRight) ||
                    (numMiddle < numLeft && numMiddle < numRight)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

# Personal Reflection

This was my first time documenting a LeetCode contest on GitHub.
The goal is to stay consistent, improve contest accuracy, and gradually solve medium-level problems faster.
I will continue uploading contest solutions and refining my approach as I learn more.
