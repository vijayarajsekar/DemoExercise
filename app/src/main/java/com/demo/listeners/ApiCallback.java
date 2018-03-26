package com.demo.listeners;

import com.demo.model.Row;

import java.util.List;


/**
 * Created by vijayaraj_s on 25/03/18.
 */

public interface ApiCallback {

    void notifylist(List<Row> _data);
}
