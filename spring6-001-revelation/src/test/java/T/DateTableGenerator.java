package T;

import com.powernode.spring6.bean.DateLoopVo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateTableGenerator {
    public static void main(String[] args) {
        DateLoopVo dateLoopVo001 =
                new DateLoopVo("abc",LocalDate.parse("2023-03-05",DateTimeFormatter.ISO_DATE),LocalDate.parse("2024-03-05",DateTimeFormatter.ISO_DATE));
        DateLoopVo dateLoopVo002 =
                new DateLoopVo("abc123",LocalDate.parse("2021-03-05",DateTimeFormatter.ISO_DATE),LocalDate.parse("2022-03-05",DateTimeFormatter.ISO_DATE));
        List<DateLoopVo>  dataLoops = new ArrayList<>();
        dataLoops.add(dateLoopVo001);
        dataLoops.add(dateLoopVo002);


        for(DateLoopVo dateLoopVo1 : dataLoops){
            //List<DateLoopVo> cars = new ArrayList<>();
            DateLoopVo car = new DateLoopVo();

            //获取数据
            String assetCode = dateLoopVo1.getAssetCode();
            LocalDate startDate = dateLoopVo1.getStartDate();
            LocalDate endDate = dateLoopVo1.getEndDate();

            LocalDate currentDate = startDate;
            //循环写入
            for (int i = 0; !currentDate.isAfter(endDate); i++) {
                car.setAssetCode(assetCode);
                //首次循环取start_date否则取上条end_date+1
                if(i == 0){
                    car.setStartDate(currentDate);
                }
                car.setStartDate(currentDate.plusDays(1));

                if (i == 0) {
                    car.setEndDate(currentDate.plusDays(45));
                    currentDate = currentDate.plusDays(45);
                } else {
                    car.setEndDate(currentDate.plusDays(30));
                    currentDate = currentDate.plusDays(30);
                }
                //cars.add(car);
                System.out.println(car);
            }
        }

    }
}
