package net.hosni.claimservice.enums;




public enum Status {
    PENDING,DONE
}

//import java.util.HashMap;
//import java.util.Map;

//public enum Status {
//    PENDING("pending"),
//    DONE("done");
//
//    private static final Map<String, Status> BY_VALUE = new HashMap<>();
//
//    static {
//        for (Status status : values()) {
//            BY_VALUE.put(status.value, status);
//        }
//    }
//
//    private final String value;
//
//    Status(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public static Status fromString(String value) {
//        return BY_VALUE.get(value);
//    }
//}

