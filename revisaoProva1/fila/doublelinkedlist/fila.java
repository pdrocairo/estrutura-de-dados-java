public class Fila{
    public class Node{
        int value;
        Node previous = null;
    }
    Node first;
    Node last;
    private int size_;

    public Fila(){
        this.size_ = 0;
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        if (first == null){
            return true;
        }return false;
    }

    public int size(){
        return this.size_;
    }

    public void enqueue(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (isEmpty()){
            this.first = newNode;
        }else{
            this.last.previous = newNode;
        }
        this.last = newNode;
        this.size_++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("fila vazia");
        }
        int toRemove = this.first.value;
        if (this.first == this.last){
            this.first = null;
            this.last = null;
        }else{
            this.first = this.first.previous;
        }
        this.size_--;
        return toRemove;
    }

    public int front(){
        if (isEmpty()){
            throw new IllegalStateException("fila vazia");
        }
        return this.first.value;
    }

    public int back(){
        if (isEmpty()){
            throw new IllegalStateException("fila vazia");
        }
        return this.last.value;
    }
}

//void enqueue(int value)
//int dequeue()
//int front()

//int size_()
//int back()