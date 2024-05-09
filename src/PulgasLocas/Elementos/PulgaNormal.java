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
import javax.imageio.ImageIO;
/**
 *
 * @author santi
 */
public class PulgaNormal extends Pulga{
   
    
    
    public PulgaNormal(int x, int y, Repaintable repaint){
        super(x, y, WIDTHNormal, HEIGHTNormal, Color.RED);
        repaint.repaint();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        try{
            BufferedImage image = ImageIO.read(new File("/home/pier/Desktop/Estudio/UAM/POO/PulgasLocas/src/Images/PulgaNormal.png"));
            g.drawImage(image, x, y, WIDTHNormal, HEIGHTNormal, null);
        }
        catch(IOException e){
            
        }
        

    }

    @Override
    public void saltarA(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public void move(Repaintable repaint, Boundable bounds) {
        
    }
}
