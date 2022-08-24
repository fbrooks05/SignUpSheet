/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SEED;

/**
 *
 * @author Fisher
 */
public class SignUpSheet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    // use a for loop to look at the elements in the args array
    System.out.println("args.length: " + args.length);
    for ( int index = 0; index < args.length; index++ ) {
        System.out.println("args[ " + index + " ]: " + args[ index ]);
    }
    
    if (( args.length == 1 ) && (( args[ 0 ].equalsIgnoreCase("/?") == true ) || ( args[ 0 ].equalsIgnoreCase("/h") == true ))) {
        help(); // explicit call for help
    } else if ((args.length == 2) && (args[0].equalsIgnoreCase("/View") == true ) && (args[1].equalsIgnoreCase("/Active") == true )){
        //display all active student files
        System.out.println("View all Active students");
        displayActive();
    } else if ((args.length == 3) && (args[0].equalsIgnoreCase("/View") == true ) && (args[1].equalsIgnoreCase("/Event") == true )){
        //display all active student files
        System.out.println("View all Students for " + args[2]);
        displayEvent(args[2]);
    } else {
       help(); // implicit call for help
    }
    
    }
    
    public static void help() {
        System.out.println("Usage: ");
        System.out.println("    /h                  ...calls help");
        System.out.println("    /?                  ...calls help");
        System.out.println("    /View   /Active     ...Views all active students");
        System.out.println("    /View   /Event     <EventName>    ...Shows all students for a certain event");
    }
    
    public static void displayActive() {
        //System.out.println("SEED.SignUpSheet.displayActive()");
        java.io.File activeFolder = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Active");
        activeFolder.mkdirs();
        
        SEED.Registrant tempStudent = new SEED.Registrant();
        
        String studentContents = "";
        
        java.io.File[] activeContents;
        
        activeContents = readDir(activeFolder);
        
        if (activeContents != null) {
           // System.out.println("Contents not null");
            for (java.io.File f : activeContents) {
                //java.io.File inputFile = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Active");
                
                studentContents = importString(f);
                
                tempStudent = SEED.Registrant.importCustom(studentContents);
                
                if (tempStudent != null) {
                    System.out.println(tempStudent.exportCustom());
                } else {
                    System.out.println("Student object is invalid!");
                }
            }
        } else {
            System.out.println("Directory is empty!");
        }
    }
    
    public static void displayEvent(String eventName) {
        //System.out.println("SEED.SignUpSheet.displayActive()");
        java.io.File eventFolder = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Events\\" + eventName);
        eventFolder.mkdirs();
        
        SEED.Registrant tempStudent = new SEED.Registrant();
        
        String studentContents = "";
        
        java.io.File[] activeContents;
        
        activeContents = readDir(eventFolder);
        
        if (activeContents != null) {
           System.out.println("Contents not null");
            for (java.io.File f : activeContents) {
                //java.io.File inputFile = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Active");
                
                studentContents = importString(f);
                
                tempStudent = SEED.Registrant.importCustom(studentContents);
                
                if (tempStudent != null) {
                    System.out.println(tempStudent.exportCustom());
                } else {
                    System.out.println("Student object is invalid!");
                }
            }
        } else {
            System.out.println("Directory is empty!");
        }
    }
    
    public static java.io.File[] readDir(java.io.File inputFile) {
        java.io.File[] contents = inputFile.listFiles();
        
        if (contents != null) {
            for (java.io.File f : contents) {
                //System.out.println(f.getName());
            }
//            System.out.println("Contents of " + inputFile.toString() + " are not equal to null");
        } else {
            System.out.println("Directory is empty!");
        }
        
        return( contents );
    }
    
    private static String importString( java.io.File inputFile ) {
        String results = "";
        String line = "";
        java.io.FileReader inputFileReader;
        java.io.BufferedReader inputBufferedReader;       
        
        try {
            if (inputFile.exists() == true) {
                inputFileReader = new java.io.FileReader(inputFile);
                inputBufferedReader = new java.io.BufferedReader(inputFileReader);
                
                while ((line = inputBufferedReader.readLine()) != null) {
                    results += line + '\n'; // appends the contents line by line.
                }
                
                inputBufferedReader.close();
            } else {
                results = "";
            }
        } catch (java.lang.Exception ex) {
            System.out.println( ex.toString() );
        }
        
        return( results );
    } 
    
}
