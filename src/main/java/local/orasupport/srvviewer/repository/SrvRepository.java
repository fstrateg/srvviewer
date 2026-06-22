package local.orasupport.srvviewer.repository;

import local.orasupport.srvviewer.model.SrvModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SrvRepository extends JpaRepository<SrvModel, Long> {

}
