package Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category; // Logical, Technical, or Programming

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private int passingScore;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}