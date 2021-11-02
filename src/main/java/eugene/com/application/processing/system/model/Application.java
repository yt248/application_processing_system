package eugene.com.application.processing.system.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request")
    private String request;                  // запрос заявки

    @Column(name = "bid")
    private Double bid;                      // предлагаемая цена

    @Column(name = "due_date")
    private Date due_date;                   // срок оплаты

    @Column(name = "status")
    private StatusApplication status;                   // статус

    @ManyToOne(fetch = FetchType.LAZY)
    private User creatorApplication;                   //создатель заявки

    public Application() {
    }

    public Application(String request, Double bid, Date due_date, StatusApplication status) {
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

    public User getCreatorApplication() {
        return creatorApplication;
    }

    public void setCreatorApplication(User creatorApplication) {
        this.creatorApplication = creatorApplication;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", bid=" + bid +
                ", due_date=" + due_date +
                ", status='" + status + '\'' +
                '}';
    }

}
