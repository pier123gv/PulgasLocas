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
 * @author pier
 */
public class Explosion extends Sprite {

    public Explosion(int x, int y, int width, int height) {
        super(x, y, width, height, Color.yellow);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        try{
            BufferedImage image = ImageIO.read(new File("/home/pier/Desktop/Estudio/UAM/POO/PulgasLocas/src/Images/Explosion.png"));
            g.drawImage(image, x, y, width, height , null);
        }
        catch(IOException e){
            
        }
     

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
