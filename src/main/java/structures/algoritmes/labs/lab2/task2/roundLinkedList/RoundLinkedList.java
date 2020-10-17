package structures.algoritmes.labs.lab2.task2.roundLinkedList;

public class RoundLinkedList {
    private RoundElement first;
    private int size = 0;

    void add(RoundElement element) {
        if (size == 0) {
            first = element;
        } else {
            int counter = 0;
            RoundElement cursor = first;
            while (counter <= size - 2) {
                cursor = cursor.getNext();
                counter++;
            }
            cursor.setNext(element);
            element.setNext(first);
        }
        size++;
    }

    RoundElement get(int n) {
        if (n >= 0 && n < size) {
            RoundElement cursor = first;
            int counter = 0;
            while (counter <= n - 1) {
                cursor = cursor.getNext();
                counter++;
            }
            return cursor;
        } else throw new IllegalArgumentException();
    }

    void delete(int position) {
        if (position < size) {
            if (position == 0) {
                if (size == 1) {
                    first.setNext(null);
                } else {
                    first = get(1);
                    get(size - 1).setNext(first);
                }
            } else if (position == size - 1) {
                RoundElement previousElement = get(position - 1);
                previousElement.setNext(first);
            } else {
                RoundElement previousElement = get(position - 1);
                previousElement.setNext(get(position + 1));
            }
            size--;
        } else throw new IllegalArgumentException();
    }

    void delete(int startPosition, int step) {
        int positionForDeliting = startPosition + step;
        if ((positionForDeliting) >= size) {
            positionForDeliting = (startPosition + step) - size;
        }
        delete(positionForDeliting);
    }

    RoundElement get(int startPosition, int step) {
        int position = startPosition + step;
        if ((position) >= size) {
            position = (startPosition + step) - size;
        }
        return get(position);
    }

    public int getSize() {
        return size;
    }
}
