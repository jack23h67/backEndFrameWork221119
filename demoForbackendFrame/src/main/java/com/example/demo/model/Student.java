package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID", nullable=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="NAME", nullable=false)
    private String name;
    
    @Column(name="SCORE", nullable=false)
    private Double score;
    
    @Column(name="GRADUATE", nullable=false)
    private boolean graduate;
    
    @Column(name="CREATE_DATE", nullable=false)
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public Student setScore(Double score) {
        this.score = score;
        return this;
    }

    public boolean isGraduate() {
        return graduate;
    }

    public Student setGraduate(boolean graduate) {
        this.graduate = graduate;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Student setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }
}
