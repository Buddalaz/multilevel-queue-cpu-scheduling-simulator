/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class FirstComeFirstServe extends Scheduler{

    public FirstComeFirstServe() {
        super();
    }
    
    @Override
    public ProcessSimulator executeScheduling() {
        for (Queue queue : queues) {
            ProcessSimulator currentProcess = queue.getNextProcess();
            if (currentProcess != null) {
                queue.removeProcess(currentProcess);
                return currentProcess;
            }
        }
        return null;
    }
    
}
