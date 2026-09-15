public class Pilha{
    private int top;
    private int[] pilha;
    private int coeficienteCrescimento;
    private int tamanho;

    public Pilha(int tamanho, int crescimento){
        this.tamanho = tamanho;
        this.top = -1;
        this.pilha = new int[tamanho];
        coeficienteCrescimento = crescimento;

        if (crescimento <= 0){
            coeficienteCrescimento = 0;
        }
        
    }

    public void tryResize(){
        if (this.top >= this.tamanho-1){
            if (coeficienteCrescimento == 0){
                this.tamanho*=2;
            }
            else{
                this.tamanho+=coeficienteCrescimento;
            }
            int[] novaPilha = new int[length];
            for (int i=0; i< pilha.length;i++){
                novaPilha[i] = pilha[i];
            }
            pilha = novaPilha;
        }
    }

    public boolean isEmpty(){
        if (this.top == -1){
            return true;
        }
        return false;
    }

    public int size(){
        if (isEmpty()){
            throw new IllegalStateException("pilha vazia");
        }
        return this.top +1;
    }

    public int top(){
        if (isEmpty()){
            throw new IllegalStateException("pilha vazia");
        }
        return pilha[this.top];
    }

    public void push(int valor){
        tryResize();
        this.top++;
        pilha[this.top] = valor;
    }

    public int pop(){
        if (isEmpty()){
            throw new IllegalStateException("pilha vazia");
        }
        int remover = pilha[this.top];
        this.top--;
        return remover;
    }
}