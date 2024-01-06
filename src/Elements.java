import java.util.Scanner;

public class Elements {

    public Elements(String name, int number){

        this.name = name;
        this.number = number;

        init = null;
        last = null;
        nextElement = null;


    }
    public String name;
    public int number;

    public Elements init;
    public Elements last;
    public Elements nextElement;
    public int qtd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Elements getInit() {
        return init;
    }

    public void setInit(Elements init) {
        this.init = init;
    }

    public Elements getLast() {
        return last;
    }

    public void setLast(Elements last) {
        this.last = last;
    }

    public Elements getNextElement() {
        return nextElement;
    }

    public void setNextElement(Elements nextElement) {
        this.nextElement = nextElement;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }



}
