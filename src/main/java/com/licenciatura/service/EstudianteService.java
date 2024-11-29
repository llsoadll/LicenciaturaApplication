package com.licenciatura.service;

import com.licenciatura.model.Estudiante;
import com.licenciatura.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }

    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        String nombreNormalizado = normalize(nombre);
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .filter(e -> normalize(e.getNombre()).contains(nombreNormalizado))
                .collect(Collectors.toList());
    }

    private String normalize(String text) {
        String nfdNormalizedString = java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD);
        return nfdNormalizedString.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }

    public List<Estudiante> buscarPorLegajo(String legajo) {
        return estudianteRepository.findByLegajo(legajo);
    }
}
