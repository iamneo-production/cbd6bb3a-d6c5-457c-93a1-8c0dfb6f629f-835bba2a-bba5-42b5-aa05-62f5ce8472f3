package com.example.bookstagram.bookstagram.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstagram.bookstagram.Models.Book;

public interface BookRepo extends JpaRepository<Book, Integer>
{
    
}
