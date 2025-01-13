package com.contrato.contrato.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotBlank
    @Size(max = 63, min = 2, message = "The long name employ is invalid")
    @Pattern(regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]{1,15}( [A-Za-zÑñÁáÉéÍíÓóÚú]{1,15})*( [A-Za-zÑñÁáÉéÍíÓóÚú]{1,15})?$" , message = "Name is invalid")
    @Column(name = "employ", nullable = false)
    private String employ;

    @NotBlank(message = "Name company is empty")
    @Column(name = "company", nullable = false)
    private String company;

    @Positive(message = "Month duration can't be zero or negative")
    @Column(name = "month_duration", nullable = false)
    private int month_duration;

    @Column(name = "date_start")
    private LocalDateTime date_start;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 63, min = 2, message = "The long name employ is invalid") @Pattern(regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]{1,15}( [A-Za-zÑñÁáÉéÍíÓóÚú]{1,15})*( [A-Za-zÑñÁáÉéÍíÓóÚú]{1,15})?$", message = "Name is invalid") String getEmploy() {
        return employ;
    }

    public void setEmploy(@NotBlank @Size(max = 63, min = 2, message = "The long name employ is invalid") @Pattern(regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]{1,15}( [A-Za-zÑñÁáÉéÍíÓóÚú]{1,15})*( [A-Za-zÑñÁáÉéÍíÓóÚú]{1,15})?$", message = "Name is invalid") String employ) {
        this.employ = employ;
    }

    public @NotBlank(message = "Name company is empty") String getCompany() {
        return company;
    }

    public void setCompany(@NotBlank(message = "Name company is empty") String company) {
        this.company = company;
    }

    @PositiveOrZero(message = "Month duration can't be zero or negative")
    public int getMonth_duration() {
        return month_duration;
    }

    public void setMonth_duration(@PositiveOrZero(message = "Month duration can't be zero or negative") int month_duration) {
        this.month_duration = month_duration;
    }

    public LocalDateTime getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDateTime date_start) {
        this.date_start = date_start;
    }
}
