class Solution {
    static class sTree{
        int n;
        int[] tree;
        public sTree(int n){
            this.n=n;
            tree=new int[4*n];
        }

        public int query(int  node,int l,int  r,int ql,int qr){
            if(l>qr || r<ql){    //no overlappong
                return 0;
            }
            if(l>=ql && r<=qr){  //fully overlapping
                return tree[node];
            }
            //partial overlapping
            int mid=l+(r-l)/2;
            return query(2*node+1,l,mid,ql,qr) + query(2*node+2,mid+1,r,ql,qr);
        }

        public void update(int node,int l,int r,int idx){
            if(l==r){
                tree[node]++;
                return;
            }
            
            int mid=l+(r-l)/2;
            if(idx<=mid){
                update(2*node+1,l,mid,idx);
            }else{
                update(2*node+2,mid+1,r,idx);
            }

            tree[node]=tree[2*node+1] + tree[2*node+2];
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int[] sorted=nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer,Integer> map=new HashMap<>();
        int idx=0;
        for(int val : sorted){
            if(!map.containsKey(val)){
                map.put(val,idx++);
            }
        }
        //segment tree;
        sTree seg=new sTree(idx);
        Integer[] ans=new Integer[n];

        //right -> left
        for(int i=n-1;i>=0;i--){
            int val=map.get(nums[i]);
            ans[i]=seg.query(0,0,idx-1,0,val-1);
            seg.update(0,0,idx-1,val);
        }
        return Arrays.asList(ans);




        
    }
}