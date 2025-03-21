package com.hospital.santajoana.domain.repository;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hospital.santajoana.domain.entity.Enfermeiro;

@Repository
public class EnfermeiroRepository extends BaseRepository<Enfermeiro> {

    public EnfermeiroRepository(JdbcTemplate jdbcTemplate) {
        super("ENFERMEIRO","ID_ENFERMEIRO",jdbcTemplate, (rs, rowNum) -> new Enfermeiro(
            rs.getLong("ENFERMEIRO_ID"),
            rs.getString("CRE"),
            rs.getString("NOME"),
            rs.getString("CARGO"),
            rs.getString("SETOR")
        ));
    }

    public Enfermeiro save(Enfermeiro enfermeiro) {
        String insertSql = "INSERT INTO ENFERMEIRO (CRE, NOME, CARGO, SETOR) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertSql,
            enfermeiro.getCre(),
            enfermeiro.getNome(),
            enfermeiro.getCargo(),
            enfermeiro.getSetor()
        );
        return enfermeiro;
        
    }

    public Optional<Enfermeiro> findById(Long id) {
        return super.findById(id);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Enfermeiro update(Enfermeiro enfermeiro) {
        String updateSql = "UPDATE ENFERMEIRO SET CRE = ?, NOME = ?, CARGO = ?, SETOR = ? WHERE ENFERMEIRO_ID = ?";
        jdbcTemplate.update(updateSql,
            enfermeiro.getCre(),
            enfermeiro.getNome(),
            enfermeiro.getCargo(),
            enfermeiro.getSetor(),
            enfermeiro.getId()
        );
        return enfermeiro;
    }




}
