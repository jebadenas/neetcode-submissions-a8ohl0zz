class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurences = new HashMap<>();

        //count occurences and store in hashmap
        for (int num: nums){
            occurences.put(num, occurences.getOrDefault(num, 0)+1);
        }

        List<Integer>[] freq = new List[nums.length + 1]; //array of list integers
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int indexK = 0;
        for (int i = freq.length - 1; i > 0 && indexK < k; i--){
            System.out.println(i);
            List<Integer> curList = freq[i];
            for (int j = 0; j < curList.size(); j++){
                res[indexK] = curList.get(j);
                indexK++;
                

            }
        }
        return res;
    }
}
