/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Parcial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author aaron
 */
@Controller
public class LoginController {
    

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Muestra el formulario de login
    }

    @PostMapping("/authenticate")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return "success"; // Redirige a la pagina de éxito
        } else {
            model.addAttribute("error", "El usuario no existe o la contraseña es incorrecta.");
            return "redirect:/error"; // Redirige a la pagina de error
        }
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error"; // Muestra la página de error
    }
}
