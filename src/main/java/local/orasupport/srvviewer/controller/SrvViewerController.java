package local.orasupport.srvviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import local.orasupport.srvviewer.repository.SrvRepository;


@Controller
public class SrvViewerController {
    SrvRepository repository;

    public SrvViewerController(SrvRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Developer");
        model.addAttribute("servers", repository.findAll());
        return "pages/index";
    }
    
    
}
