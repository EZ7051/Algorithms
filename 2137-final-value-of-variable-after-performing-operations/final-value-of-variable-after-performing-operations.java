class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;

        for(String opr : operations){
            if(opr.contains("+")){
                ans++;
            }
            else{
                ans--;
            }
        }

        return ans;
    }
}