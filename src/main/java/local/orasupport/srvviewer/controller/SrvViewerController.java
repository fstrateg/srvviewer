package local.orasupport.srvviewer.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/server/add")
    public String add(@RequestParam String url,
                    @RequestParam String name,
                    @RequestParam Long groupId,
                    @RequestParam(required = false) String notes) {
        SrvModel server = new SrvModel();
        server.setUrl(url);
        server.setName(name);
        server.setNotes(notes);
        if (groupId != -1) {
            SrvGroupModel group = groupRepository.findById(groupId).orElseThrow();
            server.setGroup(group);
        }
        repository.save(server);
        return "redirect:/";
    }

    @PostMapping("/server/delete")
    public String delete(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
    
    @GetMapping("/server/listurl")
    @ResponseBody
    public List<String> listAvailableUrls() {
        return repository.findAvailableUrls();
    }
    
}
