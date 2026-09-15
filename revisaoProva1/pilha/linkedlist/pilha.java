public class Pilha{
    public class Node{
        int valor;
        Node anterior;
    }
    private Node top;
    private int tamanho;

    public Pilha(){
        this.top = null;
        this.tamanho = 0;
    }

    public boolean isEmpty(){
        if (this.top == null or this.tamanho == 0){
            return true;
        }
        return false;
    }

    public int size(){
        if (isEmpty()){
            throw new IllegalStateException("pilha vazia");
        }
        return this.tamanho;
    }

    public int top(){
        if (isEmpty()){
            throw new IllegalStateException("pilha vazia");
        }
        return this.top.valor;
    }

    public void push(int valor){
        Node newNode = new Node();
        newNode.valor = valor;
        if (this.top == null){
            this.top = newNode;
        }
        else{
            newNode.anterior = this.top;
            this.top = newNode;
        }
        this.tamanho++;
    }

    public int pop(){
        if (isEmpty()){
            throw new IllegalStateException("pilha vazia");
        }
        int remover =this.top.valor;
        this.top = this.top.anterior;
        this.tamanho--;
        
        return remover;
    }
}