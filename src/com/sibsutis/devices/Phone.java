package com.sibsutis.devices;

import java.util.Objects;

public class Phone extends Device {
    
    public Phone(int id, int price) {
        super(id, price);
    }
    
    public Phone(int id, int price, String ip) {
        super(id, price, ip);
    }
    
    @Override
    public String getDeviceType() {
        return "Phone";
    }
    @Override
    public String print() {
        String ipInfo = (ip != null) ? ip : "null";
        return "Phone{id=" + id + ", price=" + price + ", ip='" + ipInfo + "'}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(ip, phone.ip);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ip);
    }
}
