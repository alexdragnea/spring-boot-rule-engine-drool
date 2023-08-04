package net.dg.springbootruleengine.service;

import lombok.RequiredArgsConstructor;
import net.dg.springbootruleengine.model.OrderDiscount;
import net.dg.springbootruleengine.model.OrderRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final KieContainer kieContainer;

  public OrderDiscount getDiscount(OrderRequest orderRequest) {
    OrderDiscount orderDiscount = new OrderDiscount();
    KieSession kieSession = kieContainer.newKieSession();
    kieSession.setGlobal("orderDiscount", orderDiscount);
    kieSession.insert(orderRequest);
    kieSession.fireAllRules();
    kieSession.dispose();
    return orderDiscount;
  }
}
