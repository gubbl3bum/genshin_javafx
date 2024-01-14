package com.genshin_javafx.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_info_logs")

public class UserInfoLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLog;


    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Integer idUser;

    @Column(name = "time_log")
    private LocalDateTime timelog;

    @Column(name = "result")
    private String result;

    //Gettery
    public Integer getIdLog() {
        return idLog;
    }
    public Integer getIdUser() {
        return idUser;
    }
    public LocalDateTime getTimelog() {
        return timelog;
    }
    public String getResult() {
        return result;
    }

    //Settery
    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public void setTimelog(LocalDateTime timelog) {
        this.timelog = timelog;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
