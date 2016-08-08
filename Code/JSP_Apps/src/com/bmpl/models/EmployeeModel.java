package com.bmpl.models;

import java.util.ArrayList;

import com.bmpl.dto.EmployeeDTO;

public class EmployeeModel {
	ArrayList<EmployeeDTO> empList ; 
	public EmployeeModel(){
		this.empList = this.prepareData();
	}
	private ArrayList<EmployeeDTO> prepareData(){
		ArrayList<EmployeeDTO> empList = new ArrayList<>();
		for(int i = 1; i<=10 ; i++){
			empList.add(new EmployeeDTO(1000+i,"Ram"+i,2000*i));
		}
		return empList;
	}
	public ArrayList<EmployeeDTO> search(double salary){
		ArrayList<EmployeeDTO> searchResult = new ArrayList<>();
		for(int i = 0 ; i<empList.size(); i++){
			if(empList.get(i).getSalary()>=salary){
				searchResult.add(empList.get(i));
			}
		}
		return searchResult;
	}
	
}
