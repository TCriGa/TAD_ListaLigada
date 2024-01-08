public class Elements {

    public Elements(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String name;
    public int number;


    public Elements nextElement;


    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }


    public Elements getNextElement() {
        return nextElement;
    }

    public void setNextElement(Elements nextElement) {
        this.nextElement = nextElement;
    }

}
