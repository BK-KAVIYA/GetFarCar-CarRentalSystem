
package com.getfarcars.maintanance;

import com.getfarcar.common.*;
import java.util.List;

/**
 *
 * @author sanjeewa
 */
public interface MaintananceDAO {
    public void Add(CarMaintanance car_maintanance);
    public void Update(CarMaintanance car_maintanance);
    public void Delete(CarMaintanance car_maintanance);
    public CarMaintanance Serch(String M_ID);
    public List<CarMaintanance> list(String tableName);
    public List<CarMaintanance> CarMaintanancelist();
}
