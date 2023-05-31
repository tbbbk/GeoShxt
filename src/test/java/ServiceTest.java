import entity.HeterogeneousMineral;
import entity.HomogeneousMineral;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HeterogeneousMineralService;
import service.HomogeneousMineralService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ServiceTest {
    @Test
    public void injectData() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");
        HomogeneousMineralService homogeneousMineralService = (HomogeneousMineralService) context.getBean("homogeneousMineralService");
        String filePath = "src/main/resources/data/衔石填海-非均质矿物表.xlsx";
        String arg[] = new String[11];
        // 非均质
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            DataFormatter dataFormatter = new DataFormatter();
            // 获取第一个Sheet
            Sheet sheet = workbook.getSheetAt(1);
            for (int i = 18; i < 19; i++) {
                for (int j = 0; j <11; j++) {
                    // 获取指定位置的单元格
                    arg[j] = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                }
                HomogeneousMineral homogeneousMineral = new HomogeneousMineral(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5], arg[6], arg[7], arg[8], arg[9], arg[10], arg[0]);
                System.out.println(homogeneousMineral);
                homogeneousMineralService.insert(homogeneousMineral);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestID() {
        HeterogeneousMineral heterogeneousMineral = new HeterogeneousMineral();
        System.out.println(heterogeneousMineral.getId());
    }

    @Test
    public void HeterogeneousMineralServiceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");
        HeterogeneousMineralService heterogeneousMineralService = (HeterogeneousMineralService) context.getBean("HeterogeneousMineralService");

        HeterogeneousMineral heterogeneousMineral_1 = new HeterogeneousMineral();
        heterogeneousMineral_1.setName("尊尼获加");
        heterogeneousMineral_1.setDispersion("dispersion");
//        HeterogeneousMineral heterogeneousMineral_2 = new HeterogeneousMineral();
//        heterogeneousMineral_2.setName("娜美");
//        heterogeneousMineral_2.setMatch("match");
//        HeterogeneousMineral heterogeneousMineral_3 = new HeterogeneousMineral();
//        heterogeneousMineral_3.setName("电棍");
//        heterogeneousMineral_3.setLightSymbol("lightSymbol");
//
//        heterogeneousMineralService.insert(heterogeneousMineral_1);
//        heterogeneousMineralService.insert(heterogeneousMineral_2);
//        heterogeneousMineralService.insert(heterogeneousMineral_3);

//        heterogeneousMineralService.selectByCondition(heterogeneousMineral_3).forEach(System.out::println);

//        heterogeneousMineralService.selectAll().forEach(System.out::println);

//        HeterogeneousMineral heterogeneousMineral_test = heterogeneousMineralService.selectByCondition(heterogeneousMineral_1).get(0);
//        System.out.println(heterogeneousMineral_test);
        heterogeneousMineralService.delete(1);
        heterogeneousMineralService.delete(2);
        heterogeneousMineralService.delete(5);

//        heterogeneousMineral_1.setDoubleReflection("double");
//        heterogeneousMineralService.update(heterogeneousMineral_1);

        /**
         * BINGO!
         */
    }

    @Test
    public void HomogeneousServiceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");
        HomogeneousMineralService homogeneousMineralService = (HomogeneousMineralService) context.getBean("HomogeneousMineralService");

        HomogeneousMineral homogeneousMineral_1 = new HomogeneousMineral();
        HomogeneousMineral homogeneousMineral_2 = new HomogeneousMineral();
        HomogeneousMineral homogeneousMineral_3 = new HomogeneousMineral();
        homogeneousMineral_1.setName("腕豪");
        homogeneousMineral_2.setName("亚索");
        homogeneousMineral_3.setName("永恩");
        homogeneousMineral_1.setMarkHardness("111");
        homogeneousMineral_2.setMohsHardness("222");
        homogeneousMineral_3.setVickersHardness("333");

        homogeneousMineralService.insert(homogeneousMineral_1);
        System.out.println(homogeneousMineral_1.getId());

//        homogeneousMineralService.delete(3);
//        homogeneousMineralService.delete(2);
//        homogeneousMineralService.delete(4);
//        homogeneousMineralService.insert(homogeneousMineral_1);
//        homogeneousMineralService.insert(homogeneousMineral_2);
//        homogeneousMineralService.insert(homogeneousMineral_3);

//        homogeneousMineralService.selectAll().forEach(System.out::println);

//        homogeneousMineralService.selectByCondition(homogeneousMineral_1).forEach(System.out::println);

//        homogeneousMineralService.delete(homogeneousMineral_1.getName());

//        homogeneousMineral_2.setName("RICK");
//        homogeneousMineralService.update(homogeneousMineral_2);
    }
}
