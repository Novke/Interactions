package tri.novica.interactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tri.novica.interactions.entity.InteractionEntity;

@Repository
public interface InteractionRepository extends JpaRepository<InteractionEntity, Long> {
}
