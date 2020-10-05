package structures.algoritmes.labs.lab2.task1.singleLinkedList;

public class SingleLinkedListGenerator {
    static SingleLinkedList generate(int number) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < number; i++) {
            singleLinkedList.add(new Element(i));
        }
        return singleLinkedList;
    }
}
