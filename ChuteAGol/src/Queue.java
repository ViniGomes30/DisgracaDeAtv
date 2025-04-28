package projfila;

public class Queue extends Vetor {

    public Queue(int capacity) {
        // Cria uma fila com uma capacidade inicial
        super(capacity);
    }

    public int size() {
        // Devolve o número de elementos da fila
        return qtde;
    }

    public void enqueue(String n) throws Exception {
        // Enfileira, caso a fila não esteja cheia, o elemento n
        add(qtde,n);        
    }

    public void dequeue() throws Exception {
        // Desenfileira, caso a fila não esteja vazia, o primeiro elemento
        remove(0);
    }

    public String front() throws Exception{
        // Devolve, sem desenfileirar, o primeiro elemento da fila
        return get(0);
    }
}
