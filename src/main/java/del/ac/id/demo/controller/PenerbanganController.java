package del.ac.id.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import del.ac.id.demo.jpa.Penerbangan;
import del.ac.id.demo.service.PenerbanganService;

@Controller
public class PenerbanganController {

    @Autowired
    private PenerbanganService penerbanganService;

    // display list of penerbangan
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listpenerbangan", penerbanganService.getAllPenerbangans());
        return "index";
    }

    @GetMapping("/showNewPenerbanganForm")
    public String showNewPenerbanganForm(Model model) {
        // create model attribute to bind form data
        Penerbangan penerbangan = new Penerbangan();
        model.addAttribute("penerbangan", penerbangan);
        return "new_penerbangan";
    }

    @PostMapping("/savePenerbangan")
    public String savePenerbangan(@ModelAttribute("penerbangan") Penerbangan penerbangan) {
        // save penerbangan to database
        penerbanganService.savePenerbangan(penerbangan);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get penerbangan from the service
        Penerbangan penerbangan = penerbanganService.getPenerbanganById(id);

        // set penerbangan as a model attribute to pre-populate the form
        model.addAttribute("penerbangan", penerbangan);
        return "update_penerbangan";
    }

    @GetMapping("/deletePenerbangan/{id}")
    public String deletePenerbangan(@PathVariable(value = "id") long id) {

        // call delete penerbangan method 
        this.penerbanganService.deletePenerbanganById(id);
        return "redirect:/";
    }
}