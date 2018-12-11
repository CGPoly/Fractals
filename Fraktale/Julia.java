package core;

import turtle.Turtle;

public class Julia{
    protected static Turtle turtle;

    public static void main(String[] args) {
        turtle = new Turtle(1500,750);
        //turtle.setSpeed(10);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){}
        int maxIter = 250; //größere Zahlen = höhere Prezision = dünnere Striche
        double escapeTime = 30; //größere Zahlen = höhere Przision (ab 30 kein unterschied mehr bemerkbar)
        double discriminator = 225; //kleinere Zahlen = höhere Prezision = dünnere Striche
        JuliaSet(1.15, maxIter, -0.835,-0.2321,0,0,escapeTime, discriminator, 1+1*Math.pow(10,-10),25);
    }

    public static void JuliaSet(double zoom, int maxIterations, double cReal, double cImaginary, double posX, double posY, double escapeTime, double discriminator, double colourSpacing, double colourSpace) {
         for (int x = 0; x < turtle.getMaxX(); x++) {
            for (int y = 0; y < turtle.getMaxY(); y++) {
                double zx = 2.0 * (x - turtle.getMaxX() / 2) / (0.5 * zoom * turtle.getMaxX()) + posX; // Berechnet das Z das 2.0 passt die Größe auf das Format an
                double zy = (y - turtle.getMaxY() / 2) / (0.5 * zoom * turtle.getMaxY()) + posY; // Berechnet das Z
                draw(x, y, calculate(zx, zy,  cReal, cImaginary,  escapeTime,  maxIterations), discriminator, colourSpacing, colourSpace);
            }
        }
    }

    public static int calculate(double zx,double zy, double cReal,double cImaginary, double escapeTime, int iterations){
        if (zx * zx + zy * zy < escapeTime && iterations > 0) {
            double tmp = zx * zx - zy * zy + cReal;
            zy = 2.0 * zx * zy + cImaginary;
            zx = tmp;
            return calculate(zx, zy,cReal, cImaginary, escapeTime, iterations-1);
        }
        return iterations;
    }

    public static void draw(int x, int y,int iterations, double discriminator, double colourSpacing, double colourSpace){
        for (int i = 0; i < colourSpace; i++){
            if(i == 0 && iterations < discriminator) {
                turtle.toStartingPoint(x, y);
                turtle.setColor(i);
                turtle.plotPixel();
            }
            else if(discriminator+(colourSpacing*(i-1)) < iterations && iterations < discriminator + (colourSpacing*i)) {
                turtle.toStartingPoint(x, y);
                turtle.setColor(i);
                turtle.plotPixel();
            }
        }
    }
}