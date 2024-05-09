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
public class PulgaMutante extends Pulga{
    
    
    public PulgaMutante(int x, int y, Repaintable repaint){
        super(x, y, WIDTHMutante, HEIGHTMutante, Color.BLACK);
        repaint.repaint();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        try{
            BufferedImage image = ImageIO.read(new File("/home/pier/Desktop/Estudio/UAM/POO/PulgasLocas/src/Images/PulgaMutante.png"));
            g.drawImage(image, x, y, WIDTHMutante, HEIGHTMutante, null);
        }
        catch(IOException e){
            
        }
    }

    @Override
    public void saltarA(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
