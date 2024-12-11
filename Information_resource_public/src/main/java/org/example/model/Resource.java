package org.example.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String filePath;
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
