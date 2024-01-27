class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> mp1 = new HashMap<>();
        HashMap<String, Integer> mp2 = new HashMap<>();

        for(String w : words1){
            mp1.put(w, mp1.getOrDefault(w, 0) + 1);
        }

        for(String w : words2){
            mp2.put(w, mp2.getOrDefault(w, 0) + 1);
        }

        AtomicInteger count = new AtomicInteger(0);
        mp1.forEach((k,v) -> {
            if(v == 1){
                if(mp2.getOrDefault(k,0) == 1 ){
                    count.incrementAndGet();
                }
            }


        });

        return count.get();
    }
}