package com.example.backend.domain.repository.jdbc;

import java.util.List;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.JoinDetailToMst;
import com.example.backend.domain.repository.dao.JoinDetailToMstDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JoinDetailToMstDaoJdbc implements JoinDetailToMstDao {

    @Autowired
    JdbcTemplate jdbc;

    //全てのデータを取得
    public List<JoinDetailToMst> selectAll() {
        String detailTblName = Constants.db.ESTIMATE_DETAIL_TBL_NAME.getlabel();
        String productTblName = Constants.db.MST_PRODUCT_TBL_NAME.getlabel();
        String sql = "SELECT *, price * quantity as total_price FROM ("
            +"SELECT " + detailTblName + ".*, "+ productTblName + ".name"
            + " FROM " + detailTblName
            + " INNER JOIN " + productTblName
            + "ON " + detailTblName + ".product_cd = " + productTblName + ".cd)";

        RowMapper<JoinDetailToMst> rowMapper = new BeanPropertyRowMapper<>(JoinDetailToMst.class);
        return jdbc.query(sql, rowMapper);
    }
    
    //指定した見積IDの全てのデータを取得
    public List<JoinDetailToMst> selectAllByEstimateId(int estimateId) {
        String detailTblName = Constants.db.ESTIMATE_DETAIL_TBL_NAME.getlabel();
        String productTblName = Constants.db.MST_PRODUCT_TBL_NAME.getlabel();
        String sql = "SELECT *, price * quantity as total_price FROM ("
            +"SELECT " + detailTblName + ".*, "+ productTblName + ".name"
            + " FROM " + detailTblName
            + " INNER JOIN " + productTblName
            + "ON " + detailTblName + ".product_cd = " + productTblName + ".cd)"
            + " WHERE estimate_id = ?";

        RowMapper<JoinDetailToMst> rowMapper = new BeanPropertyRowMapper<>(JoinDetailToMst.class);
        return jdbc.query(sql, rowMapper, estimateId);
    }
}
