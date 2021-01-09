package by.igorbuldin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @NotBlank
    @NotEmpty
    private String name;
}