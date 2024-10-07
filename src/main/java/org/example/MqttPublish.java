package org.example;


import org.eclipse.paho.client.mqttv3.*;
import org.example.mqtt.MqttConfiguration;
import org.example.mqtt.MqttConnector;
import org.example.systemstats.Cpu;
import org.example.systemstats.Memory;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MqttPublish {
    private static final Logger logger = Logger.getLogger(MqttPublish.class.getName());

    public static void main(String[] args) throws MqttException, InterruptedException {
        MqttConfiguration mqttConfiguration = new MqttConfiguration(args);

        Cpu cpu = new Cpu();
        Memory memory = new Memory();
        IMqttClient mqttClient = MqttConnector.connect(mqttConfiguration);

        while (true) {
            String message = String.format("{\"cpu_load\":%s,\"ram_free\":%s}", cpu.getCpuLoad(), memory.getFreeMemory());
            MqttMessage mqttMessage = getMqttMessage(message);
            mqttClient.publish(mqttConfiguration.getTopic(), mqttMessage);
            logger.info(message);
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }

    private static MqttMessage getMqttMessage(String message) {
        MqttMessage msg = new MqttMessage(message.getBytes(StandardCharsets.UTF_8));
        msg.setQos(0);
        msg.setRetained(true);
        return msg;
    }
}