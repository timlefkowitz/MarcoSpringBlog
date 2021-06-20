package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.daos.UsersRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class PostController {


    private final PostRepository postsDao;
    private final UsersRepository usersDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, UsersRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }

    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.findPostById(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String getPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = usersDao.getById(1L);
        post.setUser(user);
        post.setImages(null);
        postsDao.save(post);

        // send email to the user
        emailService.prepareAndSend(post, "New Post Created", post.getBody());
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping(path = "/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getById(id));
        return "posts/edit";
    }

    @PostMapping(path = "/posts/{id}/edit")
    public String edit(@PathVariable long id,
                       @RequestParam(name = "title") String title,
                       @RequestParam(name = "body") String body,
                       Model model) {
        User user = usersDao.getById(1L);
        Post post = postsDao.getById(id);
        post.setUser(user);
        post.setTitle(title);
        post.setBody(body);
        model.addAttribute("post", postsDao.saveAndFlush(post));
        return "redirect:/posts/" + id;
    }

    @PostMapping(path = "/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

}
