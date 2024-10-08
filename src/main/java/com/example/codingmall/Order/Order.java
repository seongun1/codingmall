package com.example.codingmall.Order;

import com.example.codingmall.Coupon.Coupon;
import com.example.codingmall.User.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "Orders") // order은 mysql 예약어라서 테이블 이블을 orders로 변경
public class Order {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="orderId")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couponId")
    private Coupon coupon;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String receiverName;
    private String receiverPhone;
    private String deliveryAddress;
    private String orderNote;
    private BigDecimal totalAmount;

    private boolean isCancelled; // 취소여부
    private boolean isPaid; // 결제여부
}
