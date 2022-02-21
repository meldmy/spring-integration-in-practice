package com.amid.distributed.spring.gateway;

import com.amid.distributed.spring.DistributedSpringAppApplication;
import com.amid.distributed.spring.entity.BankAsset;
import com.amid.distributed.spring.entity.Credit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

/**
 * @author Dmytro Melnychuk
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DistributedSpringAppApplication.class)
public class GatewaySenderTest {

    private static final BankAsset DUMMY_PAYLOAD = new Credit();
    @MockBean
    private BankOperationsGateway gateway;

    @Autowired
    private GatewaySender gatewaySender;

    @Test
    public void shouldSendMessageByTheProperMethodWhenMessageCounterDividedByFive() {
        doNothing().when(gateway).printDevidedByFive(any());
        var givenCreditMessage = createMessageWith(5);

        gatewaySender.sentMessage(givenCreditMessage);

        verify(gateway, only()).printDevidedByFive(givenCreditMessage);
    }

    @Test
    public void shouldSendMessageByTheProperMethodWhenMessageCounterIsNotDividedByFive() {
        doNothing().when(gateway).print(any());

       var givenCreditMessage = createMessageWith(1);

        gatewaySender.sentMessage(givenCreditMessage);

        verify(gateway, only()).print(givenCreditMessage);
    }

    private Message<BankAsset> createMessageWith(int counterValue) {
        return MessageBuilder.withPayload(DUMMY_PAYLOAD)
                .setHeader("counter", counterValue)
                .build();
    }
}