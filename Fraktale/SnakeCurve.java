public class SnakeCurve
{
    protected Turtle t;

    public SnakeCurve()
    {
        t = new Turtle();
    }

    private void drehe (int grad)
    {
        t.drehe(grad);
    }

    private void vor (double laenge){
        t.vor(laenge);
    }

    public void drawStart(int iter, double lengthVer, double lengthHor) {
        t.zumStart(5,5);
        if(iter > 0) {
            if(iter%2 == 0) {
                vor(lengthVer);
                drehe(90);
                vor(lengthHor);
                drehe(90);
                vor(lengthVer);
            }
            else {
                t.hebeStift();
                vor(lengthVer);
                drehe(180);
                t.senkeStift();
                vor(lengthVer);
                drehe(-90);
                vor(lengthHor);
                drehe(-90);
                vor(lengthVer);
            }
            drawRun(iter-1, lengthVer, lengthHor);
        }
    }

    private void drawRun(int iter, double lengthVer, double lengthHor) {
        if(iter > 0) {
            if(iter%2 == 0) {
                drehe(90);
                vor(lengthHor);
                drehe(90);
                vor(lengthVer);
            }
            else {
                drehe(-90);
                vor(lengthHor);
                drehe(-90);
                vor(lengthVer);
            }
            drawRun(iter-1, lengthVer, lengthHor);
        }
    }
}
