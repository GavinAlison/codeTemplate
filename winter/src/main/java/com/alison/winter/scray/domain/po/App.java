package com.alison.winter.scray.domain.po;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author huangyong
 * @version: 0.1
 **/


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "icon", columnDefinition = "blob", nullable = false)
    private byte[] icon;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    @Column(nullable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateTime;
}
