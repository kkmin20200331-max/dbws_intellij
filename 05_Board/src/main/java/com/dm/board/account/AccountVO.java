package com.dm.board.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class AccountVO {
    private String id;
    private String pw;
    private String name;
}
