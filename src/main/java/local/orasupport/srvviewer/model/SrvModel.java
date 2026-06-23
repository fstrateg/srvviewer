package local.orasupport.srvviewer.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="web_servers")
public class SrvModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private SrvGroupModel group;
}
