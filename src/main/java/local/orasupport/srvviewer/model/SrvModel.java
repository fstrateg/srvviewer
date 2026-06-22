package local.orasupport.srvviewer.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="v_all_srv_torg")
public class SrvModel {
    private String ip;
    private String port;
    private String sid;
    private String sch;
    private String dsc;
    @Id
    private String cfg;
}
