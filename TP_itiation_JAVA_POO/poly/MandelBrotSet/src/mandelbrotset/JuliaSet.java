
package mandelbrotset;


import java.awt.*;
import javax.swing.*;

public class JuliaSet extends JPanel {
    private final int width = 800;
    private final int height = 800;
    private final double xmin = -1.5, xmax = 1.5, ymin = -1.5, ymax = 1.5;
    private final int maxIter = 300;
    private final Complexe c = new Complexe(-0.05, 0.7);

    public JuliaSet() {
        setPreferredSize(new Dimension(width, height));
    }

    private int juliaIterations(Complexe z) {
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
                double zx = xmin + x * (xmax - xmin) / width;
                double zy = ymin + y * (ymax - ymin) / height;
                Complexe z = new Complexe(zx, zy);
                int iter = juliaIterations(z);
                g.setColor(new Color(iter % 256, iter % 256, iter % 256));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ensemble de Julia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JuliaSet());
        frame.pack();
        frame.setVisible(true);
    }
}
