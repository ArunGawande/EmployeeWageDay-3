package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeWage
{
    //constants
    public static final int IS_FULL_TIME=1;
    public static final int IS_PART_TIME=2;
    int daySalary;
    //list
    ArrayList<Integer> dailyWage = new ArrayList<Integer>();
    ArrayList<CompanyEmpWage> CompanyEmpWageArrayList;
    HashMap<String, CompanyEmpWage> CompanyEmpWageMap;

    public EmployeeWageOops() {
        CompanyEmpWageArrayList = new ArrayList<>();
        CompanyEmpWageMap = new HashMap<>();
    }

    public void dailyWage() {
        dailyWage.add(daySalary);
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
        CompanyEmpWageArrayList.add(companyEmpWage);
        CompanyEmpWageMap.put(company, companyEmpWage);
    }

    public void computeEmpWage() {
        for(int i=0;i<CompanyEmpWageArrayList.size();i++) {
            CompanyEmpWage companyEmpWage = CompanyEmpWageArrayList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        while(totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {
            totalWorkingDays++;
            double empCheck = Math.floor(Math.random() * 10) % 3;
            switch ((int) empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            int daySalary = empHrs * companyEmpWage.empRatePerHr;
            companyEmpWage.dailyWage.add(daySalary);
            totalEmpHrs += empHrs;
            System.out.println("totalWorkingDays: " + totalWorkingDays + "/ daily empHrs: " + empHrs + "/ totalEmpHrs: " + totalEmpHrs);
        }
        System.out.println("\nTotal emp wage : " +  (totalEmpHrs * companyEmpWage.empRatePerHr) + "\n");
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    }

    public int getTotalEmpWage(String company) {
        return CompanyEmpWageMap.get(company).totalEmpWage;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //object s
        System.out.println("enter the company name");
        String no1= s.nextLine();
        //variable no1 no2
        EmployeeWageOops empWageBuilder = new EmployeeWageOops();
        empWageBuilder.addCompanyEmpWage(no1, 50, 20, 100);
        String no2= s.next();
        empWageBuilder.addCompanyEmpWage(no2, 40, 20, 100);
        String no3= s.next();
        empWageBuilder.addCompanyEmpWage(no3, 30, 20, 100);
        String no4= s.next();
        empWageBuilder.addCompanyEmpWage(no4, 30, 20, 100);
        String no5= s.next();
        empWageBuilder.addCompanyEmpWage(no5, 50, 20, 100);
        empWageBuilder.computeEmpWage();
        System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage(no1));
        System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage(no2));
        System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage(no3));
        System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage(no4));
        System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage(no5));

    } //main
}
