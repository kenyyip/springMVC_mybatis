package com.keny.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.log4j.Logger;

public class MyBatisPlusGenerator {
    private static Logger logger = Logger.getLogger(MyBatisPlusGenerator.class);
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        logger.info(projectPath);
        // 整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig())
                .setPackageInfo(getPackageConfig());
        // 执行
        autoGenerator.execute();
    }

    /**
     * 全局配置
     *
     * @return GlobalConfig
     */
    public static GlobalConfig getGlobalConfig() {

        return new GlobalConfig()
                //输出目录
                .setOutputDir("E:\\workspaces-idea\\springMVC_mybatis\\src\\main\\java")
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setOpen(false)//生成后打开文件夹
                .setAuthor("keny")
                .setIdType(IdType.ASSIGN_UUID)
                //.setSwagger2(true)// 开启 swagger2 模式
                .setDateType(DateType.ONLY_DATE)// 时间类型对应策略
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                /*.setEntityName("%sEntity")*/;
    }

    /**
     * 数据源配置
     *
     * @return DataSourceConfig
     */
    public static DataSourceConfig getDataSourceConfig() {

        //Oracle 配置
        /*new DataSourceConfig().setUrl("jdbc:oracle:thin:@ip:端口:库名")
                .setDriverName("oracle.jdbc.driver.OracleDriver")
                //数据库登录名
                .setUsername("xxx")
                //数据库密码
                .setPassword("xxx")
                .setDbType(DbType.ORACLE);*/

        // MySql 配置
        //SSH的连接（useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false）
        return new DataSourceConfig().setUrl("jdbc:mysql://localhost:3306/permission?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                //数据库登录名
                .setUsername("root")
                //数据库密码
                .setPassword("root")
                .setDbType(DbType.MYSQL)
                /*.setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        if (fieldType.toLowerCase().contains("tinyint")) {
                            return DbColumnType.INTEGER;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                })*/;

    }

    /**
     * 策略配置
     *
     * @return StrategyConfig
     */
    public static StrategyConfig getStrategyConfig() {

        return new StrategyConfig()
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                //需要导入的表的名称
                .setInclude("t_sys_user")
                //需要导入表删除前缀（如：xxx_xx,删除完前缀是xx,只剩下表名）
                .setTablePrefix("t_")
                .setRestControllerStyle(true)
                .setEntityLombokModel(true);// 是否为lombok模型（默认 false）
    }

    /**
     * 包名策略配置
     *
     * @return PackageConfig
     */
    public static PackageConfig getPackageConfig() {

        return new PackageConfig().setParent("com.keny")
                //Dao层的文件
                .setMapper("mapper")
                //service层的文件
                .setService("service")
                .setServiceImpl("service.impl")
                //controller层的文件
                .setController("controller")
                //实体类的文件
                .setEntity("domain")
                //xml的文件
                .setXml("mapper");
    }

}
