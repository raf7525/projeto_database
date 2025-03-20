package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.santajoana.domain.entity.Enfermeiro;

public class EnfermeiroRepository extends BaseRepository<Enfermeiro> {

    public EnfermeiroRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "enfermeiro", (rs, rowNum) -> new Enfermeiro(
            rs.getString("cre"),
            rs.getString("nome"),
            rs.getString("cargo"),
            rs.getString("setor")
        ));
    }

    public Enfermeiro save(Enfermeiro enfermeiro) {
        String insertSql = "INSERT INTO enfermeiro (cre, nome, cargo, setor) VALUES (?, ?, ?, ?)";
        return super.save(insertSql,
            enfermeiro.getCre(),
            enfermeiro.getNome(),
            enfermeiro.getCargo(),
            enfermeiro.getSetor());
    }

    public Enfermeiro findById(String cre) {
        return super.findById("cre", cre);
    }

    public void delete(String cre) {
        super.delete("cre", cre);
    }
}
