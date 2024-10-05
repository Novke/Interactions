package tri.novica.interactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tri.novica.interactions.entity.TagEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

    public List<TagEntity> findAllByName(String name);
    Optional<TagEntity> findByName(String name);
}
