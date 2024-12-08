package Models;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "programming_question")
public class ProgramingQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String difficulty; // Easy, Medium, Hard

    @Column(nullable = false)
    private String referenceAnswer;
}