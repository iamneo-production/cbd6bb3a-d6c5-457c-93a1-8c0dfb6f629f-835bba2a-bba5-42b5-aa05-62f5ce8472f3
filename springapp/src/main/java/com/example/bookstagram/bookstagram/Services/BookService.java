package com.example.bookstagram.bookstagram.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstagram.bookstagram.Models.Book;
import com.example.bookstagram.bookstagram.Repositories.BookRepo;

@Service
public class BookService
{
    @Autowired
    private BookRepo bookRepo;

    public String createBook(Book book)
    {
        if(bookRepo.save(book) != null)
        {
            return "Saved Successfully";
        }
        else
        {
            return "Not saved";
        }
    }





    
}
