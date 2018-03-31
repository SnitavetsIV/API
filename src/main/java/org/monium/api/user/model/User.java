package org.monium.api.user.model;

import org.monium.api.core.model.ModelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Entity
public class User extends ModelEntity {

  @Column private String username;

  @Column private String password;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified;

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public static class Fields extends ModelEntity.Fields {

    public final static String username = "username";
    public final static String password = "password";
  }
}
