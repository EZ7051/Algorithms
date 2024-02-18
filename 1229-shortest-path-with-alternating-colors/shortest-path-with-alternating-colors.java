

import static java.lang.System.in;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
         //creating blue and red adjacency lists:
        List<List<Integer>> redAdj = new ArrayList<>(n);
        List<List<Integer>> blueAdj = new ArrayList<>(n);

        for(int i=0; i<n ;i++){
            redAdj.add(new ArrayList<>());
            blueAdj.add(new ArrayList<>());
        }

        for(int i=0; i<redEdges.length; i++){
           redAdj.get(redEdges[i][0]).add(redEdges[i][1]);
        //    redAdj.get(redEdges[i][1]).add(redEdges[i][0]);
        }

        for(int i=0; i<blueEdges.length; i++){
           blueAdj.get(blueEdges[i][0]).add(blueEdges[i][1]);
        //    blueAdj.get(blueEdges[i][1]).add(blueEdges[i][0]);
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});
        queue.offer(new int[]{0,1});
        


        int[][] dist = new int[2][n];

        for(int[] row : dist){
            Arrays.fill(row, -1);
        }

        dist[0][0] = 0;
        dist[1][0] = 0;
        

        while(!queue.isEmpty()){
            int[] info = queue.poll();

            int node = info[0], color = info[1];

            int nextColor = color ^ 1;

            List<List<Integer>> adjList = nextColor == 0 ?  redAdj : blueAdj;

            for(int nei : adjList.get(node)){
                if(dist[nextColor][nei] == -1){
                    dist[nextColor][nei] = dist[color][node] + 1;
                    queue.offer(new int[]{nei, nextColor});
                }
            }

            
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[0][i] == -1 || dist[1][i] == -1) {
                res[i] = Math.max(dist[0][i], dist[1][i]);
            } else {
                res[i] = Math.min(dist[0][i], dist[1][i]);
            }
        }
        return res;
    }
}