package Assignment14;

class MovieNode {
    private String movieTitle;
    private String directorName;
    private int yearOfRelease;
    private float rating;

    MovieNode next;
    MovieNode prev;

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getDirectorName() {
        return directorName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "MovieNode{" +
                "movieTitle='" + movieTitle + '\'' +
                ", directorName='" + directorName + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                '}';
    }

    public MovieNode(String movieTitle, String directorName, int yearOfRelease, float rating) {
        this.movieTitle = movieTitle;
        this.directorName = directorName;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        next = null;
        prev = null;
    }
}

public class MovieManagementSystem {

    MovieNode head;
    MovieNode tail;

    void insertAtBeginning(String movieTitle, String directorName, int yearOfRelease, float rating) {
        MovieNode node = new MovieNode(movieTitle, directorName, yearOfRelease, rating);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    void insertAtEnd(String movieTitle, String directorName, int yearOfRelease, float rating) {
        if (head == null) {
            insertAtBeginning(movieTitle, directorName, yearOfRelease, rating);
            return;
        }
        MovieNode node = new MovieNode(movieTitle, directorName, yearOfRelease, rating);
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    void insertAtSpecificPosition(int position, String movieTitle, String directorName, int yearOfRelease, float rating) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            insertAtBeginning(movieTitle, directorName, yearOfRelease, rating);
            return;
        }

        int count = 1;
        MovieNode temp = head;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            insertAtEnd(movieTitle, directorName, yearOfRelease, rating);
            return;
        }

        MovieNode node = new MovieNode(movieTitle, directorName, yearOfRelease, rating);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
    }

    void removeMovieRecord(String title) {
        if (head == null) {
            System.out.println("Movie List is empty!!");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            if (temp.getMovieTitle().equals(title)) {
                System.out.println("Movie Record with the name " + title + " is deleted.");
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found!");
    }

    void searchMovieRecord(String director) {
        if (head == null) {
            System.out.println("Movie List is empty!!");
            return;
        }

        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.getDirectorName().equals(director)) {
                System.out.println("--Record Found--");
                System.out.println(temp.toString());
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("--Record Not Found--");
        }
    }

    void displayRecordForward() {
        if (head == null) {
            System.out.println("No Record to display!!");
            return;
        }

        MovieNode temp = head;
        System.out.println("Displaying Movies (Forward Order):");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    void displayRecordReverse() {
        if (tail == null) {  // Fix: Check tail instead of head
            System.out.println("No Record to display!!");
            return;
        }

        MovieNode temp = tail;
        System.out.println("Displaying Movies (Reverse Order):");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.prev;
        }
    }


    void updateMovieRating(String title, float rating) {
        if (head == null) {
            System.out.println("No Record to update!!");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            if (temp.getMovieTitle().equals(title)) {
                temp.setRating(rating);
                System.out.println("Movie name " + temp.getMovieTitle() + " rating is updated to " + rating);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie with the title " + title + " not found!!");
    }
}
