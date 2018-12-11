package core;

import turtle.Turtle;

public class MandelbrotOriginal {

    protected static Turtle turtle;

    public static void main(String[] args) {
        turtle = new Turtle(1500,750);
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ex){}
        double escapeTime = Math.pow(10,3); //größere Zahlen = höhere Przision (ab 30 kein unterschied mehr bemerkbar)
        mandelbrotSet(400, turtle.getMaxX(), turtle.getMaxY(),escapeTime, 100);
    }

    public static void mandelbrotSet(double zoom, double posX, double posY, double escapeTime, int maxIter){
        for (int x = 0; x < turtle.getMaxX(); x++) {
            for (int y = 0; y < turtle.getMaxY(); y++) {
                double cReal = (x - posX/2) / zoom; // Berechnet das C für die X-Achse (durch Zoom und verschiebung wird das C genau das gefragte)
                double cImaginary = (y - posY/2) / zoom; // Berechner das C für die Y-Achse
                draw(x, y, calculate(0, 0,  cReal, cImaginary,  escapeTime,  0, 100));
            }
        }
    }

    public static int calculate(double zx,double zy, double cReal,double cImaginary, double escapeTime, int iterations, int maxIter){
        if (zx * zx + zy * zy < escapeTime && maxIter > iterations) {
            try {
                double tmp = zx * zx - zy * zy + cReal;
                zy = 2.0 * zx * zy + cImaginary;
                zx = tmp;
                return calculate(zx, zy, cReal, cImaginary, escapeTime, iterations + 1, maxIter);
            } catch (StackOverflowError er){
                return 0;
            }
        }
        return iterations;
    }

    public static void draw(int x, int y,int iterations) {
        turtle.toStartingPoint(x, y);
        turtle.setColor(iterations);
        turtle.plotPixel();
    }
}
