package com.piatsevich.repository.impl;

import com.piatsevich.model.Chat;
import com.piatsevich.repository.ChatRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ChatRepositoryImpl implements ChatRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ChatRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Chat getById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Chat chat = (Chat) currentSession.get(Chat.class, id);

        return chat;
    }

    @Override
    public Chat save(Chat chat) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(chat);

        return chat;
    }

    @Override
    public List<Chat> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Chat");

        List<Chat> chat = theQuery.list();

        return chat;
    }

    @Override
    public Chat update(Chat chat) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Chat where chat_id=:chatId");
        query.setParameter("chatId", id);

        query.executeUpdate();
    }
}
