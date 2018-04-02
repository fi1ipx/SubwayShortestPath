/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscowsubway.rs;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.moscowsubway.objects.Station;

@XmlRootElement(name = "stationlist")
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseList {

    public ResponseList() {
    }
    
    @XmlElement(name = "station")
    private List<Station> list;
    
    public List<Station> getList() {
        return list;
    }

    public void setList(List<Station> list) {
        this.list = list;
    }
}
