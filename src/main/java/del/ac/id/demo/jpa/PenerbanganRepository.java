package del.ac.id.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import del.ac.id.demo.jpa.Penerbangan;

@Repository
public interface PenerbanganRepository extends JpaRepository<Penerbangan, Long>{
}