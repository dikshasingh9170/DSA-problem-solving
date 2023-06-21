class MyStack {
    static Queue<Integer> q1;
    static Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<Integer>();
        q2=new LinkedList<Integer>();
    }
    
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }
    
    public int pop() {
        int val=q1.peek();
        q1.poll();
        return val;
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */