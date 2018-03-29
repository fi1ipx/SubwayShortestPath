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
public class Edge {
    private int src;
    private int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
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
