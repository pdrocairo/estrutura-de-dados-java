public class Vetor{
    private int[] vetor;
    private int size_;
    private int growthRatio;
    private int length;

    public Vetor(int length, int growth){
        vetor = new int[length];
        this.length = length;
        this.size_ = 0;
        growthRatio = growth;

        if (growth <= 0){
            growthRatio = 0;
        }
    }

    public void tryResize(){
        if (this.size_ >= this.length-1){
            if (growthRatio == 0){
                this.length*=2;
            }else{
                this.length+=growthRatio;
            }
            int[] newVector = new int[length];
            for (int i =0; i<vetor.length;i++){
                newVector[i] = vetor[i];
            }
            vetor = newVector;
        }
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
        if (idx < 0 || idx>= this.size_){
            throw new IllegalStateException("index fora do range");
        }
        if (isEmpty()){
            throw new IllegalStateException("vetor vazio");
        }
        return vetor[idx];
    }

    public int replaceAtRank(int idx, int value){
        if (idx < 0 || idx>= this.size_){
            throw new IllegalStateException("index fora do range");
        }
        if (isEmpty()){
            throw new IllegalStateException("vetor vazio");
        }
        int toRemove = vetor[idx];
        vetor[idx] = value;
        
        return toRemove;
    }

    public void insertAtRank(int idx, int value){
        if (idx < 0 || idx>= this.size_){
            throw new IllegalStateException("index fora do range");
        }
        if (isEmpty()){
            throw new IllegalStateException("vetor vazio");
        }
        tryResize();
        
        for (int i = this.size_; i>idx;i--){
            vetor[i] = vetor[i-1];
        }
        vetor[idx] = value;
        this.size_++;
    }

    public int removeAtRank(int idx){
        if (idx < 0 || idx>= this.size_){
            throw new IllegalStateException("index fora do range");
        }
        if (isEmpty()){
            throw new IllegalStateException("vetor vazio");
        }
        int toRemove = vetor[idx];
        if (idx == this.size_ -1){
            this.size_--;
            return toRemove;
        }
        for (int i= idx; i< this.size_ -1;i++){
            vetor[i] = vetor[i+1];
        }
        this.size_--;
        return toRemove;
    }
}