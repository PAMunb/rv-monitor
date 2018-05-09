package com.runtimeverification.rvmonitor.java.rvj.output.monitor;

import com.runtimeverification.rvmonitor.java.rvj.output.RVMVariable;

/**
 *
 */
public class MonitorFactory {
    private final RVMVariable factoryName;
    private final RVMVariable monitorName;

    public MonitorFactory(SuffixMonitor monitor) {
        this.monitorName = monitor.getOutermostName();
        this.factoryName = new RVMVariable(monitorName + "Factory");
    }

    @Override
    public String toString() {
        String ret = "final class " + this.factoryName + " extends java.lang.rv.RuntimeMonitorFactory{\n";
        ret += "public Object createMonitor(){\n";
        ret += "return new " + this.monitorName + "()\n";
        ret += "}\n";
        ret += "}\n";
        return ret;
    }
}
