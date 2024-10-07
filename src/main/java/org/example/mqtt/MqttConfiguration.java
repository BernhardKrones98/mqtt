package org.example.mqtt;

import java.util.logging.Logger;

public class MqttConfiguration {
    private static final Logger logger = Logger.getLogger(MqttConfiguration.class.getName());

    private final static String DEFAULT_BROKER = "tcp://test.mosquitto.org:1883";
    private final static String DEFAULT_TOPIC = "iotlv/bernhard/performance";

    private final String broker;
    private final String topic;
    public MqttConfiguration(String[] args) {
        if (args.length == 2) {
            broker = "tcp://"+args[0].replace("http://","")+":1883";
            topic = args[1];
            logConfig();
        }else {
            logger.info("Using default configuration");
            broker = DEFAULT_BROKER;
            topic = DEFAULT_TOPIC;
            logConfig();
        }
    }

    private void logConfig() {
        logger.info("broker set to: "+broker);
        logger.info("topic set to: "+topic);
    }

    public String getBroker() {
        return broker;
    }

    public String getTopic() {
        return topic;
    }
}
