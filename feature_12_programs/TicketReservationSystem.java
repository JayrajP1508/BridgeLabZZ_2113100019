package Assignment14;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head;

    public TicketReservationSystem() {
        head = null;
    }

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicketByID(int ticketID) {
        if (head == null) return;
        if (head.ticketID == ticketID) {
            if (head.next == head) {
                head = null;
                return;
            }
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            return;
        }
        Ticket temp = head;
        while (temp.next != head && temp.next.ticketID != ticketID) {
            temp = temp.next;
        }
        if (temp.next == head) return;
        temp.next = temp.next.next;
    }

    public Ticket searchByCustomerName(String customerName) {
        Ticket temp = head;
        if (temp == null) return null;
        do {
            if (temp.customerName.equals(customerName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public Ticket searchByMovieName(String movieName) {
        Ticket temp = head;
        if (temp == null) return null;
        do {
            if (temp.movieName.equals(movieName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public int countTotalTickets() {
        int count = 0;
        if (head == null) return count;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}



