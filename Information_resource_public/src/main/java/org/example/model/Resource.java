package org.example.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resource_id;
    private String resource_name;
    private String file_Path;

    @Column(updatable = false)
    @CreationTimestamp
    private Date uploaded_at;

    private Integer uploaded_by;
}
