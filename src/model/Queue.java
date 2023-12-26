/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class Queue {
    private List<ProcessSimulator> processes;

    public Queue(List<ProcessSimulator> processes) {
        this.processes = processes;
    }

    // Methods to manage processes in the queue
    public void addProcess(ProcessSimulator process) { 
    /* Add process to the queue */ 
    }
    
    public ProcessSimulator getNextProcess() { 
        /* Get next process based on scheduling algorithm */ 
        return null;
    }
    
    // Other queue management methods
    
    public void removeProcess(ProcessSimulator currentProcess){}
}
