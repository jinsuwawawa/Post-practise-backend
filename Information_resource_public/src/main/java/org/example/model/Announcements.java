package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "announcements")
public class Announcements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private Integer announcement_id;

    @Column(nullable = false, length = 100) // 标题，最多 100 字符，不允许为空
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") // 公告内容，不允许为空
    private String content;

    @Column(name = "created_by") // 创建者用户 ID，外键
    private Integer created_by;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
}