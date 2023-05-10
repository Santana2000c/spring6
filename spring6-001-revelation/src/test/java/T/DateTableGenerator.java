package T;

import com.powernode.spring6.vo.DateLoopCarVo;
import com.powernode.spring6.vo.DateLoopVo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateTableGenerator {
    public static void main(String[] args) {
        DateLoopVo dateLoopVo001 =
                new DateLoopVo("abc",LocalDate.parse("2023-03-05",DateTimeFormatter.ISO_DATE),LocalDate.parse("2024-03-05",DateTimeFormatter.ISO_DATE)
                        ,LocalDate.parse("2023-05-05",DateTimeFormatter.ISO_DATE));
        List<DateLoopVo>  dataLoops = new ArrayList<>();
        dataLoops.add(dateLoopVo001);


        for(DateLoopVo dateLoopVo1 : dataLoops){
            //DateLoopVo car = new DateLoopVo();
            DateLoopCarVo car = new DateLoopCarVo();


            //获取数据
            String assetCode = dateLoopVo1.getAssetCode();
            LocalDate startDate = dateLoopVo1.getStartDate();
            LocalDate endDate = dateLoopVo1.getEndDate();
            LocalDate packetDate = dateLoopVo1.getPacketDate();

            LocalDate currentDate = startDate;
            LocalDate currentDate1 = packetDate;

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
                car.setPacketStatus(0);
                System.out.println(car);
            }

            for (int i = 0; !currentDate1.isAfter(endDate); i++) {
                car.setAssetCode(assetCode);
                //首次循环取start_date否则取上条end_date+1
                if(i == 0){
                    car.setStartDate(currentDate1);
                }
                car.setStartDate(currentDate1.plusDays(1));

                if (i == 0) {
                    car.setEndDate(currentDate1.plusDays(45));
                    currentDate1 = currentDate1.plusDays(45);
                } else {
                    car.setEndDate(currentDate1.plusDays(30));
                    currentDate1 = currentDate1.plusDays(30);
                }
                car.setPacketStatus(1);
                System.out.println(car);
            }
        }

    }
}
