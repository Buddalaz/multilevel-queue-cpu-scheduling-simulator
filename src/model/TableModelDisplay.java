/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class TableModelDisplay {
    private int completeTime;
    private int waitingTime;
    private int turnAroundTime;
    private double averageWaitingTime;
    private double avarageTurnAroundTime;

    public TableModelDisplay(int completeTime, int waitingTime, int turnAroundTime) {
        this.completeTime = completeTime;
        this.waitingTime = waitingTime;
        this.turnAroundTime = turnAroundTime;
    }

    public int getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(int completeTime) {
        this.completeTime = completeTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public double getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public void setAverageWaitingTime(double averageWaitingTime) {
        this.averageWaitingTime = averageWaitingTime;
    }

    public double getAvarageTurnAroundTime() {
        return avarageTurnAroundTime;
    }

    public void setAvarageTurnAroundTime(double avarageTurnAroundTime) {
        this.avarageTurnAroundTime = avarageTurnAroundTime;
    }
   
}
