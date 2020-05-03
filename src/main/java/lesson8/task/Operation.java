package lesson8.task;

public class Operation {

    String x;
    String y;
    String operation;
    String result;

    public Operation(String x, String y, String operation, String result) {
        this.x = x;
        this.y = y;
        this.operation = operation;
        this.result = result;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        return result;
    }
}