class Solution {
    private boolean dfs(int node, boolean visited[], Stack<Integer> stk,  List<List<Integer>> adj, boolean inStack[]){
        if(inStack[node]){
            return true;
        }

        if(visited[node]){
            return false;
        }
        
        visited[node] = true;
        inStack[node] = true;

        for(int nei : adj.get(node)){
            if(dfs(nei, visited, stk, adj, inStack)){
                return true;
            }
            
        }

        inStack[node] = false;
        stk.push(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean inStack[] = new boolean[numCourses];

        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<numCourses; i++){
                if(dfs(i, visited, stk, adj, inStack)){
                    return new int[0];
                }
        }

        int ans[] = new int[numCourses];
        for(int i=0;i<numCourses; i++){
            ans[i] = stk.pop();
        }

        return ans;
    }
}