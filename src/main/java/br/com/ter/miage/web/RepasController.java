package br.com.ter.miage.web;

import br.com.ter.miage.dto.AjoutRepasDto;
import br.com.ter.miage.entities.Repas;
import br.com.ter.miage.services.interfaces.RepasService;
import br.com.ter.miage.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class RepasController {

    @Autowired
    RepasService repasService;

    @GetMapping("repas")
    public String showRepas(Model model) {
        List<Repas> repasList = repasService.getAllRepas();

        model.addAttribute("repasList", repasList);
        return "repas";
    }

    @ModelAttribute("ajoutRepasDto")
    public AjoutRepasDto repasDtoAdd () {
        return new AjoutRepasDto();

    }


    @GetMapping("/ajoutRepas")
    public String showRepasForm(Model model) {
        return "ajoutRepas";
    }


    @PostMapping("/ajoutRepas")
    public RedirectView saveRepas(@ModelAttribute("ajoutRepasDto") AjoutRepasDto ajoutRepasDto,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        ajoutRepasDto.setPhoto(fileName);

        Repas repas = repasService.addRepas(ajoutRepasDto);

        String uploadDir = "src/main/webapp/repas-photos/" + repas.getIdRepas();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/repas", true);
    }



}
