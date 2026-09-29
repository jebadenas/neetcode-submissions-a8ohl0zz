class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
       // We use a set. Check if in set otherwise put in set. If in set we return true. if we finish traversing then we return false
       unordered_set<int> seen;

       for (int num: nums) {
        if (seen.count(num)) {
            return true;
        }
        seen.insert(num);
       }
       return false; 
        
    }
};