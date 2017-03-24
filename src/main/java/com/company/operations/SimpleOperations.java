package com.company.operations;

/**
 * @author adokucha  on 07.03.2017.
 */
public final class SimpleOperations implements Operations{
    @Override
    public Character getOperationByCharId(char id){
        for (Operations operation : Operations.values()){
            if (operation.getCharId() == id){
                return operation.getOperation();
            }
        }

        return null;
    }

    @Override
    public Character getOperationById(int id){
        for (Operations operation : Operations.values()){
            if (operation.getId() == id){
                return operation.getOperation();
            }
        }

        return null;
    }

    @Override
    public int size(){
        return Operations.values().length;
    }

    private enum Operations{
        SUM('+', 0, '0'),
        SUBTRACTION('-', 1, '1'),
        MULTIPLY('*', 2, '2'),
        DIVISION('/', 3, '3');

        private Character operation;
        private int id;
        private Character charId;

        Operations(Character operation, int id, Character charId){
            this.operation = operation;
            this.id = id;
            this.charId = charId;
        }

        public Character getOperation(){
            return operation;
        }

        public int getId(){
            return id;
        }

        public Character getCharId(){
            return charId;
        }
    }
}
