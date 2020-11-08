package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {

    private static final EcoSystem system = EcoSystem.getInstance();
    
    public static EcoSystem configure(){
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
}
