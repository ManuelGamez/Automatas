/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.clinicaDao;
import modelo.entidad.Clinica;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class ClinicaControl {

    /**
     * Creates a new instance of ClinicaControl
     */
    private List<Clinica> listaClinicas;
    private Clinica clinica;

    public ClinicaControl() {
        clinica = new Clinica();
    }

    public List<Clinica> getListaClinicas() {
        clinicaDao ad = new clinicaDao();
        listaClinicas = ad.listarClinicas();
        return listaClinicas;
    }

    public void setListaClinicas(List<Clinica> listaClinicas) {
        this.listaClinicas = listaClinicas;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public void limpiarClinica() {
        clinica = new Clinica();
    }

    public void agregarClinica() {
        clinicaDao ad = new clinicaDao();
        ad.agregar(clinica);
    }

    public void modificarClinica() {
        clinicaDao ad = new clinicaDao();
        ad.modificar(clinica);
        limpiarClinica();
    }

    public void eliminarClinica() {
        clinicaDao ad = new clinicaDao();
        ad.eliminar(clinica);
        limpiarClinica();
    }
}

