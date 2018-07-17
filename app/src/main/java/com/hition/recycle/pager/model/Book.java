package com.hition.recycle.pager.model;

import java.io.Serializable;

public class Book implements Serializable {

    private String bid;

    private String book_cover;

    private String bookname;

    private String book_info;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBook_info() {
        return book_info;
    }

    public void setBook_info(String book_info) {
        this.book_info = book_info;
    }
}
