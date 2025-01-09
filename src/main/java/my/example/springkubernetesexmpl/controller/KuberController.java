package my.example.springkubernetesexmpl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KuberController {

    @GetMapping("/check-kuber")
    public String hello() {
        return "Kuber works fine!!!";
    }
}
