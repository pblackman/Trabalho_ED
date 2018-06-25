package trabalho_ed;

//maxheap
public class MaxHeap
{
	
    private Atendimento[] Heap;
    private int n;
    private int maxsize;
 
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.n = 0;
        Heap = new Atendimento[this.maxsize + 1];
    }
    
    private void trocar(int i,int j)
    {
    	Atendimento tmp;
        tmp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = tmp;
    }
    
    private void descer(int i) {
    	int j = 2 * i + 1;
        if (j < n) {
            if (j < n - 1) {
    			if(Heap[j + 1].getPrioridade()  > Heap[j].getPrioridade()) {
    				j++;
    			}
    		}
    		if(Heap[i].getPrioridade() < Heap[j].getPrioridade()) {
    			trocar(i, j);
    			descer(i);
    		}
    	}
    }
    
    private void subir(int i) {
        int j = (i - 1) / 2;
        if (Heap[i].getPrioridade() > Heap[j].getPrioridade()) {
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
 
    public void inserir(Atendimento atendimento) throws Exception {
        
        if (n < Heap.length - 1) {
        	Heap[n++] = atendimento;
            //subir(n - 1);
            arranjar();
        } else
            throw new Exception("Overflow");
        
    }
 
    public void print()
    {
        for (int i = 1; i <= n / 2; i++ )
        {
            System.out.print(" PAI : " + Heap[i] + " FILHO ESQ: " + Heap[2*i]
                  + " FILHO DIR:" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }
 
    public Atendimento remover()
    {
    	this.arranjar();
    	Atendimento item = Heap[0];
        Heap[0] = Heap[--n];
        Heap[n] = null;
        descer(0);
        return item;
    }
 
}