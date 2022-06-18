package com.amid.distributed.spring.message.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * @author Dmytro Melnychuk
 */
public class PollableChannelInterceptor extends ChannelInterceptorAdapter {

    private final Logger log = LogManager.getLogger(PollableChannelInterceptor.class);

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.info("-- Intercepted message: " + message.getHeaders().get("messageId"));
        return super.preSend(message, channel);
    }
}
