package ru.LiessaDar.telegrambot.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {
@Query(value = "SELECT Id FROM Category c WHERE c.id =?1 or c.parent = ?1",
        nativeQuery = true)
    List<Long> categoryListByParent(Long cid);
}

