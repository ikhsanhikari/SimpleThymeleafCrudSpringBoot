package com.hikari.thymeleaf.dao;

import com.hikari.thymeleaf.model.Masjid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMasjidDao  extends JpaRepository<Masjid,Integer> {
}
