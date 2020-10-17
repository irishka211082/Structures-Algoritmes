package structures.algoritmes.labs.lab2;

public class Menu {
    public void showMainMenu() {
        System.out.println("To work with singleLinkedList - input 1." +
                "\nTo work with roundList - input 2." +
                "\nTo exit - input 0.");
    }

    public void showSingleMenu() {
        System.out.println("Let's search working of my SingleLinkedList." +
                "\nChoose the function to work with it:" +
                "\n0. Create the SingleLinkedList." +
                "\n1. Add the element to the beginning." +
                "\n2. Delete element number N." +
                "\n3. Move the element on N positions." +
                "\n4. Add new element after the N-position." +
                "\n5. Create the copy of singleLinkedList." +
                "\n6. Add two lists." +
                "\n7. Sorting ASC." +
                "\n8. Sorting DESC." +
                "\n9. Create the list with common elements." +
                "\n10. Delete every N element in the list." +
                "\n11. Clear the list." +
                "\n100. Exit." +
                "\n\nInput the number:");
    }
}
