package structures.algoritmes.labs.lab2.task1.singleLinkedList;

public class SingleLinkedList {

    Element first;
    private int size = 0;

    void add(Element element) {
        if (size == 0) {
            first = element;
        } else {
            int counter = 0;
            Element cursor = first;
            while (counter <= size - 2) {
                cursor = cursor.getNext();
                counter++;
            }
            cursor.setNext(element);
        }
        size++;
    }

    void addFirst(Element element) {
        if (size != 0) {
            element.setNext(first);
        }
        first = element;
        size++;
    }

    Element get(int n) {
        if (n >= 0 && n < size) {
            Element cursor = first;
            int counter = 0;
            while (counter <= n - 1) {
                cursor = cursor.getNext();
                counter++;
            }
            return cursor;
        } else throw new IllegalArgumentException();
    }

    //if need, add case, when can work with first and last element.Now works just with el-s in the middle
    void addAfter(int n, Element element) {
        if (n >= 0 && n < size - 1) {
            Element previous = get(n);
            Element next = get(n + 1);

            previous.setNext(element);
            element.setNext(next);
            size++;
        } else throw new IllegalArgumentException();
    }

    void delete(int position) {
        if (position < size) {
            if (position == 0) {
                if (size == 1) {
                    first = null;
                } else {
                    first = get(1);
                }
            } else if (position == size - 1) {
                Element previousElement = get(position - 1);
                previousElement.setNext(null);
            } else {
                Element previousElement = get(position - 1);
                previousElement.setNext(get(position + 1));
            }
            size--;
        } else throw new IllegalArgumentException();
    }

    void clear() {
        int counter = 0;
        int givenSize = size;
        while (counter < givenSize) {
            delete(0);
            counter++;
        }
    }

    SingleLinkedList makeCopy() {
        SingleLinkedList copyList = new SingleLinkedList();
        for (int i = 0; i < size; i++) {
            copyList.add(get(i));
        }
        return copyList;
    }

    void addList(SingleLinkedList list2) {
        for (int i = 0; i < list2.getSize(); i++) {
            add(list2.get(i));
        }
    }

    SingleLinkedList makeListWithCommon1(SingleLinkedList list1, SingleLinkedList list2) {
        SingleLinkedList bigger;
        SingleLinkedList less;
        if (list1.getSize() > list2.getSize()) {
            bigger = list1.makeCopy();
            less = list2.makeCopy();
        } else {
            less = list1.makeCopy();
            bigger = list2.makeCopy();
        }
        less.sortAscList();
        bigger.sortAscList();

        SingleLinkedList resultList = new SingleLinkedList();

        int iteration = Math.min(less.getSize(), bigger.getSize());
        int counter = 0;
        for (int i = 0; counter < iteration && i < less.getSize(); i++) {
            for (int j = 0; j < bigger.getSize(); j++) {
                if (less.get(i).getValue() == bigger.get(j).getValue()) {
                    Element addElement = less.get(i);
                    resultList.add(addElement);
                    less.delete(i);
                    bigger.delete(j);
                    i--;
                    break;
                }
            }
            counter++;
        }
        return resultList;
    }

    SingleLinkedList makeListWithCommon(SingleLinkedList list1, SingleLinkedList list2) {
        list1.sortAscList();
        list2.sortAscList();
        SingleLinkedList resultList = new SingleLinkedList();

        int iteration = Math.min(list1.getSize(), list2.getSize());
        for (int i = 0; i < iteration; i++) {
            for (int j = 0; j < iteration; j++) {
                if (list1.get(i).getValue() == list2.get(j).getValue()) {
                    Element addElement = list1.get(i);
                    resultList.add(addElement);
                    break;
                }
            }
        }
        return resultList;
    }

    void sortAscList() {
        SingleLinkedList tempList = new SingleLinkedList();
        int startedSize = size;
        while (tempList.getSize() < startedSize) {
            Element min = get(0);
            int minPosition = 0;
            for (int i = 1; i < size; i++) {
                if (get(i).getValue() < min.getValue()) {
                    min = get(i);
                    minPosition = i;
                }
            }
            tempList.add(min);
            delete(minPosition);
        }
        clear();
        addList(tempList);
    }

    void sortDescList() {
        SingleLinkedList tempList = new SingleLinkedList();
        int startedSize = size;
        while (tempList.getSize() < startedSize) {
            Element max = get(0);
            int maxPosition = 0;
            for (int i = 1; i < size; i++) {
                if (get(i).getValue() > max.getValue()) {
                    max = get(i);
                    maxPosition = i;
                }
            }
            tempList.add(max);
            delete(maxPosition);
        }
        clear();
        addList(tempList);
    }

    void moveRightOnNElements(int position, int n) {
        Element freeElement = get(position);
        delete(position);
        addAfter(position - 1 + n, freeElement);
    }

    void deleteEveryN(int n, int startPosition) {
        int i = startPosition + n;
        while (i < size) {
            delete(i);
            i = i + n - 1;
        }
    }

    public Element getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }
}
