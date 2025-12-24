class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum =0;
        int count=0;
        Arrays.sort(capacity);
        for(int x:apple){
            sum+=x;
        
        }
        for(int j =capacity.length-1;j>=0;j--){
            if(sum>0){
                sum-=capacity[j];
                count++;
            }
            else{
                break;
            }
        }
        return count;
        
    }
}