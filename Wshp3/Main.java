public class Main {
    
    public static void main(String[] args){
        Patient p1 = new Patient();
        p1.age = 30;
        p1.name = "Jhon";
        p1.condition = "Cancer";
        p1.id = "1232132323";
        p1.lifeExpectancy = "less than 3 years";

        System.out.println("Patient: " + p1.name + " Age: " + p1.age + " Condition: " + 
        p1.condition + " ID: " + p1.id + " Life expectancy: " + p1.lifeExpectancy );
    
    }
}
