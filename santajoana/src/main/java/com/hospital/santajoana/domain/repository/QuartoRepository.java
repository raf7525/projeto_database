package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.santajoana.domain.entity.Quarto;

public class QuartoRepository extends BaseRepository<Quarto> {

    public QuartoRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "quarto", (rs, rowNum) -> new Quarto(
            rs.getLong("id_quarto"),
            rs.getString("numero"),
            rs.getString("tipo")
        ));
    }

    public Quarto save(Quarto quarto) {
        String insertSql = "INSERT INTO quarto (numero, tipo) VALUES (?, ?)";
        return super.save(insertSql,
            quarto.getNumero(),
            quarto.getTipo());
    }

    public Quarto findById(Long id) {
        return super.findById("id_quarto", id);
    }

    public void delete(Long id) {
        super.delete("id_quarto", id);
    }
}
