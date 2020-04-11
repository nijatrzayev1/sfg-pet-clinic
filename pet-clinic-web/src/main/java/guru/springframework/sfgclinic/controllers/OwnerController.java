package guru.springframework.sfgclinic.controllers;

import guru.springframework.sfgclinic.model.Owner;
import guru.springframework.sfgclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView modelAndView = new ModelAndView("owners/ownerdetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping("/new")
    public String initCreationForm(Map<String, Object> model){
        Owner owner = new Owner();
        model.put("owner", owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String peocessformCreation(@Valid Owner owner, BindingResult result){
      if(result.hasErrors()){
          return "owners/createOrUpdateOwnerForm";
      }else {
         Owner savedOwner =  ownerService.save(owner);
          return "redirect:/owners/" + savedOwner.getId();
      }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable("ownerId") Long ownerId, Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else {
           owner.setId(ownerId);
           Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/"+  savedOwner.getId();
        }
    }

}
