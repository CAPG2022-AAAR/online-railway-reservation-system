package com.orrs.availabletraininfo.trainService;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Service
public class DayOfTheWeek {

    public Date convertToDate(String date){
        Date convertedDate = new Date();
        try {
            convertedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException parseEx) {
            parseEx.printStackTrace();
        }

            return convertedDate;
        }


        public String convertDayToDate (String date) throws Exception {

            Date dateFromString = convertToDate(date);

            System.out.println(date);
            Calendar c = Calendar.getInstance();
            c.setTime(dateFromString);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String dayWeekText = new SimpleDateFormat("EEEE").format(dateFromString);
            return dayWeekText;
        }

    }
