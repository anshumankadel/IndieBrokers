/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IndieBrokers.controller.algorithms;

import com.IndieBrokers.model.IndieBrokersModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author forea
 */
public class SelectionSort {
    List <IndieBrokersModel>  BrokerSortList;
    
    public SelectionSort(){
        BrokerSortList = new ArrayList<>();
    }
    /**
     * Sorts a list of StudentModel objects by their LMU ID in ascending or
     * descending order.
     *
     * @param studentList the list of StudentModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<IndieBrokersModel> sortByBrokerID(List<IndieBrokersModel> BrokersList, boolean isDesc) {
        this.BrokerSortList.clear();
        this.BrokerSortList.addAll(BrokersList);
        if (BrokerSortList == null || BrokerSortList.isEmpty()) {
            throw new IllegalArgumentException("Student list cannot be null or empty.");
        }

        for (int i = 0; i < BrokerSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(BrokerSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(BrokerSortList, i, extremumIndex);
            }
        }

        return BrokerSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param studentSortList the list of StudentModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<IndieBrokersModel> BrokerSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < BrokerSortList.size(); j++) {
            if (shouldSwap(BrokerSortList.get(j).getBrokerID(), BrokerSortList.get(extremumIndex).getBrokerID(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param studentSortList the list of StudentModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<IndieBrokersModel> BrokerSortList, int i, int j) {
        IndieBrokersModel temp = BrokerSortList.get(i);
        BrokerSortList.set(i, BrokerSortList.get(j));
        BrokerSortList.set(j, temp);
    }
    
}
