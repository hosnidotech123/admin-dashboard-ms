package net.hosni.claimservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {

    private Long id ;

    private String username;

    private String company;

    private String contact ;

    private String email;

    private String image;

    private String isActivated;
}
