package com.anole.core.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * <p>扩展信息</p>
 */
public class Extension implements Serializable {
    private static final long serialVersionUID = 8034857888313309344L;

    /** 扩展信息列表 */
    private List<Kvp>         entryList        = new ArrayList<Kvp>();

    /**
     * 增加键值
     * @param key
     * @param value
     */
    public void add(String key, String value) {
        this.remove(key);
        this.entryList.add(new Kvp(key, value));
    }

    /**
     * 根据键对象获取值对象
     * @param key
     * @return
     */
    public String getValue(String key) {
        if (entryList == null || entryList.size() == 0) {
            return null;
        }
        for (Kvp kvp : entryList) {
            if (kvp == null) {
                continue;
            }
            if (key.equals(kvp.getKey())) {
                return kvp.getValue();
            }
        }

        return null;
    }

    /**
     * 剔除键值
     * @param key
     */
    public void remove(String key) {
        if (entryList == null || entryList.size() == 0) {
            return;
        }
        for (Iterator<Kvp> it = entryList.iterator(); it.hasNext();) {
            Kvp kvp = it.next();
            if (kvp == null) {
                continue;
            }
            if (key.equals(kvp.getKey())) {
                it.remove();
                return;
            }
        }
    }

    public List<Kvp> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Kvp> entryList) {
        this.entryList = entryList;
    }
}
