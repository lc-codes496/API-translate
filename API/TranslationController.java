package com.translation.api.controller;

import com.translation.api.model.TranslationRequest;
import com.translation.api.service.TranslationService;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TranslationController {

    private final TranslationService service = new TranslationService();

    @PostMapping("/translate")
    public String translate(@RequestBody TranslationRequest request) {
        return service.translate(request.getText(), request.getFrom(), request.getTo());
    }

    @GetMapping("/languages")
    public List<String> getLanguages() {
        return Arrays.asList("pt", "en", "ru", "ar");
    }
}
