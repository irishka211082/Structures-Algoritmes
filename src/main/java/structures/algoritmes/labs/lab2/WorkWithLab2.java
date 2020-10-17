package structures.algoritmes.labs.lab2;

import structures.algoritmes.labs.lab2.task1.singleLinkedList.WorkWithSingleLinkedList;
import structures.algoritmes.labs.lab2.task2.roundLinkedList.WorkWithRoundList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkWithLab2 {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    WorkWithSingleLinkedList workWithSingleLinkedList = new WorkWithSingleLinkedList();
    WorkWithRoundList workWithRoundList = new WorkWithRoundList();
    Menu menu = new Menu();

    void run() throws IOException {
        menu.showMainMenu();
        System.out.println("Input the number:");
        boolean isRunning = true;
        while (isRunning) {
            int numOfAction = Integer.parseInt(reader.readLine());
            switch (numOfAction) {
                case 1:
                    workWithSingleLinkedList.run();
                    break;
                case 2:
                    workWithRoundList.run();
                    break;
                case 0:
                    isRunning = false;
                    break;
            }
        }
    }
}
