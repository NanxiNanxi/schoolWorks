 public static void main(String[] args) 
    {
        String[] name = {"Robin", "Jo", "Kelly", "Jaimie"};
        int[] midtermScore = {28, 78, 92, 83};
        int[] finalScore = {58, 75, 96, 79};
        int[] assignmentGrade = {33, 80, 90, 83};
        double[] finalGrade = getFinalGrades(midtermScore, finalScore, assignmentGrade);
        double average = ArrayMethods.average(finalGrade);
        
        System.out.println("Name\tMidterm\tFinal\tAssignment\tFinal Grades");
        for(int i = 0; i < finalScore.length; i++)
        {
            System.out.print(name[i] + "\t");
            System.out.print(midtermScore[i] + "\t");
            System.out.print(finalScore[i] + "\t");
            System.out.print(assignmentGrade[i] + "\t\t");
            System.out.printf("%.2f\n", finalGrade[i]);
        }
        System.out.printf("The average of the final grades is: %.2f\n", average);
        System.out.println("---------------------------------------------------");
        
        //create new arrays
        String[] newName = new String[6];
        int[] newMid = new int[6];
        int[] newFin = new int[6];
        int[] newAss = new int[6];
        System.arraycopy(name, 0, newName, 0, name.length);
        newName[4] = "Terry";
        newName[5] = "Kerry";
        System.arraycopy(midtermScore, 0, newMid, 0, midtermScore.length);
        newMid[4] = 86;
        newMid[5] = 71;
        System.arraycopy(finalScore, 0, newFin, 0, finalScore.length);
        newFin[4] = 76;
        newFin[5] = 75;
        System.arraycopy(assignmentGrade, 0, newAss, 0, assignmentGrade.length);
        newAss[4] = 91;
        newAss[5] = 78;
        double[] newFinGrades = getFinalGrades(newMid, newFin, newAss);
        double newAverage = ArrayMethods.average(newFinGrades);
        System.out.println("Name\tMidterm\tFinal\tAssignment\tFinal Grades");
        for(int i = 0; i < newFin.length; i++)
        {
            System.out.print(newName[i] + "\t");
            System.out.print(newMid[i] + "\t");
            System.out.print(newFin[i] + "\t");
            System.out.print(newAss[i] + "\t\t");
            System.out.printf("%.2f\n", newFinGrades[i]);
        }
        System.out.printf("The average of the new final grades is: %.2f\n", newAverage);
        System.out.println("---------------------------------------------------");
        
        //lowest and highest
        int minIndex = ArrayMethods.getMinIndex(newFinGrades);
        int maxIndex = ArrayMethods.getMaxIndex(newFinGrades);
        int passFrequency = findFrequency(newFinGrades, 60);
        System.out.printf("The highest grade is: " + newName[maxIndex] + " %.2f", newFinGrades[maxIndex]);
        System.out.printf("\nThe lowest grade is: " + newName[minIndex] + " %.2f", newFinGrades[minIndex]);
        System.out.println("\nThere are " + passFrequency + " students passed the class.");
        
    }
    public static double[] getFinalGrades(int[] mid, int[] fin, int[] ass)
    {
        double[] finalGrade = new double[mid.length];
        for(int i = 0; i < mid.length; i++)
        {
            finalGrade[i] =(double) .15 * ass[i] + .40 * mid[i] + .45*fin[i];
//            finalGrade[i] =Math.round( .15 * ass[i] + .40 * mid[i] + .45*fin[i])*100.0/100.0;
        }
        return finalGrade;
    }
    public static int findFrequency(double[] array, double value)
    {
        int frequency = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] >= value)
            {
                frequency++;
            }
        }
        return frequency;
    }
