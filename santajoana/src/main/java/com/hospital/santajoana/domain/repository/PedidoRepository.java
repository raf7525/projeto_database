package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Timestamp;

import com.hospital.santajoana.domain.entity.Pedido;
import com.hospital.santajoana.domain.entity.Pedido.StatusPedido;

public class PedidoRepository extends BaseRepository<Pedido> {

    public PedidoRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "pedido", (rs, rowNum) -> new Pedido(
            rs.getInt("id_pedido"),
            rs.getTimestamp("data_hora").toLocalDateTime(),
            rs.getInt("paciente_id"),
            rs.getInt("quarto_id"),
            StatusPedido.valueOf(rs.getString("status"))
        ));
    }

    public Pedido save(Pedido pedido) {
        String insertSql = "INSERT INTO pedido (data_hora, paciente_id, quarto_id, status) VALUES (?, ?, ?, ?)";
        return super.save(insertSql,
            Timestamp.valueOf(pedido.getDataHora()),
            pedido.getPacienteId(),
            pedido.getQuartoId(),
            pedido.getStatus().name());
    }

    public Pedido findById(Integer id) {
        return super.findById("id_pedido", id);
    }

    public void delete(Integer id) {
        super.delete("id_pedido", id);
    }
}
