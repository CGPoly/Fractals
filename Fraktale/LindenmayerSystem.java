import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LindenmayerSystem
{
    protected Turtle t;

    public LindenmayerSystem()
    {
        t = new Turtle();

        //Hilbert Curve
        /*t.zumStart(5,5);
        String[] rules = {"X:+YF-XFX-FY+", "Y:-XF+YFY+FX-"};
        LSystem("X", rules, 8, 2, 90);*/

        //HexagonalGosper:
        /*t.zumStart(1000,100);
        String[] rules = {"X=X+YF++YF-FX--FXFX-YF+", "Y=-FX+YFYF++YF+FX--FX-Y"};
        LSystem("XF", rules, 5, 6, 60);*/

        //Peano-Kurve
        /*t.zumStart(5,5);
        String[] rules = {"X = XFYFX+F+YFXFY-F-XFYFX", "Y = YFXFY-F-XFYFX+F+YFXFY"};
        LSystem("X", rules, 5, 3, 90);*/

        //Sierpinski-Teppich
        /*t.zumStart(5,t.liesMaxY()/2);
        String[] rules = {"F = F+F-F-FF-F-F-fF", "f = fff"};
        LSystem("F", rules, 6, 2, 90);*/

        //Lévy-C-Kurve
        /*String[] rules = {"F = +F--F+"};
        LSystem("F", rules, 15, 2, 45);*/
        
        //Wiggle Curve
        String[] rules = {"Z = ZZZF", "X = -FX+F+XF-F-FX+F+F", "Y = -F+F+YF-F-FY+F+YF-"};
        LSystem("Z-FX+F+YF-z", rules, 1, 25, 90);
    }

    private void drehe (double grad)  
    {
        t.drehe(grad);
    } 

    private void vor (double laenge){
        t.vor(laenge); 
    }

    public void LSystem(String axiom, String[] rules, int iterations, double length, double angle) {
        Map<Character, char[]> parsedRules = rulesToMap(rules); // erstellt eine Map aus der Methode parsedRules() 
        for (int i = 0; i < iterations; i++) { 
            axiom = applyRules(parsedRules, axiom); // wendet apply rules so häufig auf state an, wie die Iterationen Vorgeben
        }
        draw(axiom, length, angle); // wendet den fertigen String, die Länge und den Winkel auf draw an
    }

    private Map<Character, char[]> rulesToMap(String[] rules) {
        Map<Character, char[]> parsedRules = new HashMap<Character, char[]>(); // erstellt eine neue HashMap, ähnlich einem Dictionary in Python
        for (String rule : rules) { // Foreach Schleife, die ein CharArray aus rules durchgeht
            rule = rule.replaceAll("[=\\:\\s]", ""); // löscht alle ":", "=" und " "
            char[] parsedRule = rule.toCharArray(); // zerlegt den String in ein CharArray
            char constant = parsedRule[0]; // setzt den ersten Char des Arrays als constant
            char[] production = Arrays.copyOfRange(parsedRule, 1, parsedRule.length); // kopiert den Array parsedRules, lässt dabei aber den ersten Char aus
            parsedRules.put(constant, production); // setzt constant und product als key und value ein
        }
        return parsedRules;
    }

    private String applyRules(Map<Character, char[]> rules, String axiom) {
        String newAxiom = ""; // erstellt einen leeren String
        for (char i : axiom.toCharArray()) { // Foreach Schleife, die ein CharArray aus axiom durchgeht
            if (rules.get(i) != null) { // überprüft, ob es zu dem akktuellen char ein value in rules gibt
                String p = new String(rules.get(i)); // erstellt einen String aus dem Array, das dem key entspricht
                newAxiom += p; // erweitert newAxiom um p
            } else {
                newAxiom += i; // erweitert newAxiom um den akktuellen key
            }
        }
        return newAxiom;
    }

    private void draw(String axiom, double length, double angle) {  
        //failed code for Branching
        /*double[] posBevorBranchX = new double[0]; 
        double[] posBevorBranchY = new double[0];
        double[] dirBevorBranch = new double[0];
        int accBranch = -1;*/

        for(char item : axiom.toCharArray()) { // Foreach Schleife, die ein CharArray aus axiom durchgeht
            switch(item) { // switch anweisung, die den akktuellen Buchstaben des Arrays untersucht
                case 'F': // wenn der akktuelle Buchstabe F ist geht die Turtle um length nach Vorne
                    vor(length);
                    break;
                case 'f': // wenn der akktuelle Buchstabe f ist geht die Turtle um length nach Vorne, zeichnet aber keinen Strich
                    t.hebeStift();
                    vor(length);
                    t.senkeStift();
                    break;
                case '+': // wenn der akktuelle Buchstabe + ist dreht sich die Turtle um angle nach rechts
                    drehe(angle);
                    break;
                case '-': // wenn der akktuelle Buchstabe + ist dreht sich die Turtle um angle nach links
                    drehe(-angle);
                    break;
                case 'C':
                    t.setzeFarbe(t.liesFarbe()+1);
                    break;
                case 'c':
                    t.setzeFarbe(t.liesFarbe()-1);
                    break;
                default: // wenn der akktuelle Buchstabe nicht einprogramiert ist, dann passiert nichts
                    break;
            } 
        }
    }

    //needed for Branching
    /*public char[] biggerizeArray(char[] array, char input) { 
        char[] tmp = new char[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[tmp.length-1] = input;
        return tmp; 
    }

    public char[] smallerizeArray(char[] array) { 
        return Arrays.copyOfRange(array, 0, array.length-1); 
    } */
}
