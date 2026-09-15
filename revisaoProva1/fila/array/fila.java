
public class Fila{
    
    private int[] fila;
    private int tamanho;
    private int primeiro;
    private int ultimo;
    private int length;
    private int growthRatio;

    public Fila(int length, int growth){
        tamanho = 0;
        fila = new int[length];
        primeiro = -1;
        ultimo = -1;
        this.length = length;
        growthRatio = growth;

        if (growth <= 0){
            growthRatio = 0;
        }

    }

    public void tryResize(){
        if (tamanho >= this.length-1){
            if (growthRatio == 0){
                this.length*=2;
            }else{
                this.length+=growthRatio;
            }
            int[] novaFila = new int[this.length];
            for (int i = 0; i<this.tamanho;i++){
                novaFila[i] = fila[i];
            }
            fila = novaFila;
        }
    }

    public boolean isEmpty(){
        if (tamanho == 0){
            return true;
        }return false;
    }

    public void enqueue(int valor){
       tryResize();
       
       if (isEmpty()){
        primeiro++;
        ultimo++;
       }else{
        
        ultimo++;
       }
       tamanho++;
       fila[ultimo] = valor;
       
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("fila vazia");
        }
        int remover = fila[primeiro];
        if (primeiro == ultimo){
            primeiro = -1;
            ultimo = -1;
        }else{
            primeiro++;
        }
        tamanho--;
        return remover;
    }

    public int front(){
        if (isEmpty()){
            throw new IllegalStateException("fila vazia");
        }return fila[primeiro];
    }

    public int back(){
        if (isEmpty()){
            throw new IllegalStateException("fila vazia");
        }return fila[ultimo];
    }

}

//void enqueue(int value)
//int dequeue()
//int front()

//int size_()
//int back()
