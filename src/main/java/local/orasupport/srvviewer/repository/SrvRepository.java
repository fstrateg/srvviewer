package local.orasupport.srvviewer.repository;

import local.orasupport.srvviewer.model.SrvModel;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SrvRepository extends JpaRepository<SrvModel, Long> {

    // SrvRepository.java
    @Query(value = """
    WITH dt0 AS (
        SELECT CASE WHEN ip='TBSB' THEN sid
                    ELSE ip||':'||port||':'||sid
               END url
        FROM v_all_srv_torg@atlas.world a
        WHERE a.sch='TRANSIT'
    )
    SELECT dt0.url FROM dt0
    WHERE dt0.url NOT IN (SELECT t.url FROM WEB_SERVERS t)
    """, nativeQuery = true)
    List<String> findAvailableUrls();
}
