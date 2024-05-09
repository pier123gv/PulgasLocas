/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PulgasLocas.Juego;

import PulgasLocas.Elementos.Boundable;
import PulgasLocas.Elementos.Explosion;
import PulgasLocas.Elementos.Pulga;
import PulgasLocas.Elementos.PulgaFantasma;
import PulgasLocas.Elementos.PulgaNormal;
import PulgasLocas.Elementos.PulgaMutante;
import PulgasLocas.Elementos.Repaintable;
import PulgasLocas.Elementos.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pier
 */
public class Simulador{
    
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_MUTANTE = 2;
    public static final int TYPE_FANTASMA = 3;
    private double score;

    private ArrayList<Pulga>pulgas;
    private boolean juegoIniciado;
    private Explosion explosion;
    private int width;
    private int height;
    
    public Simulador(int width, int height){
        this.width = width;
        this.height = height;        
        pulgas = new ArrayList<>();
        explosion = null;
        score = 0;
        juegoIniciado = false;
    }
    
    public double getScore(){
        return score;
    }

    public void draw(Graphics g) {
        
        for (Pulga pulga : pulgas) {
            pulga.draw(g);
        }
        if (explosion != null){
            explosion.draw(g);
        }
    }
    
    
    private void addPulga(int x, int y, Repaintable repaint){
        Pulga pulga = null;
        pulga = new PulgaNormal(x, y, repaint);
        pulgas.add(pulga);
    }
    
    private void addPulga(int type, Repaintable repaint){
        juegoIniciado = true;
        int px = (int)((width - Pulga.WIDTHNormal) * Math.random());
        int py = (int)((height - Pulga.HEIGHTNormal) * Math.random());
        Pulga pulga = null;
        
        if (type == TYPE_NORMAL){
            
            pulga = new PulgaNormal(px, py, repaint);
            pulgas.add(pulga);
        }
        else if (type == TYPE_MUTANTE){
            pulga = new PulgaMutante(px, py, repaint);
            pulgas.add(pulga);
        }
        else if (type == TYPE_FANTASMA){
            pulga = new PulgaFantasma(px, py, repaint);
        }
        pulgas.add(pulga);
        
    }
    
    
    public void keyPressed(int code, Repaintable repaint){
        
        if (code == KeyEvent.VK_H){
            addPulga(TYPE_NORMAL,repaint);
        }
        if (code == KeyEvent.VK_P){
            addPulga(TYPE_MUTANTE,repaint);
        }
        if (code == KeyEvent.VK_F){
            addPulga(TYPE_FANTASMA, repaint);
        }
        if (code == KeyEvent.VK_S){
            saltarTodos();
        }

    }
    public boolean juegoAcabado(){
        if(juegoIniciado && pulgas.size() == 0){
            return true;
        }
        else return false;
    }
    
    public void move(Repaintable repaint, Boundable bounds){
        for(Pulga pulga : pulgas){
            pulga.move(repaint,bounds);
        }
    }
    private void saltarTodos(){
        for(Pulga pulga:pulgas){
            int px = (int)((width - Pulga.WIDTHNormal) * Math.random());
            int py = (int)((height - Pulga.HEIGHTNormal) * Math.random());
            pulga.saltarA(px, py);
        }
    }
    private Pulga clickedApple(int x, int y){
        for (Pulga pulga : pulgas) {
            if (x <= (pulga.getX()+pulga.getWidth()) & x >= (pulga.getX()) & y <= (pulga.getY()+pulga.getHeight()) & y >= (pulga.getY())){
                return pulga;
            }
        }
        return null;
    }
    
    public void mouseClicked(int x, int y, int button, Repaintable repaint){
        
        if(button == MouseEvent.BUTTON2){
            for(int i = 0; i< pulgas.size()/2; i++){
                pulgas.remove(i);
                score+=1;
            }
            explosion = new Explosion(x-180,y-180,360,360);
            return;
        
        }
        else{
            explosion = new Explosion(x-22,y-22,45,45);
        }
        Pulga pulga = clickedApple(x, y);
        if (pulga != null){
            if(pulga.getClass().getSimpleName().equals("PulgaMutante")){
                addPulga(pulga.getX(),pulga.getY(), repaint);
            }
            pulgas.remove(pulga);
            score+=1;
        }
        
    }
    
    
}
