package studyproject.gbs.AluraFlix.infra.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;

@Repository
public interface CategoryJpa extends JpaRepository<Category, Long> {

    @Query("SELECT v FROM Video v JOIN v.category c WHERE c.id = :categoryId")
    Page<Video> findVideosPerCategory(@Param("categoryId") Long categoryId, Pageable pageable);
}
