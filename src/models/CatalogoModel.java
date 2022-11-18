package models;

public class CatalogoModel {
    private int consecutivo;
    private String nombreCatalogo;
    public ProcesosModel ProcesosModel = new ProcesosModel();

    public CatalogoModel() {
    }
    
    public CatalogoModel(int consecutivo, String nombreCatalogo) {
        this.consecutivo = consecutivo;
        this.nombreCatalogo = nombreCatalogo;
    }
    
    
    public CatalogoModel(int consecutivo, String nombreCatalogo, ProcesosModel ProcesosModel) {
        this.consecutivo = consecutivo;
        this.nombreCatalogo = nombreCatalogo;
        this.ProcesosModel = ProcesosModel;
    }
    
    /**
     * @return int return the consecutivo
     */
    public int getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param consecutivo the consecutivo to set
     */
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return String return the nombreCatalogo
     */
    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    /**
     * @param nombreCatalogo the nombreCatalogo to set
     */
    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

}