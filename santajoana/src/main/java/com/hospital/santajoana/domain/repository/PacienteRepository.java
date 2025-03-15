package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.santajoana.domain.entity.Paciente;

public class PacienteRepository extends BaseRepository<Paciente>{

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "paciente", (rs, rowNum) -> new Paciente(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getString("telefone"),
            rs.getString("email"),
            rs.getString("endereco"),
            rs.getString("data_nascimento"),
            rs.getString("sexo"),
            rs.getString("tipo_sanguineo")
        ));
    }

    public Paciente save(Paciente paciente) {
        String insertSql =
        "INSERT INTO paciente (nome, cpf, telefone, email, endereco, data_nascimento, sexo, tipo_sanguineo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return super.
        save(insertSql,
        paciente.getNome(),
        paciente.getCpf(),
        paciente.getTelefone(),
        paciente.getEmail(),
        paciente.getEndereco(),
        paciente.getDataNascimento(),
        paciente.getSexo(),
        paciente.getTipoSanguineo());
    }

    public Paciente findById(Long id) {
        return super.findById("id", id);
    }

    public void delete(Long id) {
        super.delete("id", id);
    }
}
