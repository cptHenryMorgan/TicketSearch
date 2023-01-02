public class Repository {
    private Ticket[] tickets = new Ticket[0];


    public void add(Ticket product) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tickets.length] = product;
        tickets = tmp;
    }

    public void removeById(int removeId) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int indexToInsert = 0;
        for (Ticket product : tickets) {
            if (product.getId() != removeId) {
                tmp[indexToInsert] = product;
                indexToInsert++;
            }
        }
        tickets = tmp;
    }

    private Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket   [] findAll() {
        return tickets;
    }
}
