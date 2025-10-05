package com.translation.api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslationService {

    /**
     * Traduz texto real usando Google Translate (HTTP GET)
     *
     * @param text Texto a traduzir
     * @param from Código do idioma de origem (pt, en, ru, ar)
     * @param to Código do idioma destino
     * @return Texto traduzido
     */
    public String translate(String text, String from, String to) {
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");
            String urlStr = String.format(
                "https://translate.googleapis.com/translate_a/single?client=gtx&sl=%s&tl=%s&dt=t&q=%s",
                from, to, encodedText
            );

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "osIDE-Translation-API");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) response.append(line);
            reader.close();

            // Parse JSON retornado
            ObjectMapper mapper = new ObjectMapper();
            JsonNode arr = mapper.readTree(response.toString());
            StringBuilder translated = new StringBuilder();
            for (JsonNode node : arr.get(0)) {
                translated.append(node.get(0).asText());
            }
            return translated.toString();

        } catch (Exception e) {
            return "Erro na tradução: " + e.getMessage();
        }
    }
}
