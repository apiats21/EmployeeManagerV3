package com.piatsevich.service.impl;

import com.piatsevich.model.Chat;
import com.piatsevich.repository.ChatRepository;
import com.piatsevich.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Override
    public Chat getById(Integer id) {
        return chatRepository.getById(id);
    }

    @Override
    public Chat create(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.getAll();
    }

    @Override
    public Chat update(Chat chat) {
        return chatRepository.update(chat);
    }

    @Override
    public void delete(Integer id) {
        chatRepository.deleteById(id);
    }
}
