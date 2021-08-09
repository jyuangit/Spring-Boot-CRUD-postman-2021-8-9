package com.employee.crud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jyuan
 * @since 2021-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("companyName")
    private String companyname;

    @TableField("employeesNumber")
    private Integer employeesnumber;


}
