package structures.algoritmes.labs.lab2.task2.roundLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Let's create roundList of Students." +
                "\nPlease, input number of students");
        int studentNumber = Integer.parseInt(reader.readLine());
        RoundLinkedList studentList = RoundListGenerator.generateStudents(studentNumber);

        System.out.println("Let's create roundList of Tickets." +
                "\nPlease, input number of tickets");
        int ticketNumber = Integer.parseInt(reader.readLine());
        RoundLinkedList ticketList = RoundListGenerator.generateTickets(ticketNumber);

        System.out.println("Now we will say every K of students take every N of tickets." +
                "\nInput K for students, but not more than " + studentNumber + "." +
                "\nInput N for tickets, but not more than " + ticketNumber + ".");

        int k = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        System.out.println("Let's see, what roundLists we got." +
                "\nFirst - studentList:");
        for (int i = 0; i < studentList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + studentList.get(i).getStudent().getSurname());
        }

        System.out.println("Second  - tickets:");
        for (int i = 0; i < ticketList.getSize(); i++) {
            System.out.println("The element № " + i + " is " + ticketList.get(i).getTicket().getTicketNumber());
        }

        System.out.println("\nNow will see which student get which ticket-number");
        int studentStartPosition = -1;
        int ticketStartPosition = -1;
        while (studentList.getSize() >= k || ticketList.getSize() >= n) {
            if (studentStartPosition > (studentList.getSize() - 1)) {
                studentStartPosition = studentStartPosition - studentList.getSize() - 1;
            }
            if (ticketStartPosition > (ticketList.getSize() - 1)) {
                ticketStartPosition = ticketStartPosition - ticketList.getSize() - 1;
            }

            Student student = studentList.get(studentStartPosition, k).getStudent();
            ExamTicket ticket = ticketList.get(ticketStartPosition, n).getTicket();

            System.out.println("Student " + student.getSurname() + " got ticket number " + ticket.getTicketNumber());

            studentList.delete(studentStartPosition, k);
            ticketList.delete(ticketStartPosition, n);

            if (studentList.getSize() < k || ticketList.getSize() < n) {
                break;
            }

            studentStartPosition = studentStartPosition + k - 1;
            ticketStartPosition = ticketStartPosition + n - 1;
        }

        System.out.println("We have " + studentList.getSize() + " free students and " + ticketList.getSize() +
                " free tickets.");
    }
}
