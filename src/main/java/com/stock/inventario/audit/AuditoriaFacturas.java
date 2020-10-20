package com.stock.inventario.audit;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Table(name = "audtoria_factura")
@Entity
public class AuditoriaFacturas implements Serializable {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_audit_pers;

    @Getter
    @Setter
    @Size(min = 2, max = 20)
    @Column(name = "table_name")
    @NotNull
    private String tableName;

    @Setter
    @Getter
    @Column(name = "id_table")
    @NotNull
    private int idTable;

    @Setter
    @Getter
    @Size(min = 0, max = 500)
    @NotNull
    private String description;

    @Setter
    @Getter
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date deleteDate;

    @Setter
    @Getter
    @NotNull
    private String userDelete;

    public AuditoriaFacturas() {
    }
}
