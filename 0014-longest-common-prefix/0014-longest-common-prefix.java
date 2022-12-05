class TrieNode{
    boolean isleaf=false;
    HashMap<Character,TrieNode> hm=new HashMap<>();
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode head=new TrieNode();
        for(String s:strs){
            insert(head,s);
        }
        StringBuilder lcp=new StringBuilder();
        TrieNode curr=head;
        while(curr!=null && !curr.isleaf && curr.hm.size()==1){
            for(var entry:curr.hm.entrySet()){
                lcp.append(entry.getKey());
                curr=entry.getValue();
            }
        }
        return lcp.toString();
    }
    private static void insert(TrieNode head,String str){
        TrieNode curr=head;
        for(char c:str.toCharArray())
        {
            curr.hm.putIfAbsent(c,new TrieNode());
            curr=curr.hm.get(c);
        }
        curr.isleaf=true;
    }
    
}