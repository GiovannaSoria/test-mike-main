package com.example.demo.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HolaMundoControlador {

    /**
     * Endpoint principal que coincide con la ruta del ALB
     * Responde a: /api/analisis
     * @return ResponseEntity con información del servicio
     */
    @GetMapping("/api/analisis")
    public ResponseEntity<Map<String, Object>> analisisEndpoint() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("servicio", "API Analisis");
        respuesta.put("mensaje", "Hola Mundo desde el servicio de vehiculos");
        
        respuesta.put("estado", "activo");
        respuesta.put("version", "1.0.0");
        respuesta.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(respuesta);
    }

    /**
     * Health check endpoint para el ALB
     * @return ResponseEntity con estado del servicio
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "analisis");
        return ResponseEntity.ok(status);
    }

    /**
     * Health check específico del servicio de análisis
     * Responde a: /api/analisis/health
     * @return ResponseEntity con estado detalladoasasas
     */
    @GetMapping("/api/analisis/health")
    public ResponseEntity<Map<String, Object>> analisisHealth() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "analisis");
        status.put("version", "1.0.0");
        status.put("timestamp", System.currentTimeMillis());
        status.put("database", "connected");
        
        return ResponseEntity.ok(status);
    }

    /**
     * Endpoint simple del servicio de análisis
     * Responde a: /api/analisis/hola
     * @return String con mensaje simple
     */
    @GetMapping("/api/analisis/hola")
    public String analisisHolaSimple() {
        return "Hola Mundo desde el servicio de análisis";
    }

    @GetMapping("/hola-simple1")
    public String obtenerHolaMundoSimple() {
        return "Hola Mundo";
    }

    /**
     * Endpoint que devuelve un saludo en formato JSON
     * @return ResponseEntity con un JSON que contiene el mensaje
     */
    @GetMapping("/hola-json")
    public ResponseEntity<Map<String, String>> obtenerHolaMundoJson() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Hola Mundo");
        respuesta.put("estado", "exitoso");
        respuesta.put("codigo", "200");
        
        return ResponseEntity.ok(respuesta);
    }

    /**
     * Endpoint adicional para verificar el estado de la API
     * @return ResponseEntity con información del estado
     */
    @GetMapping("/estado")
    public ResponseEntity<Map<String, Object>> obtenerEstado() {
        Map<String, Object> estado = new HashMap<>();
        estado.put("servicio", "API Hola Mundo");
        estado.put("version", "1.0.0");
        estado.put("estado", "activo");
        estado.put("puerto", 80);
        
        return ResponseEntity.ok(estado);
    }
} 