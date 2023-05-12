import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void getBooksByPrice(int k, int p, List<Book> listBook) {
        List<Book> result = new ArrayList<>();
        for (Book book : listBook) {
            if (book.getPrice() <= p) {
                result.add(book);
                if (result.size() == k) {
                    break;
                }
            }
        }
        System.out.println("Ket qua:");

        for (Book book : result) {
            book.output();
        }
    }

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String msg = """
                Chuong trinh quan ly sach
                    1. Them 1 cuon sach
                    2. Xoa 1 cuon sach
                    3. Thay doi sach
                    4. Xuat thonh tin
                    5. Tim sach lap trinh
                    6. Lay sach toi da theo gia
                    7. Tim Kiem theo tac gia 
                    0.Thoat
                    Chon chuc nang:
                """;
        int chon = 0;
        do {
            System.out.printf(msg);
            chon = x.nextInt();
            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                }
                case 2 -> {
                    System.out.print("Nhap vao ma sach can xoa:");
                    int bookid = x.nextInt();
                    Book find = listBook.stream().filter(p -> p.getId() == bookid).findFirst().orElse(null);
                    if (find == null) {
                        System.out.print("Khong co Ma Sach nay!!!\n");
                    } else {
                        listBook.remove(find);
                        System.out.print("Da xoa thanh cong!!!\n");
                    }
                }
                case 3 -> {
                    System.out.print("Nhap vao Ma Sach can dieu chinh:");
                    int bookid = x.nextInt();
                    x.nextLine();
                    Book find = listBook.stream().filter(p -> p.getId() == bookid).findFirst().orElse(null);

                    if (find == null) {
                        System.out.print("Khong co Ma Sach nay!!!\n");
                    } else {
                        System.out.print("Nhap vao gia tri moi cua thuoc tinh: \n");
                        System.out.print("1. Ma Sach\n");
                        System.out.print("2. Ten Sach\n");
                        System.out.print("3. Ten Tac Gia\n");
                        System.out.print("4. Don Gia\n");
                        int choice = x.nextInt();

                        switch (choice) {
                            case 1 -> {
                                System.out.print("Nhap vao Ma Sach moi: ");
                                int newId = x.nextInt();
                                find.setId(newId);
                                System.out.print("Da chinh sua Ma Sach thanh cong!!!\n");
                            }
                            case 2 -> {
                                System.out.print("Nhap vao Ten Sach moi: ");
                                x.nextLine();
                                String newTitle = x.nextLine();
                                find.setTitle(newTitle);
                                System.out.print("Da chinh sua Ten Sach thanh cong!!!\n");
                            }
                            case 3 -> {
                                System.out.print("Nhap vao Ten Tac Gia moi: ");
                                x.nextLine();
                                String newAuthor = x.nextLine();
                                find.setAuthor(newAuthor);
                                System.out.print("Da chinh sua Ten Tac Gia thanh cong!!!\n");
                            }
                            case 4 -> {
                                System.out.print("Nhap vao Don Gia moi: ");
                                long newPrice = x.nextLong();
                                find.setPrice(newPrice);
                                System.out.print("Da chinh sua Don Gia thanh cong!!!\n");
                            }
                            default -> System.out.println("Lua chon khong hop le!");
                        }
                    }
                }
                case 4 -> {
                    System.out.print("\n Xuat thong tin danh sach\n");
                    listBook.forEach(p -> p.output());
                }
                case 5 -> {
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains("lap trinh")).toList();
                    list5.forEach(Book::output);
                }
                case 6 -> {
                    System.out.print("Nhap vao so K: ");
                    int k = x.nextInt();
                    System.out.print("Nhap vao gia P: ");
                    int p = x.nextInt();
                    getBooksByPrice(k, p, listBook);
                    break;
                }
                case 7 -> {
                    System.out.print("Nhap vao danh sach cac tac gia (cach nhau boi dau phay): ");
                    x.nextLine();
                    String[] authors = x.nextLine().split(",");

                    // Lọc ra các cuốn sách của các tác giả đã nhập
                    List<Book> result = new ArrayList<>();
                    for (String author : authors) {
                        for (Book book : listBook) {
                            if (book.getAuthor().equals(author.trim())) {
                                result.add(book);
                            }
                        }
                    }

                    // Hiển thị kết quả
                    System.out.println("Cac cuon sach cua cac tac gia da nhap la: ");
                    for (Book book : result) {
                        book.output();
                    }
                }
            }
        } while (chon != 0);
    }
}