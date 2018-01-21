package com.apress.prospring5.ch17;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@NoArgsConstructor
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATE_FORMAT = "MMM dd yyyy HH:mm:ss";

    @Getter @Setter private String code;
    @Getter @Setter private double price;
    @Getter @Setter private Date date = new Date();
    private DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public Stock(String code, double price) {
        this.code = code;
        this.price = price;
    }

    public String getDateFormatted() {
        return dateFormat.format(date);
    }
}
