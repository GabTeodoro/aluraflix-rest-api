package studyproject.gbs.AluraFlix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT v FROM Video v JOIN v.category c WHERE c.id = :categoryId")
    Page<Video> findVideosPerCategory(@Param("categoryId") Long categoryId, Pageable pageable);
}
