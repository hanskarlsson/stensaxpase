package com.jayway.stensaxpase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hanskarlsson
 * Date: 8/2/2013
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Player {
    @XmlElement
    private String email;

    public Player(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

}
