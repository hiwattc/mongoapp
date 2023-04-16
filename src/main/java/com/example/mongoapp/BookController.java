package com.example.mongoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
 
    @Autowired
    BookService bookService;
    @RequestMapping("/getAllBooks")
    @ResponseBody
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }
 
    @RequestMapping("/getBook")
    @ResponseBody
    public List<Book> getBook(@RequestParam("category") String category){
        return bookService.getBookByCategory(category);
    }
 
    @RequestMapping("/getBookById")
    @ResponseBody
    public Book getBookById(@RequestParam("bookId") long bookId){
        return bookService.getBookByBookId(bookId);
    }
 
    @RequestMapping("/addBook")
    @ResponseBody
    public String addBook(@RequestParam("bookId") long bookId,@RequestParam("isbnNumber") String isbnNumber,
                          @RequestParam("bookName") String bookName,
                          @RequestParam("category") String category,
                          @RequestParam("writer") String writer
                          ){
        if(bookService.addBook(bookId,isbnNumber,bookName,category,writer) != null){
            return "Book got  Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }

    @RequestMapping("/updateBook")
    @ResponseBody
    public String updateBook(
                          @RequestParam("id") String id,
                          @RequestParam("bookId") long bookId,
                          @RequestParam("isbnNumber") String isbnNumber,
                          @RequestParam("bookName") String bookName,
                          @RequestParam("category") String category,
                          @RequestParam("writer") String writer
                          ){
        if(bookService.updateBook(id, bookId,isbnNumber,bookName,category,writer) != null){
            return "Book got  Updated Successfully";
        }else{
            return "Something went wrong !";
        }
    } 

    @RequestMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(@RequestParam("bookId") int bookId){
        if(bookService.deleteBook(bookId) == 1){
            return "Book got  Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}