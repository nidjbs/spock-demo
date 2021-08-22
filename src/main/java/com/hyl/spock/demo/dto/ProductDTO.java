package com.hyl.spock.demo.dto;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:41
 * @desc the class desc
 */
public class ProductDTO {

    private Integer id;

    private String name;

    private Integer remain;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remain=" + remain +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }
}
