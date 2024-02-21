class Solution {

    private boolean dfs(int node, List<List<Integer>> adj, boolean visited[], boolean inStack[]){
        if(inStack[node]){
            return true;
        }

        if(visited[node]){
            return false;
        }

        visited[node] = true;
        inStack[node] = true;

        for (int nei : adj.get(node)){
                if(dfs(nei, adj, visited, inStack)){
                    return true;
                }
        }

        inStack[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean inStack[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(dfs(i, adj, visited, inStack)){
                return false;
            }
        }

        return true;
    }
}