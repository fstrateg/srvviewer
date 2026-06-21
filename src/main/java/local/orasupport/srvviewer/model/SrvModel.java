package local.orasupport.srvviewer.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="v_all_trg")
public class SrvModel {
    public String ip;
    public String port;
    @Id
    public String sid;
    public String sch;
    public String des;
}
