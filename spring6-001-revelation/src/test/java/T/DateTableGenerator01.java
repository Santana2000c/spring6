package T;

import com.powernode.spring6.bean.DateLoopVo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateTableGenerator01 {
    public static void main(String[] args) {
        DateLoopVo dateLoopVo001 =
                new DateLoopVo("abc",LocalDate.parse("2023-03-05",DateTimeFormatter.ISO_DATE),LocalDate.parse("2024-03-05",DateTimeFormatter.ISO_DATE));
        DateLoopVo dateLoopVo002 =
                new DateLoopVo("abc123",LocalDate.parse("2021-03-05",DateTimeFormatter.ISO_DATE),LocalDate.parse("2022-03-05",DateTimeFormatter.ISO_DATE));
        List<DateLoopVo>  dataLoops = new ArrayList<>();
        dataLoops.add(dateLoopVo001);
        dataLoops.add(dateLoopVo002);

        for(DateLoopVo dateLoopVo1 : dataLoops){
            String assetCode = dateLoopVo1.getAssetCode();
            LocalDate startDate = dateLoopVo1.getStartDate();
            LocalDate endDate = dateLoopVo1.getEndDate();
            ArrayList<ArrayList<String>> dateTable = new ArrayList<>();
            ArrayList<String> headerRow = new ArrayList<>();
            LocalDate currentDate = startDate;

            //循环写入
            for (int i = 0; !currentDate.isAfter(endDate); i++) {
                ArrayList<String> currentRow = new ArrayList<>();
                currentRow.add(assetCode);
                currentRow.add(currentDate.format(DateTimeFormatter.ISO_DATE));
                if (i == 0) {
                    currentRow.add(currentDate.plusDays(45).format(DateTimeFormatter.ISO_DATE));
                    currentDate = currentDate.plusDays(45);
                } else {
                    currentRow.add(currentDate.plusDays(30).format(DateTimeFormatter.ISO_DATE));
                    currentDate = currentDate.plusDays(30);
                }
                dateTable.add(currentRow);
            }
            //将数据写入表
            for (ArrayList<String> row : dateTable) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
    }
}
