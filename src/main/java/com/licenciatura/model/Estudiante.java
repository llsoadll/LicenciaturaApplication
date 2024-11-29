package com.licenciatura.model;

import jakarta.persistence.*;


@Entity
public class Estudiante {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_seq")
    @SequenceGenerator(name = "estudiante_seq", sequenceName = "estudiante_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    private String nombre;
    private String dni;
    private String legajo;
    private String correo;
    private int anioIngreso;
    private String tituloTFL;
    private String tutor;
    private String cotutor;
    private String evaluadores;
    private String fechaEnvioEvaluar;
    private double notaEvaluador1;
    private double notaEvaluador2;
    private double notaTutor;
    private String observaciones;
    private Boolean graduado;

    // Casillas de verificación
    private boolean solicitudTutor;
    private boolean consentimientoTutor;
    private boolean solicitudCotutor;
    private boolean consentimientoCotutor;
    private boolean espaciosCurriculares;
    private boolean practicasProfesionales;
    private boolean autorizacionPublicacion;
    private boolean proyecto;
    private boolean informeTutor;
    private boolean tfl;

    // Getters y Setters (puedes generarlos automáticamente con IntelliJ)


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getCorreo() {
        return correo;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public String getTituloTFL() {
        return tituloTFL;
    }

    public String getTutor() {
        return tutor;
    }

    public String getCotutor() {
        return cotutor;
    }

    public String getEvaluadores() {
        return evaluadores;
    }

    public String getFechaEnvioEvaluar() {
        return fechaEnvioEvaluar;
    }

    public double getNotaEvaluador1() {
        return notaEvaluador1;
    }

    public double getNotaEvaluador2() {
        return notaEvaluador2;
    }

    public double getNotaTutor() {
        return notaTutor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Boolean getGraduado() {
        return graduado;
    }

    public boolean isSolicitudTutor() {
        return solicitudTutor;
    }

    public boolean isConsentimientoTutor() {
        return consentimientoTutor;
    }

    public boolean isSolicitudCotutor() {
        return solicitudCotutor;
    }

    public boolean isConsentimientoCotutor() {
        return consentimientoCotutor;
    }

    public boolean isEspaciosCurriculares() {
        return espaciosCurriculares;
    }

    public boolean isPracticasProfesionales() {
        return practicasProfesionales;
    }

    public boolean isAutorizacionPublicacion() {
        return autorizacionPublicacion;
    }

    public boolean isProyecto() {
        return proyecto;
    }

    public boolean isInformeTutor() {
        return informeTutor;
    }

    public boolean isTfl() {
        return tfl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public void setTituloTFL(String tituloTFL) {
        this.tituloTFL = tituloTFL;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setCotutor(String cotutor) {
        this.cotutor = cotutor;
    }

    public void setEvaluadores(String evaluadores) {
        this.evaluadores = evaluadores;
    }

    public void setFechaEnvioEvaluar(String fechaEnvioEvaluar) {
        this.fechaEnvioEvaluar = fechaEnvioEvaluar;
    }

    public void setNotaEvaluador1(double notaEvaluador1) {
        this.notaEvaluador1 = notaEvaluador1;
    }

    public void setNotaEvaluador2(double notaEvaluador2) {
        this.notaEvaluador2 = notaEvaluador2;
    }

    public void setNotaTutor(double notaTutor) {
        this.notaTutor = notaTutor;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }

    public void setSolicitudTutor(boolean solicitudTutor) {
        this.solicitudTutor = solicitudTutor;
    }

    public void setConsentimientoTutor(boolean consentimientoTutor) {
        this.consentimientoTutor = consentimientoTutor;
    }

    public void setSolicitudCotutor(boolean solicitudCotutor) {
        this.solicitudCotutor = solicitudCotutor;
    }

    public void setConsentimientoCotutor(boolean consentimientoCotutor) {
        this.consentimientoCotutor = consentimientoCotutor;
    }

    public void setEspaciosCurriculares(boolean espaciosCurriculares) {
        this.espaciosCurriculares = espaciosCurriculares;
    }

    public void setPracticasProfesionales(boolean practicasProfesionales) {
        this.practicasProfesionales = practicasProfesionales;
    }

    public void setAutorizacionPublicacion(boolean autorizacionPublicacion) {
        this.autorizacionPublicacion = autorizacionPublicacion;
    }

    public void setProyecto(boolean proyecto) {
        this.proyecto = proyecto;
    }

    public void setInformeTutor(boolean informeTutor) {
        this.informeTutor = informeTutor;
    }

    public void setTfl(boolean tfl) {
        this.tfl = tfl;
    }
}