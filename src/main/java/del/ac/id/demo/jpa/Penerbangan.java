package del.ac.id.demo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "penerbangan")
public class Penerbangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nama_asal")
    private String namaAsal;
    
    @Column(name = "nama_tujuan")
    private String namaTujuan;

    @Column(name = "tanggal_keberangkatan")
    private String tanggalKeberangkatan;
    
    @Column(name = "tanggal_kedatangan")
    private String tanggalKedatangan;
    
    @Column(name = "jumlah")
    private String jumlah;

    public long getId() {
        return id;
    }
    
	public void setId(long id) {
		this.id = id;
	}

	public String getNamaAsal() {
		return namaAsal;
	}

	public void setNamaAsal(String namaAsal) {
		this.namaAsal = namaAsal;
	}

	public String getNamaTujuan() {
		return namaTujuan;
	}

	public void setNamaTujuan(String namaTujuan) {
		this.namaTujuan = namaTujuan;
	}

	public String getTanggalKeberangkatan() {
		return tanggalKeberangkatan;
	}

	public void setTanggalKeberangkatan(String tanggalKeberangkatan) {
		this.tanggalKeberangkatan = tanggalKeberangkatan;
	}

	public String getTanggalKedatangan() {
		return tanggalKedatangan;
	}

	public void setTanggalKedatangan(String tanggalKedatangan) {
		this.tanggalKedatangan = tanggalKedatangan;
	}

	public String getJumlah() {
		return jumlah;
	}

	public void setJumlah(String jumlah) {
		this.jumlah = jumlah;
	}
   
}