class Solution {
public:
    int maxArea(vector<int>& height) {
        int res=0,n=height.size()-1;
        int l=0, r=n,tmp;
        while (l<r) {
            tmp = min(height[l],height[r]);
            if ((r-l)*tmp>res) res = (r-l)*tmp;
            if (tmp==height[r]) --r;
            else ++l;
        }
        return res;
    }
};