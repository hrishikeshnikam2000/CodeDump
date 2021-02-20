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
	sort(array.begin(), array.end());
	int left = 0;
	int right = array.size() - 1;
	while (left < right) {
		int currentSum = array[left] + array[right];
		if (currentSum == targetSum) {
			return {array[left] , array[right]};
		} else if (currentSum < targetSum) {
			left++;
		} else if (currentSum > targetSum) {
			right--;
		}
	}
  return {};
}
