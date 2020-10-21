/*
 * 4. Considere a implementação de filas usando arranjos “circulares”. Escreva
 * um método na classe Fila chamado furaFila(int x) que insere um inteiro na
 * primeira posição da fila. O detalhe é que seu procedimento deve ser O(1), ou
 * seja, não pode movimentar os outros itens da fila. (observe que neste caso,
 * estaremos desrespeitando o conceito de FILA – primeiro a entrar é o
 * primeiro a sair).
 */
package br.com.rogerio.model;

/**
 *
 * @author roger
 */
public class Fila {

    private int tamanho;
    private int inicio;
    private int fim;
    private int[] array;
    private int quantElementos;

    public Fila() {
        this(10);
    }
    
    public Fila(int tamanho){
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho deve ser maior do que zero!");
        }
        this.tamanho = tamanho;
        this.array = new int [tamanho];
        inicio = 0;
        fim = 0;
        quantElementos = 0;
    }
    
    public boolean isEmpty(){
        return quantElementos == 0;
    }
    
    public boolean isFull(){
        return quantElementos == tamanho;
    }
    
    public int size(){
        return quantElementos;
    }
    
    public void enqueue(int elemento){
        if (isFull()) {
            throw new RuntimeException("A fila está cheia!");
        }
        array[fim] = elemento;
        fim = (fim + 1) % tamanho;
        quantElementos++;
    }
    
    public void dequeue(){
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia!\n");
        }
        inicio = (inicio + 1) % tamanho;
        quantElementos--;
    }
    
    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia!\n");
        }
        return array[inicio];
    }
    
    public void destroy(){
        inicio = 0;
        fim = 0;
        quantElementos = 0;
    }
    
    public void FuraFila(int elemento){
        if (isFull()) {
            throw new RuntimeException("A fila está cheia!\n");
        }
        inicio = (tamanho - 1 + inicio) % tamanho;
        array[inicio] = elemento;
        quantElementos++;
    }
    
    
    

}
