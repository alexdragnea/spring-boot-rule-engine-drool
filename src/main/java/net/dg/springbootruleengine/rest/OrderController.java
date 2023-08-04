package net.dg.springbootruleengine.rest;

import lombok.RequiredArgsConstructor;
import net.dg.springbootruleengine.model.OrderDiscount;
import net.dg.springbootruleengine.model.OrderRequest;
import net.dg.springbootruleengine.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/get-discount")
  public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
    OrderDiscount discount = orderService.getDiscount(orderRequest);
    return new ResponseEntity<>(discount, HttpStatus.OK);
  }
}
