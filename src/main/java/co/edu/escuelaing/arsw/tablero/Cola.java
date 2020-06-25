package co.edu.escuelaing.arsw.tablero;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Andres Gonzalez
 */
public class Cola {
    
    private Queue<String> eventos = new LinkedList<>(); 
    
    private Cola() {
    }

    private static class helper {

        private static final Cola INSTANCE = new Cola();
    }

    public static Cola getInstance() {
        return helper.INSTANCE;
    }
    public void add(String instruccion){
        eventos.add(instruccion);
    }
    public String next(){
        return eventos.poll();
    }
    
}
