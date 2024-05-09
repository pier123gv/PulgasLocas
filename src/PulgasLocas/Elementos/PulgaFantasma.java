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
    
    @Override
    public void move(Repaintable repaint, Boundable bounds){
        Random rand = new Random();
        
        int movX = (rand.nextInt(2)+1)*dirX;
        int movY= (rand.nextInt(2)+1)*dirY;
        
        if( this.x + movX <= 0 || this.x + movX > bounds.getBoundWidth()){
            dirX*=-1;
            move(repaint, bounds);
            return;
        }
        if( this.y + movY <= 0 || this.y + movY > bounds.getBoundHeight()){
            dirY*=-1;
            move(repaint, bounds);
            return;
        }
        
        this.x=x + movX;
        this.y=y + movY;
        repaint.repaint();
    }
    

    @Override
    public void saltarA(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
}
