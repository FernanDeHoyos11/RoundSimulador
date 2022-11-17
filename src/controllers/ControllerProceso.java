package controllers;

import connect.Consultas;
import java.util.Optional;
import javax.swing.table.DefaultTableModel;
import models.CatalogoModel;
import models.ProcesosModel;

public class ControllerProceso {

    Consultas c = new Consultas();

    public long PID;
    public Optional<String> Usuario;
    public Optional<String> Nombre_Proceso;
    public Optional<String[]> Informacion;

    public DefaultTableModel cargar() {
        String[] titulos = {"Pid", "Procesos", "Usuarios", "Información", "Prioridad"};
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
            miTabla[2] = Usuario.toString().replace("Optional.empty", "Sistema");
            miTabla[3] = Informacion;
            miTabla[4] = (Usuario.toString().replace("Optional.", "").replace("Optional", "").equals("empty") || Usuario.toString().replace("Optional.", "").replace("Optional", "").equals("root")) ? 1 : 0;
            modelo.addRow(miTabla);
        });

        return modelo;
    }

    public String formatearProceso(ProcessHandle proceso) {
        return c.Consecutivo();
    }

}
