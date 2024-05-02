/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PulgasLocas.Elementos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author pier
 */
public abstract class Pulga extends Sprite{
    
    public static final int WIDTHNormal = 45, HEIGHTNormal = 45;
    public static final int WIDTHMutante = 90, HEIGHTMutante = 90;
    
    public Pulga(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public abstract void draw(Graphics g);
    public abstract void saltarA(int x, int y);
    
}
