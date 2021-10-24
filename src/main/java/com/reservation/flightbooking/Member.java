package com.reservation.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Member extends Passenger {

    private static final Logger LOGGER = LogManager.getLogger(Member.class);

    private Integer membershipLength;

    public Member(String name, String passportNumber, Integer membershipLength) {
        super(name, passportNumber);
        this.membershipLength = membershipLength;
    }

    public Integer getMembershipLength() {
        return membershipLength;
    }

    public void setMembershipLength(Integer membershipLength) {
        this.membershipLength = membershipLength;
    }

    public Double useDiscount(Flight<Passenger> flight) {
        Double price = flight.getPrice();
        if (getMembershipLength() > 1 && getMembershipLength() < 2) {
            price = price * 0.1d;
            LOGGER.debug("You get a 10% discount.");
            return price;
        } else if (getMembershipLength() > 2 && getMembershipLength() < 5) {
            price = price * 0.20d;
            LOGGER.debug("You get a 20% discount.");
            return price;
        } else if (getMembershipLength() > 5) {
            price = price * 0.30d;
            LOGGER.debug("You get a 30% discount.");
            return price;
        } else {
            LOGGER.debug("You have no discounts available");
        }
        return price;
    }

    @Override
    public String toString() {
        return "Member:" +
                "MembershipLength:" + membershipLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;
        Member member = (Member) o;
        return Objects.equals(membershipLength, member.membershipLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), membershipLength);
    }
}
