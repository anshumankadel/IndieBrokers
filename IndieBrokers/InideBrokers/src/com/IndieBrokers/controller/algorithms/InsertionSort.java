/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IndieBrokers.controller.algorithms;

import com.IndieBrokers.model.IndieBrokersModel;
import java.util.List;

/**
 *
 * @author forea
 */
public class InsertionSort {
    
    public InsertionSort(){
        
    }
    
    public List<IndieBrokersModel>  sortalphabetically(List<IndieBrokersModel> BrokersList){
        return sort(BrokersList, true);
    }
    
    public List<IndieBrokersModel> sortReverseAlphabetically(List<IndieBrokersModel> BrokersList) {
        return sort(BrokersList, false);
    }
    
    private List<IndieBrokersModel> sort(List<IndieBrokersModel> BrokersList, boolean ascending) {
        for (int i = 1; i < BrokersList.size(); i++) {
            IndieBrokersModel key = BrokersList.get(i);
            int insertPosition = findInsertPosition(BrokersList, key, i, ascending);
            shiftRight(BrokersList, insertPosition, i);
            BrokersList.set(insertPosition, key);
        }
        return BrokersList;
    }
    
    private int findInsertPosition(List<IndieBrokersModel> BrokersList, IndieBrokersModel key, int endIndex, boolean ascending) {
        int j = endIndex - 1;
        while (j >= 0 && shouldSwap(BrokersList.get(j), key, ascending)) {
            j--;
        }
        return j + 1; // Return the insert position
    }
    
    private boolean shouldSwap(IndieBrokersModel a, IndieBrokersModel b, boolean ascending) {
        int comparison = a.getBrokername().compareTo(b.getBrokername());
        return ascending ? comparison > 0 : comparison < 0;
    }

    private void shiftRight(List<IndieBrokersModel> BrokersList, int start, int end) {
        for (int k = end; k > start; k--) {
            BrokersList.set(k, BrokersList.get(k - 1));
        }
    }

}
