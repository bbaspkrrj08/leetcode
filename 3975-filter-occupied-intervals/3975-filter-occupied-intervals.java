class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occInter, int freeStart, int freeEnd) {
        Arrays.sort(occInter, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> merged= new ArrayList<>();
        for(int[] inter: occInter){
            if(merged.isEmpty()){
                merged.add(new int[]{inter[0], inter[1]});
            }
            else{
                int[] last= merged.get(merged.size()-1);
                if(inter[0]<= last[1]+1){
                    last[1]=Math.max(last[1], inter[1]);
                }
                else{
                    merged.add(new int[]{inter[0], inter[1]});
                    
                }
            }
        }

        List<List<Integer>> ans= new ArrayList<>();
        for(int[] inter:merged){
            if(inter[0]<freeStart){
                ans.add(Arrays.asList(inter[0],Math.min(inter[1], freeStart-1)));
            }
            if(inter[1]>freeEnd){
                ans.add(Arrays.asList(Math.max(inter[0], freeEnd+1),inter[1]));
            }
        }
        return ans;
    }
}