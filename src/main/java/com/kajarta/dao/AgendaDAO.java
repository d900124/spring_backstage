package com.kajarta.dao;

import java.util.List;
import com.kajarta.demo.model.Agenda;
import org.json.JSONObject;

public interface AgendaDAO {
    public abstract List<Agenda> find(JSONObject obj);

    public abstract long count(JSONObject obj);
}
