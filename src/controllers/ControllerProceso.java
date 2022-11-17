package controllers;

import java.util.Optional;
import javax.swing.table.DefaultTableModel;
import models.CatalogoModel;
import models.ProcesosModel;

public class ControllerProceso {

    public long PID;
    public Optional<String> Usuario;
    public Optional<String> Nombre_Proceso;
    public Optional<String[]> Informacion;

    public DefaultTableModel cargar() {
        String[] titulos = {"Pid", "Procesos", "Usuarios", "Informacio","Prioridad"};
        Object[] miTabla = new Object[5];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        ProcessHandle.allProcesses().forEach(p -> {
            PID = p.pid();
            Usuario = p.info().user();
            Nombre_Proceso = p.info().command();
            String proces = Nombre_Proceso.toString();
            Informacion = p.info().arguments();

            miTabla[0] = PID;
            miTabla[1] = proces.replace("Optional.", "").replace("Optional", "");
            miTabla[2] = Usuario.toString().replace("Optional.", "").replace("Optional", "");
            miTabla[3] = Informacion;
            miTabla[4] = (Usuario.toString().replace("Optional.", "").replace("Optional", "").equals("empty") || Usuario.toString().replace("Optional.", "").replace("Optional", "").equals("root"))?1:0;
            CatalogoModel CatalogoModel = new CatalogoModel(122345, "Catalogo", new ProcesosModel(PID, Nombre_Proceso, Usuario, Informacion, 1));
            modelo.addRow(miTabla);

            String Datos = String.format("idCatalogo %d - Catalogo: %s - PID: %d - Usuario: %s - NomProceso: %s  - Info: %s",
                    CatalogoModel.getConsecutivo(), CatalogoModel.getNombreCatalogo(),
                    CatalogoModel.ProcesoModel.getPib(), CatalogoModel.ProcesoModel.getUsuario(),
                    CatalogoModel.ProcesoModel.getNombreProceso(), CatalogoModel.ProcesoModel.getDescripcion());
            System.out.println(Datos);
        });

        return modelo;
    }
}
