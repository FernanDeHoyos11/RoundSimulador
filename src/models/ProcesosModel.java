package models;

import java.util.Optional;

public class ProcesosModel {
    private long pid;
    private Optional<String> nombreProceso;
    private Optional<String> usuario;
    private Optional<String[]> descripcion;
    private int prioridad;

    public ProcesosModel(long pid, Optional<String> nombreProceso, Optional<String> nombreUser, Optional<String[]> info, int prioridad) {
        this.pid = pid;
        this.nombreProceso = nombreProceso;
        this.usuario = nombreUser;
        this.descripcion = info;
        this.prioridad = prioridad;
    }

    /**
     * @return int return the pib
     */
    public long getPib() {
        return pid;
    }

    /**
     * @param pib the pib to set
     */
    public void setPib(long pib) {
        this.pid = pib;
    }

    /**
     * @return String return the nombreProceso
     */
    public Optional<String> getNombreProceso() {
        return nombreProceso;
    }

    /**
     * @param nombreProceso the nombreProceso to set
     */
    public void setNombreProceso(Optional<String> nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    /**
     * @return String return the usuario
     */
    public Optional<String> getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Optional<String> usuario) {
        this.usuario = usuario;
    }

    /**
     * @return String return the descripcion
     */
    public Optional<String[]> getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(Optional<String[]> descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return int return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}