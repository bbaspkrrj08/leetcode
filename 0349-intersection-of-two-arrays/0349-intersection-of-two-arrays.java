class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
            HashSet<Integer>result=new HashSet<>();
            for(int num:nums2){
                if(set.contains(num)){
                    result.add(num);
                }
            }
                    int[]resultArr=new int[result.size()];
                    int i=0;
                    for(Integer num:result){
                        resultArr[i++]=num;
                    }
                
                return resultArr;
            }
        }
    
