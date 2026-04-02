class TimeMap {

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }

    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        //Map {key:List([Time, value])}
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            map.put(key, new ArrayList<Pair<Integer, String>>());
        }
        List<Pair<Integer, String>>keyArray = map.get(key);
        keyArray.add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }

        List<Pair<Integer, String>>keyArray = map.get(key);

        int l = 0;
        int r = keyArray.size() -1;

        while (l<=r){

            int mid = l + (r-l)/2;
            Pair<Integer,String>  midVal = keyArray.get(mid);

            if (timestamp< midVal.getKey()){
                r = mid - 1;
            }else if(timestamp > midVal.getKey()) {
                l = mid + 1;
            }else{
                return midVal.getValue();
            }

        }

        
        
if (r >= 0) {
    return keyArray.get(r).getValue();
}
return "";
    }
}