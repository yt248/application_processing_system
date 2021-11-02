package eugene.com.application.processing.system.dto;

import eugene.com.application.processing.system.model.StatusApplication;

import java.sql.Date;

public class ApplicationDto {

    private Long id;
    private String request;                  // запрос заявки
    private Double bid;                      // предлагаемая цена
    private Date due_date;                   // срок оплаты
    private StatusApplication status;

    public ApplicationDto() {
    }

    public ApplicationDto(String request, Double bid, Date due_date, StatusApplication status) {
        this.request = request;
        this.bid = bid;
        this.due_date = due_date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public StatusApplication getStatus() {
        return status;
    }

    public void setStatus(StatusApplication status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplicationDto{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", bid=" + bid +
                ", due_date=" + due_date +
                ", status='" + status + '\'' +
                '}';
    }
}
