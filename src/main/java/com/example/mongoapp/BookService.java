package com.example.mongoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
 
    // Getting a specific book by category from collection
    public List<Book> getBookByCategory(String category){
        List<Book> book = bookRepository.findByCategory(category);
        return book;
    }
 
    // Getting a specific book by book id from collection
    public Book getBookByBookId(long bookId){
        Book book = bookRepository.findByBookId(bookId);
        System.out.println("book.userinfo:"+book.getUserinfo().getUserId());
        System.out.println("book.userinfo:"+book.getUserinfo().getUserNm());
        return book;
    }
     
      // Adding/inserting a book into collection
    public Book addBook(long id,String isbnNumber, String bookName,String category,String writer) {
        Book book = new Book();
        book.setCategory(category);
        book.setBookId(id);
        book.setBookName(bookName);
        book.setIsbnNumber(isbnNumber);
        book.setWriter(writer);
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId("hiwatt");
        userinfo.setUserNm("staroot");
        book.setUserinfo(userinfo);
        return bookRepository.save(book);
    }
 // Adding/inserting a book into collection
 public Book updateBook(String id,long bookId , String isbnNumber, String bookName,String category,String writer) {
    Book book = new Book();
    book.setId(id);
    book.setCategory(category);
    book.setBookId(bookId);
    book.setBookName(bookName);
    book.setIsbnNumber(isbnNumber);
    book.setWriter(writer);
    return bookRepository.save(book);
}   
    // Delete a book from collection
    public int deleteBook(long bookId){
        Book book = bookRepository.findByBookId(bookId);
        if(book != null){
            bookRepository.delete(book);
            return 1;
        }
        return -1;
    }
}