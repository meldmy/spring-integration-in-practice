package com.amid.distributed_spring.interceptor;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * @author Dmytro Melnychuk
 */
public class InboundChannelInterceptor extends ChannelInterceptorAdapter {

    private final Logger log = Logger.getLogger(InboundChannelInterceptor.class);

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.info("-- Intercepted message: " + message.getHeaders().get("messageId"));
        return super.preSend(message, channel);
    }
}
