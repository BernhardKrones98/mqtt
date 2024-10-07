package org.example.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class MqttConnector {

    public static IMqttClient connect(MqttConfiguration mqttConfiguration) throws MqttException {
        String publisherId = UUID.randomUUID().toString();
        IMqttClient mqttClient = new MqttClient(mqttConfiguration.getBroker(), publisherId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        mqttClient.connect(options);
        return mqttClient;
    }
}
