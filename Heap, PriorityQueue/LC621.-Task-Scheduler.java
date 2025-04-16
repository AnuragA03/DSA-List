class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        while(!pq.isEmpty()){
            // tempList banalo 
            List<Integer> templist = new ArrayList<>();
            int cycle = n+1;
            
            for( int i=0; i < cycle; i++ ){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    if(freq > 0) templist.add(freq);
                    time++;
                }
                else{
                    if(templist.isEmpty()) break;
                    time++;
                }
            }

            // Add the templist elements back into the pq
            for(int temp : templist){
                pq.offer(temp);
            }
        }
        return time;
    }
}