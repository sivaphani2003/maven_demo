package com.example.grpc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // This method maps to the root URL ("/") and returns the HTML file
    @GetMapping("/")
    public String index(Model model) {
        // You can add attributes to the model if needed
        return "index"; // The name of your HTML file (index.html)
    }
}
