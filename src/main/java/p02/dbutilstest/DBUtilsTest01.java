package p02.dbutilstest;

import org.apache.commons.dbutils.QueryRunner;
import utils.DruidUtils;

/**
 * @author: ymm
 * @date: 2022/5/24
 * @version: 1.0.0
 * @description:
 */
public class DBUtilsTest01 {

    // QueryRunner核心的创建方式
    public static void main(String[] args) {
        // 1.方式1：手动模式

        QueryRunner queryRunner = new QueryRunner();

        // 2.方式2：自动模式（提供数据库连接池对象，）
        QueryRunner queryRunner1 = new QueryRunner(DruidUtils.getDataSource());

    }
}
