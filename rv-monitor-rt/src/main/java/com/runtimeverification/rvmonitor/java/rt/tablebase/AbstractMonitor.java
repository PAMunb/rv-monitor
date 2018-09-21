package com.runtimeverification.rvmonitor.java.rt.tablebase;

import com.runtimeverification.rvmonitor.java.rt.RVMObject;

public abstract class AbstractMonitor implements IMonitor, RVMObject {
        public long RVM_timestamp;

        public AbstractMonitor() {
          this.RVM_timestamp = System.currentTimeMillis();
        }

	/**
	 * Terminates this monitor instance. The actual code depends on the specification and,
	 * therefore, is to be implemented in the generated code.
	 * @param treeid
	 */
	protected abstract void terminateInternal(int treeid);

        protected Object clone() throws CloneNotSupportedException {
                AbstractMonitor ret = (AbstractMonitor) super.clone();
                ret.RVM_timestamp = System.currentTimeMillis();
                return ret;
        }

	@Override
	public String toString() {
		String r = this.getClass().getSimpleName();
		r += "#" + System.identityHashCode(this);
		return r;
	}
}
