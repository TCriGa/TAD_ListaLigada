import java.util.Scanner;

public class LinkedList {
    public Elements init;
    public Elements last;
    public int qtd;

    public Elements getInit() {
        return init;
    }

    public int getQtd() {
        return qtd;
    }


    public boolean isEmpty() {
        return init == null;
    }

    public boolean insertElement(Elements element) {

        try {
            if (isEmpty()) {
                init = element;
            } else {
                Elements aux = init;
                while (aux.getNextElement() != null) {
                    aux = aux.getNextElement();
                }
                aux.setNextElement(element);
            }
            last = element;
            qtd++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Elements removeElement() {
        Elements aux = init;
        if (init != null) {
            init = aux.getNextElement();
            aux.setNextElement(null);
            qtd--;
        } else {
            return null;
        }
        if (init == null) {
            last = null;
        }
        return aux;
    }


    public Elements getPositionElement(int positionAnt) {
        int positionNow = 1;

        if (positionAnt <= 0 || isEmpty() || positionNow > qtd) {
            return null;
        }

        Elements aux = init;
        while (positionNow < positionAnt) {
            aux = aux.getNextElement();
            positionNow++;
        }
        return aux;
    }

    public boolean insertElementPosition(Elements element, int position) {
        if (element == null || position <= 0 || position > qtd + 1) {
            return false;
        }
        if (position == 1) {
            element.setNextElement(init);
            init = element;
            return false;
        }
        if (position == qtd + 1 || isEmpty()) {
            insertElement(element);
            return false;
        } else {
            Elements previousElement = getPositionElement(position - 1);
            element.setNextElement(previousElement.getNextElement());
            previousElement.setNextElement(element);
        }
        qtd++;
        return true;
    }

    public Elements removeElementPosition(int position) {
        if (position <= 0 || position > qtd) {
            return null;
        }
        if (position == 1) {
            return removeElement();
        }
        Elements previousElement = getPositionElement(position - 1);
        Elements element = previousElement.getNextElement();
        previousElement.setNextElement(element.getNextElement());
        element.setNextElement(null);
        qtd--;
        return element;
    }

    public Elements createElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do elemento: ");
        String name = scanner.next();
        System.out.println("Informe o numero do elemento: ");
        int number = scanner.nextInt();
        return new Elements(name, number);

    }
}
