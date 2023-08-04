package net.dg.springbootruleengine.model;

import lombok.Getter;
import lombok.Setter;
import net.dg.springbootruleengine.enums.CustomerType;

@Getter
@Setter
public class OrderRequest {

  private String customerNumber;
  private Integer age;
  private Integer amount;
  private CustomerType customerType;
}
