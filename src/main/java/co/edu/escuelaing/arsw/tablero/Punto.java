/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.tablero;

/**
 *
 * @author Andres Gonzalez
 */
public class Punto {
    private Double x;
    private Double y;
    
    public Punto(Double x, Double y ){
        this.x=x;
        this.y=y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    
}
