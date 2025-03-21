package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

import com.hospital.santajoana.domain.entity.Pedido;
import com.hospital.santajoana.domain.entity.Pedido.StatusPedido;

@Repository
public class PedidoRepository extends BaseRepository<Pedido> {

    public PedidoRepository(JdbcTemplate jdbcTemplate) {
        super("PEDIDO","ID_PEDIDO", jdbcTemplate, (rs, rowNum) -> new Pedido(
            rs.getLong("ID_PEDIDO"),
            rs.getTimestamp("DATA_HORA").toLocalDateTime(),
            rs.getLong("PACIENTE_ID"),
            rs.getLong("quartoId"),
            StatusPedido.valueOf(rs.getString("STATUS"))
        ));
    }

    public Pedido save(Pedido pedido) {
        String insertSql = "INSERT INTO PEDIDO (DATA_HORA, PACIENTE_ID, quartoId, STATUS) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertSql,
            Timestamp.valueOf(pedido.getDataHora()),
            pedido.getPacienteId(),
            pedido.getQuartoId(),
            pedido.getStatus().name());
        return pedido;
    }

    public Optional<Pedido> findById(Long id) {
        return super.findById(id);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Pedido update(Pedido pedido) {
        String updateSql = "UPDATE PEDIDO SET DATA_HORA = ?, PACIENTE_ID = ?, quartoId = ?, STATUS = ? WHERE ID_PEDIDO = ?";
        jdbcTemplate.update(updateSql,
            Timestamp.valueOf(pedido.getDataHora()),
            pedido.getPacienteId(),
            pedido.getQuartoId(),
            pedido.getStatus().name(),
            pedido.getId()
        );
        return pedido;
    }
}
