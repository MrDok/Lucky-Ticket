package com.company.operations;

/**
 * @author adokucha  on 07.03.2017.
 */
public enum SimpleOperations implements Operations{
    SUM('+', 0),
    SUBTRACTION('-', 1),
    MULTIPLY('*', 2),
    DIVISION('/', 3);

    public Character operation;
    private int id;

    SimpleOperations(Character operation, int id){
        this.operation = operation;
        this.id = id;
    }

    public Character getOperation(){
        return operation;
    }

    public int getId(){
        return id;
    }

    public Character getOperationById(int id){
        for (SimpleOperations operation : values()){
            if (operation.getId() == id){
                return operation.getOperation();
            }
        }

        return null;
    }

    public int size(){
        return values().length;
    }
}
