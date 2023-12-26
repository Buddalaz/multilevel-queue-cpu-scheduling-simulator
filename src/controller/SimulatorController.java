/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Collections;
import java.util.List;
import model.ProcessSimulator;

/**
 *
 * @author ASUS
 */
public class SimulatorController {

    public static void calculateFCFS(List<ProcessSimulator> processes) {
        int n = processes.size();
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        // Waiting time for the first process is 0
        waitingTime[0] = 0;

        // Calculating waiting time
        for (int i = 1; i < n; i++) {
            waitingTime[i] = processes.get(i - 1).getBurstTime() + waitingTime[i - 1];
        }

        // Calculating turnaround time
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = processes.get(i).getBurstTime() + waitingTime[i];
        }

        // Displaying results in console
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + processes.get(i).getProcessId()
                    + "  Complete Time: " + turnaroundTime[i]
                    + "  Waiting Time: " + waitingTime[i]
                    + "  Turnaround Time: " + turnaroundTime[i]);
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }

        avgWaitingTime /= n;
        avgTurnaroundTime /= n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void calculateSJF(List<ProcessSimulator> processes) {
        int n = processes.size();
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        // Sort processes based on burst time (SJF)
        Collections.sort(processes, (p1, p2) -> p1.getBurstTime() - p2.getBurstTime());

        // Waiting time for the first process is 0
        waitingTime[0] = 0;

        // Calculating waiting time
        for (int i = 1; i < n; i++) {
            waitingTime[i] = processes.get(i - 1).getBurstTime() + waitingTime[i - 1];
        }

        // Calculating turnaround time
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = processes.get(i).getBurstTime() + waitingTime[i];
        }

        // Displaying results in console
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + processes.get(i).getProcessId()
                    + "  Complete Time: " + turnaroundTime[i]
                    + "  Waiting Time: " + waitingTime[i]
                    + "  Turnaround Time: " + turnaroundTime[i]);
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }

        avgWaitingTime /= n;
        avgTurnaroundTime /= n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void calculateSRTF(List<ProcessSimulator> processes) {
        int n = processes.size();
        int[] remainingTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        // Copy burst times to remainingTime array
        for (int i = 0; i < n; i++) {
            remainingTime[i] = processes.get(i).getBurstTime();
        }

        int complete = 0, shortest = Integer.MAX_VALUE, shortestIndex = 0;
        boolean check = false;

        // Calculate completion time
        int currentTime = 0;
        while (complete != n) {
            for (int i = 0; i < n; i++) {
                if (processes.get(i).getArrivalTime() <= currentTime && remainingTime[i] < shortest && remainingTime[i] > 0) {
                    shortest = remainingTime[i];
                    shortestIndex = i;
                    check = true;
                }
            }

            if (!check) {
                currentTime++;
                continue;
            }

            remainingTime[shortestIndex]--;

            if (remainingTime[shortestIndex] == 0) {
                complete++;
                check = false;
                int finishTime = currentTime + 1;
                turnaroundTime[shortestIndex] = finishTime - processes.get(shortestIndex).getArrivalTime();
                waitingTime[shortestIndex] = finishTime - processes.get(shortestIndex).getBurstTime() - processes.get(shortestIndex).getArrivalTime();

                if (waitingTime[shortestIndex] < 0) {
                    waitingTime[shortestIndex] = 0;
                }
            }

            currentTime++;
            shortest = Integer.MAX_VALUE;
        }

        // Displaying results in console
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + processes.get(i).getProcessId()
                    + "  Complete Time: " + (processes.get(i).getArrivalTime() + turnaroundTime[i])
                    + "  Waiting Time: " + waitingTime[i]
                    + "  Turnaround Time: " + turnaroundTime[i]);
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }

        avgWaitingTime /= n;
        avgTurnaroundTime /= n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void roundRobinScheduling(List<ProcessSimulator> processes, int timeQuantum) {
        int n = processes.size();
        int[] remainingTime = new int[n];
        int[] completionTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        for (int i = 0; i < n; i++) {
            remainingTime[i] = processes.get(i).getBurstTime();
        }

        int currentTime = 0;
        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (remainingTime[i] > 0) {
                    done = false;

                    if (remainingTime[i] > timeQuantum) {
                        currentTime += timeQuantum;
                        remainingTime[i] -= timeQuantum;
                    } else {
                        currentTime += remainingTime[i];
                        completionTime[i] = currentTime;
                        remainingTime[i] = 0;
                    }
                }
            }

            if (done) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i] - processes.get(i).getArrivalTime();
            waitingTime[i] = turnaroundTime[i] - processes.get(i).getBurstTime();
        }

        // Displaying results in console
        System.out.println("Process\tArrival\tBurst\tComplete\tWaiting\tTurnaround");
        for (int i = 0; i < n; i++) {
            System.out.println(processes.get(i).getProcessId() + "\t"
                    + processes.get(i).getArrivalTime() + "\t"
                    + processes.get(i).getBurstTime() + "\t"
                    + completionTime[i] + "\t\t"
                    + waitingTime[i] + "\t\t"
                    + turnaroundTime[i]);
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }

        avgWaitingTime /= n;
        avgTurnaroundTime /= n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
