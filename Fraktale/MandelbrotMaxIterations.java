package core;

import turtle.Turtle;

public class MandelbrotMaxIterations {
    protected static Turtle turtle;

    public static void main(String[] args) {
        turtle = new Turtle(1500,750);
        //turtle.setSpeed(10);
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ex){}
        int maxIter = 500; //größere Zahlen = höhere Prezision = dünnere Striche
        double escapeTime = 36; //größere Zahlen = höhere Przision (ab 30 kein unterschied mehr bemerkbar)
        double discriminator = 475; //kleinere Zahlen = höhere Prezision = dünnere Striche
        mandelbrotSet(400,maxIter, turtle.getMaxX(), turtle.getMaxY(),escapeTime,discriminator,1+1*Math.pow(10,-14),23);
    }

    public static void mandelbrotSet(double zoom, int maxIterations, double posX, double posY, double escapeTime, double discriminator, double colourSpacing, int colourSpace){
        for (int x = 0; x < turtle.getMaxX(); x++) {
            for (int y = 0; y < turtle.getMaxY(); y++) {
                double cReal = (x - posX/2) / zoom; // Berechnet das C für die X-Achse (durch Zoom und verschiebung wird das C genau das gefragte)
                double cImaginary = (y - posY/2) / zoom; // Berechner das C für die Y-Achse
                draw(x, y, calculate(0, 0,  cReal, cImaginary,  escapeTime,  maxIterations), discriminator, colourSpacing, colourSpace);
            }
        }
    }

    public static int calculate(double zx,double zy, double cReal,double cImaginary, double escapeTime, int iterations){
        if (zx * zx + zy * zy < escapeTime && iterations > 0) {
            double tmp = zx * zx - zy * zy + cReal;
            zy = 2.0 * zx * zy + cImaginary;
            zx = tmp;
            //System.out.println(zx+" "+zy+" "+iterations);
            return calculate(zx, zy,cReal, cImaginary, escapeTime, iterations-1);
        }
        System.out.println(zx+" "+zy+" "+iterations);
        /*System.out.println();
        System.out.println();
        System.out.println();*/
        return iterations;
    }

    public static int calculate(int power, double zx,double zy, double cReal,double cImaginary, double escapeTime, int iterations){
        if (Math.pow(zx,2) + Math.pow(zy,2) < escapeTime && iterations > 0) {
            double tmp = Math.pow(zx,power) - Math.pow(zy,power) + cReal;
            zy = 2 * zx * zy + cImaginary;
            zx = tmp;
            return calculate(power, zx, zy,cReal, cImaginary, escapeTime, iterations-1);
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

    public static void highlightPoint(double real, double imaginary){
        turtle.toStartingPoint(real,imaginary);
        if (turtle.getPixelColor() != 0){
            turtle.setColor(0);
        }
        else {
            turtle.setColor(9);
        }
        turtle.fillCircle(10);
    }
}
