/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
abstract class Scheduler {
    protected List<Queue> queues;

    public Scheduler() {
        queues = new ArrayList<>(); // Initialize queues
        // Initialize queues based on priority levels, e.g., queues.add(new Queue());
    }

    public void addProcessToQueue(ProcessSimulator process, int priority) {
        queues.get(priority).addProcess(process);
    }

    // Abstract method for executing scheduling algorithm
    public abstract ProcessSimulator executeScheduling();

    public ProcessSimulator getNextProcessForExecution() {
        for (Queue queue : queues) {
            ProcessSimulator nextProcess = queue.getNextProcess();
            if (nextProcess != null) {
                return nextProcess;
            }
        }
        return null;
    }
}
