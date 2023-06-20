package Task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class WorkExperience {
    private String companyName;
    private String startDate;
    private String endDate;

    public WorkExperience(String companyName, String startDate, String endDate) {
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getMonthsOfWork() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            long startMs = dateFormat.parse(startDate).getTime();
            long endMs = dateFormat.parse(endDate).getTime();
            long difference = endMs - startMs;
            int months = (int) (difference / (1000L * 60L * 60L * 24L * 30L));
            return months;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
