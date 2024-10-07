package org.example.systemstats;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class Memory {
    private final OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    public long getFreeMemory(){
        long freeMemoryBytes = osBean.getFreeMemorySize();
        return freeMemoryBytes / (1024 * 1024);
    }
}
