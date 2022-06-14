package studyproject.gbs.AluraFlix.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import studyproject.gbs.AluraFlix.dto.request.CategoryDTO;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String color;

    public void toCategory(CategoryDTO categoryDTO) {
        this.id = categoryDTO.getId();
        this.title = categoryDTO.getTitle();
        this.color = categoryDTO.getColor();
    }
}
