
package mandelbrotset;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MandelbrotSet extends JPanel {
    private final int width = 800;
    private final int height = 800;
    private final double xmin = -2.0, xmax = 1.0, ymin = -1.5, ymax = 1.5;
    private final int maxIter = 300;

    public MandelbrotSet() {
        setPreferredSize(new Dimension(width, height));
    }

    private int mandelbrotIterations(Complexe c) {
        Complexe z = new Complexe(0, 0);
        int iter = 0;
        while (iter < maxIter && z.module() < 2.0) {
            z = z.multiplication(z).addition(c);
            iter++;
        }
        return iter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double cx = xmin + x * (xmax - xmin) / width;
                double cy = ymin + y * (ymax - ymin) / height;
                Complexe c = new Complexe(cx, cy);
                int iter = mandelbrotIterations(c);
                g.setColor(new Color(iter % 256, iter % 256, iter % 256));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ensemble de Mandelbrot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MandelbrotSet());
        frame.pack();
        frame.setVisible(true);
    }
}