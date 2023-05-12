import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private long price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public  Book(){

    }
    public Book(int id, String title, String author, long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void input(){
        Scanner x = new Scanner(System.in);
        System.out.print("Nhap Ma Sach:");
        this.id=Integer.parseInt(x.nextLine());
        System.out.print("Nhap Ten Sach:");
        this.title=x.nextLine();
        System.out.print("Nhap Ten Tac Gia:");
        this.author=x.nextLine();
        System.out.print("Nhap Don Gia:");
        this.price=x.nextLong();
    }
    public void output(){
        String msg = """
                BOOK: id= %d,
                      Title= %s,
                      Authour= %s,
                      Price = %d
                """.formatted(id,title,author,price);
        System.out.print(msg);
    }

}