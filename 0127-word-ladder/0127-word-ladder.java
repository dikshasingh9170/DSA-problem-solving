class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        Queue<pair> q=new LinkedList<pair>();
        q.add(new pair(beginWord,1));
        while(!q.isEmpty()){
            pair p=q.poll();
            if(p.x.equals(endWord)){
                return p.y;
            }
            for(int i=0;i<p.x.length();i++){
                for(char j='a';j<='z';j++){
                    char[] replacedarray=p.x.toCharArray();
                    replacedarray[i]=j;
                    String replaced=new String(replacedarray);
                     
                    if(hs.contains(replaced)){
                        hs.remove(replaced);
                        q.add(new pair(replaced,p.y+1));
                    }
                }
               
            }
        }
        return 0;
    }
}
class pair{
    String x;
    int y;
    public pair(String x,int y){
        this.x=x;
        this.y=y;
    }
}