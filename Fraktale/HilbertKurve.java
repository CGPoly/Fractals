//Nachbau des beruemten Fraktals von Hilbert

public class HilbertKurve {
    //Erschaffung der Turtle und bauen einer schneller schreibbaren Turtle Funktion
    protected Turtle t;

    public HilbertKurve()
    {
        t = new Turtle();
        //setzen einer Idealen Startposition

        //Eingaben zur suche der Regelmäsigkeit
        /*hilbert(1, 250, true, 0, 1); //1
        hilbert(2, 250, true, 1, 0); //1
        hilbert(3, 250, true, 2, 1); //2
        t.zumStart(5, 260);
        hilbert(4, 250, true, 5, 0); //4
        hilbert(5, 250, true, 10, 1); //8
        hilbert(6, 250, true, 21, 0); //16
        /*t.zumStart(5, 515);
        hilbert(7, 250, true, 42, 1);
        hilbert(8, 250, true, 85, 0);
        hilbert(9, 250, true, 170, 1);*/

        /*hilbert(1, 250, true);
        hilbert(2, 250, true);
        hilbert(3, 250, true);
        t.zumStart(5, 260);
        hilbert(4, 250, true);
        hilbert(5, 250, true);
        hilbert(6, 250, true);
        /*t.zumStart(5, 515);
        hilbert(7, 250, true);
        hilbert(8, 250, true);
        hilbert(9, 250, true);*/

        /*hilbertStart(7, 850, true);
        vor(getLaenge(7, 850));
        hilbert(7, getLaenge(7, 850));*/

        hilbertStart(1, 400, true);
        t.hebeStift();
        vor(25);
        t.senkeStift();
        hilbertStart(2, 400, false);
        t.hebeStift();
        vor(25);
        t.senkeStift();
        hilbertStart(3, 400, false);
        t.hebeStift();
        vor(25);
        t.senkeStift();
        hilbertStart(4, 400, false);
    }

    private void drehe (int grad)
    {
        t.drehe(grad);
    }

    private void vor (double laenge){
        t.vor(laenge);
    }

    //Die start Funktion der Hilbert Kurve und halbe Iterations Funktion
    private void hilbert(int iterationen, double laenge) {
        //Überprüft ob die Iteration größer 0 ist
        if (iterationen > 0) {
            //Malt die Kurve. Ohne die Funktionsaufrufe (eingerückt) würde das Programm nur eine Hilbertkurve der 1sten Itertionstufe Malen
            //Ruft die Iterationsproramme und die gedrehten Iterationsprogramme so auf, dass die Kurve ohne Überlappung an einem stück gezeichnet werden kann.
            drehe(90);
            hilbertGedreht(iterationen-1, laenge);
            vor(laenge);
            drehe(-90);
            hilbert(iterationen-1, laenge);
            vor(laenge);
            hilbert(iterationen-1, laenge);
            drehe(-90);
            vor(laenge);
            hilbertGedreht(iterationen-1, laenge);
            drehe(90);
        }
    }

    public void hilbertStart(int iterationen, double laenge, boolean resetPosition) {
        if(iterationen > 1) {
            laenge = getLaenge(iterationen, laenge);
        }
        if(resetPosition) {
            t.zumStart(5, 5);
        }
        //Überprüft ob die Iteration größer 0 ist
        if (iterationen > 0) {
            //Malt die Kurve. Ohne die Funktionsaufrufe (eingerückt) würde das Programm nur eine Hilbertkurve der 1sten Itertionstufe Malen
            //Ruft die Iterationsproramme und die gedrehten Iterationsprogramme so auf, dass die Kurve ohne Überlappung an einem stück gezeichnet werden kann.
            drehe(90);
            hilbertGedreht(iterationen-1, laenge);
            vor(laenge);
            drehe(-90);
            hilbert(iterationen-1, laenge);
            vor(laenge);
            hilbert(iterationen-1, laenge);
            drehe(-90);
            vor(laenge);
            hilbertGedreht(iterationen-1, laenge);
            drehe(90);
        }
    }

    //Überladene Funktion zum Test der Regelmäsigkeit
    /*public void hilbert(int iterationen, double laenge, boolean first, double factor, double adder) {
    //Überprüft ob die Iteration größer 0 ist
    if(first && iterationen > 1) {
    laenge = laenge / ((3 * factor)+adder);
    }
    if (iterationen > 0) {
    //Malt die Kurve. Ohne die Funktionsaufrufe (eingerückt) würde das Programm nur eine Hilbertkurve der 1sten Itertionstufe Malen
    //Ruft die Iterationsproramme und die gedrehten Iterationsprogramme so auf, dass die Kurve ohne Überlappung an einem stück gezeichnet werden kann.
    drehe(90);
    hilbertGedreht(iterationen-1, laenge, false);
    vor(laenge);
    drehe(-90);
    hilbert(iterationen-1, laenge, false);
    vor(laenge);
    hilbert(iterationen-1, laenge, false);
    drehe(-90);
    vor(laenge);
    hilbertGedreht(iterationen-1, laenge, false);
    drehe(90);
    }
    }*/

    //Die andere Hälfte der Iterations Funktion
    private void hilbertGedreht(int iterationen, double laenge) {
        //Überprüft ob die Iteration größer 0 ist
        if (iterationen > 0) {
            //Malt die Kurve. Ohne die Funktionsaufrufe (eingerückt) würde das Programm nur eine Hilbertkurve der 1sten Itertionstufe Malen
            //Ruft die Iterationsproramme und die gedrehten Iterationsprogramme so auf, dass die Kurve ohne Überlappung an einem stück gezeichnet werden kann.
            drehe(-90);
            hilbert(iterationen-1, laenge);
            vor(laenge);
            drehe(90);
            hilbertGedreht(iterationen-1, laenge);
            vor(laenge);
            hilbertGedreht(iterationen-1, laenge);
            drehe(90);
            vor(laenge);
            hilbert(iterationen-1, laenge);
            drehe(-90);
        }
    }

    private double getLaenge(int iterationen, double laenge) {
        int factor = 1;
        for (int i = 2; i != iterationen; i++) {
            if(i % 2 == 0) {
                factor = factor * 2;
            }
            else {
                factor *= 2;
                factor = factor + 1;
            }
        }
        if(iterationen % 2 == 0) {
            laenge = laenge / (3 * factor);
        }
        else {
            laenge = laenge / ((3 * factor)+1);
        }
        return laenge;
    }
}