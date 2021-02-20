
/*

TWO NUMBER SUM:


Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.


Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1]

Input: nums = [3,2,4], target = 6
Output: [1,2]

Input: nums = [3,3], target = 6
Output: [0,1]

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/


#include <vector>
using namespace std;

vector<int> twoNumberSum(vector<int> array, int targetSum) {
	for(int i = 0; i < array.size() - 1;i++) {
		int firstNum = array[i];
		for(int j = i+1; j < array.size(); j++) {
			int secondNum = array[j];
			if(firstNum + secondNum == targetSum) {
				return vector<int>{firstNum , secondNum};
			}
		}
	}
	
  return {};
}