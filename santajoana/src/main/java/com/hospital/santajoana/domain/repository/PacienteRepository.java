package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Date;

import com.hospital.santajoana.domain.entity.Paciente;

public class PacienteRepository extends BaseRepository<Paciente>{

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "paciente", (rs, rowNum) -> new Paciente(
            rs.getLong("id_paciente"),
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getDate("data_nascimento").toLocalDate(),
            rs.getLong("quarto_id"),
            rs.getString("status")
        ));
    }

    public Paciente save(Paciente paciente) {
        String insertSql =
        "INSERT INTO paciente (nome, cpf, data_nascimento, quarto_id, status) VALUES (?, ?, ?, ?, ?)";
        return super.
        save(insertSql,
        paciente.getNome(),
        paciente.getCpf(),
        Date.valueOf(paciente.getData_nascimento()),
        paciente.getQuarto_id(),
        paciente.getStatus());
    }

    public Paciente findById(Long id) {
        return super.findById("id_paciente", id);
    }

    public void delete(Long id) {
        super.delete("id_paciente", id);
    }
}
