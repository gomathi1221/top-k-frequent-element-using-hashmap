class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> p=new PriorityQueue<>((a,b)->map.get(a) - map.get(b));
        for(int n:map.keySet()){
            p.add(n);
            if(p.size()>k){
                p.poll();
            }
        }
        int[] res=new int[k];
        int i=0;
        while(!p.isEmpty()){
            res[i++]=p.poll();
        }
        return res;

    }
}