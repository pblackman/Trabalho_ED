package Trabalho_2018;

import javax.naming.LimitExceededException;

public class MaxHeap
{
	
    private HeapItem[] Heap;
    private int n;
    private int maxsize;
 
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.n = 0;
        Heap = new HeapItem[this.maxsize + 1];
    }
    
    public class HeapItem {
    	private float prioridade;
    	private Object item;
    	
    	public HeapItem(float prioridade, Object item) {
    		this.prioridade = prioridade;
    		this.item = item;
    	}
    	public void setPrioridade(float prioridade) {
    		this.prioridade = prioridade;
    	}
    	public float getPrioridade() {
    		return this.prioridade;
    	}
    	
    	public Object getItem() {
    		return this.item;
    	}
    }
    
    private void trocar(int i,int j)
    {
    	HeapItem tmp;
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
        if (Heap[i].prioridade > Heap[j].prioridade) {
            trocar(i, j);
            subir(j);
        }
    }
 
    private void arranjar() {
    	for(int i = n/2 - 1; i >= 0; i-- ) {
    		descer(i);
    	}
    }
 
    public void insert(float f, Object objeto) throws Exception {
        
        if (n < Heap.length - 1) {
        	Heap[n++] = new HeapItem(f, objeto);
            //subir(n - 1);
            arranjar();
        } else
            throw new Exception("Overflow");
        
    }
 
    public void print()
    {
        for (int i = 1; i <= n / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                  + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }
 
    public HeapItem remover()
    {
    	arranjar();
        HeapItem item = Heap[0];
        Heap[0] = Heap[--n];
        Heap[n] = null;
        descer(0);
        return item;
    }
 
}