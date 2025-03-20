package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Timestamp;

import com.hospital.santajoana.domain.entity.Fatura;
import com.hospital.santajoana.domain.entity.Fatura.StatusPagamento;

public class FaturaRepository extends BaseRepository<Fatura> {

    public FaturaRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "fatura", (rs, rowNum) -> {
            Timestamp dataPagamento = rs.getTimestamp("data_pagamento");
            Integer idMetodoPagamento = rs.getObject("id_metodo_pagamento") != null ? 
                rs.getInt("id_metodo_pagamento") : null;
                
            if (dataPagamento == null) {
                return new Fatura(
                    rs.getInt("id_fatura"),
                    rs.getInt("paciente_id"),
                    rs.getBigDecimal("valor_total"),
                    StatusPagamento.valueOf(rs.getString("status_pagamento"))
                );
            } else {
                return new Fatura(
                    rs.getInt("id_fatura"),
                    rs.getInt("paciente_id"),
                    rs.getBigDecimal("valor_total"),
                    StatusPagamento.valueOf(rs.getString("status_pagamento")),
                    dataPagamento.toLocalDateTime(),
                    idMetodoPagamento
                );
            }
        });
    }

    public Fatura save(Fatura fatura) {
        String insertSql = "INSERT INTO fatura (paciente_id, valor_total, status_pagamento, data_pagamento, id_metodo_pagamento) VALUES (?, ?, ?, ?, ?)";
        
        return super.save(insertSql,
            fatura.getPacienteId(),
            fatura.getValorTotal(),
            fatura.getStatusPagamento().name(),
            fatura.getDataPagamento() != null ? Timestamp.valueOf(fatura.getDataPagamento()) : null,
            fatura.getIdMetodoPagamento());
    }

    public Fatura findById(Integer id) {
        return super.findById("id_fatura", id);
    }

    public void delete(Integer id) {
        super.delete("id_fatura", id);
    }
}
