package lk.ac.vau.fas.ict.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.ict.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    
    // Get student who borrowed books when given book id
    @Query("SELECT s from Student s JOIN s.borrows b WHERE b.book.id=?1")
    public List<Student> getBorrowedStudent(String bookId);
}
