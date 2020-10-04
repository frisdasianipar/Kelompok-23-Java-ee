package del.ac.id.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import del.ac.id.demo.jpa.Penerbangan;
import del.ac.id.demo.jpa.PenerbanganRepository;

@Service
public class PenerbanganServiceImpl implements PenerbanganService {

    @Autowired
    private PenerbanganRepository penerbanganRepository;

    @Override
    public List < Penerbangan > getAllPenerbangans() {
        return penerbanganRepository.findAll();
    }

    @Override
    public void savePenerbangan(Penerbangan penerbangan) {
        this.penerbanganRepository.save(penerbangan);
    }

    @Override
    public Penerbangan getPenerbanganById(long id) {
        Optional < Penerbangan > optional = penerbanganRepository.findById(id);
        Penerbangan penerbangan = null;
        if (optional.isPresent()) {
            penerbangan = optional.get();
        } else {
            throw new RuntimeException(" Penerbangan not found for id :: " + id);
        }
        return penerbangan;
    }

    @Override
    public void deletePenerbanganById(long id) {
        this.penerbanganRepository.deleteById(id);
    }
}