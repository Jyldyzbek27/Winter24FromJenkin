package com.winter24.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PracticeFormEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String userNumber;
    private String subject;
    private String picture;
    private String currentAddress;

}
