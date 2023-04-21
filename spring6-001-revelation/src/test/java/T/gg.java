package T;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author wangguangtao
 * @date 2023/4/20
 * @apiNote
 */
public class gg {
    public static void main(String[] args) {
        String startDateString = "2023-04-20";
        String endDateString = "2023-10-01";
        LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.parse(endDateString, DateTimeFormatter.ISO_DATE);
        ArrayList<ArrayList<String>> dateTable = new ArrayList<>();
        ArrayList<String> headerRow = new ArrayList<>();
        headerRow.add("Start Date");
        headerRow.add("Next Date");
        dateTable.add(headerRow);
        LocalDate currentDate = startDate;

        for (int i = 0; !currentDate.isAfter(endDate); i++) {
            ArrayList<String> currentRow = new ArrayList<>();
            if (i == 0) {
                currentRow.add(currentDate.format(DateTimeFormatter.ISO_DATE));
                currentRow.add(currentDate.plusDays(45).format(DateTimeFormatter.ISO_DATE));
                currentDate = currentDate.plusDays(45);
            } else {
                LocalDate prevNextDate = LocalDate.parse(dateTable.get(i - 1).get(1), DateTimeFormatter.ISO_DATE);
                currentRow.add(prevNextDate.plusDays(1).format(DateTimeFormatter.ISO_DATE));
                currentRow.add(prevNextDate.plusDays(31).format(DateTimeFormatter.ISO_DATE));
            }
            dateTable.add(currentRow);
        }

        for (ArrayList<String> row : dateTable) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }





}
