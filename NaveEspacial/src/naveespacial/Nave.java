/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naveespacial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author SAMSUNG
 */
public class Nave extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    private int x = 0;
    private int y = 0;
    private int x2 = 0;
    private int y2 = 0;
    private int velX = 0;
    private int velY = 0;
    private int velX2 = 0;
    private int velY2 = 0;

    public Nave() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.BLACK);

        //PROPULSORES LATERALES
        g.setColor(Color.WHITE);
        g.fillRoundRect(0 + x, 0 + y, 70, 20, 10, 10);
        g.fillRoundRect(0 + x, 110 + y, 70, 20, 10, 10);

        //CUERPO NAVE
        g.setColor(Color.BLUE);
        g.fillRect(0 + x, 40 + y, 30, 20);
        g.fillRect(0 + x, 70 + y, 30, 20);
        g.fillRect(20 + x, 50 + y, 70, 30);
        g.fillOval(80 + x, 50 + y, 40, 30);

        //ALAS NAVE
        g.fillRoundRect(20 + x, 15 + y, 30, 40, 12, 12);
        g.fillRoundRect(20 + x, 80 + y, 30, 40, 12, 12);

        //CABINA NAVE
        g.setColor(Color.YELLOW);
        g.fillOval(90 + x, 55 + y, 25, 20);

        g.setColor(Color.GREEN);
        //BALAS NAVE
        g.fillRect(20 + x2, 30 + y2, 20, 5);
        g.fillRect(20 + x2, 90 + y2, 20, 5);

    }

    public void actionPerformed(ActionEvent e) {
        if (x < 0) {
            velX = 0;
            velX2 = 0;
            x = 0;

        }
        if (x > 500) {
            velX = 0;
            velX2 = 0;
            x = 500;
            x2 = 500;
        }

        if (y < 0) {
            velY = 0;
            velY2 = 0;
            y = 0;
            y2 = 0;
        }
        if (y > 330) {
            velY = 0;
            velY2 = 0;
            y = 330;
            y2 = 330;
        }

        if (x2 < x) {
            x2 = 0;
        }
        if (x2 > 500) {

            velX2 = 0;

            x2 = x;
        }

        if (y2 < y) {

            velY2 = 0;

            y2 = 0;
        }
        if (y2 > y) {

            velY2 = 0;

            y2 = 330;
        }

        x = x + velX;
        y = y + velY;
        x2 = x2 + velX2;
        y2 = y2 + velY2;

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = -10;
            velY = 0;
            velX2 = -10;
            velY2 = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            velX = 0;
            velY = -10;
            velX2 = 0;
            velY2 = -10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 10;
            velY = 0;
            velX2 = 10;
            velY2 = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 10;
            velX2 = 0;
            velY2 = 10;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velX2 = 100;
            velY2 = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = 0;
            velY = 0;
            velX2 = 0;
            velY2 = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            velX = 0;
            velY = 0;
            velX2 = 0;
            velY2 = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 0;
            velY = 0;
            velX2 = 0;
            velY2 = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 0;
            velX2 = 0;
            velY2 = 0;
        }
    }

    
    public static void main(String[] args) {
        Nave N = new Nave();
        JFrame f = new JFrame();

        f.setTitle("Nave Espacial");
        f.setSize(630, 493);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.BLACK);
        f.setResizable(false);
        f.setVisible(true);
        f.add(N);
    }
}