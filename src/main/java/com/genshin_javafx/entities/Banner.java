package com.genshin_javafx.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBanner")
    private Integer idBanner;

    @Column(name = "name")
    private String name;

    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;

    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "character5", referencedColumnName = "id")
    private Characters character5;

    @ManyToOne
    @JoinColumn(name = "character4_1", referencedColumnName = "id")
    private Characters character4_1;

    @ManyToOne
    @JoinColumn(name = "character4_2", referencedColumnName = "id")
    private Characters character4_2;

    @ManyToOne
    @JoinColumn(name = "character4_3", referencedColumnName = "id")
    private Characters character4_3;

    @Column(name = "version")
    private String version;

    // Gettery
    public Integer getIdBanner() {
        return idBanner;
    }
    public String getName() {
        return name;
    }
    public Date getDateStart() {
        return dateStart;
    }
    public Date getDateEnd() {
        return dateEnd;
    }
    public Characters getCharacter5() {
        return character5;
    }
    public Characters getCharacter4_1() {
        return character4_1;
    }
    public Characters getCharacter4_2() {
        return character4_2;
    }
    public Characters getCharacter4_3() {
        return character4_3;
    }
    public String getVersion() {
        return version;
    }
    // Settery
    public void setIdBanner(Integer idBanner) {
        this.idBanner = idBanner;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    public void setCharacter5(Characters characters5) {
        this.character5 = characters5;
    }
    public void setCharacter4_1(Characters characters4_1) {
        this.character4_1 = characters4_1;
    }
    public void setCharacter4_2(Characters characters4_2) {
        this.character4_2 = characters4_2;
    }
    public void setCharacter4_3(Characters characters4_3) {
        this.character4_3 = characters4_3;
    }
    public void setVersion(String version) {
        this.version = version;
    }
}

