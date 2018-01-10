package com.test.ws.requestobject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Response")
public class Response {
    private Integer status;
    private String message;
    private String TransactionDate;
    private String reason;
    private Object data;

    @XmlElement(name = "data")
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Response() {
    }

    private String getCurrentTimeStemp(String str) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public Response(Integer status, String message, String date, String reason, Object list) {
        this.status = status;
        this.message = message;
        this.TransactionDate = getCurrentTimeStemp(date);
        this.reason = reason;

        if (list instanceof Collection<?>) {
            this.data = (Collection<?>) list;
        } else {
            this.data = list;
        }
    }

    @XmlElement(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*@XmlElement(name = "transactionDate")*/
    @XmlTransient
    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    /*@XmlElement(name = "reason")*/
    @XmlTransient
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Data [status=");
        builder.append(status);
        builder.append(", message=");
        builder.append(message);
        builder.append(", data=");
        builder.append(data);
        builder.append(", TransactionDate=");
        builder.append(TransactionDate);
        builder.append(", reason=");
        builder.append(reason);
        builder.append("]");
        return builder.toString();
    }

}
