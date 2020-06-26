package co.edu.escuelaing.arsw.tablero;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Andres Gonzalez
 */
public class Cola {
    
    private Queue<Punto> eventos = new ConcurrentLinkedQueue<>(); 
    
    private Cola() {
    }

    private static class helper {
        private static final Cola INSTANCE = new Cola();
    }

    public static Cola getInstance() {
        return helper.INSTANCE;
    }
    /**
     * El metodo agrega un punto a la cola
     * @param punto el punto que se quiere agregar 
     */
    public void add(Punto punto){
        eventos.add(punto);
    }
    /**
     * Devuelve el primero de la cola y lo remueve de la cola
     * @return Punto primero en la cola
     */
    public Punto next(){
        return eventos.poll();
    }
    public boolean isEmpty(){
        return eventos.isEmpty();
    }
    
}
