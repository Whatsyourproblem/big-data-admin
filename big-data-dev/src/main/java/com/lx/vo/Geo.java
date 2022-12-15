package com.lx.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Geo implements Serializable {

    private Integer id;
    private Integer deep;
    private String name;
}
