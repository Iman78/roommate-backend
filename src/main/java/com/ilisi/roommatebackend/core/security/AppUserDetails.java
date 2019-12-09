package com.ilisi.roommatebackend.core.security;

import com.ilisi.roommatebackend.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDetails implements UserDetails {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String prenom;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String telephone;

    @Getter @Setter
    private String mobile;

    @Getter @Setter
    private int score;

    @Getter @Setter
    private int nbrVote;


    public AppUserDetails(int id, String username,String password,String nom, String prenom,
                          String email, String mobile, String telephone, int score, int nbrVote){
        this.username=username;
        this.password=password;
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.telephone=telephone;
        this.mobile=mobile;
        this.score=score;
        this.nbrVote=nbrVote;
    }

    public AppUserDetails(int id, String username,String password,String nom
                            , String prenom){
        this.username=username;
        this.password=password;
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
    }

    public AppUserDetails(User user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.id=user.getId();
        this.nom=user.getNom();
        this.prenom=user.getPrenom();
        this.email=user.getEmail();
        this.telephone=user.getTelephone();
        this.mobile=user.getMobile();
        this.score=user.getId();
        this.nbrVote=user.getNbrVote();
    }

    public AppUserDetails(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       /* ArrayList list=new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));*/
        return new ArrayList<GrantedAuthority>();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
