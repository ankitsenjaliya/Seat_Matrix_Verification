
public class ConverterClass {
    
    private final String[] queries = new String[20];
    private final String[] instruction = new String[20];
    private final String[] activation = new String[20];
    private int maxQueryCapacity;
    public enum stringType{
        query, instruction, activation
    }
    
    public StringProcessor(){
        
        setMaxQueryCapacity();
        populateQueries();
        populateInstructions();
        populateActivations();
    }
    private void setMaxQueryCapacity(){
        maxQueryCapacity = 100;
    }
    
    
    private void ledActivations(){
        activation[0] = "On";
        activation[1] = "Off";
    }
  

    
    
    
    public int processString(String message){
        stringType type = checkType(message);
        System.out.println(type);
        int code = -1;
        switch(type){
            case query:
                code = commandProcess(message);
                break;
            case activation:
                code = ledActivation(message);
                break;             
        }
        return code;
    }
    private stringType checkType(String message){
        if(message.contains("?")){
            return stringType.query;
        }
        else if(message.length()<=10){
            return stringType.activation;
            
        }
    }
    
    private int commandProcess(String message){
        Boolean found = false;
        int i;
        for(i=0; i<queries.length; i++){
            if(queries[i].equals(message)){
                found = true;
                break;
            }
        }
        if(found){
            return i;
        }
        else{
            return -1;
        }
    }
    
    private int processInstruction(String message){
        Boolean found = false;
        int i;
        for(i=0; i<instruction.length; i++){
            if(instruction[i].equals(message)){
                found = true;
                break;
            }
        }
        if(found){
            return i + maxQueryCapacity;
        }
        else{
            return -1;
        }
    }
    
    private int processActivation(String message){
        Boolean found = false;
        int i;
        for(i=0; i<activation.length; i++){
            if(activation[i].equals(message)){
                found = true;
                break;
            }
        }
        if(found){
            return i + 2*maxQueryCapacity;
        }
        else{
            return -1;
        }
    }
    
}
