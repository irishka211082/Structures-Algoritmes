package structures.algoritmes.labs.lab2.task1.singleLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    SingleLinkedList singleLinkedList;

    @BeforeEach
    void before() {
        singleLinkedList = new SingleLinkedList();
    }

    @Test
    void addWithSizeNull() {
        Element element = new Element(4);
        singleLinkedList.add(element);

        assertEquals(1, singleLinkedList.getSize());
        assertEquals(element, singleLinkedList.getFirst());
    }

    @Test
    void addThree() {
        Element el0 = new Element(4);
        Element el1 = new Element(10);
        Element el2 = new Element(100);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        assertEquals(3, singleLinkedList.getSize());
        assertEquals(el0, singleLinkedList.getFirst());
        assertEquals(el1, singleLinkedList.get(1));
        assertEquals(el2, singleLinkedList.get(2));
    }

    @Test
    void addFirstWithSizeNull() {
        Element element = new Element(4);
        singleLinkedList.addFirst(element);

        assertEquals(1, singleLinkedList.getSize());
        assertEquals(element, singleLinkedList.getFirst());
    }

    @Test
    void addFirstWithTwoElements() {
        Element el1 = new Element(4);
        Element el2 = new Element(10);

        singleLinkedList.addFirst(el1);
        singleLinkedList.addFirst(el2);

        assertEquals(2, singleLinkedList.getSize());
        assertEquals(el2, singleLinkedList.getFirst());
        assertEquals(el1, singleLinkedList.get(1));
    }

    @Test
    void get() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);
        Element el3 = new Element(3);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);
        singleLinkedList.add(el3);


        assertEquals(el0, singleLinkedList.get(0));
        assertEquals(el1, singleLinkedList.get(1));
        assertEquals(el2, singleLinkedList.get(2));
        assertEquals(el3, singleLinkedList.get(3));
    }

    @Test
    void getWhenNDoesntExist() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        assertEquals(3, singleLinkedList.getSize());
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.get(3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.get(-5);
        });
    }

    @Test
    void addAfter2nd() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);
        Element el3 = new Element(3);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);
        singleLinkedList.add(el3);

        assertEquals(4, singleLinkedList.getSize());
        assertEquals(el3, singleLinkedList.get(3));

        Element addElement = new Element(100);
        singleLinkedList.addAfter(2, addElement);
        assertEquals(addElement, singleLinkedList.get(3));
    }

    @Test
    void addAfter0() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);
        Element el3 = new Element(3);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);
        singleLinkedList.add(el3);

        singleLinkedList.addAfter(0, new Element(100));
        assertEquals(100, singleLinkedList.get(1).getValue());
    }

    @Test
    void addAfterNNotInTheMiddle() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        Element addElement = new Element(100);

        assertEquals(3, singleLinkedList.getSize());
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.addAfter(2, addElement);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.addAfter(4, addElement);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.addAfter(0, addElement);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.addAfter(-5, addElement);
        });
    }

    @Test
    void delete() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        assertEquals(3, singleLinkedList.getSize());

        singleLinkedList.delete(2);
        assertEquals(2, singleLinkedList.getSize());
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.get(2);
        });

        singleLinkedList.delete(0);
        assertEquals(1, singleLinkedList.get(0).getValue());
    }

    @Test
    void deleteLast() {
        singleLinkedList.add(new Element(0));
        singleLinkedList.add(new Element(1));
        singleLinkedList.add(new Element(2));
        singleLinkedList.add(new Element(3));

        singleLinkedList.delete(3);
        assertEquals(3, singleLinkedList.getSize());
    }

    @Test
    void deleteWhenNDoesntExist() {
        Element el0 = new Element(0);
        singleLinkedList.add(el0);

        assertEquals(1, singleLinkedList.getSize());
        assertThrows(IllegalArgumentException.class, () -> {
            singleLinkedList.delete(2);
        });
    }

    @Test
    void clear() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        assertEquals(3, singleLinkedList.getSize());
        singleLinkedList.clear();

        assertEquals(0, singleLinkedList.getSize());
    }

    @Test
    void makeCopy() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        assertEquals(3, singleLinkedList.getSize());
        SingleLinkedList copySingleLinkedList = singleLinkedList.makeCopy();

        assertEquals(3, copySingleLinkedList.getSize());
        assertEquals(el0, copySingleLinkedList.get(0));
        assertEquals(el2, copySingleLinkedList.get(2));
    }

    @Test
    void addList() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);

        assertEquals(3, singleLinkedList.getSize());

        Element addEl1 = new Element(100);
        Element addEl2 = new Element(200);

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(addEl1);
        singleLinkedList2.add(addEl2);

        singleLinkedList.addList(singleLinkedList2);
        assertEquals(5, singleLinkedList.getSize());
        assertEquals(addEl2, singleLinkedList.get(4));
    }

    @Test
    void moveFirstOn3Elements() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);
        Element el3 = new Element(3);
        Element el4 = new Element(4);
        Element el5 = new Element(5);
        Element el6 = new Element(6);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);
        singleLinkedList.add(el3);
        singleLinkedList.add(el4);
        singleLinkedList.add(el5);
        singleLinkedList.add(el6);

        assertEquals(7, singleLinkedList.getSize());
        assertEquals(el1, singleLinkedList.get(1));

        singleLinkedList.moveRightOnNElements(1, 3);
        assertEquals(el1, singleLinkedList.get(4));
    }

    @Test
    void sortAsc() {
        Element el0 = new Element(3);
        Element el1 = new Element(14);
        Element el2 = new Element(-4);
        Element el3 = new Element(25);
        Element el4 = new Element(-100);
        Element el5 = new Element(0);
        Element el6 = new Element(12);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);
        singleLinkedList.add(el3);
        singleLinkedList.add(el4);
        singleLinkedList.add(el5);
        singleLinkedList.add(el6);

        assertEquals(7, singleLinkedList.getSize());
        singleLinkedList.sortAscList();

        assertEquals(7, singleLinkedList.getSize());
        assertEquals(el4, singleLinkedList.get(0));
        assertEquals(el3, singleLinkedList.get(6));
    }

    @Test
    void sortDesc() {
        Element el0 = new Element(3);
        Element el1 = new Element(14);
        Element el2 = new Element(-4);
        Element el3 = new Element(25);
        Element el4 = new Element(-100);
        Element el5 = new Element(0);
        Element el6 = new Element(12);

        singleLinkedList.add(el0);
        singleLinkedList.add(el1);
        singleLinkedList.add(el2);
        singleLinkedList.add(el3);
        singleLinkedList.add(el4);
        singleLinkedList.add(el5);
        singleLinkedList.add(el6);

        assertEquals(7, singleLinkedList.getSize());
        singleLinkedList.sortDescList();

        assertEquals(7, singleLinkedList.getSize());
        assertEquals(el4, singleLinkedList.get(6));
        assertEquals(el3, singleLinkedList.get(0));
    }

    @Test
    void makeCommonList() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);
        Element el3 = new Element(3);
        Element el4 = new Element(4);
        Element el5 = new Element(5);
        Element el6 = new Element(6);

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(el0);
        singleLinkedList1.add(el1);
        singleLinkedList1.add(el2);
        singleLinkedList1.add(el3);
        singleLinkedList1.add(el4);
        singleLinkedList1.add(el5);
        singleLinkedList1.add(el6);

        Element element0 = new Element(2);
        Element element1 = new Element(12);
        Element element2 = new Element(4);
        Element element3 = new Element(0);
        Element element4 = new Element(6);

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(element0);
        singleLinkedList2.add(element1);
        singleLinkedList2.add(element2);
        singleLinkedList2.add(element3);
        singleLinkedList2.add(element4);

        SingleLinkedList resultList = singleLinkedList1.makeListWithCommon(singleLinkedList1, singleLinkedList2);
        assertEquals(4, resultList.getSize());
    }

    @Test
    void test() {
        SingleLinkedList list1 = SingleLinkedListGenerator.generate(10);
        SingleLinkedList list2 = SingleLinkedListGenerator.generate(5);

        list1.addList(list2);

        list1.makeListWithCommon(list1, list2);
    }

    @Test
    void deleteEveryN() {
        Element el0 = new Element(0);
        Element el1 = new Element(1);
        Element el2 = new Element(2);
        Element el3 = new Element(3);
        Element el4 = new Element(4);
        Element el5 = new Element(5);
        Element el6 = new Element(6);

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(el0);
        singleLinkedList1.add(el1);
        singleLinkedList1.add(el2);
        singleLinkedList1.add(el3);
        singleLinkedList1.add(el4);
        singleLinkedList1.add(el5);
        singleLinkedList1.add(el6);

        singleLinkedList1.deleteEveryN(2, 0);
        System.out.println(singleLinkedList1.getSize());
    }
}