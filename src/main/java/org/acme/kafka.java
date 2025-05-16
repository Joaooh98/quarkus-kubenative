package org.acme;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.quarkus.logging.Log;
import jakarta.transaction.Transactional;

public class kafka {

    @Transactional
    @Incoming("power")
    public void consumerPowe(DevicePower power) {
        Log.info("update device" + power.device + " power " + power.power);

        DevicePower.persist(power);
    }
}
