package Trabalho_2018;

public class MaxHeap
{
	
    private Atendimento[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;
 
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Atendimento[this.maxsize + 1];
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
        Atendimento tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( Heap[pos].getPrioridadeCliente() < Heap[leftChild(pos)].getPrioridadeCliente()   || Heap[pos].getPrioridadeCliente()  < Heap[rightChild(pos)].getPrioridadeCliente() )
            {
                if (Heap[leftChild(pos)].getPrioridadeCliente()  > Heap[rightChild(pos)].getPrioridadeCliente() )
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
 
    public void insert(float f, Atendimento atendimento)
    {
        Heap[++size] = atendimento;
        int current = size;
        while(Heap[parent(current)] != null && (Heap[current].getPrioridadeCliente()  > Heap[parent(current)].getPrioridadeCliente()) )
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
 
    public Atendimento remove()
    {
        Atendimento popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
        maxHeapify(FRONT);
        return popped;
    }
 
}