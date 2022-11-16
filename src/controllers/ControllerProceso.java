package controllers;

import connect.Consultas;
import java.util.Optional;
import models.CatalogoModel;
import models.ProcesosModel;

public class ControllerProceso {
    
    Consultas c = new Consultas();

    public void mostrarDetallesProcesos() {
        ProcessHandle.allProcesses()
                .forEach(p -> System.out.println(formatearProceso(p)));
    }

    public String formatearProceso(ProcessHandle proceso) {

        long idProceso = proceso.pid();
        Optional<String> nombreUser = proceso.info().user();
        Optional<String> nombreProceso = proceso.info().command();
        Optional<String[]> info = proceso.info().arguments();

        //CatalogoModel CatalogoModel = new CatalogoModel(122345, "Catalogo",
                //new ProcesosModel(idProceso, nombreProceso, nombreUser, info, 1));
        
        return c.Consecutivo();
        /**return String.format("idCatalogo %d - Catalogo: %s - PID: %d - Usuario: %s - NomProceso: %s  - Info: %s",
                CatalogoModel.getConsecutivo(), CatalogoModel.getNombreCatalogo(),
                CatalogoModel.ProcesoModel.getPib(), CatalogoModel.ProcesoModel.getUsuario(),
                CatalogoModel.ProcesoModel.getNombreProceso(), CatalogoModel.ProcesoModel.getDescripcion());**/
    }
    
}