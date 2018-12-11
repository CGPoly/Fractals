package core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MandelbrotImg extends JFrame {

    private BufferedImage I;
    private int width = 30*50;
    private int heigth = 21*50;
    private int widthImg = 30*50;
    private int heigthImg = 21*50;
    private Color[] colors;

    public MandelbrotImg() {
        super("");
        colors = new Color[]{Color.black, Color.green, Color.blue, Color.yellow, Color.red, Color.gray, Color.lightGray, Color.orange, Color.darkGray, Color.white};
        setBounds(10, 10, width, heigth);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(widthImg, heigthImg, BufferedImage.TYPE_INT_RGB);
        int maxIter = 500; //größere Zahlen = höhere Prezision = dünnere Striche
        double escapeTime = Math.pow(10,3); //größere Zahlen = höhere Prezision (ab 30 kein unterschied mehr bemerkbar)
        mandelbrotSet(500,maxIter, 0, 0, escapeTime, 5);
    }

    @Override
    public void paint(Graphics g) {
        try {
            File outputfile = new File("saved.png");
            ImageIO.write(I, "png", outputfile);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error while saving!");
        }
        g.drawImage(I, 0, 0, width, heigth, this);
    }

    public void mandelbrotSet(double zoom, int maxIterations, double posX, double posY, double escapeTime, int power){
        for (int x = 0; x < widthImg; x++) {
            for (int y = 0; y < heigthImg; y++) {
                double cReal = ((x - widthImg/2.0)+posX) / zoom; // Berechnet das C für die X-Achse (durch Zoom und verschiebung wird das C genau das gefragte)
                double cImaginary = ((y - heigthImg/2.0)+posY) / zoom; // Berechner das C für die Y-Achse
                draw(x, y, calculate(0, 0,  cReal, cImaginary,  escapeTime,  0, maxIterations, power));
            }
        }
    }

    private int calculate(double zx,double zy, double cReal,double cImaginary, double escapeTime, int iterations, int maxIter, int power){
        if (zx * zx + zy * zy < escapeTime && maxIter > iterations) {
            try {
                /*double tmp = zx * zx - zy * zy + cReal;
                zy =  2.0 * zx * zy + cImaginary;
                zx = tmp;*/
                double[] result = cPower(zx,zy, power);
                zx = result[0] + cReal;
                zy = result[1] + cImaginary;
                return calculate(zx, zy, cReal, cImaginary, escapeTime, iterations + 1, maxIter, power);
            } catch (StackOverflowError er){
                return 0;
            }
        }
        return iterations;
    }

    private void draw(int x, int y,int iterations){
        I.setRGB(x, y, giveColor(iterations).getRGB());
    }

    public static void main(String[] args) {
        new MandelbrotImg().setVisible(true);
    }

    private Color giveColor(int c) {
        c = c % 10;
        return colors[c];
    }

    private double[] cMultiply(double a,double b,double c,double d){
        double[] result = new double[2];
        result[0] = a * c - b * d;
        result[1] = c * b + a *d;
        return result;
    }

    private double[] cPower(double a, double b, double n){
        double[] result = {a,b};
        for (int i = 1; i < n; i++){
            result = cMultiply(a,b,result[0], result[1]);
        }
        return result;
    }
}
