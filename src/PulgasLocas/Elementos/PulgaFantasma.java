/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PulgasLocas.Elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author santi
 */
public class PulgaFantasma extends Pulga{
    
    private int dirX = 1;
    private int dirY = 1;
    
    public PulgaFantasma(int x, int y,Repaintable repaint){
        super(x, y, WIDTHNormal, HEIGHTNormal, Color.BLACK);
        repaint.repaint();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        try{
            BufferedImage image = ImageIO.read(new File("/home/pier/Desktop/Estudio/UAM/POO/PulgasLocas/src/Images/PulgaFantasma.png"));
            g.drawImage(image, x, y, WIDTHNormal, HEIGHTNormal, null);
        }
        catch(IOException e){
        
        }
    }
    
    public void move(Repaintable repaint, Boundable bounds){
        Random rand = new Random();
        int movX = rand.nextInt(3);
        int movY= rand.nextInt(3);
        
        if(this.getX() +movX >=0 && this.getX() +movX <800 && this.getY() +movY >=0 && this.getY() + movY <600){
            this.x=x+movX;
            this.y=y+movY;
           
        }
        this.x=x+(movX*dirX);
        this.y=y+(movY*dirY);
        repaint.repaint();
    }
    

    @Override
    public void saltarA(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
}
