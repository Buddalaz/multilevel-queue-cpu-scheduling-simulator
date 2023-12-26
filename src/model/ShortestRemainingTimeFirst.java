/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class ShortestRemainingTimeFirst extends Scheduler {

    public ShortestRemainingTimeFirst() {
        super();
    }
    
    @Override
    public ProcessSimulator executeScheduling() {
        ProcessSimulator shortestProcess = null;
        int shortestTime = Integer.MAX_VALUE;

        for (Queue queue : queues) {
            ProcessSimulator currentProcess = queue.getNextProcess();
            if (currentProcess != null) {
                int remainingTime = currentProcess.getBurstTime();
                if (remainingTime < shortestTime) {
                    shortestTime = remainingTime;
                    shortestProcess = currentProcess;
                }
            }
        }

        if (shortestProcess != null) {
            shortestProcess.setBurstTime(0);
            queues.get(shortestProcess.getArrivalTime()).removeProcess(shortestProcess);
        }

        return shortestProcess;
    }
    
}
