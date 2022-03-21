package W13.W13.demo113.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import W13.W13.demo113.models.Contact;
import W13.W13.demo113.service.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ApplicationArguments appArgs;

    @Autowired
    private ContactService ctSvc;
    
    @GetMapping
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contactForm";
    }

    @PostMapping("/contact")
    public String showContact(@ModelAttribute Contact contact, Model model) {
        ctSvc.savingForm(contact, appArgs, model);
        return "showContact";
    }

    @GetMapping("/contact/{contactID}")
    public String gettingContact(@PathVariable String contactID, Model model) {
        ctSvc.loadContact(contactID, model, appArgs);
        System.out.println(">>>>> pathVariable: " + contactID);
        return "showContact";
    }
}
