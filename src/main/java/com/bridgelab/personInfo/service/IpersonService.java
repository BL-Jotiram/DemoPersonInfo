package com.bridgelab.personInfo.service;

import java.util.List;

import com.bridgelab.personInfo.dto.PersonRegisterDTO;
import com.bridgelab.personInfo.entity.Person;

public interface IpersonService {
  public String registerPerson(PersonRegisterDTO personRegisterDTO);
  public List<Person> editPerson(PersonRegisterDTO personRegisterDTO);
  public List<Person> deletePerson(String emailId);
  public Person getPerson(int id);
}
