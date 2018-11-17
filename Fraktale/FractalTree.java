public class FractalTree
{
    double lessLength;
    double winkel;
    protected Turtle t;
    public FractalTree()
    {
        t = new Turtle();
        lessLength = 0.75;
        winkel = 35;
    }

    private void drehe(double deg)
    {
        t.drehe(deg);
    }

    private void vor(double length)
    {
        t.vor(length);
    }

    private void zumStart(double posX, double posY)
    {
        t.zumStart(posX, posY);
    }

    public void fractalTreePerfect(int iter, double length)
    {
        zumStart(t.liesMaxX()/2, t.liesMaxY()-5);
        drehe(-90);
        vor(length);
        double posX = t.liesX();
        double posY = t.liesY();
        double direction = t.liesRichtung();
        fractalTreeRunL(iter-1, length*lessLength, posX, posY, direction);
        fractalTreeRunR(iter-1, length*lessLength, posX, posY, direction);
    }

    private void  fractalTreeRunL(int iter, double length, double posX, double posY, double direction)
    {
        if(iter > 0)
        {
            zumStart(posX, posY);
            t.setzeRichtung(direction);
            drehe(winkel);
            vor(length);
            posX = t.liesX();
            posY = t.liesY();
            direction = t.liesRichtung();
            fractalTreeRunL(iter-1, length*lessLength, posX, posY, direction);
            fractalTreeRunR(iter-1, length*lessLength, posX, posY, direction);
        }
    }

    private void  fractalTreeRunR(int iter, double length, double posX, double posY, double direction)
    {
        if(iter > 0)
        {
            zumStart(posX, posY);
            t.setzeRichtung(direction);
            drehe(-winkel);
            vor(length);
            posX = t.liesX();
            posY = t.liesY();
            direction = t.liesRichtung();
            fractalTreeRunL(iter-1, length*lessLength, posX, posY, direction);
            fractalTreeRunR(iter-1, length*lessLength, posX, posY, direction);
        }
    }
}
