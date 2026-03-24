package com.dm.web;

import com.sun.tools.javac.comp.Resolve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    //결과에서 뭘 쓸지 생각하자 db보고 정하면됨
    private String name;
    private int age;

}
