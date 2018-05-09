package com.runtimeverification.rvmonitor.java.rvj.output.monitorset;

import com.runtimeverification.rvmonitor.java.rvj.output.RVMVariable;
import com.runtimeverification.rvmonitor.java.rvj.output.monitor.SuffixMonitor;

/**
 *
 */
public class MonitorSetFactory {
    private final RVMVariable factoryName;
    private final RVMVariable monitorName;
    private final RVMVariable setName;
    public MonitorSetFactory(SuffixMonitor monitor) {
        this.monitorName = monitor.getOutermostName();
        this.factoryName = new RVMVariable(monitorName + "SetFactory");
        this.setName = new RVMVariable(monitorName + "_Set");
    }

    @Override
    public String toString() {
        String ret = "final class " + this.factoryName + " extends java.lang.rv.RuntimeMonitorFactory{\n";
        ret += "public Object createMonitor(){\n";
        ret += "return new " + this.setName + "()\n";
        ret += "}\n";
        ret += "}\n";
        return ret;
    }
}
