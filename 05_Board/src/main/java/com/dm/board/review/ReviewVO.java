package com.dm.board.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewVO {
    private int no;
    private String title;
    private String txt;
    private Date date;
}
