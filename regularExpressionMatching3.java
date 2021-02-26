// Recursive Approach


// If a star is present in the pattern, it will be in the second position \text{pattern[1]}pattern[1]. 
// Then, we may ignore this part of the pattern, or delete a matching character in the text. 
// If we have a match on the remaining strings after any of these operations, then the initial inputs matched.

/*

Time Complexity: Let T, PT,P be the lengths of the text and the pattern respectively. In the worst case, a call to match(text[i:], pattern[2j:]) will be made \binom{i+j}{i}( 
i
i+j
​   
 ) times, and strings of the order O(T - i)O(T−i) and O(P - 2*j)O(P−2∗j) will be made. Thus, the complexity has the order \sum_{i = 0}^T \sum_{j = 0}^{P/2} \binom{i+j}{i} O(T+P-i-2j)∑ 
i=0
T
​   
 ∑ 
j=0
P/2
​   
 ( 
i
i+j
​   
 )O(T+P−i−2j). With some effort outside the scope of this article, we can show this is bounded by O\big((T+P)2^{T + \frac{P}{2}}\big)O((T+P)2 
T+ 
2
P
​   
 
 ).

Space Complexity: For every call to match, we will create those strings as described above, possibly creating duplicates. If memory is not freed, this will also take a total of O\big((T+P)2^{T + \frac{P}{2}}\big)O((T+P)2 
T+ 
2
P
​   
 
 ) space, even though there are only order O(T^2 + P^2)O(T 
2
 +P 
2
 ) unique suffixes of PP and TT that are actually required.


*/

class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}