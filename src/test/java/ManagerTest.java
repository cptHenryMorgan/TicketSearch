import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    @Test
    public void shouldFoundFewTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1,200,"MSC", "SPB");
        Ticket t2 = new Ticket(2,700,"UFA", "SPB");
        Ticket t3 = new Ticket(3,100,"MSC", "SPB");
        Ticket t4 = new Ticket(4,200,"MSC", "SPB");
        Ticket t5 = new Ticket(5,300,"MSC", "LON");
        Ticket t6 = new Ticket(6,600,"MSC", "SPB");
        Ticket t7 = new Ticket(7,500,"LON", "UFA");
        Ticket t8 = new Ticket(8,600,"MSC", "SPB");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t3, t1, t4, t6, t8};
        Ticket[] actual = manager.searchBy("MSC","SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1,200,"MSC", "SPB");
        Ticket t2 = new Ticket(2,700,"UFA", "SPB");
        Ticket t3 = new Ticket(3,100,"MSC", "SPB");
        Ticket t4 = new Ticket(4,200,"MSC", "SPB");
        Ticket t5 = new Ticket(5,300,"MSC", "LON");
        Ticket t6 = new Ticket(6,600,"MSC", "SPB");
        Ticket t7 = new Ticket(7,500,"LON", "UFA");
        Ticket t8 = new Ticket(8,600,"MSC", "SPB");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("FRA","GB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFoundOneTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1,200,"MSC", "SPB");
        Ticket t2 = new Ticket(2,700,"UFA", "SPB");
        Ticket t3 = new Ticket(3,100,"MSC", "SPB");
        Ticket t4 = new Ticket(4,200,"MSC", "SPB");
        Ticket t5 = new Ticket(5,300,"HON", "PEK");
        Ticket t6 = new Ticket(6,600,"MSC", "SPB");
        Ticket t7 = new Ticket(7,500,"LON", "UFA");
        Ticket t8 = new Ticket(8,600,"MSC", "SPB");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t5};
        Ticket[] actual = manager.searchBy("HON","PEK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFoundSamePriceTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1,200,"MSC", "SPB");
        Ticket t2 = new Ticket(2,700,"UFA", "SPB");
        Ticket t3 = new Ticket(3,100,"MSC", "SPB");
        Ticket t4 = new Ticket(4,200,"MSC", "SPB");
        Ticket t5 = new Ticket(5,300,"MSC", "LON");
        Ticket t6 = new Ticket(6,600,"BEL", "TOY");
        Ticket t7 = new Ticket(7,500,"LON", "UFA");
        Ticket t8 = new Ticket(8,600,"BEL", "TOY");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t6, t8};
        Ticket[] actual = manager.searchBy("BEL","TOY");

        Assertions.assertArrayEquals(expected, actual);
    }

}