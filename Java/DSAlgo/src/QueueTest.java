import sree.datastructures.AdvancedQueueWithLinkedList;
import sree.dto.Person;

public class QueueTest {

    public static void main(String[] args) throws Exception {

        Person p = new Person(5, "Andy");
        AdvancedQueueWithLinkedList<Person> queue = new AdvancedQueueWithLinkedList(p);
        Person p1 = new Person(10, "Chad");
        Person p2 = new Person(15, "Kate");
        queue.enQueue(p1);
        queue.enQueue(p2);
        System.out.println(queue.size());
        Person.printPerson(p);
        Person.printPerson(queue.deQueue());

    }

}
