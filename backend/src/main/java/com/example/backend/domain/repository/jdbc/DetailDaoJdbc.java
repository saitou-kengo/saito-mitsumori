package com.example.backend.domain.repository.jdbc;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.EstimateDetail;
import com.example.backend.domain.repository.dao.DetailDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DetailDaoJdbc implements DetailDao {
    
    @Autowired
    JdbcTemplate jdbc;

    //指定したデータを登録
    public void insert(EstimateDetail detail) {
        String tableName = Constants.db.ESTIMATE_DETAIL_TBL_NAME.getlabel();
        String sql = "INSET INTO " + tableName + " VALUE(?,?,?,?,?)";

        jdbc.update(sql,
            detail.getId(),
            detail.getSubId(),
            detail.getEstimateId(),
            detail.getProductCd(),
            detail.getQuantity()
        );
    }

    //データ更新
    public void update(EstimateDetail updatedDetail, int id) {
        String tableName = Constants.db.ESTIMATE_DETAIL_TBL_NAME.getlabel();
        String sql = "UPDATE " + tableName + " SET VALUE(?,?,?,?,?) WHERE id = ?";

        jdbc.update(sql,
            updatedDetail.getId(),
            updatedDetail.getSubId(),
            updatedDetail.getEstimateId(),
            updatedDetail.getProductCd(),
            updatedDetail.getQuantity(),
            id);
    }

    //指定したIDのデータを削除
    public void delete(int id) {
        String tableName = Constants.db.ESTIMATE_DETAIL_TBL_NAME.getlabel();
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        jdbc.update(sql, id);
    }
}
