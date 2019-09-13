package com.lee.phoenix.common.generic;

import java.util.List;

/**
 * 分页对象. <p />
 *
 * @author lee
 * @version 1.0.0
 * @date 2018/08/07 23:00
 * @since JDK1.8
 */
public class Page<T> {

    public final static int DEFAULT_PAGE_SIZE = 10;

    public final static int DEFAULT_PAGE_INDEX = 1;

    /**
     * 总记录数.
     */
    private long total = 0L;

    /**
     * 查询结果集合
     */
    private List<T> rows = null;

    /**
     * 当前页（页码）
     */
    private int pageIndex = DEFAULT_PAGE_INDEX;

    /**
     * 每页显示记录数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 构造函数.
     *
     * @param total     总记录数
     * @param rows      查询结果集合
     * @param pageIndex 当前页
     * @param pageSize  每页显示记录数
     */
    public Page(long total, List<T> rows, int pageIndex, int pageSize) {
        this.total = total;
        this.rows = rows;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    /**
     * 获得记录数目. <br/>
     *
     * @return 记录数目
     */
    public long getTotal() {
        return total;
    }

    /**
     * 获得记录集合. <br/>
     *
     * @return 记录集合
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 获得当前页码. <br/>
     *
     * @return
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * 获得每页显示记录数. <br/>
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 总页数
     *
     * @return 总页数
     */
    public int getPageCount() {
        return (int) ((total + pageSize - 1) / pageSize);
    }


    public boolean getHasPreviousPage() {
        return getPageIndex() > 1;
    }

    public boolean getHasNextPage() {
        return getPageIndex() < getPageCount();
    }

    public boolean getIsFirstPage() {
        return getPageIndex() == 1;
    }

    public boolean getIsLastPage() {
        return getPageIndex() == getPageCount();
    }
}
