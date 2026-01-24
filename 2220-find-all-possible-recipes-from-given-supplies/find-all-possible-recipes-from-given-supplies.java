class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesSet=new HashSet<>();
        Map<String, List<String>> adj = new HashMap<>();
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:supplies){
            suppliesSet.add(s);
        }
        for(String recipe:recipes){
            hm.put(recipe,0);
        }
        for(int i=0;i<recipes.length;i++){
            for(String s:ingredients.get(i)){
                    adj.putIfAbsent(s,new ArrayList<>());
                    adj.get(s).add(recipes[i]);
                    hm.put(recipes[i],hm.getOrDefault(recipes[i],0)+1);
            }
        }
        Queue<String> q=new LinkedList<>();
        List<String> result=new ArrayList<>();
        for(String s:supplies)q.offer(s);
        while(!q.isEmpty()){
            String x=q.poll();
            if(!adj.containsKey(x))continue;
            for(String s:adj.get(x)){
                hm.put(s,hm.get(s)-1);
                if(hm.get(s)==0){
                    result.add(s);
                    q.offer(s);
                }
            }
        }
        return result;
    }
}