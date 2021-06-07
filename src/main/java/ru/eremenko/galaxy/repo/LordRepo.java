package ru.eremenko.galaxy.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.eremenko.galaxy.model.Lord;

@Repository
public interface LordRepo extends JpaRepository<Lord, Long> {

    @Query("select l from Lord l left join Planet p on l.id = p.lord where p.lord is null")
    List<Lord> findUnemployedLords();
}
