package com.hikari.thymeleaf.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tb_masjid")
public class Masjid {

    @Id
    private Integer id;

    @Column(name = "nama_masjid")
    private String namaMasjid;

}
