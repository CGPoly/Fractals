//Eine selbst "entwickelte" abänderung der Koch Flocke

public class KochX {
    protected Turtle t;

    public KochX()
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
    
    public void kochX(int iterationen, double laenge)
    {
        //Turtle wird auf die optimale Position gesetzt
        t.zumStart(5, 5/*t.liesMaxY()-(laenge*0.32)*/);
        //Seitenlaengen werden auf Iterationsstufen angepasst
        laenge /= Math.pow(3.0, iterationen); 
        //Programm zur Dreieckszeichnung, wo die vor() methode gegen das Iterationsprogramm ersetzt wird.
        for (int i = 0; i < 4; i++) {
            kochSeite(iterationen, laenge);
            drehe(90);
        }
    }
    
    private void kochSeite(int iterationen, double laenge) {
        // wenn die Iteration nicht = 0 ist wird ein Dreieck gezeichnet, bei dem der schließende strich um 180° gedreht ist.
        //Dabei werden die vor() methoden wieder gegen das Iterationsprogram ersetzt
        if (iterationen != 0) 
        {
            kochSeite(iterationen-1, laenge);
            drehe(60);
            kochSeite(iterationen-1, laenge);
            drehe(-120);
            kochSeite(iterationen-1, laenge);
            drehe(60);
            kochSeite(iterationen-1, laenge);
        }
        // wenn die Iteration = 0 ist wird einfach nur ein Strich gezeichnet.
        else
        {
            vor(laenge);
        }
    } 
} 

