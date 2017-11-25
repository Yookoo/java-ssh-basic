package com.bos.bussiness.domain;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * decidedzone entity. @author MyEclipse Persistence Tools
 */

public class Decidedzone  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
     private Staff staff;
     private String name;
     private Set<Subarea> subareas = new HashSet<Subarea>();


    // Constructors

    /** default constructor */
    public Decidedzone() {
    }

    
    /** full constructor */
    public Decidedzone(Staff staff, String name, Set<Subarea> subareas) {
        this.staff = staff;
        this.name = name;
        this.subareas = subareas;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set<Subarea> getSubareas() {
        return this.subareas;
    }
    
    public void setSubareas(Set<Subarea> subareas) {
        this.subareas = subareas;
    }
   








}