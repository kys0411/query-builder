package util.statement;

import util.constant.Table;

public class Delete {

    private Table table;

    public Delete(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }
}
