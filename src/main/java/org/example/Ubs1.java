package org.example;

import org.apache.commons.lang3.StringUtils;

public class Ubs1 {
    public void test_stringDistance() throws Exception {
        String teamName = "Partizan Belgradeis";
        String propositionName = "Partizan Belgradeis walking in the steet with is dog walking in the steet with is dog walking in the steet with is dog";

        // This one seems better
        double distance = StringUtils.getJaroWinklerDistance(teamName, propositionName);
        System.out.println(distance);
    }
    public static void main(String args[]) throws Exception {
        Ubs1 ubs1=new Ubs1();
        ubs1.test_stringDistance();
    }
}
