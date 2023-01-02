public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public Ticket(int id, int price, String from, String to) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public int compareTo(Ticket diffrentTicket) {
        if (this.price > diffrentTicket.getPrice()) {
            return 1;
        }
        if (this.price < diffrentTicket.getPrice()) {
            return -1;
        }
        return 0;
    }
}
