public class BookDemo {
    public static void main(String[] args) {
        Book book = new Book("Developing Java Software", "Russel Winder", 79.75);
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
    }
}