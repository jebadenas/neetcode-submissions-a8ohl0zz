class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            if (people[l] + people[r] > limit){
                r--;
            }else{
                l++;
                r--;
            }

            res++;
        }

        return res;

        


    }
}