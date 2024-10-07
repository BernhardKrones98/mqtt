package org.example.systemstats;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Cpu {

   private final RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();

    public double getCpuLoad(){
        long startTime = runtimeBean.getStartTime();
        long uptime = runtimeBean.getUptime();

        double load = (double) uptime / (System.currentTimeMillis() - startTime);
        return Math.round(load*100)/100.0;
    }
}
