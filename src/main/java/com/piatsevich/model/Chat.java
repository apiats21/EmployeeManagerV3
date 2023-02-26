package com.piatsevich.model;

import javax.persistence.*;

@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "chat_name")
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = { CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "creator_id")
//    private Employee employee;

    public Chat() {
    }

    public Chat(Integer id, String name, Employee employee) {
        this.id = id;
        this.name = name;
//        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee="  +
                '}';
    }
}
