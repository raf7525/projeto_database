package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

import com.hospital.santajoana.domain.entity.Fatura;
import com.hospital.santajoana.domain.entity.Fatura.StatusPagamento;

@Repository
public class FaturaRepository extends BaseRepository<Fatura> {

    public FaturaRepository(JdbcTemplate jdbcTemplate) {
        super("FATURA","ID_FATURA" ,jdbcTemplate, (rs, rowNum) -> {
            Timestamp dataPagamento = rs.getTimestamp("DATA_PAGAMENTO");
            Long idMetodoPagamento = rs.getObject("ID_METODO_PAGAMENTO") != null ? 
                rs.getLong("ID_METODO_PAGAMENTO") : null;
                
            if (dataPagamento == null) {
                return new Fatura(
                    rs.getLong("ID_FATURA"),
                    rs.getLong("PACIENTE_ID"),
                    rs.getBigDecimal("VALOR_TOTAL"),
                    StatusPagamento.valueOf(rs.getString("STATUS_PAGAMENTO"))
                );
            } else {
                return new Fatura(
                    rs.getLong("ID_FATURA"),
                    rs.getLong("PACIENTE_ID"),
                    rs.getBigDecimal("VALOR_TOTAL"),
                    StatusPagamento.valueOf(rs.getString("STATUS_PAGAMENTO")),
                    dataPagamento.toLocalDateTime(),
                    idMetodoPagamento
                    
                );
            }
        });
    }

    public Fatura save(Fatura fatura) {
        String insertSql = "INSERT INTO FATURA (PACIENTE_ID, VALOR_TOTAL, STATUS_PAGAMENTO, DATA_PAGAMENTO, ID_METODO_PAGAMENTO) VALUES (?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(insertSql,
            fatura.getPacienteId(),
            fatura.getValorTotal(),
            fatura.getStatusPagamento().name(),
            fatura.getDataPagamento() != null ? Timestamp.valueOf(fatura.getDataPagamento()) : null,
            fatura.getIdMetodoPagamento());
            return fatura;

    }

    public Optional<Fatura> findById(Long id) {
        return super.findById(id);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Fatura update(Fatura fatura) {
        String updateSql = "UPDATE FATURA SET PACIENTE_ID = ?, VALOR_TOTAL = ?, STATUS_PAGAMENTO = ?, DATA_PAGAMENTO = ?, ID_METODO_PAGAMENTO = ? WHERE ID_FATURA = ?";
        jdbcTemplate.update(updateSql,
            fatura.getPacienteId(),
            fatura.getValorTotal(),
            fatura.getStatusPagamento().name(),
            fatura.getDataPagamento() != null ? Timestamp.valueOf(fatura.getDataPagamento()) : null,
            fatura.getIdMetodoPagamento(),
            fatura.getId()
        );
        return fatura;
    }

}
