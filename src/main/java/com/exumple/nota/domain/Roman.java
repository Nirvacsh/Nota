package com.exumple.nota.domain;

import org.apache.tomcat.jni.Error;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EmptyStackException;


// Таблица, базовый класс
@Entity
public class Roman {

    // Поле айди, автозаполняемое
    @Id
    @Column(name = "IDX", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // Поле для ввода числа
    private Integer chi;
    // Поле для римского числа
    private String roman;
  /*  // Поле для даты
    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime romanDate;
*/
/*
    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    */
    // Дефолтный конструктор
    public Roman() {
    }
    // Конструктор
    public Roman(Integer chi) {
        this.chi = chi;
        roman = Roman.toRoman(chi);
    }
    // Геттер числа
    public Integer getChi() {
        return chi;
    }
    // Сеттер числа
    public void setChi(Integer chi) {
        this.chi = chi;
    }
    // Геттер айди
    public Integer getId() {
        return id;
    }
    // Сеттер айди
    public void setId(Integer id) {
        this.id = id;
    }
    // Геттер римского
    public String getRoman() {
        return roman;
    }
    // Сеттер римского
    public void setRoman(String roman) {
        this.roman = roman;
    }
    /*
    // Геттер даты
    public Date getData() {
        return romanDate;
    }
    // Сеттер даты
    public void setData(Date romanDate) {
        this.romanDate= romanDate;
    }
    */
    // Метод конвертация в римский формат
    private static String toRoman(int chi) {
        if (chi > 4999 || chi < 1) throw new ArithmeticException("Wrong number");
        else
        return String.valueOf(new char[chi]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }
}
