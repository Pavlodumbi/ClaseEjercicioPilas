public class Pila<T> {
    private T[]pila;
    private int tope;

    public Pila(){
        pila = (T[]) new Object[10];
        tope = -1;
    }

    public Pila(int capacidad){
        pila = (T[]) new Object[10];
        tope = -1;
    }

    public void push(T objeto){
        if (llena()) return;
        tope++;
        pila[tope] = objeto;
    }

    public T pop(){
        if (vacia()) return null;
        T retorno = pila[tope];
        pila[tope] = null;
        tope --;
        return retorno;
    }

    public boolean llena(){
        return tope == pila.length;
    }

    public boolean vacia(){
        return tope == -1;
    }

}

