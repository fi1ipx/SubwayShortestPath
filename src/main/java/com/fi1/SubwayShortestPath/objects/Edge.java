package com.fi1.SubwayShortestPath.objects;

import javax.persistence.*;

@Entity
@Table(name="edges")
public class Edge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "st1")
    private int src;

    @Column(name = "st2")
    private int dst;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDst() {
        return dst;
    }

    public void setDst(int dst) {
        this.dst = dst;
    }
}
