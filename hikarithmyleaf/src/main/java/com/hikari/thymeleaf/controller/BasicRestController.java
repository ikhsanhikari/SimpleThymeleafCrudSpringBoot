package com.hikari.thymeleaf.controller;

import com.hikari.thymeleaf.dao.IMasjidDao;
import com.hikari.thymeleaf.model.Masjid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicRestController {

    @Autowired
    IMasjidDao iMasjidDao;

    @GetMapping("/rest/masjid")
    public ResponseEntity get(){
        return ResponseEntity.ok(iMasjidDao.findAll());
    }

    @PostMapping("rest/masjid/save")
    public Masjid save(@RequestBody Masjid masjid){
        Masjid masjid1 = iMasjidDao.save(masjid);
        return masjid1;
    }

    @GetMapping("rest/masjid/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        Masjid masjid = iMasjidDao.findById(id).orElse(null);
        if(masjid!=null){
            iMasjidDao.delete(masjid);
        }
    }

}
