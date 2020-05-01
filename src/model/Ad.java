package model;

import java.util.Date;

public class Ad {
    private String title;
    private String text;
    private String price;
    private Date createdDate;
    private Category category;
    private User author;

    public Ad(String title, String text, String price, Date createdDate, Category category, User author) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.createdDate = createdDate;
        this.category = category;
        this.author = author;
    }

    public Ad() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad add = (Ad) o;

        if (title != null ? !title.equals(add.title) : add.title != null) return false;
        if (text != null ? !text.equals(add.text) : add.text != null) return false;
        if (price != null ? !price.equals(add.price) : add.price != null) return false;
        if (createdDate != null ? !createdDate.equals(add.createdDate) : add.createdDate != null) return false;
        if (category != add.category) return false;
        return author != null ? author.equals(add.author) : add.author == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ADD{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price='" + price + '\'' +
                ", createdDate=" + createdDate +
                ", category=" + category +
                ", author=" + author +
                '}';
    }


}
