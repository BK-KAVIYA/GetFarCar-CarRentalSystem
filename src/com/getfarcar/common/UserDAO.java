
package com.getfarcar.common;

import java.util.List;

/**
 *
 * @author KA VI YA
 */
public interface UserDAO {
    public void Add(User user,String tableName);
    public void Update(User user,String tableName);
    public void Delete(User user,String tablename);
    public User Serch(String userID);
    public List<User> list(String tableName);
    public List<User> Userlist();
}
