import java.util.Scanner;

public class ElementsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int position;

        String name = "";
        int number = 0;
        OperationsElements elements = new OperationsElements(name,number);

        while (true) {
            System.out.println("\n\n#**************** QTD de Elementos da Fila -> " + elements.getQtd() + "*************");

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
                    if (elements.insertElement(elements.createElement())) {
                        System.out.println("Elemento inserido com sucesso");
                    } else {
                        System.out.println("*** Falha na inserção do elemento ***");
                    }
                    break;

                case 2:
                    if (elements.getInit() != null) {
                        elements.removeElement();
                        System.out.println("Elemento removido com sucesso");
                        System.out.println("\n Nome -----> " + elements.getName());
                        System.out.println("\n Numero -----> " + elements.getNumber());

                    } else {
                        System.out.println("Lista está vazia!!");
                    }
                    break;

                case 3:
                    System.out.println("***** Elementos na fila *****");
                    elements.showElements();
                    break;

                case 4:
                    try {
                        int numberElement = scanner.nextInt();
                        elements.getPositionElement(numberElement);
                    } catch (Exception e) {
                        System.out.println("Informe um número válido");
                        continue;
                    }
                    break;

                case 5:
                    System.out.println("Quantidade de posissões possivéis é = " + elements.qtd + 1);
                    System.out.println();
                    System.out.println("Informe a posição que deseja inserir o elemento -> ");
                    try {
                        position = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Informe um número válido");
                        continue;
                    }
                    if (position > elements.qtd + 1) {
                        System.out.println("Posição inválida");
                        continue;
                    }
                    if (elements.insertElementPosition(elements.createElement(), position)) {
                        System.out.println("Elemento incluído com sucesso!!");
                    } else {
                        System.out.println("*** Falha na inserção do elemento ***");
                    }
                    break;

                case 6:
                    System.out.println("Quantidade de posissões possivéis é = " + elements.qtd + 1);
                    System.out.println();
                    System.out.println("Informe a posição do elemento a ser removido -> ");
                    try {
                        position = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Informe um número válido");
                        continue;
                    }
                    if (position > elements.qtd + 1) {
                        System.out.println("Posição inválida");
                        continue;
                    } else {
                        elements.removeElementPosition(position);
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

