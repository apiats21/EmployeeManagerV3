package com.piatsevich.controller;

import com.piatsevich.model.Chat;
import com.piatsevich.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listChats(Model model){
        model.addAttribute("chats", this.chatService.getAll());

        return "chat/list-chat";
    }

    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Chat chat = new Chat();

        model.addAttribute("chat", chat);
        return "chat/chat-form";
    }

    @RequestMapping(value = "/showFormForUpdate", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("chat_id") Integer id, Model model) {
        Chat chat = chatService.getById(id);

        model.addAttribute("chat", chat);

        return "chat/chat-form";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteChat(@RequestParam("chat_id") Integer id) {
        this.chatService.delete(id);
        return "redirect:/chats/list";
    }

    @RequestMapping(value = "/saveChat", method = RequestMethod.POST)
    public String saveChat(@ModelAttribute("chat") Chat chat) {
        chatService.create(chat);
        return "redirect:/chats/list";
    }
}