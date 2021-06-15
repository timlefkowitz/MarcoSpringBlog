package com.codeup.spingblog.controllers;


import com.codeup.spingblog.daos.AdRepository;
import com.codeup.spingblog.models.Ad;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {
    private final AdRepository adsDao;
    private final UsersRepository usersDao;

    public AdController(AdRepository adDao){
        this.adsDao = adDao;
        this.usersDao = UsersRepository;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        List<Ad> adsList = adsDao.findAll();
        model.addAttribute("ads", adsDao.findAll());
        model.addAttribute("noAdsFound", adsList.size() == 0);
        model.addAttribute("topAd", adsDao.findByTitle("bicycle north side"));
        model.addAttribute("searchAd", adsDao.findByTitleLike("%childcare%"));
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("adId", id);
        model.addAttribute("ad", adsDao.getById(id));
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String showForm(){
        return "ads/create";
    };


    @PostMapping("/ads/create")
    public String save(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description){
        User user = usersDao.getById(1l);
        Ad newAd = new Ad(title, description, user, null);
        Ad savedAd = adsDao.save(newAd);
        return "redirect:/ads/" + savedAd.getId();
    }


    public String show(@PathVariable long id, Model model){
        model.addAttribute("adId", id);
        model.addAttribute("ad", adsDao.getById(id));
        return "ads/show";
    }


    @GetMapping("/ads/{id}/edit")
    public String showEditFrom(Model model, @PathVariable long id) {
        // find an ad
        Ad adToEdit = adsDao.getById(id);
        model.addAttribute("ad", adToEdit);
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    @ResponseBody
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "description") String desc){
        // find an ad
        Ad foundAd = adsDao.getById(id); // select * from ads where id = ?
        // edit the ad
        foundAd.setTitle(title);
        foundAd.setDescription(desc);
        // save the changes
        adsDao.save(foundAd); // update ads set title = ? where id = ?
        return "ad updated";
    }

    @PostMapping("/ads/{id}/delete")
    public String destroy(@PathVariable long id){
        adsDao.deleteById(id);
        return "redirect:/ads";
    }

    @GetMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "term") String term){
        List<Ad> ads = adsDao.searchByTitle(term);
        model.addAttribute("ads", ads);
        return "ads/index";
    }
}











}
