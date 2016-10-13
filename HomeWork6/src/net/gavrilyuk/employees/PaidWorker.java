package net.gavrilyuk.employees;

/**
 * Paid Worker interface
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public interface PaidWorker {

    String NO_TAX_OR_SOCIAL = "no_tax_or_social_id_number";
    int WORK_HOURLY_PER_MONTH = 160;// 8 hours *5 days* 4 week - the number of hours worked per month

    float calculatePay();
    Department getDepartment();
}
