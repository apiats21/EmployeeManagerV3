package com.piatsevich.controller;

import com.piatsevich.model.Client;
import com.piatsevich.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listClients(Model model){
        model.addAttribute("clients", this.clientService.getAll());

        return "client/list-client";
    }

    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Client client = new Client();

        model.addAttribute("client", client);
        return "client/client-form";
    }

    @RequestMapping(value = "/showFormForUpdate", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("client_id") Integer id, Model model) {
        Client client = clientService.getById(id);

        model.addAttribute("client", client);

        return "client/client-form";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteClient(@RequestParam("client_id") Integer id) {
        this.clientService.delete(id);
        return "redirect:/clients/list";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.create(client);
        return "redirect:/clients/list";
    }
}