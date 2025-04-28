/*
Diego Estevão Lopes de Queiroz - 10419038
Ricardo Andre Lopes Ikeda - 10390256
Vinicius Gutierrez Gomes - 10425609
*/
public class Queue extends Vetor {

    public Queue(int capacity) {
        // Cria uma fila com uma capacidade inicial
        super(capacity);
    }

    public int size(int qtde) {
        // Devolve o número de elementos da fila
        return qtde;
    }

    public void enqueue(String n) throws Exception {
        // Enfileira, caso a fila não esteja cheia, o elemento n
        add(size, n);        
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
