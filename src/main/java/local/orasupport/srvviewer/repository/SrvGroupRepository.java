package local.orasupport.srvviewer.repository;

import local.orasupport.srvviewer.model.SrvGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SrvGroupRepository extends JpaRepository<SrvGroupModel, Long> {
}