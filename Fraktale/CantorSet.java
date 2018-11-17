
public class CantorSet {
    protected Turtle t;

    public CantorSet() {
        t = new Turtle();
        t.zumStart(5,5);
    }

    private void drehe (int grad) {
        t.drehe(grad);
    }

    private void vor (double laenge){
        t.vor(laenge);
    }

    public void draw(String input, double length, int iter) {
        if(iter>0) {
            double posX = t.liesX();
            double posY = t.liesY();
            switch(input) {
                case "A":
                    vor(length);
                    break;
                case "B":
                    t.hebeStift();
                    vor(length);
                    t.senkeStift();
                    break;
            }
            //t.zumStart(posX, posY+10);
            String rule[] = rule(input);
            draw(rule[0], length/3, iter-1);
            draw(rule[1], length/3, iter-1);
            draw(rule[2], length/3, iter-1);
        }
    }

    public String[] rule(String input) {
        String a[];
        switch(input) {
            case "A":
            return new String[] {"A","B","A"};
            case "B":
            return new String[] {"B","B","B"};
            default:
            return new String[] {"","",""};
        }
    }
}
