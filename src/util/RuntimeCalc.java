package util;

/**
 * Calculates the execution time duration of the application in nanoseconds. 
 * Overriding toString() method shows the result in unit seconds. Results will 
 * vary after every execution, but they are used for benchmark.
 * 
 * Idea: creating a benchmark for how long it takes to encrypt or decrypt contents 
 * based on cryptographic technique and/or the amount of text for use.
 * 
 * @author Joseph R.
 * @since May 12, 2020
 */
public class RuntimeCalc {
    private final long startTime;
    private long endTime;
    private long execTime;
    
    public RuntimeCalc() {
        this.startTime = System.nanoTime();
    }
    
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    public void setExecTime(long execTime) {
        this.execTime = execTime;
    }
    
    public long getStartTime() {
        return this.startTime;
    }
    
    public long getEndTime() {
        return this.endTime;
    }
    
    public long getExecTime() {
        return this.execTime;
    }
    
    @Override
    public String toString() {
        return "EXECUTION TIME = " + (this.execTime / 1_000_000_000) + " SECONDS";
    }
}
