package com.amid.distributed.spring.gateway;

import com.amid.distributed.spring.entity.BankAsset;
import com.amid.distributed.spring.entity.Credit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.mockito.Mockito.*;

/**
 * @author Dmytro Melnychuk
 */
@RunWith(MockitoJUnitRunner.class)
public class GatewaySenderTest {

    private static final BankAsset DUMMY_PAYLOAD = new Credit();
    @Mock
    private BankOperationsGateway gateway;
    @InjectMocks
    private GatewaySender gatewaySender;

    @Test
    public void shouldSendMessageByTheProperMethodWhenMessageCounterDividedByFive() {
        Message<BankAsset> givenCreditMessage = createMessageWith(5);

        gatewaySender.sentMessage(givenCreditMessage);

        verify(gateway, only()).printDevidedByFive(givenCreditMessage);
        verify(gateway, atLeastOnce()).printDevidedByFive(givenCreditMessage);
    }

    @Test
    public void shouldSendMessageByTheProperMethodWhenMessageCounterIsNotDividedByFive() {
        Message<BankAsset> givenCreditMessage = createMessageWith(1);

        gatewaySender.sentMessage(givenCreditMessage);

        verify(gateway, only()).print(givenCreditMessage);
        verify(gateway, atLeastOnce()).print(givenCreditMessage);
    }

    private Message<BankAsset> createMessageWith(int counterValue) {
        return MessageBuilder.withPayload(DUMMY_PAYLOAD)
                .setHeader("counter", counterValue)
                .build();
    }
}