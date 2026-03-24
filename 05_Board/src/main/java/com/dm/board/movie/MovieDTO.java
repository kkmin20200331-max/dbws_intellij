package com.dm.board.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private int no;
    private String title;
    private String actor;
    private String img;
    private String story;
}
