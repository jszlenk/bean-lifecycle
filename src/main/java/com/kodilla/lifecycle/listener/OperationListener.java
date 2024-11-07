package com.kodilla.lifecycle.listener;

import com.kodilla.lifecycle.event.OperationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OperationListener implements ApplicationListener<OperationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(OperationListener.class);

    @Override
    public void onApplicationEvent(OperationEvent event) {
        logger.info("Operation '{}' performed with operands {} and {}. Result: {}",
                event.getOperationType(),
                event.getOperand1(),
                event.getOperand2(),
                event.getResult());
    }
}
