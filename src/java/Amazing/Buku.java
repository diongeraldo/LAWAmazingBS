/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Dion Geraldo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Buku", propOrder = {"id", "judul", "pengarang", "tahunterbit", "jenis"})
public class Buku {
    
    @XmlElement(name = "id", required = true)
    private int id;
    
    @XmlElement(name = "judul", required = true)
    private String judul;
    
    @XmlElement(name = "pengarang", required = true)
    private String pengarang;
    
    @XmlElement(name = "tahunterbit", required = true)
    private String tahunterbit;
    
    @XmlElement(name = "jenis", required = true)
    private String jenis;

    public Buku(int id, String judul, String pengarang, String tahunterbit, String jenis) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunterbit = tahunterbit;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getTahunterbit() {
        return tahunterbit;
    }

    public String getJenis() {
        return jenis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setTahunterbit(String tahuterbit) {
        this.tahunterbit = tahunterbit;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    
}
