package com.fi1.SubwayShortestPath.objects;

import javax.persistence.*;

@Entity
@Table(name="subway_lines")
public class Line {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "line_num")
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
