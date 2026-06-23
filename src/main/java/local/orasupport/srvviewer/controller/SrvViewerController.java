package local.orasupport.srvviewer.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import local.orasupport.srvviewer.model.SrvGroupModel;
import local.orasupport.srvviewer.model.SrvModel;
import local.orasupport.srvviewer.repository.*;


@Controller
public class SrvViewerController {
    SrvRepository repository;
    SrvGroupRepository groupRepository;

    public SrvViewerController(SrvRepository repository, SrvGroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Developer");
        Sort sort = Sort.by(Sort.Direction.ASC, "group.name")
        .and(Sort.by(Sort.Direction.ASC, "name"));
        model.addAttribute("servers", repository.findAll( sort ));
        model.addAttribute("groups", groupRepository.findAll(Sort.by("id")));
        return "pages/index";
    }

    @PostMapping("/server/save")
    public String save(@RequestParam Long id,
                    @RequestParam String name,
                    @RequestParam String url,
                    @RequestParam Long groupId,         
                    @RequestParam(required = false) String notes) {
        SrvModel server = repository.findById(id).orElseThrow();
        SrvGroupModel group = groupRepository.findById(groupId).orElseThrow();
        server.setName(name);
        server.setUrl(url);
        server.setNotes(notes);
        server.setGroup(group);                             
        repository.save(server);
        return "redirect:/";
    }
    
    
}
