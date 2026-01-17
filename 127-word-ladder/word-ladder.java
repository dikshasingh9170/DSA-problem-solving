class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>(wordList);
        if(!hs.contains(endWord))return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        hs.remove(beginWord);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.word;
            int dist=p.dist;
            if(word.equals(endWord)){
                return dist;
            }
            char[] arr=word.toCharArray();
            for(int i=0;i<word.length();i++){
                char original=arr[i];
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String newWord=new String(arr);
                    if(hs.contains(newWord)){
                        q.add(new Pair(newWord,dist+1));
                        hs.remove(newWord);
                    }
                }
                arr[i]=original;
            }
        }
        return 0;
    }
}
class Pair{
    String word;
    int dist;
    public Pair(String word,int dist){
        this.word=word;
        this.dist=dist;
    }
}