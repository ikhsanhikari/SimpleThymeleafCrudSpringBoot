package com.hikari.thymeleaf.controller;

import com.hikari.thymeleaf.dao.IMasjidDao;
import com.hikari.thymeleaf.model.Masjid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Controller
public class BasicController {
    @Autowired
    IMasjidDao iMasjidDao;

    @GetMapping("/index")
    public  String test(Model modelMap){
        Collection<Masjid> masjids = iMasjidDao.findAll();
        modelMap.addAttribute("listMasjid",masjids);
        modelMap.addAttribute("masjid",new Masjid());
        return "index";
    }

    @PostMapping("/save")
    public  String saveData(Masjid masjid){
        iMasjidDao.save(masjid);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Masjid masjid = iMasjidDao.findById(id).orElse(null);
        iMasjidDao.delete(masjid);
        return "redirect:/index";
    }

    @GetMapping("/getById/{id}")
    public String getById(@PathVariable("id") Integer id,Model model){
        Masjid masjid = iMasjidDao.findById(id).orElse(null);
        model.addAttribute("masjid",masjid);
        return "edit";
    }

    @PostMapping("/update")
    public String update(Masjid masjid){
        iMasjidDao.save(masjid);
        return "redirect:/index";
    }
}
