package com.ycplay.download.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @CreateTime:2018/3/26 11:26
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment: 下载统计实体类
 */

@Entity
@Table(name = "tb_download", catalog = "db_ycplay")
public class Download {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "uid")
    private String uid;

    @Column(name = "time")
    private Timestamp time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
