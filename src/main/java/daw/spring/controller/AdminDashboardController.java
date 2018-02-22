package daw.spring.controller;

import daw.spring.component.CurrentUserInfo;
import daw.spring.model.User;
import daw.spring.service.DeviceService;
import daw.spring.service.HomeService;
import daw.spring.service.ProductService;
import daw.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;


@Controller

@RequestMapping("/adminDashboard")
public class AdminDashboardController implements CurrentUserInfo {

    private final UserService userService;
    private final DeviceService deviceService;
    private final HomeService homeService;
    private final ProductService productService;

    @Autowired
    public AdminDashboardController(UserService userService, DeviceService deviceService, HomeService homeService, ProductService productService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.homeService = homeService;
        this.productService = productService;
    }

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("user", userService.findOneById(getIdFromPrincipalName(principal.getName())));
        return "adminDashboard/index";
    }

    @RequestMapping("/index")
    public void index2(Model model, Principal principal) {
        index(model, principal);
    }

    @RequestMapping("/inventario")
    public String inventario(Model model, Principal principal) {
        model.addAttribute("user", userService.findOneById(getIdFromPrincipalName(principal.getName())));        model.addAttribute("product", productService.findAllProducts());
        //model.addAttribute("devicesNotActivated", deviceService.countNotActivatedDevices());
        return "adminDashboard/inventario";
    }


    @RequestMapping("/usuarios")
    public String usuarios(Model model, @RequestParam(required = false) String name,Principal principal) {
        model.addAttribute("user", userService.findOneById(getIdFromPrincipalName(principal.getName())));
        model.addAttribute("userCount", userService.countAllUsers());
        model.addAttribute("homeActives", homeService.countHomeActives());
        if (name != null && !name.isEmpty()) {
            model.addAttribute("listUser", userService.findAllUsersByFirstName(name));
        } else {
            model.addAttribute("listUser", userService.findAll());
        }
        return "adminDashboard/usuarios";
    }

    @RequestMapping("/pedidos")
    public String pedidos(Model model,Principal principal) {
        model.addAttribute("user", userService.findOneById(getIdFromPrincipalName(principal.getName())));
        return "adminDashboard/pedidos";
    }

/*
    @RequestMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("user", userService.findOneById((long) 1));
        return "adminDashboard/detail";
    }
*/



   @RequestMapping("/detail")
    public String profile(Model model, Principal principal) {
       model.addAttribute("user", userService.findOneById((long) 1));
       model.addAttribute("userSesion", userService.findOneById(getIdFromPrincipalName(principal.getName())));
        return "adminDashboard/detail";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String saveProfile(Model model, @RequestParam("file") MultipartFile photo, Principal principal) {
        User user = userService.findOneById(getIdFromPrincipalName(principal.getName()));
        if (!photo.isEmpty()) {
            //Path directorioRecusrsos=Paths.get("file");

            Path directorioRecusrsos = Paths.get("src//main//resources//static//upload");
            String rootPath = directorioRecusrsos.toFile().getAbsolutePath();

            try {
                byte[] bytes = photo.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + photo.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                //flash.addAttribute("info", "Ha subido correctamente '"+ foto.getOriginalFilename()+"'");
                user.setPhoto(photo.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        userService.saveUser(user);
        //model.addAttribute("titulo", "Perfil");
        //status.setComplete();
        return "dashboard/created";
    }


}
