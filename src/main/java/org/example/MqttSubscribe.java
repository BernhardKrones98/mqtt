package org.example;


import org.eclipse.paho.client.mqttv3.*;
import org.example.mqtt.MqttConfiguration;
import org.example.mqtt.MqttConnector;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.logging.Logger;

public class MqttSubscribe {
    private static final Logger logger = Logger.getLogger(MqttSubscribe.class.getName());

    public static void main(String[] args) throws MqttException {

        MqttConfiguration mqttConfiguration = new MqttConfiguration(args);

        IMqttClient mqttClient = MqttConnector.connect(mqttConfiguration);

        mqttClient.subscribe(mqttConfiguration.getTopic(), (topic1, msg) -> {
            String message = new String(msg.getPayload(), StandardCharsets.UTF_8);
            logger.info("Received message from topic: " + topic1);
            logger.info("Message: " + message);
        });

        logger.info("Listening to topic: " + mqttConfiguration.getTopic());
        while (true) {
            mqttClient.isConnected();
        }
    }
}