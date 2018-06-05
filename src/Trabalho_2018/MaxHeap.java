package Trabalho_2018;

public class MaxHeap
{
	
    private HeapItem[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;
 
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
    
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new HeapItem[this.maxsize + 1];
    }
 
    private int parent(int pos)
    {
        return pos / 2;
    }
 
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        {
            return true;
        }
        return false;
    }
 
    private void swap(int fpos,int spos)
    {
    	HeapItem tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( Heap[leftChild(pos)]!= null && Heap[pos].getPrioridade() < Heap[leftChild(pos)].getPrioridade()   || Heap[rightChild(pos)] != null && Heap[pos].getPrioridade()  < Heap[rightChild(pos)].getPrioridade() )
            {
                if (Heap[leftChild(pos)].getPrioridade()  > Heap[rightChild(pos)].getPrioridade() )
                {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }
 
    public void insert(float f, Object objeto)
    {
    	HeapItem item = new HeapItem(f, objeto);
        Heap[++size] = item;
        int current = size;
        while(Heap[parent(current)] != null && (Heap[current].getPrioridade()  > Heap[parent(current)].getPrioridade()) )
        {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
 
    public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                  + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }
 
    public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            maxHeapify(pos);
        }
    }
 
    public HeapItem remove()
    {
        HeapItem popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
        maxHeapify(FRONT);
        return popped;
    }
 
}