package exercise.p03_1_code;

public class Book {

    private String name;
    private int publishYear;
    private int price;

    public Book(String name, int publishYear, int price) {
        this.name = name;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
