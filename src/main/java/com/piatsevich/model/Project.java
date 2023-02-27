package com.piatsevich.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "project_name")
    private String name;


//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = { CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "department_id")
//    private Department department;

    public Project() {
    }

    public Project(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
