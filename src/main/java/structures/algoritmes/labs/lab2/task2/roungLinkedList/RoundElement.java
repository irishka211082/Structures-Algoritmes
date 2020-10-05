package structures.algoritmes.labs.lab2.task2.roungLinkedList;

public class RoundElement {

    private RoundElement next;
    private Student student;
    private ExamTicket ticket;

    public RoundElement getNext() {
        return next;
    }

    public void setNext(RoundElement next) {
        this.next = next;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ExamTicket getTicket() {
        return ticket;
    }

    public void setTicket(ExamTicket ticket) {
        this.ticket = ticket;
    }
}
