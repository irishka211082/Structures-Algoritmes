package structures.algoritmes.labs.lab2.task1.singleLinkedList;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import structures.algoritmes.labs.lab2.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkWithSingleLinkedList {

    Menu menu = new Menu();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    SingleLinkedList singleLinkedList;
    SingleLinkedList copyList;
    SingleLinkedList list2;
    SingleLinkedList commonElementsList;

    public void run() throws IOException {
        createSingleLinkedList();

        boolean isRunning = true;
        while (isRunning) {
            menu.showSingleMenu();
            int numOfAction = Integer.parseInt(reader.readLine());
            switch (numOfAction) {
                case 1:
                    addToTheBeginning();
                    break;
                case 2:
                    deleteElementNumberN();
                    break;
                case 3:
                    moveTheElementOnNPositions();
                    break;
                case 4:
                    addNewElementAfterNPosition();
                    break;
                case 5:
                    createTheCopy();
                    break;
                case 6:
                    addTwoLists();
                    break;
                case 7:
                    sortASC();
                    break;
                case 8:
                    sortDESC();
                    break;
                case 9:
                    createCommonElementsList();
                    break;
                case 10:
                    deleteEveryNElement();
                    break;
                case 11:
                    clear();
                    break;
                case 0:
                    isRunning = false;
                    break;
            }
        }
    }

    void createSingleLinkedList() throws IOException {
        System.out.println("Let's create the singleLinkedList for demonstrate it's functions." +
                "\nPlease input natural number for size of future list:");
        int size = Integer.parseInt(reader.readLine());
        singleLinkedList = SingleLinkedListGenerator.generate(size);

        System.out.println("We have list of " + singleLinkedList.getSize() + " elements.");
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println("The element number " + i + " is " + singleLinkedList.get(i).getValue());
        }
    }

    void addToTheBeginning() throws IOException {
        System.out.println("\n1. Demonstrate adding the element to the beginning of the list:");
        System.out.println("Please, input the integer number for adding to the beginning");
        int numForAdding = Integer.parseInt(reader.readLine());

        singleLinkedList.addFirst(new Element(numForAdding));
        System.out.println("We have list of " + singleLinkedList.getSize() + " elements.");
        System.out.println("We added to the beginning the element with value " + singleLinkedList.get(0).getValue());
    }

    void deleteElementNumberN() throws IOException {
        System.out.println("\n2. Demonstrate deleting the element with number N. " +
                "\nPlease, input the position of element for deleting not more, than " + (singleLinkedList.getSize() - 1)
                + " position:");
        int position = Integer.parseInt(reader.readLine());
        System.out.println("Now the element number " + position + " is " + singleLinkedList.get(position).getValue());
        System.out.println("We'll delete " + position + " element.");

        singleLinkedList.delete(position);
        System.out.println("We have list of " + singleLinkedList.getSize() + " elements.");
        System.out.println("Check, what is the element number " + position + " we have now:");
        System.out.println("This element is " + singleLinkedList.get(position).getValue() + ". So it was deleted.");
    }

    void moveTheElementOnNPositions() throws IOException {
        System.out.println("\n3. Demonstrate moving some element on some positions. " +
                "\nPlease, input the position of initial element, not more than " + singleLinkedList.getSize() / 2);
        int elementPosition = Integer.parseInt(reader.readLine());
        System.out.println("Now please input number of element for moving, but not more than " +
                (singleLinkedList.getSize() - 1 - elementPosition));
        System.out.println("Notice, that we had element " + elementPosition + " with value " +
                singleLinkedList.get(elementPosition).getValue() + " before.");
        int moveOn = Integer.parseInt(reader.readLine());

        singleLinkedList.moveRightOnNElements(elementPosition, moveOn);
        System.out.println("We still have list of " + singleLinkedList.getSize() + " elements.");
        System.out.println("Notice, that we have the element number " + elementPosition + " is " +
                singleLinkedList.get(elementPosition).getValue());
        System.out.println("And where is our moved element? Try to find it on " + (elementPosition + moveOn) +
                " position:");
        System.out.println("The element number " + elementPosition + " is " +
                singleLinkedList.get(elementPosition + moveOn).getValue());
    }

    void addNewElementAfterNPosition() throws IOException {
        System.out.println("\n4. Demonstrate adding some element after some position of our list." +
                "\nPlease, input the integer number for this example for adding: ");

        int valueForAdding = Integer.parseInt(reader.readLine());
        System.out.println("Please, input the position, after which you want to add it, but not more " +
                (singleLinkedList.getSize() - 2));

        int previousPosition = Integer.parseInt(reader.readLine());
        System.out.println("Before adding the next value was " + singleLinkedList.get(previousPosition + 1).getValue() +
                ". Size of list was " + singleLinkedList.getSize());

        singleLinkedList.addAfter(previousPosition, new Element(valueForAdding));
        System.out.println("After adding the next value was " + singleLinkedList.get(previousPosition + 1).getValue() +
                ". Size of list was " + singleLinkedList.getSize());
    }

    void createTheCopy() {
        System.out.println("\n5. Demonstrate creating the copy of our singleLinkedList.");
        copyList = singleLinkedList.makeCopy();
        System.out.println("We created the copy. Let's compare our lists:");
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println("The element № " + i + "of initial list is " + singleLinkedList.get(i).getValue() +
                    " and the same element of copyList is also " + copyList.get(i).getValue());
        }
    }

    void addTwoLists() throws IOException {
        System.out.println("\n6. Demonstrate adding of two lists. For this task let's create the second list." +
                "\nPlease, input it's size for generating:");
        int size2 = Integer.parseInt(reader.readLine());
        list2 = SingleLinkedListGenerator.generate(size2);
        System.out.println("We successfully created the second list. Now we'll add it to first." +
                "\nNotice, that the size of first list was " + singleLinkedList.getSize());
        singleLinkedList.addList(list2);
        System.out.println("The list2 was added to list1. \nNow the size of list1 is " + singleLinkedList.getSize());
        System.out.println("Lets print the hole result-list");
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + singleLinkedList.get(i).getValue());
        }
    }

    void sortASC() {
        System.out.println("\n7. Demonstrate the sorting ASC of singleLinkedList:");
        System.out.println("Lets print our singleLinkedList:");
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + singleLinkedList.get(i).getValue());
        }
        singleLinkedList.sortAscList();
        System.out.println("Lets see it after sort-ASC:");
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + singleLinkedList.get(i).getValue());
        }
    }

    void sortDESC() {
        System.out.println("\n8. Demonstrate the sorting DESC of singleLinkedList:");
        singleLinkedList.sortDescList();
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + singleLinkedList.get(i).getValue());
        }
    }

    void createCommonElementsList() {
        System.out.println("\n9. Demonstrate the creating the list with common elements." +
                "\nWe'll compare our singleLinkedList and list2 from previous task." +
                "\nLet's create the result-list:");
        commonElementsList = singleLinkedList.makeListWithCommon(singleLinkedList, list2);
        System.out.println("We got the result list with the size " + commonElementsList.getSize());
        System.out.println("Lets print the hole result-list");
        for (int i = 0; i < commonElementsList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + commonElementsList.get(i).getValue());
        }
    }

    void deleteEveryNElement() throws IOException {
        System.out.println("\n10. Demonstrate deleting every N element of the list:" +
                "\nPlease, input N (some little number > 1):");
        int numberN = Integer.parseInt(reader.readLine());
        System.out.println("Also, input start position for deleting:");
        int startPosition = Integer.parseInt(reader.readLine());

        singleLinkedList.deleteEveryN(numberN, startPosition);

        System.out.println("We have the list with " + singleLinkedList.getSize() + " elements." +
                "\nHere they are:");
        for (int i = 0; i < singleLinkedList.getSize(); i++) {
            System.out.println(singleLinkedList.get(i).getValue());
        }
    }

    void clear() {
        System.out.println("\n11. Demonstrate if we can clear our list:" +
                "\nThe size of list before clearing was " + singleLinkedList.getSize());
        singleLinkedList.clear();
        System.out.println("The size now is " + singleLinkedList.getSize());
    }
}
