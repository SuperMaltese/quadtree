package quad;

import java.util.HashSet;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class QuadTreeVisualizer extends Canvas {
    QuadTree q;
    int coordSize = 20;
    int xAxis = 100;
    int yAxis = 100;
    static int cWidth = 200;
    static int cHeight = 200;
    public QuadTreeVisualizer() {
        q = new QuadTree(1, 1);
        q.add(3, 4);
        q.add(4, 5);
        q.add(2, 5);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new QuadTreeVisualizer();
        canvas.setSize(cWidth, cHeight);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        //g.drawLine(yAxis, 0, yAxis, cHeight);
        //g.drawLine(0, xAxis, cWidth, xAxis);
        drawQ(g, q, 0, cWidth, 0, cHeight); 
    }
    private void drawQ(Graphics g, QuadTree qt, int leftBound, int rightBound, int upBound, int lowBound) {
        if (qt != null) {
            int xPixel = yAxis + (qt.xx * coordSize);
            int yPixel = xAxis - (qt.yy * coordSize);
            g.fillOval(xPixel, yPixel, 10, 10);
            g.drawLine(leftBound, yPixel, rightBound, yPixel);
            g.drawLine(xPixel, upBound, xPixel, lowBound);
            drawQ(g, qt.northeast, xPixel, rightBound, upBound, yPixel);
            drawQ(g, qt.northwest, leftBound, xPixel, upBound, yPixel);
            drawQ(g, qt.southeast, xPixel, rightBound, yPixel, upBound);
            drawQ(g, qt.southwest, leftBound, xPixel, yPixel, upBound);
        }
    }


}
