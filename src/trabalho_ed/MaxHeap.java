package trabalho_ed;

//maxheap
public class MaxHeap
{
	
    private ObjetoBase[] Heap;
    private int n;
    private int maxsize;
 
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.n = 0;
        Heap = new ObjetoBase[this.maxsize + 1];
    }
    
    
    private void trocar(int i,int j)
    {
    	ObjetoBase tmp;
        tmp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = tmp;
    }
    
    private void descer(int i) {
    	int j = 2 * i + 1;
        if (j < n) {
            if (j < n - 1) {
    			if(Float.parseFloat(Heap[j + 1].getChave())  > Float.parseFloat(Heap[j].getChave())) {
    				j++;
    			}
    		}
    		if(Float.parseFloat(Heap[i].getChave()) < Float.parseFloat(Heap[j].getChave())) {
    			trocar(i, j);
    			descer(i);
    		}
    	}
    }
    
    private void subir(int i) {
        int j = (i - 1) / 2;
        if (Float.parseFloat(Heap[i].getChave()) > Float.parseFloat(Heap[j].getChave())) {
            trocar(i, j);
            subir(j);
        }
    }
    //Reorganiza o heap em tempo linear - O(n)
    public void arranjar() {
    	for(int i = n/2 - 1; i >= 0; i-- ) {
    		descer(i);
    	}
    }
 
    public void inserir(float f, ObjetoBase objeto) throws Exception {
        
        if (n < Heap.length - 1) {
        	Heap[n++] = objeto;
            //subir(n - 1);
            arranjar();
        } else
            throw new Exception("Overflow");
        
    }
 
    public ObjetoBase remover()
    {
    	ObjetoBase item = Heap[0];
        Heap[0] = Heap[--n];
        Heap[n] = null;
        descer(0);
        return item;
    }
 
}