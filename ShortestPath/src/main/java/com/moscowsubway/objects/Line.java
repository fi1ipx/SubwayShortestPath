/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscowsubway.objects;

/**
 *
 * @author Fil
 */
public class Line {
    private int id;
    private String name;
    private int line_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLineNum() {
        return line_num;
    }

    public void setLineNum(int line_num) {
        this.line_num = line_num;
    }
}
