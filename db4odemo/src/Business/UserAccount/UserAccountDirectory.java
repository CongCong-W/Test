/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * @author raunak
 */
public class UserAccountDirectory {

    private final ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)) {
                return ua;
            }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }

    public void insert(UserAccount entity) {
        userAccountList.add(entity);
    }

    public int update(UserAccount userAccount) {
        int target = -1;
        for (int i = 0; i < userAccountList.size(); i++) {
            if (userAccountList.get(i).getEmployee().getId() == userAccount.getEmployee().getId()) {
                target = i;
            }
        }
        if (target < 0) {
            return target;
        }
        userAccountList.set(target, userAccount);
        return target;
    }

    public void delete(UserAccount userAccount) {
        userAccountList.remove(userAccount);
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
