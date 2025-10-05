package com.translation.api.controller;

import com.translation.api.model.TranslationRequest;
import com.translation.api.service.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Controller da API de Tradução.
 * Suporta idiomas: Português (pt), Inglês (en), Russo (ru), Árabe (ar)
 */
@RestController
@RequestMapping("/api")
public class TranslationController {

    private final TranslationService service = new TranslationService();

    /**
     * Endpoint POST para traduzir texto.
     * Recebe JSON com texto, idioma origem e idioma destino.
     *
     * @param request TranslationRequest
     * @return Texto traduzido
     */
    @PostMapping("/translate")
    public String translate(@RequestBody TranslationRequest request) {
        return service.translate(request.getText(), request.getFrom(), request.getTo());
    }

    /**
     * Endpoint GET para retornar os idiomas suportados
     *
     * @return Lista de códigos de idiomas
     */
    @GetMapping("/languages")
    public List<String> getLanguages() {
        return Arrays.asList("pt", "en", "ru", "ar");
    }
}
