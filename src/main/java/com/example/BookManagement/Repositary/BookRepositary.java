package com.example.BookManagement.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BookManagement.Model.*;
@Repository
public interface BookRepositary extends JpaRepository<Book, Long> {

}
