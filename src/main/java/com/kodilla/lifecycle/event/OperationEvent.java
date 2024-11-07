package com.kodilla.lifecycle.event;

import org.springframework.context.ApplicationEvent;

public class OperationEvent extends ApplicationEvent {
    private String operationType;
    private double operand1;
    private double operand2;
    private double result;

    public OperationEvent(Object source, String operationType, double operand1, double operand2, double result) {
        super(source);
        this.operationType = operationType;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    public String getOperationType() {
        return operationType;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public double getResult() {
        return result;
    }
}
