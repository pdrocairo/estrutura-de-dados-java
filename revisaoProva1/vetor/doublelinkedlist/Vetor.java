public class Vetor{
    public class Node{
        int value;
        Node previous = null;
        Node next = null;
    }
    Node first;
    Node last;
    private int size_;

    public Vetor(){
        this.size_ = 0;
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        if (this.size_ == 0){
            return true;
        }return false;
    }

    public int size(){
        return this.size_;
    }

    public int elemAtRank(int idx){
        if (isEmpty()){
            throw new IllegalStateException("vetor vazio");
        }
        if (idx < 0 || idx>=this.size_){
            throw new IllegalStateException("indice fora do range");
        }
        Node node = this.first;
        for (int i=0; i<idx;i++){
            node = node.next;
        }
        return node.value;
    }

    // public int replaceAtRank(int idx, Node newNode){
    //     if (isEmpty()){
    //         throw new IllegalStateException("vetor vazio");
    //     }
    //     if (idx < 0 || idx>=this.size_){
    //         throw new IllegalStateException("indice fora do range");
    //     }
    //     Node node = this.first;
    //     for (int i=0; i<idx;i++){
    //         node = node.next;
    //     }
    //     int toRemove = node.value;

    //     if (this.first == this.last){
    //         this.first = newNode;
    //         this.last = newNode;
    //     }
    //     else if (node == this.first){
    //         node.next.previous = newNode;
    //         newNode.next = node.next;
    //         node.next = null;
    //         this.first = newNode;
    //     }
    //     else if (node == this.last){
    //         node.previous.next = newNode;
    //         newNode.previous = node.previous;
    //         node.previous = null;
    //         this.last = newNode;
    //     }
    //     else{
    //         node.previous.next = newNode;
    //         node.next.previous = newNode;
    //         newNode.previous = node.previous;
    //         newNode.next = node.next;
    //         node.previous = null;
    //         node.next = null;
    //     }
    //     return toRemove;
    // }

    public int replaceAtRank(int idx, int value){
        if (isEmpty()){
            throw new IllegalStateException("vetor vazio");
        }
        if (idx < 0 || idx>=this.size_){
            throw new IllegalStateException("indice fora do range");
        }
        Node node = this.first;
        for (int i=0; i<idx;i++){
            node = node.next;
        }
        int toRemove = node.value;

        node.value = value;

        return toRemove;
    }

    public void insertAtRank(int idx, int value){
        if (idx < 0 || idx>=this.size_){
            throw new IllegalStateException("indice fora do range");
        }
        Node node = this.first;
        for (int i=0;i<idx;i++){
            node= node.next;
        }
        Node newNode = new Node();
        newNode.value = value;
        
        if(this.first == this.last){
            this.first = newNode;
            this.last = newNode;
        }
        else if ()
    }
}