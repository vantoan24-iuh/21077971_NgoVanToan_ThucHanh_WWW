package vn.edu.iuh.fit.exercise.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "loaithuoc")
@NamedQuery(name = "Loaithuoc.findAll", query = "SELECT l FROM Loaithuoc l")
public class Loaithuoc implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoai", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TenLoai", length = 50)
    private String tenLoai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}