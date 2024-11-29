package com.licenciatura.controller;

import com.licenciatura.model.Estudiante;
import com.licenciatura.repository.EstudianteRepository;
import com.licenciatura.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteViewController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Mostrar la lista de estudiantes
    @GetMapping("/lista")
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.obtenerTodos();
        // Asegurarse de que el campo graduado esté inicializado
        estudiantes.forEach(estudiante -> {
            if (estudiante.getGraduado() == null) {
                estudiante.setGraduado(false);
            }
        });
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";  // Vista para mostrar la lista de estudiantes
    }

    @GetMapping("/eliminar_estudiante")
    public String eliminarEstudianteForm() {
        return "eliminar_estudiante";
    }

    // Mostrar el formulario de agregar estudiante
    @GetMapping("/nuevo")
    public String mostrarFormularioDeAgregarEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "nuevoEstudiante";  // La vista que mostrará el formulario
    }

    // Agregar un nuevo estudiante
    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiantes/lista";  // Redirige a la lista de estudiantes
    }

    // Buscar estudiantes por nombre
    @GetMapping("/buscar")
    public String buscarEstudiantes(@RequestParam("nombre") String nombre, Model model) {
        String nombreNormalizado = normalize(nombre);
        List<Estudiante> estudiantes = estudianteService.buscarPorNombre(nombreNormalizado);
        System.out.println("Estudiantes encontrados: " + estudiantes);
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";  // Muestra los resultados de la búsqueda
    }

    private String normalize(String text) {
        String nfdNormalizedString = java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD);
        return nfdNormalizedString.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }

    // Buscar estudiante por ID
    @GetMapping("/buscar/id")
    public String buscarEstudiantePorId(@RequestParam("id") Long id, Model model) {
        Estudiante estudiante = estudianteService.obtenerPorId(id);
        model.addAttribute("estudiante", estudiante);
        return "resultadoBusqueda";  // Vista para mostrar el resultado
    }

    @GetMapping("/buscar/formulario")
    public String mostrarFormularioDeBusqueda() {
        return "buscarEstudiante"; // Nombre del archivo HTML
    }

    @PostMapping("/eliminar")
    public String eliminarEstudiante(@RequestParam("id") Long id) {
        estudianteService.eliminar(id);  // Llama al servicio para eliminar
        return "redirect:/estudiantes/lista";  // Redirige a la lista de estudiantes después de la eliminación
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de estudiante inválido:" + id));
        model.addAttribute("estudiante", estudiante);
        return "editarEstudiante";
    }

    @PostMapping("/editar/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes/lista";
    }
}
