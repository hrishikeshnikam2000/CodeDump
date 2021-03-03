/*

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:

The first word in the sequence is beginWord.
The last word in the sequence is endWord.
Only one letter is different between each adjacent pair of words in the sequence.
Every word in the sequence is in wordList.
Given two words, beginWord and endWord, and a dictionary wordList, 
return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.


*/

// JAVA BFS SOLUTION


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)){
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0 ; i<size ; i++){
                
                String current_word = queue.poll();
                char word_array[] = current_word.toCharArray();
                
                for(int j = 0 ; j<word_array.length ; j++){
                    
                    char current = word_array[j];
                    
                    for(char c = 'a' ; c<='z' ; c++){
                        
                        if(word_array[j] != c){
                            word_array[j] = c;
                            
                            String possible = String.valueOf(word_array);
                            
                            if(possible.equals(endWord)){
                                return level+1;
                            }
                            
                            if(set.contains(possible)){
                                queue.add(possible);
                                set.remove(possible);
                            }
                            
                        }
                        
                        word_array[j] = current;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

