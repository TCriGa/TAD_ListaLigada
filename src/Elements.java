import java.util.Scanner;

public class Elements {

    public Elements(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public String name;
    public int number;

    public Elements init;
    public Elements last;
    public Elements nextElement;
    public int qtd;

    public int getQtd() {
        return qtd;
    }

    public String getName() {
        return name;
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


    public Elements getNextElement() {
        return nextElement;
    }

    public void setNextElement(Elements nextElement) {
        this.nextElement = nextElement;
    }

}
