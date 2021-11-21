package com.example.backend.domain.repository.jdbc;

import java.util.List;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.Estimate;
import com.example.backend.domain.repository.dao.EstimateDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EstimateDaoJdbc implements EstimateDao {
    
    @Autowired
    JdbcTemplate jdbc;

    //指定したIDのデータを取得
    public Estimate selectOne(int id) {
        String tableName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";

        RowMapper<Estimate> rowMapper = new BeanPropertyRowMapper<>(Estimate.class);
        return jdbc.queryForObject(sql, rowMapper, id);
    }

    //指定した文字列に部分一致するデータを取得
    public List<Estimate> selectLikeList(String likeStr) {
        String tableName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + " WHERE estimate_name LIKE ?";

        RowMapper<Estimate> rowMapper = new BeanPropertyRowMapper<>(Estimate.class);
        return jdbc.query(sql, rowMapper, likeStr);
    }

    //全てのデータを取得
    public List<Estimate> selectAll() {
        String tableName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName;

        RowMapper<Estimate> rowMapper = new BeanPropertyRowMapper<>(Estimate.class);
        return jdbc.query(sql, rowMapper);
    }

    //指定したデータを登録
    public void insert(Estimate estimate) {
        String tableName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String sql = "INSET INTO " + tableName + " VALUE(?,?,?,?,?,?,?,?,?)";

        jdbc.update(sql,
            estimate.getId(),
            estimate.getEstimate_name(),
            estimate.getEstimate_amount(),
            estimate.getBudgeted_amount(),
            estimate.getCustomer_cd(),
            estimate.getEmployee_cd(),
            estimate.getEstimate_date(),
            estimate.getStatus(),
            estimate.getOrder_id());
    }

    //データ更新
    public void update(Estimate updatedEstimate, int id) {
        String tableName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String sql = "UPDATE " + tableName + " SET VALUE(?,?,?,?,?,?,?,?,?) WHERE id = ?";

        jdbc.update(sql,
            updatedEstimate.getId(),
            updatedEstimate.getEstimate_name(),
            updatedEstimate.getEstimate_amount(),
            updatedEstimate.getBudgeted_amount(),
            updatedEstimate.getCustomer_cd(),
            updatedEstimate.getEmployee_cd(),
            updatedEstimate.getEstimate_date(),
            updatedEstimate.getStatus(),
            updatedEstimate.getOrder_id(),
            id);
    }

    //指定したIDのデータを削除
    public void delete(int id) {
        String tableName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        jdbc.update(sql, id);
    }
}
