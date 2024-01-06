import java.util.Scanner;

public class OperationsElements extends Elements {
    public OperationsElements(String name, int numero) {
        super(name, numero);
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

    public void showElements(Elements elements) {
        if (isEmpty()) {
            System.out.println("Lista vazia!!");
        }
        while (elements.getInit() != null) {
            System.out.println("Nome: " + elements.getName() + "||" + "Número: " + elements.getNumber());
            elements = elements.getNextElement();
        }
    }

    public Elements getPositionElement(int index) {
        int position = 0;

        System.out.println("Informe o número do elemento que deseja pesquisar ->");

        int number = new Scanner(System.in).nextInt();
        Elements element = new Elements(null, number);

        while (element.getInit() != null) {
            position++;
            if (element.getNumber() == number) {
                System.out.println("Elemento encontrado na posição " + position);
                System.out.println("\n Nome -----> " + element.getName());
                System.out.println("\n Numero -----> " + element.getNumber());
            }
        }

        if (index <= 0 || isEmpty() || index > qtd) {
            return null;
        }

        Elements aux = init;
        int i = 1;
        while (i < index) {
            aux = aux.getNextElement();
            i++;
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
        name = scanner.next();
        System.out.println("Informe o numero do elemento: ");
        number = scanner.nextInt();
        return new Elements(name, number);

    }
}
