package com.atguigu.pojo;

import java.util.List;
/**
 * @ClassName : Page  //类名
 * @Description : 分页  //描述
 * @Author : 胡雨//作者
 * @Date: 2020/10/27  21:19
 */
/*Page Page是 分 页 的 模 型 对 象
 @param <T>是 具 体 的 模 块 的 javaBean类
* */
public class Page<T> {
    //每页显示的数量
    public  static  final  Integer PAGE_SIZ = 4;
    //当前页码
    private  Integer pageNo;
    //总页码
    private  Integer pageTotal;
    //当前显示数量
    private  Integer pageSiz= PAGE_SIZ;
    //总记录数
    private  Integer pageTotalCount;
    //当前页数据
    private List<T> items;
    //分页条请求地址
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPageNo(Integer pageNo) {

      /*
       if (pageNo < 1) { pageNo = 1; }
       if (pageNo > pageTotal) { pageNo = pageTotal; }
        */

        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSiz() {
        return pageSiz;
    }

    public void setPageSiz(Integer pageSiz) {
        this.pageSiz = pageSiz;
    }
    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSiz=" + pageSiz +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}



