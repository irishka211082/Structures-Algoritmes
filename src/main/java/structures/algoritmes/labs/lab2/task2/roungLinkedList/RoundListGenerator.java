package structures.algoritmes.labs.lab2.task2.roungLinkedList;

public class RoundListGenerator {

    static RoundLinkedList generateStudents(int number) {
        RoundLinkedList studentList = new RoundLinkedList();
        for (int i = 0; i < number; i++) {
            Student student = new Student("Student " + i);
            RoundElement element = new RoundElement();
            element.setStudent(student);
            studentList.add(element);
        }
        return studentList;
    }

    static RoundLinkedList generateTickets(int number) {
        RoundLinkedList ticketList = new RoundLinkedList();
        for (int i = 0; i < number; i++) {
            ExamTicket ticket = new ExamTicket(i);
            RoundElement element = new RoundElement();
            element.setTicket(ticket);
            ticketList.add(element);
        }
        return ticketList;
    }
}
