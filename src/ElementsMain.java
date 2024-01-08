import java.util.Scanner;

public class ElementsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int position;

        LinkedList linkedList = new LinkedList();

        while (true) {
            System.out.println("\n\n#**************** QTD de Elementos da Fila -> " + linkedList.getQtd() + "*************");

            System.out.println("\n\n#**********************************************************************************");
            System.out.println("\n\n#--------------------------------MENU----------------------------------------------");
            System.out.println("############# Escolha a opção desejada ################################################");
            System.out.println("############# 1 - Inserir elemento no final da fila ###################################");
            System.out.println("############# 2 - Remover elemento no inicio da fila ##################################");
            System.out.println("############# 3 - Exibir Informações sobre a fila ######################################");
            System.out.println("############# 4 - Localizar/posição de um elemento na fila ############################");
            System.out.println("############# 5 - Inserir elemento na fila em determinada posicao #####################");
            System.out.println("############# 6 - Remover elemento da fila  em determinada posicao ####################");
            System.out.println("############# 7 - Sair do programa ####################################################");
            System.out.println("\n#----------------------------------------------------------------------------------");
            int option = scanner.nextInt();
            switch (option) {

                case 1:
                    if (linkedList.insertElement(linkedList.createElement())) {
                        System.out.println("Elemento inserido com sucesso");
                    } else {
                        System.out.println("*** Falha na inserção do elemento ***");
                    }
                    break;

                case 2:
                    if (linkedList.getInit() != null) {
                        linkedList.removeElement();
                        System.out.println("Elemento removido com sucesso");

                    } else {
                        System.out.println("Lista está vazia!!");
                    }
                    break;

                case 3:
                    System.out.println("***** Elementos na fila *****");
                    Elements elements = linkedList.getInit();
                    if (linkedList.isEmpty()) {
                        System.out.println("Lista vazia!!");
                    } else {
                        while (elements != null) {
                            System.out.println("Nome: " + elements.getName() + "||" + "Número: " + elements.getNumber());
                            elements = elements.getNextElement();
                        }
                    }
                    break;

                case 4:
                    int numberElement;

                    if (linkedList.isEmpty()) {
                        System.out.println("Lista está vazia!!");
                        continue;
                    }
                    System.out.println("Informe o número do elemento que deseja pesquisar ->");
                    try {
                        numberElement = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Informe um número válido");
                        continue;
                    }
                    Elements el = linkedList.getInit();

                    position = 0;
                    while (el != null) {
                        position++;
                        if (el.getNumber() == numberElement) {
                            System.out.println("Localizado elemento na posicao " + position);
                            System.out.println("Nome: " + el.getName() + "||" + "Número: " + el.getNumber());
                        }
                        el = el.getNextElement();
                    }
                    break;

                case 5:
                    System.out.println("Quantidade de posissões possivéis é = " + linkedList.qtd + 1);
                    System.out.println();
                    System.out.println("Informe a posição que deseja inserir o elemento -> ");
                    try {
                        position = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Informe um número válido");
                        continue;
                    }
                    if (position > linkedList.qtd + 1) {
                        System.out.println("Posição inválida");
                        continue;
                    }
                    if (linkedList.insertElementPosition(linkedList.createElement(), position)) {
                        System.out.println("Elemento incluído com sucesso!!");
                    } else {
                        System.out.println("*** Falha na inserção do elemento ***");
                    }
                    break;

                case 6:
                    System.out.println("Quantidade de posissões possivéis é = " + linkedList.qtd + 1);
                    System.out.println();
                    System.out.println("Informe a posição do elemento a ser removido -> ");
                    try {
                        position = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Informe um número válido");
                        continue;
                    }
                    if (position > linkedList.qtd + 1) {
                        System.out.println("Posição inválida");
                        continue;
                    } else {
                        linkedList.removeElementPosition(position);
                        System.out.println("Elemento removido com sucesso!!");
                    }
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}

