package Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mcq")
public class MCQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String category; // Logical, Technical, or Programming

    @Column(nullable = false)
    private String option1;

    @Column(nullable = false)
    private String option2;

    @Column
    private String option3;

    @Column
    private String option4;

    @Column(nullable = false)
    private String correctAnswer;
}