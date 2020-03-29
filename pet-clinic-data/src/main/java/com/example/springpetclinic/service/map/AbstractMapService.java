package com.example.springpetclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract  class AbstractMapService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
        return map.put(id, object);
    }

    void delete(T object) {
        map.entrySet().removeIf(obj -> obj.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }
}
