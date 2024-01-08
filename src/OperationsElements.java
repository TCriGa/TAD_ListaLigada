import java.util.Scanner;

public class OperationsElements extends Elements {

    public OperationsElements(String name, int number) {
        super(name, number);
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

    public void showElements(Elements aux) {

        if (isEmpty()) {
            System.out.println("Lista vazia!!");
        }
        while (aux != null) {
            System.out.println("Nome: " + aux.getName() + "||" + "Número: " + aux.getNumber());
            aux = aux.getNextElement();
        }
    }

    public Elements getPosition(int position) {
        int positionNow = 1;
        if (number <= 0 || isEmpty() || number > qtd) {
            return null;
        }
        init = getInit();
        while(positionNow < position) {
            init = init.getNextElement();
            positionNow++;
        }
        System.out.println("Elemento: " + init.getName() + " || " + "Número: " + init.getNumber());
        return init;
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
            Elements previousElement = getPosition(position - 1);
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
        Elements previousElement = getPosition(position - 1);
        Elements element = previousElement.getNextElement();
        previousElement.setNextElement(element.getNextElement());
        element.setNextElement(null);
        qtd--;
        return element;
    }

    public Elements createElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do elemento: ");
        name = scanner.next();
        System.out.println("Informe o numero do elemento: ");
        number = scanner.nextInt();
        return new Elements(name, number);

    }
}
