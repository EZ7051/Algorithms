class Solution {
    class Pair{
        int weight;
        int vertex;

        Pair(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n + 1; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int dis[] = new int[n + 1];

        for(int i=0;i<=n;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));

        pq.add(new Pair(k, 0));
        dis[k] = 0;

        while(!pq.isEmpty()){
            int u = pq.poll().vertex;

            for(Pair nei : adj.get(u)){
                int v = nei.vertex;
                int weight = nei.weight;
                if(dis[u] != Integer.MAX_VALUE && dis[u] + weight < dis[v]){
                    dis[v] = dis[u] + weight;
                    pq.offer(new Pair(v, dis[v]));
                }
            }
            
        }

        int ans = dis[1];

        for(int d : dis)
            System.out.print(d + " ");

        for(int i=1; i<=n; i++){

            if(dis[i] == Integer.MAX_VALUE) return -1;

            ans = Math.max(ans, dis[i]);
        }


        return ans;
    }
}