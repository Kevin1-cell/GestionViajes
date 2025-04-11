package com.miempresa.gestionReservas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BienvenidaController {

    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "!Bienvenido a mi API¡";
    }
}
