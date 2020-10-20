package com.stock.inventario.controllernative;

import com.stock.inventario.dto.PersonaCliente;
import com.stock.inventario.enums.EEstados;
import com.stock.inventario.enums.EGenero;
import com.stock.inventario.enums.ETipoDocumento;
import com.stock.inventario.model.Ciudad;
import com.stock.inventario.model.Cliente;
import com.stock.inventario.model.Persona;
import com.stock.inventario.model.TipoDocumento;
import com.stock.inventario.services.ParameterServices;
import com.stock.inventario.services.ServiceCiudad;
import com.stock.inventario.services.ServiceCliente;
import com.stock.inventario.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
@SessionAttributes("clientsAttributes")
public class ClientController {

    @Autowired
    ServiceCliente serviceCliente;

    @Autowired
    ServicePersona servicePersona;

    @Autowired
    ParameterServices<TipoDocumento> parameterServices;

    @Autowired
    ServiceCiudad serviceCiudad;

    @ModelAttribute("tipDocument")
    public List<TipoDocumento> listTipDocument(){
       List<TipoDocumento> tipoDocumentos= new ArrayList<TipoDocumento>();
        try {
            tipoDocumentos = parameterServices.findAll(1);
            /*TipoDocumento tp = new TipoDocumento();
            tp.setIdTipo(ETipoDocumento.CEDULA.getId());
            tp.setNombre(ETipoDocumento.CEDULA.getDescripcion());
            tipoDocumentos.add(tp);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tipoDocumentos;
    }

    @ModelAttribute("genero")
    public List<EGenero> listGenero(){
        List<EGenero> generos = new ArrayList<>();

        generos.add(EGenero.M);
        generos.add(EGenero.F);
        generos.add(EGenero.O);

        return generos;
    }

    @ModelAttribute("ciudades")
    public List<Ciudad> lisCiudades(){
        List<Ciudad> c = new ArrayList<>();
        try {
            c = serviceCiudad.findAll();
        } catch (Exception e) {
            //e.printStackTrace();
            c = new ArrayList<>();
        }

        return  c;
    }

    /**
     * metodo que se encarga de llamar al html formPerson
     * e inicializa el objeto Cliente (guardar o modificar)
     * @param model
     * @return
     */
    @RequestMapping(value = "/formPersons")
    public String createClient(Map<String, Object> model){
        PersonaCliente cliente = new PersonaCliente();
        model.put("cliente",cliente);
        model.put("nombreTitulo","ADMINISTRACIÓN DE CLIENTES");
        return  "formPersons";
    }

    /**
     * metodo que se encargar de persistir el ciente y la persona que se esta creando
     * @param c
     * @param rd
     * @param model
     * @param ra
     * @param st
     * @return
     */
    @RequestMapping(value = "/formPersons", method = RequestMethod.POST)
    //PostMapping(value = "/formPersons")
    public String saveClient(@Valid @ModelAttribute("cliente") PersonaCliente c, BindingResult rd,
                             Model model, RedirectAttributes ra, SessionStatus st){

        String resultado = null;

        if(rd.hasErrors()){
            model.addAttribute("nombreTitulo", "ADMINISTRACIÓN CLIENTES");
            resultado = "formPersons";
        }else{
            String messages = null;
            if(c.getPersona().getIdPersona() == null) {
                try {
                    //Crea la persona
                    Cliente cl = new Cliente();
                    cl.setEstado(EEstados.A.getDesEstado());
                    servicePersona.create(c.getPersona());

                    //buscamos la persona creada por el numero de documento
                    Persona persTemporal = servicePersona.
                            findPersonByDocument(c.getPersona().getDocumento());
                    //validamos que la persona exista
                    if (persTemporal.getIdPersona() > 0) {
                        Cliente clientTmp = serviceCliente.findById(persTemporal.getIdPersona().longValue());

                        //modifica el cliente
                        if (clientTmp.getIdCliente() > 0) {
                            serviceCliente.create(c.getCliente());
                        } else {
                            //si el man no existe
                            c.getCliente().setEstado(EEstados.A.getDesEstado());
                            c.getCliente().setIdCliente(c.getPersona().getIdPersona());
                            serviceCliente.create(c.getCliente());
                        }
                        servicePersona.create(c.getPersona());
                    } else {
                        servicePersona.create(c.getPersona());
                        c.getCliente().setIdCliente(c.getPersona().getIdPersona());
                        serviceCliente.create(c.getCliente());
                    }

                    messages = c.getPersona().getIdPersona() > 0 ?
                            (c.getCliente().getIdCliente() > 0 ?
                                    "EL CLIENTE SE HA MODIFICADO" : "SE HA CREADO EL CLIENTE")
                            : "SE HA CREADO LA PERSONA";
                } catch (Exception e) {
                    messages = "ERROR CREANDO PERSONA";
                }


            }else{
                try {
                    servicePersona.create(c.getPersona());
                    messages = "EL CLIENTE SE HA MODIFICADO EL CLIENTE";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            st.setComplete();
            ra.addAttribute("success", messages);
            resultado = "redirect:/client/listClients";
        }
        return resultado;
    }

    /**
     * medotodos sincrono que se encarga de presentar la informacion y modifiacarla según peticion realziada
     * por el front html
     * @param idClient
     * @param model
     * @param rd
     * @return
     */
    @RequestMapping(value = "/formPersons/{idClient}")
    public String editClient(@PathVariable(value = "idClient")Integer idClient, Map<String, Object> model, RedirectAttributes rd){
        String clientUpdate = "";

        Persona personaEdit = new Persona();
        Cliente clienteEdit = new Cliente();
        PersonaCliente personaCliente = new PersonaCliente();

        if(idClient>0){
            try {
                clienteEdit = serviceCliente.findById(idClient.longValue());
                if(clienteEdit.getIdCliente()>0) {
                    try {
                        personaEdit = servicePersona.findById(clienteEdit.getIdCliente().longValue());
                        if (personaEdit.getIdPersona() > 0) {
                            personaCliente.setCliente(clienteEdit);
                            personaCliente.setPersona(personaEdit);
                            clientUpdate = "/formPersons";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        clientUpdate = "redirect:/client/listClients";
                        rd.addFlashAttribute("error", "LA PERSONA SOLICTADA NO EXISTE");
                    }
                }else{
                    rd.addFlashAttribute("warning", "EL CIENTE NO ESTA REALCIONADO CON LOS DATOS DE BUSQUEDA");
                    clientUpdate = "redirect:/client/listClients";
                }
            } catch (Exception e) {
                e.printStackTrace();
                rd.addFlashAttribute("error","EL CLIENTE SOLICTADO NO EXISTE");
            }
        }

        model.put("cliente",personaCliente);
        model.put("nombreTitulo", "Edición de Cliente");

        return  clientUpdate;
    }

    @RequestMapping(value = "/delete/{idClient}")
    public String delete(@PathVariable(value = "idClient")Integer idClient, Map<String, Object> model, RedirectAttributes rd) {
        String clientUpdate = "";

        Persona personaEdit = new Persona();
        Cliente clienteEdit = new Cliente();
        PersonaCliente personaCliente = new PersonaCliente();

        if (idClient > 0) {
            try {
                clienteEdit = serviceCliente.findById(idClient.longValue());
                if (clienteEdit.getIdCliente() > 0) {
                    try {
                        personaEdit = servicePersona.findById(clienteEdit.getIdCliente().longValue());
                        if (personaEdit.getIdPersona() > 0) {
                            clienteEdit.setEstado(EEstados.I.getDesEstado());
                            personaCliente.setCliente(clienteEdit);
                            personaCliente.setPersona(personaEdit);
                            serviceCliente.create(clienteEdit);
                            rd.addFlashAttribute("succes", "EL CLIENTE HA SIDO INACTIVADO DEL SISTEMA");
                            clientUpdate = "redirect:/client/listClients";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        rd.addFlashAttribute("error", "LA PERSONA SOLICTADA NO EXISTE");
                    }
                } else {
                    rd.addFlashAttribute("warning", "EL CIENTE NO ESTA REALCIONADO CON LOS DATOS DE BUSQUEDA");
                    clientUpdate = "redirect:/client/listClients";
                }
            } catch (Exception e) {
                e.printStackTrace();
                rd.addFlashAttribute("error", "EL CLIENTE SOLICTADO NO EXISTE");
            }
        }

        model.put("cliente", personaCliente);
        model.put("nombreTitulo", "Edición de Cliente");

        return clientUpdate;
    }

    @GetMapping(value = "/listClients")
    public  String listClients(Model model, RedirectAttributes rd){
        String retorono = "";

        List<PersonaCliente> personaClienteList = new ArrayList<PersonaCliente>();

        try {
            personaClienteList = servicePersona.personaClienteFindAll();

            if(personaClienteList.size()>0) {
                rd.addFlashAttribute("succes", "LISTADO DE CLIENTES");
                model.addAttribute("clientsList", personaClienteList);
                model.addAttribute("titulo", "CLIENTES INSCRITOS");

            }
            else {
                rd.addFlashAttribute("warning","NO HAY DATOS EXISTENTES" );
                model.addAttribute("titulo", "CLIENTES INSCRITOS");
            }

            retorono = "/listClients";

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorono;

    }

    @GetMapping(value = "/details/{idClient}")
    public String verDetails(@PathVariable(value = "idClient") Integer idCliente, Map<String, Object> model,
                                RedirectAttributes rd){
        String retorno = "";

        PersonaCliente personaCliente = new PersonaCliente();
        Persona p = new Persona();
        Cliente c = new Cliente();

        try {
            p = servicePersona.findById(idCliente.longValue());
            c = serviceCliente.findById(idCliente.longValue());

            if(p.getIdPersona()>0 && c.getIdCliente()>0){
                personaCliente.setPersona(p);
                personaCliente.setCliente(c);
                model.put("cliente", personaCliente);
                model.put("titulo", "DETALLLE DE ".concat(p.getPrimerNombre().trim() + " "+ p.getPrimerApellido().trim()));

                retorno = "details";
            }else{
                rd.addFlashAttribute("error", "ERROR AL VISUALIZAR CLIENTE");
                retorno = "redirect: /listClients";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        return retorno;
    }

}
