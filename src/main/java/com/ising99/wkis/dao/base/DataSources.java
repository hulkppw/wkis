package com.ising99.wkis.dao.base;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * Created by jerry on 2014/7/3.
 */
public class DataSources extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceSwitch.getDataSourceType();
    }
    //配置于applicationContext 中，线程局部变量ThreadLocal contextHolder 保存当前需要的数据源类型，当 DataSourceSwitch.setDataSourceType(DataSourceInstances.XXX)
    // 保存当前需要的数据源类型的时候，DataSources 会从当前线程中查找线程变量的数据源类型，从而决定使用何种数据源
}
