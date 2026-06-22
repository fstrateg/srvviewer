package local.orasupport.srvviewer.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="web_servers_group")
public class SrvGroupModel {
    @Id
    private Long id;
    private String name;
}
