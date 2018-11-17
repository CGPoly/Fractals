public class SierpinskiKurve
{
    protected Turtle t;
    protected int iter;
    public SierpinskiKurve()
    {
        t = new Turtle();
        iter = 0;
    }

    private void vor(double laenge)
    {
        t.vor(laenge);
        //try {Thread.sleep(1000);}catch (InterruptedException ex) {}
    }

    private void drehe(int grad)
    {
        t.drehe(grad);
    }
    
    /*public void kurveStart(int iterations, double laenge)
    {
        iter = iterations;
        drehe(45);
        
        //for(int i = 0; i < 4; i++)
        //{
            kurve(iterations, laenge);
        //}
    }

    private void kurve(int iterations, double laenge)
    {
        if(iterations <= 0)
        {
            vor(laenge/4);
            drehe(90);
            vor(laenge/2);
            drehe(90);
            vor(laenge/4);
        }
        else if(iter == iterations)
        {
            vor(laenge/4);
            drehe(-45);
            vor(laenge);
            drehe(-45);
            vor(laenge/4);
            kurve(iterations-1, laenge);
        }
        else
        {
            vor(laenge/4);
            drehe(-45);
            vor(laenge);
            drehe(-45);
            vor(laenge/4);
            
            vor(laenge/4);
            drehe(90);
            vor(laenge/2);
            drehe(90);
            vor(laenge/4);
            
            vor(laenge/4);
            drehe(45);
            vor(laenge);
            drehe(45);
            vor(laenge/4);
            kurve(iterations-1, laenge);
        }
    }*/
    
    private void kurveRun(int iterations, double laenge)
    {
        if(iterations>0)
        {
            vor(laenge/2);
            drehe(-45);
            vor(laenge);
            drehe(45);
            vor(laenge/2);
            kurveRun(iterations-1,laenge);
        }
        else
        {
            drehe(90);
            vor(laenge/2);
            drehe(90);
        }
    }
    
    public void kurveStart(int iterations, double laenge)
    {
        drehe(45);
        for(int i = 0; i<4; i++)
        {
            kurveRun(iterations, laenge);
        }
    }
}