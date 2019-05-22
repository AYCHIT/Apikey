package eu.europeana.apikey.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by luthien on 22/06/2017.
 */

@JsonInclude(NON_EMPTY)
public class ApikeyCreate implements ApikeyAction{

    public ApikeyCreate(String firstName, String lastName, String email){
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
    }

    //empty constructor needed to facilitate integration testing
    public ApikeyCreate(){}

    private String firstName;
    private String lastName;
    private String email;
    private String level;
    private String appName;
    private String company;
    private String sector;
    private String website;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLevel() {
        return level;
    }

    public String getAppName() {
        return appName;
    }

    public String getCompany() {
        return company;
    }

    public String getSector() {
        return sector;
    }

    public String getWebsite() {
        return website;
    }
}
