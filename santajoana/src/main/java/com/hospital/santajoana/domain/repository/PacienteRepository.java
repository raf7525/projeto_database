package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

import com.hospital.santajoana.domain.entity.Paciente;

@Repository
public class PacienteRepository extends BaseRepository<Paciente>{

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        super("PACIENTE", "ID_PACIENTE", jdbcTemplate, (rs, rowNum) -> new Paciente(
            rs.getLong("ID_PACIENTE"),
            rs.getString("NOME"),
            rs.getString("CPF"),
            rs.getDate("DATA_NASCIMENTO").toLocalDate(),
            rs.getLong("quartoId"),
            rs.getString("STATUS")
        ));
    }

    @Override
    public Paciente save(Paciente paciente) {
        String insertSql =
        "INSERT INTO PACIENTE (NOME, CPF, DATA_NASCIMENTO, quartoId, STATUS) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertSql,
            paciente.getNome(),
            paciente.getCpf(),
            Date.valueOf(paciente.getDataNascimento()),
            paciente.getQuartoId(),
            paciente.getStatus());
        return paciente;
    }

    public Optional<Paciente> findById(Long id) {
        return super.findById(id);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Paciente update(Paciente paciente) {
        String updateSql = "UPDATE PACIENTE SET NOME = ?, CPF = ?, DATA_NASCIMENTO = ?, quartoId = ?, STATUS = ? WHERE ID_PACIENTE = ?";
        jdbcTemplate.update(updateSql,
            paciente.getNome(),
            paciente.getCpf(),
            Date.valueOf(paciente.getDataNascimento()),
            paciente.getQuartoId(),
            paciente.getStatus(),
            paciente.getId()
        );
        return paciente;
    }
}
