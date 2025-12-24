public class Solution {
    public long pickGifts(int[] gifts,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:gifts){
            pq.offer(i);
        }
        while(k-->0){
            int x=pq.poll();
            x=(int)Math.sqrt(x);
            pq.offer(x);
        }
        long left=0;
        while(!pq.isEmpty()){
            left+=pq.poll();
        }
        return left;
    }
}
