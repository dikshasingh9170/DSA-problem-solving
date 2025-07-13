class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count=0;
        int i=0;int j=0;
        int n=players.length;
        int m=trainers.length;
        while(i<n && j<m){
            if(players[i]<=trainers[j]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}

// 4 7 9
// 2 5 8 8
//        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
 /*for(int i=0;i<players.length;i++){
            for(int j=0;j<trainers.length;j++){
                if(players[i]<=trainers[j]){
                    if(!hm.containsKey(j)){
                        hm.put(j,i);
                        break;
                    }
                }
            }
        }*/