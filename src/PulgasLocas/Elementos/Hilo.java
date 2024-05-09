/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PulgasLocas.Elementos;

import PulgasLocas.Juego.Simulador;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author pier
 */
public class Hilo extends Thread{
    
    public Simulador simulador;
    public Repaintable repintable;
    public Boundable bounds;
    
    public Hilo(Simulador simulador, Repaintable repintable, Boundable bounds){
        this.simulador = simulador;
        this.repintable = repintable;
        this.bounds = bounds;
    }
    
    public void run(){
        for(;;){
            simulador.move(repintable, bounds);
            try{
                Hilo.sleep(10);
            }
            catch (InterruptedException Ex){
                
            }
            
        }
    }
}
