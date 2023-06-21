class MyCircularQueue {
    int[] arr;
	int len;
	int rear;
    public MyCircularQueue(int k) {
        len=k;
		arr=new int[k];
		rear=-1;
    }
    
    public boolean enQueue(int value) {
        if(rear==len-1){
			return false;
		}
		rear++;
		arr[rear]=value;
		return true;
    }
    
    public boolean deQueue() {
        if(rear==-1){
			return false;
		}
		int result=arr[0];
		for(int i=0;i<rear;i++){
			arr[i]=arr[i+1];
		}
		rear--;
		return true;
    }
    
    public int Front() {
        if(rear==-1){
            return -1;
        }
        return arr[0];
    }
    
    public int Rear() {
        if(rear==-1){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(rear==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(rear==len-1){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */