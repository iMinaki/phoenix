package com.lee.phoenix.service.impl;

import com.lee.phoenix.common.generic.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl {
    @Autowired
    protected EntityManager em;
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected <T> Page<T> findPagedData(String countSQL, String querySQL, Map<String, Object> params, Integer pageIndex, Integer pageSize, RowMapper<T> rowCallbackHandler) {
        int total = namedParameterJdbcTemplate.queryForObject(countSQL, params, Integer.class);
        if (total > 0) {
            pageIndex = (pageIndex == null || pageIndex < 0) ? Page.DEFAULT_PAGE_INDEX : pageIndex;
            pageSize = (pageSize == null || pageSize <= 0) ? Page.DEFAULT_PAGE_SIZE : pageSize;
            params.put("offset", pageIndex * pageSize);
            params.put("limit", pageSize);
            List<T> data = namedParameterJdbcTemplate.query(querySQL, params, rowCallbackHandler);
            return new Page<T>(total, data, pageIndex, pageSize);
        } else {
            return new Page<>(total, new ArrayList<>(), pageIndex, pageSize);
        }
    }
}
