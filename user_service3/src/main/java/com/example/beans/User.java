package com.example.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: MingKing
 * @DayNameFull: 星期三
 * @Date: Create in 14:37 2020/7/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;

}
