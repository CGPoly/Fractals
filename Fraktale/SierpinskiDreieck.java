public class SierpinskiDreieck
{
    protected Turtle t;
    public SierpinskiDreieck()
    {
        t = new Turtle();
    }

    private void vor(double length)
    {
        t.vor(length);
    }

    private void drehe(int grad)
    {
        t.drehe(grad);
    }
    
    public void sierpinskiStart(int iterations, double length)
    {
        t.zumStart(5, t.liesMaxY()-5);
        vor(length/2);
        sierpinskiRun(iterations-1, length/2);
        vor(length/2);
        drehe(-120);
        vor(length);
        drehe(-120);
        vor(length);
    }
    
    private void sierpinskiRun(int iterations, double length)
    {
        if(iterations > 0)
        {
            drehe(-60);
            for(int i = 0; i < 3; i++)
            {
                vor(length/2);
                sierpinskiRun2(iterations-1, length/2);
                vor(length/2);
                drehe(-120);
            }
            drehe(60);
        }
    }
    
    private void sierpinskiRun2(int iterations, double length)
    {
        if(iterations > 0)
        {
            drehe(120);
            for(int i = 0; i < 3; i++)
            {
                vor(length/2);
                sierpinskiRun2(iterations-1, length/2);
                vor(length/2);
                drehe(-120);
            }
            drehe(-120);
        }
    }
}

