package models;

import java.util.Optional;

public class ProcesosModel {
    private long pid;
    private String nombreProceso;
    private String usuario;
    private String descripcion;
    private int prioridad;

    public ProcesosModel() {
    }

    public ProcesosModel(long pid, String nombreProceso, String usuario, String descripcion, int prioridad) {
        this.pid = pid;
        this.nombreProceso = nombreProceso;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }
    

    /**
     * @return int return the pib
     */
    public long getPid() {
        return pid;
    }

    /**
     * @param pid the pib to set
     */
    public void setPid(long pid) {
        this.pid = pid;
    }

    /**
     * @return String return the nombreProceso
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     * @param nombreProceso the nombreProceso to set
     */
    public void setNombreProceso(Optional<String> nombreProceso) {
        this.nombreProceso = (nombreProceso.toString().equals("Optional.empty")) ? "System-Process-" + getPid() : nombreProceso.toString().replace("Optional.", "").replace("Optional", "");
    }

    /**
     * @return String return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Optional<String>  usuario) {
        this.usuario = (usuario.toString().equals("Optional.empty")) ? "System" : usuario.toString().replace("Optional.", "").replace("Optional", "");;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
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
    public void setPrioridad(Optional<String> prioridad) {
        this.prioridad = (prioridad.toString().replace("Optional.", "").replace("Optional", "").equals("empty") || prioridad.toString().replace("Optional.", "").replace("Optional", "").equals("root")) ? 1 : 0;
    }

}