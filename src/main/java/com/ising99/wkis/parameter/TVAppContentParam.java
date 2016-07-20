package com.ising99.wkis.parameter;

/**
 * Created by jerry on 2014/6/27.
 */
public class TVAppContentParam extends PageBaseParam {
    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    Integer columnid;
    Integer order;
    String spell;
}
