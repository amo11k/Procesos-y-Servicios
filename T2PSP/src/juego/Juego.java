package juego;

import javax.swing.JFrame;

public class Juego extends JFrame {

    public Juego() {

        add(new BoardMultiMoviles());        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Star");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Juego();
    }
}