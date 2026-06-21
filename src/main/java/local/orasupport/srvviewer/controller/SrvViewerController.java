package local.orasupport.srvviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SrvViewerController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Developer");
        return "index";
    }
    
    
}
