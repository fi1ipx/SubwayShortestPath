/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscowsubway.interfaces;

import com.moscowsubway.objects.Station;
import com.moscowsubway.objects.Line;
import java.util.*;

public interface ObjectsLists {
    ArrayList<Station> getStations();
    
    ArrayList<Line> getLines();
}
