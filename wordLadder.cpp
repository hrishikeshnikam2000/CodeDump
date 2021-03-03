// BFS SOLUTION C++


class Solution {
public:
    void dfs_helper(unordered_map<string, vector<string>>& graph, string beginWord, string endWord, int& minPath, vector<string>& path) {
	if (beginWord == endWord) {
		int path_size = path.size();
		minPath = min(minPath, path_size + 1);
		return;
	}
	for (auto word : graph[beginWord]) {
		path.emplace_back(word);
		dfs_helper(graph, word, endWord, minPath, path);
		path.pop_back();
	}
}
int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
	// create a adjacency list
	unordered_set<string>word_set(begin(wordList), end(wordList));
	unordered_map<string, vector<string>>graph;
	if (!word_set.count(endWord))
		return 0;
	if (word_set.count(beginWord))
		word_set.erase(beginWord);
	queue<string>word_queue;
	word_queue.push(beginWord);
	while (!empty(word_queue)) { // Creating a graph to dfs traverse
		string word = word_queue.front();
		word_queue.pop();
		for (int i = 0; i < size(word); i++) {
			string dummy_word = word;
			for (char c = 'a'; c <= 'z'; c++) {
				dummy_word[i] = c;
				if (word_set.count(dummy_word)) {
					graph[word].emplace_back(dummy_word);
					word_set.erase(dummy_word);
					word_queue.push(dummy_word);
				}
			}

		}
	}
	int minPath = INT_MAX;
	vector<string>path;
	dfs_helper(graph, beginWord, endWord, minPath, path);
	return minPath == INT_MAX ? 0:minPath;
}
};