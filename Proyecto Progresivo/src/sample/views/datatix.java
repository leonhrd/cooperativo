package sample.views;

import java.util.ArrayList;

public class datatix {
    public ArrayList<String> taco = new ArrayList<String>();
    public ArrayList<Integer> tacop = new ArrayList<Integer>();

    public datatix(ArrayList<String> taco, ArrayList<Integer> tacop) {
        this.taco = taco;
        this.tacop = tacop;
    }

    public ArrayList<String> getTaco() {
        return taco;
    }

    public void setTaco(ArrayList<String> taco) {
        this.taco = taco;
    }

    public ArrayList<Integer> getTacop() {
        return tacop;
    }

    public void setTacop(ArrayList<Integer> tacop) {
        this.tacop = tacop;
    }
}
