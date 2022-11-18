package controllers;

import connect.Consultas;
import javax.swing.table.DefaultTableModel;
import models.CatalogoModel;

public class ControllerProceso {

    Consultas c = new Consultas();
    CatalogoModel CatalogoModel = new CatalogoModel();

    public DefaultTableModel cargar(String txtNombreCatalogo) {
        c.GuardarCatalogo(txtNombreCatalogo);
        String[] titulos = {"Pid", "Procesos", "Usuarios", "Descripción", "Prioridad"};
        Object[] miTabla = new Object[5];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        int Consecutivo = c.Consecutivo();

        //.filter(ProcessHandle::isAlive) sacar los procesos activos solamente
        ProcessHandle.allProcesses().forEach(p -> {

            CatalogoModel.setConsecutivo(Consecutivo);
            CatalogoModel.setNombreCatalogo(txtNombreCatalogo);
            CatalogoModel.ProcesosModel.setPid(p.pid());
            CatalogoModel.ProcesosModel.setNombreProceso(p.info().command());
            CatalogoModel.ProcesosModel.setUsuario(p.info().user());
            CatalogoModel.ProcesosModel.setDescripcion("IsAlive: " + p.isAlive() + ", Children Count: " + p.children().count());
            CatalogoModel.ProcesosModel.setPrioridad(p.info().user());

            miTabla[0] = CatalogoModel.ProcesosModel.getPid();
            miTabla[1] = CatalogoModel.ProcesosModel.getNombreProceso();
            miTabla[2] = CatalogoModel.ProcesosModel.getUsuario();
            miTabla[3] = CatalogoModel.ProcesosModel.getDescripcion();
            miTabla[4] = CatalogoModel.ProcesosModel.getPrioridad();
            modelo.addRow(miTabla);
            
            c.GuardarProcesos(CatalogoModel.ProcesosModel.getPid(), CatalogoModel.ProcesosModel.getNombreProceso(), CatalogoModel.ProcesosModel.getUsuario(), CatalogoModel.ProcesosModel.getDescripcion(), CatalogoModel.ProcesosModel.getPrioridad(), CatalogoModel.getConsecutivo());
        });

        return modelo;
    }

}
