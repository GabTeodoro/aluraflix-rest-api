package studyproject.gbs.AluraFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
