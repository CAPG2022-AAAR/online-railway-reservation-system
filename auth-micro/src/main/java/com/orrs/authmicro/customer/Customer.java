package com.orrs.authmicro.customer;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Customer implements UserDetails {

    @Id
    @SequenceGenerator(name = "sequence1", sequenceName = "sequence1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence1")
    private Long id;


    private String fname;
    private String lname;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private CustomerRole customerRole;
    private boolean locked = false;
    private boolean enabled = true;

    public
    Customer(String fname, String lname, String address, String phoneNumber, Gender gender, String password, String email, CustomerRole customerRole) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.customerRole = customerRole;
    }

    public Customer(Long id, String fname, String lname, String address, String phoneNumber, Gender gender, String password, String email, CustomerRole customerRole) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.customerRole = customerRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customerRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
